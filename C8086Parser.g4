parser grammar C8086Parser;

options {
    tokenVocab = C8086Lexer;
}

@parser::header {
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
	#include "Utills/2105004_SymbolTable.hpp"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;

    extern int syntaxErrorCount;
}

@parser::members {

	SymbolTable *symbolTable = new SymbolTable(7);
	bool hasInserted = false;
	SymbolInfo *existing;

	void writeIntoparserLogFile(const std::string message) {
        if (!parserLogFile) {
            std::cout << "Error opening parserLogFile.txt" << std::endl;
            return;
        }

        parserLogFile << message << std::endl;
        parserLogFile.flush();
    }

    void writeIntoErrorFile(const std::string message) {
        if (!errorFile) {
            std::cout << "Error opening errorFile.txt" << std::endl;
            return;
        }
        errorFile << message << std::endl;
        errorFile.flush();
    }
}


start : program
	{
        writeIntoparserLogFile("Parsing completed successfully with " + std::to_string(syntaxErrorCount) + " syntax errors.");
	}
	;

program : pg=program unt=unit {
	writeIntoparserLogFile("Line " + std::to_string($unt.stop->getLine()) + ":" + " program : program unit\n");
	writeIntoparserLogFile($pg.text + "\n" + $unt.text + "\n");
}
	| unt=unit {
	writeIntoparserLogFile("Line " + std::to_string($unt.stop->getLine()) + ":" + " program : unit\n");
	writeIntoparserLogFile($unt.text + "\n");
	}
	;
	
unit : var_dec=var_declaration { 
	writeIntoparserLogFile("Line " + std::to_string($var_dec.start->getLine()) + ":" + " unit : var_declaration\n"); 
	writeIntoparserLogFile($var_dec.text + "\n"); 
}
     | func_dec=func_declaration {
		writeIntoparserLogFile("Line " + std::to_string($func_dec.stop->getLine()) + ":" + " unit :  func_declaration\n");
		writeIntoparserLogFile($func_dec.text + "\n");
	 }
     | func_def=func_definition {
		writeIntoparserLogFile("Line " + std::to_string($func_def.stop->getLine()) + ":" + " unit :  func_definition\n");
		writeIntoparserLogFile($func_def.text + "\n");
	 }
     ;
     
func_declaration : t=type_specifier id=ID {
	if(symbolTable->LookUp($id.text)){
		writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
		syntaxErrorCount++;
	} 
} lp=LPAREN pl=parameter_list rp=RPAREN sm=SEMICOLON {
			writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
			writeIntoparserLogFile($t.text + $id.text + $lp.text + $pl.text +$rp.text + $sm.text + "\n");
			if(!symbolTable->LookUp($id.text)){
				SymbolAdditionalInfo info = SymbolAdditionalInfo();
				info.isFunction = true;
				info.parameters = $pl.params;
				info.returnType = $t.text;
				symbolTable->Insert($id.text, "ID", info);
			}
}
		| t=type_specifier id=ID {
		if(symbolTable->LookUp($id.text)){
		writeIntoErrorFile("Line " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' already declared.");
		syntaxErrorCount++;
	} 
		} lp=LPAREN rp=RPAREN sm=SEMICOLON {
			writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
			writeIntoparserLogFile($t.text + " " + $id.text + $lp.text + $rp.text + $sm.text + "\n");
			if(!symbolTable->LookUp($id.text)){
				SymbolAdditionalInfo info = SymbolAdditionalInfo();
				info.isFunction = true;
				info.returnType = $t.text;
				hasInserted = symbolTable->Insert($id.text, "ID", info);
			}
		}
		;
		 
func_definition : t=type_specifier id=ID {
	existing = symbolTable->LookUp($id.text);
	if (existing) {
			if(!existing->additionalInfo.isFunction){
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
				syntaxErrorCount++;
			}
			else if(existing->additionalInfo.isDefined) {
                writeIntoErrorFile("Line# " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' is already defined.");
                syntaxErrorCount++;
            }
        }
} lp=LPAREN { symbolTable->Enter_scope(); } pl=parameter_list { 
if($pl.params.size() == $pl.names.size()){
		for(int i = 0; i < $pl.params.size(); i++){
			if(symbolTable->LookUp2($pl.names[i])){
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $pl.names[i] + " in parameter" + "\n");
				syntaxErrorCount++;
				continue;
			}
		SymbolAdditionalInfo info = SymbolAdditionalInfo();
		info.dataType = $pl.params[i];
		symbolTable->Insert($pl.names[i], "ID", info);
	}
}
 } rp=RPAREN cm_stmt=compound_statement[true] {
			writeIntoparserLogFile("Line " + std::to_string($id->getLine()) + ":" + " func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n");
			writeIntoparserLogFile($t.text + $id.text + $lp.text + $pl.text + $rp.text + $cm_stmt.text + "\n");
		existing = symbolTable->LookUp($id.text);
		if (!existing) {
            SymbolAdditionalInfo info = SymbolAdditionalInfo();
            info.isFunction = true;
            info.isDefined = true;
            info.returnType = $t.text;
            info.parameters = $pl.params;
            hasInserted = symbolTable->Insert($id.text, "ID", info);
        } else {
			if(existing->additionalInfo.isFunction && !existing->additionalInfo.isDefined) {
            existing->additionalInfo.isDefined = true;
			if(existing->additionalInfo.returnType != $t.text) {
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Return type mismatch with function declaration in function " + $id.text + "\n");
				syntaxErrorCount++;
        }
			if(existing->additionalInfo.parameters != $pl.params) {
				syntaxErrorCount++;
				if(existing->additionalInfo.parameters.size() != $pl.params.size()){
					writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + $id.text + "\n");
				}
				}
			}
		}
}
		| t=type_specifier id=ID {
	existing = symbolTable->LookUp($id.text);
	if (existing) {
            if (existing->additionalInfo.isDefined) {
                writeIntoErrorFile("Line# " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' is already defined.");
                syntaxErrorCount++;
            }
        }
		} lp=LPAREN { symbolTable->Enter_scope(); } rp=RPAREN cm_stmt=compound_statement[true] {
			writeIntoparserLogFile("Line " + std::to_string($id->getLine()) + ":" + " func_definition : type_specifier ID LPAREN RPAREN compound_statement\n");
			writeIntoparserLogFile($t.text + $id.text + $lp.text + $rp.text + $cm_stmt.text + "\n");
		existing = symbolTable->LookUp($id.text);
		if (!existing) {
			SymbolAdditionalInfo info = SymbolAdditionalInfo();
			info.isFunction = true;
			info.isDefined = true;
			info.returnType = $t.text;
			hasInserted = symbolTable->Insert($id.text, "ID", info);
		}
		else{
			if(!existing->additionalInfo.isDefined) {
			existing->additionalInfo.isDefined = true;
			if(existing->additionalInfo.returnType != $t.text) {
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Return type mismatch with function declaration in function " + $id.text + "\n");
				syntaxErrorCount++;
		}
		if(existing->additionalInfo.parameters.size() > 0){
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + $id.text + "\n");
				syntaxErrorCount++;
		}
		}
		}
	}
 		;				


parameter_list  returns [std::vector<std::string> params , std::vector<std::string> names]: pl=parameter_list cm=COMMA t=type_specifier id=ID {
	writeIntoparserLogFile("Line " + std::to_string($cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier ID\n");
	writeIntoparserLogFile($pl.text + $cm.text + $t.text + " " +$id.text + "\n");
	$params = $pl.params;
    $params.push_back($t.text);
	$names = $pl.names;
	$names.push_back($id.text);
}
		| pl=parameter_list cm=COMMA t=type_specifier {
	writeIntoparserLogFile("Line " + std::to_string($cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier\n");
	writeIntoparserLogFile($pl.text + $cm.text + $t.text + "\n");
	$params = $pl.params;
    $params.push_back($t.text);
	$names = $pl.names;
	$names.push_back($id.text);
		}
 		| t=type_specifier id=ID {
	writeIntoparserLogFile("Line " + std::to_string($t.stop->getLine()) + ":" + " parameter_list : type_specifier ID\n");
	writeIntoparserLogFile($t.text + " " + $id.text + "\n");
	$params.push_back($t.text);
	$names.push_back($id.text);
		}
		| t=type_specifier {
	writeIntoparserLogFile("Line " + std::to_string($t.stop->getLine()) + ":" + " parameter_list : type_specifier\n");
	writeIntoparserLogFile($t.text + "\n");
	$params.push_back($t.text);
		}
 		;

 		
compound_statement[bool IsFunction] : LCURL {
	if(!IsFunction){
	symbolTable->Enter_scope();
 }
} stmts=statements RCURL {
			writeIntoparserLogFile("Line " + std::to_string($LCURL->getLine()) + ":" + " compound_statement : LCURL statements RCURL\n");
			writeIntoparserLogFile($LCURL->getText() + $stmts.text + $RCURL->getText() + "\n");
			symbolTable->Remove_scope();
}
 		    | LCURL {
				 if(!IsFunction){
		 symbolTable->Enter_scope();
	 }
			} RCURL {
			writeIntoparserLogFile("Line " + std::to_string($LCURL->getLine()) + ":" + " compound_statement : LCURL RCURL\n");
			writeIntoparserLogFile($LCURL->getText() + $RCURL->getText() + "\n");
			symbolTable->Remove_scope();
			}
 		    ;
 		    
var_declaration 
    : t=type_specifier dl=declaration_list sm=SEMICOLON {
		writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " var_declaration : type_specifier declaration_list SEMICOLON\n");
		writeIntoparserLogFile($t.text + " " + $dl.text + $sm.text + "\n");
		for(int i = 0; i < $dl.decls.size(); i++) {
			if(symbolTable->LookUp2($dl.decls[i].first)) {
				writeIntoErrorFile("Error at line " + std::to_string($sm->getLine()) + ": Multiple declaration of " + $dl.decls[i].first + "\n");
				syntaxErrorCount++;
			} else {
				SymbolAdditionalInfo info = SymbolAdditionalInfo();
				info.dataType = $t.text;
				info.isArray = $dl.decls[i].second;
				info.arraySize = $dl.arrsize[i];
				hasInserted = symbolTable->Insert($dl.decls[i].first, "ID", info);
				if($t.text == "void"){
					writeIntoErrorFile("Error at line " + std::to_string($sm->getLine()) + ": Variable type cannot be void\n");
					syntaxErrorCount++;
				}
			}
		}
      }

    | t=type_specifier de=declaration_list_err sm=SEMICOLON {
        writeIntoErrorFile(
            std::string("Line# ") + std::to_string($sm->getLine()) +
            " with error name: " + $de.error_name +
            " - Syntax error at declaration list of variable declaration"
        );

        syntaxErrorCount++;
      }
    ;

declaration_list_err returns [std::string error_name]: {
        $error_name = "Error in declaration list";
    };

 		 
type_specifier returns [std::string name_line]	
        : INT {
            $name_line = "type: INT at line" + std::to_string($INT->getLine());
			writeIntoparserLogFile("Line " + std::to_string($INT->getLine()) + ":" + " type_specifier : INT\n");
            writeIntoparserLogFile($INT->getText() + "\n");
        }
 		| FLOAT {
            $name_line = "type: FLOAT at line" + std::to_string($FLOAT->getLine());
			writeIntoparserLogFile("Line " + std::to_string($FLOAT->getLine()) + ":" + " type_specifier : FLOAT\n");
            writeIntoparserLogFile($FLOAT->getText() + "\n");
        }
 		| VOID {
            $name_line = "type: VOID at line" + std::to_string($VOID->getLine());
			writeIntoparserLogFile("Line " + std::to_string($VOID->getLine()) + ":" + " type_specifier : VOID\n");
            writeIntoparserLogFile($VOID->getText() + "\n");
        }
 		;
 		
declaration_list returns [std::vector<std::pair<std::string, bool>> decls, std::vector<int> arrsize]
		: decl=declaration_list COMMA ID {
			writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " declaration_list : declaration_list COMMA ID\n");
			writeIntoparserLogFile($decl.text + $COMMA->getText() + $ID->getText() + "\n");
			$decls = $decl.decls;
			$decls.push_back({$ID->getText(), false});
			$arrsize = $decl.arrsize;
			$arrsize.push_back(0);
		}
		| decl=declaration_list COMMA ID LTHIRD CONST_INT RTHIRD {
			writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD\n");
			writeIntoparserLogFile($decl.text + $COMMA->getText() + $ID->getText() + $LTHIRD->getText() + $CONST_INT->getText() + $RTHIRD->getText() + "\n");
			$decls = $decl.decls;
			$decls.push_back({$ID->getText(), true});
			$arrsize = $decl.arrsize;
			$arrsize.push_back(std::stoi($CONST_INT->getText()));
		}
		| ID {
			writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " declaration_list : ID\n");
			writeIntoparserLogFile($ID->getText() + "\n");
			$decls.push_back({$ID->getText(), false});
			$arrsize.push_back(0);
		}
		| ID LTHIRD CONST_INT RTHIRD {
			writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " declaration_list : ID LTHIRD CONST_INT RTHIRD\n");
			writeIntoparserLogFile($ID->getText() + $LTHIRD->getText() + $CONST_INT->getText() + $RTHIRD->getText() + "\n");
			$decls.push_back({$ID->getText(), true});
			$arrsize.push_back(std::stoi($CONST_INT->getText()));
		}
		;
 		  
statements : stmt=statement {
	writeIntoparserLogFile("Line " + std::to_string($stmt.stop->getLine()) + ":" + " statements : statement\n");
	writeIntoparserLogFile($stmt.text + "\n");
}
	   | stmts=statements stmt=statement {
	writeIntoparserLogFile("Line " + std::to_string($stmt.stop->getLine()) + ":" + " statements : statements statement\n");
	writeIntoparserLogFile($stmts.text + $stmt.text +"\n");
	   }
	   ;
	   
statement : var_dec=var_declaration {
	writeIntoparserLogFile("Line " + std::to_string($var_dec.stop->getLine()) + ":" + " statement :  var_declaration\n");
	writeIntoparserLogFile($var_dec.text + "\n");
}
	  | expr_stmt=expression_statement {
	writeIntoparserLogFile("Line " + std::to_string($expr_stmt.stop->getLine()) + ":" + " statement : expression_statement\n");
	writeIntoparserLogFile($expr_stmt.text +"\n");
	  }
	  | cm_stmt=compound_statement[false] {
	writeIntoparserLogFile("Line " + std::to_string($cm_stmt.stop->getLine()) + ":" + " statement : compound_statement\n");
	writeIntoparserLogFile($cm_stmt.text +"\n");
	  }
	  | fr=FOR lp=LPAREN expr_stmt1=expression_statement expr_stmt2=expression_statement expr=expression rp=RPAREN stmt=statement {
	writeIntoparserLogFile("Line " + std::to_string($fr->getLine()) + ":" + " statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement\n");
	writeIntoparserLogFile($fr.text + $lp.text + $expr_stmt1.text + $expr_stmt2.text + $expr.text + $rp.text + $stmt.text +"\n");
	  }
	  | iff=IF lp=LPAREN expr=expression rp=RPAREN stmt=statement {
	writeIntoparserLogFile("Line " + std::to_string($iff->getLine()) + ":" + " statement : IF LPAREN expression RPAREN statement\n");
	writeIntoparserLogFile($iff.text + $lp.text + $expr.text + $rp.text + $stmt.text + "\n");
	  }
	  | iff=IF lp=LPAREN expr=expression rp=RPAREN stmt1=statement els=ELSE stmt2=statement {
	writeIntoparserLogFile("Line " + std::to_string($iff->getLine()) + ":" + " statement : IF LPAREN expression RPAREN statement ELSE statement\n");
	writeIntoparserLogFile($iff.text + $lp.text + $expr.text + $rp.text + $stmt1.text + $els.text + $stmt2.text + "\n");
	  }
	  | whl=WHILE lp=LPAREN expr=expression rp=RPAREN stmt=statement {
	writeIntoparserLogFile("Line " + std::to_string($whl->getLine()) + ":" + " statement : WHILE LPAREN expression RPAREN statement\n");
	writeIntoparserLogFile($whl.text + $lp.text + $expr.text + $rp.text + $stmt.text + "\n");
	  }
	  | prln=PRINTLN lp=LPAREN id=ID rp=RPAREN sm=SEMICOLON {
	writeIntoparserLogFile("Line " + std::to_string($prln->getLine()) + ":" + " statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n");
	writeIntoparserLogFile($prln.text + $lp.text + $id.text + $rp.text + $sm.text + "\n");
	existing = symbolTable->LookUp($id.text);
	if(!existing) {
		writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Undeclared variable " + $id.text + "\n");
		syntaxErrorCount++;
	} else {
		if(existing->additionalInfo.isArray) {
			writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + $id.text + " is an array" + "\n");
			syntaxErrorCount++;
		}
		if(existing->additionalInfo.dataType != "int" && existing->additionalInfo.dataType != "float") {
			writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ": Variable type not int or float in printf\n");
			syntaxErrorCount++;
		}
	}
	  }
	  | rtn=RETURN expr=expression sm=SEMICOLON {
	writeIntoparserLogFile("Line " + std::to_string($rtn->getLine()) + ":" + " statement : RETURN expression SEMICOLON\n");
	writeIntoparserLogFile($rtn.text + " " + $expr.text + $sm.text + "\n");
	  }
	  ;
	  
expression_statement 	: SEMICOLON	{
	writeIntoparserLogFile("Line " + std::to_string($SEMICOLON->getLine()) + ":" + " expression_statement : SEMICOLON\n");
	writeIntoparserLogFile($SEMICOLON->getText() + "\n");
}	
			| expr=expression SEMICOLON {
	writeIntoparserLogFile("Line " + std::to_string($SEMICOLON->getLine()) + ":" + " expression_statement : expression SEMICOLON\n");
	writeIntoparserLogFile($expr.text + $SEMICOLON->getText() + "\n");
			}
			;
	  
variable returns [std::string datatype]: ID  {
	writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " variable : ID\n");
	writeIntoparserLogFile($ID->getText() + "\n");
	existing = symbolTable->LookUp($ID->getText());
	if(existing) {
		$datatype = existing->additionalInfo.dataType;
		if(existing->additionalInfo.isArray) {
			writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ": Type mismatch," + $ID->getText() + " is an array" + "\n");
			syntaxErrorCount++;
		}
	}
	else {
		writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ":" + " Undeclared variable " + $ID->getText() + "\n");
		syntaxErrorCount++;
		$datatype = "error";
	}
}		
	 | ID LTHIRD expr=expression RTHIRD {
	writeIntoparserLogFile("Line " + std::to_string($LTHIRD->getLine()) + ":" + " variable : ID LTHIRD expression RTHIRD\n");
	writeIntoparserLogFile($ID->getText() + $LTHIRD->getText() + $expr.text + $RTHIRD->getText() + "\n");
	existing = symbolTable->LookUp($ID->getText());
	if(existing) {
		$datatype = existing->additionalInfo.dataType;
		if(!existing->additionalInfo.isArray){
			writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ": " + $ID->getText() + " not an array" + "\n");
			syntaxErrorCount++;
		}
	}
	else{
		writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ":" + " Undeclared variable " + $ID->getText() + "\n");
		syntaxErrorCount++;
		$datatype = "error";
	}
	if($expr.datatype != "int") {
		writeIntoErrorFile("Error at line " + std::to_string($expr.start->getLine()) + ": Expression inside third brackets not an integer" + "\n");
		syntaxErrorCount++;
	}
	 }
	 ;
	 
 expression returns [std::string datatype]: lgexpr=logic_expression	{
	writeIntoparserLogFile("Line " + std::to_string($lgexpr.start->getLine()) + ":" + " expression : logic_expression\n");
	writeIntoparserLogFile($lgexpr.text + "\n");
	$datatype = $lgexpr.datatype;
 }
	   | var=variable ASSIGNOP lgexpr=logic_expression  {
	writeIntoparserLogFile("Line " + std::to_string($ASSIGNOP->getLine()) + ":" + " expression : variable ASSIGNOP logic_expression\n");
	writeIntoparserLogFile($var.text + $ASSIGNOP->getText() + $lgexpr.text + "\n");
	$datatype = $var.datatype;
	if(($var.datatype == "int") && ($lgexpr.datatype == "float")) {
		writeIntoErrorFile("Error at line " + std::to_string($lgexpr.start->getLine()) + ": Type mismatch" + "\n");
		syntaxErrorCount++;
	}
	if($lgexpr.datatype == "void") {
		writeIntoErrorFile("Error at line " + std::to_string($lgexpr.start->getLine()) + ": Void function used in expression" + "\n");
		syntaxErrorCount++;
	}
	   }	
	   ;
			
logic_expression returns [std::string datatype]: rlexpr=rel_expression {
	writeIntoparserLogFile("Line " + std::to_string($rlexpr.start->getLine()) + ":" + " logic_expression :  el_expression\n");
	writeIntoparserLogFile($rlexpr.text + "\n");
	$datatype = $rlexpr.datatype;
} 	
		 | rlexpr1=rel_expression LOGICOP rlexpr2=rel_expression {
	writeIntoparserLogFile("Line " + std::to_string($LOGICOP->getLine()) + ":" + " logic_expression : rel_expression LOGICOP rel_expression\n");
	writeIntoparserLogFile($rlexpr1.text + $LOGICOP->getText() + $rlexpr2.text + "\n");
	$datatype = $rlexpr1.datatype;
		 }	
		 ;
			
rel_expression	returns [std::string datatype]: smexpr=simple_expression {
	writeIntoparserLogFile("Line " + std::to_string($smexpr.start->getLine()) + ":" + " rel_expression : simple_expression\n");
	writeIntoparserLogFile($smexpr.text + "\n");
	$datatype = $smexpr.datatype;
}
		| smexpr1=simple_expression RELOP smexpr2=simple_expression	{
	writeIntoparserLogFile("Line " + std::to_string($RELOP->getLine()) + ":" + " rel_expression : simple_expression RELOP simple_expression\n");
	writeIntoparserLogFile($smexpr1.text + $RELOP->getText() + $smexpr2.text + "\n");
	$datatype = $smexpr1.datatype;
		}
		;
				
simple_expression returns [std::string datatype]: trm=term {
	writeIntoparserLogFile("Line " + std::to_string($trm.start->getLine()) + ":" + " simple_expression : term\n");
	writeIntoparserLogFile($trm.text + "\n");
	$datatype = $trm.datatype;
}
		  | smexpr=simple_expression ADDOP trm=term {
	writeIntoparserLogFile("Line " + std::to_string($ADDOP->getLine()) + ":" + " simple_expression : simple_expression ADDOP term\n");
	writeIntoparserLogFile($smexpr.text + $ADDOP->getText() + $trm.text + "\n");
	if($smexpr.datatype == "float" || $trm.datatype == "float") {
		$datatype = "float";
	}
	else{
		$datatype = "int";
	}
		  }
		  ;
					
term returns [std::string datatype]:	unexpr=unary_expression {
	writeIntoparserLogFile("Line " + std::to_string($unexpr.start->getLine()) + ":" + " term : unary_expression\n");
	writeIntoparserLogFile($unexpr.text + "\n");
	$datatype = $unexpr.datatype;
}
     |  trm=term MULOP unexpr=unary_expression {
	writeIntoparserLogFile("Line " + std::to_string($MULOP->getLine()) + ":" + " term : term MULOP unary_expression\n");
	writeIntoparserLogFile($trm.text + $MULOP->getText() + $unexpr.text + "\n");
	if($trm.datatype == "float" || $unexpr.datatype == "float") {
		$datatype = "float";
	}
	if($MULOP->getText() == "%"){
		$datatype = "int";
	}
	else{
		$datatype = "int";
	}
	if($MULOP->getText() == "%" && ($unexpr.datatype == "float" || $trm.datatype == "float")) {
		writeIntoErrorFile("Error at line " + std::to_string($MULOP->getLine()) + ": Non-Integer operand on modulus operator" + "\n");
		syntaxErrorCount++;
	}
	if($MULOP->getText() == "%" && $unexpr.text == "0"){
		writeIntoErrorFile("Error at line " + std::to_string($MULOP->getLine()) + ": Modulus by Zero" + "\n");
		syntaxErrorCount++;
	}
	if($MULOP->getText() == "/" && $unexpr.text == "0"){
		writeIntoErrorFile("Error at line " + std::to_string($MULOP->getLine()) + ": Division by Zero" + "\n");
		syntaxErrorCount++;
	}
	if($trm.datatype == "void" || $unexpr.datatype == "void") {
		writeIntoErrorFile("Error at line " + std::to_string($MULOP->getLine()) + ": Void function used in expression" + "\n");
		syntaxErrorCount++;
	}
	 }
     ;

unary_expression returns [std::string datatype]: ADDOP unexpr=unary_expression  {
		writeIntoparserLogFile("Line " + std::to_string($ADDOP->getLine()) + ":" + " unary_expression : ADDOP unary_expression\n");
		writeIntoparserLogFile($ADDOP->getText() + $unexpr.text + "\n");
		$datatype = $unexpr.datatype;
}
		| NOT unexpr=unary_expression {
		writeIntoparserLogFile("Line " + std::to_string($NOT->getLine()) + ":" + " unary_expression : NOT unary_expression\n");
		writeIntoparserLogFile($NOT->getText() + $unexpr.text + "\n");
		$datatype = "int";
		}
		| fctr=factor {
		writeIntoparserLogFile("Line " + std::to_string($fctr.start->getLine()) + ":" + " unary_expression : factor\n");
		writeIntoparserLogFile($fctr.text + "\n");
		$datatype = $fctr.datatype;
		}
		 ;
	
factor returns [std::string datatype]	: var=variable {
		writeIntoparserLogFile("Line " + std::to_string($var.start->getLine()) + ":" + " factor : variable\n");
		writeIntoparserLogFile($var.text + "\n");
		$datatype = $var.datatype;
    }
	| id=ID lp=LPAREN argl=argument_list rp=RPAREN {
		writeIntoparserLogFile("Line " + std::to_string($argl.start->getLine()) + ":" + " factor : ID LPAREN argument_list RPAREN\n");
		writeIntoparserLogFile($id.text + $lp.text + $argl.text + $rp.text + "\n");
		existing = symbolTable->LookUp($id.text);
		if(existing && existing->additionalInfo.isDefined && existing->additionalInfo.isFunction){
			$datatype = existing->additionalInfo.returnType;
			if($argl.argtypes != existing->additionalInfo.parameters){
			if(existing->additionalInfo.parameters.size() != $argl.argtypes.size()){
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of argument mismatch in function " + $id.text + "\n");
				syntaxErrorCount++;
			}
			else{
				for(int i = 0; i < $argl.argtypes.size(); i++){
					if($argl.argtypes[i] != existing->additionalInfo.parameters[i]){
						writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ": " + std::to_string(i+1) + "th argument mismatch in function " + $id.text + "\n");
						syntaxErrorCount++;
						break;
					}
				}
			}
		}
		}
		else{
			writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Undeclared function " + $id.text + "\n");
			syntaxErrorCount++;
			$datatype = "error";
		}
	}
	| lp=LPAREN expr=expression rp=RPAREN {
		writeIntoparserLogFile("Line " + std::to_string($expr.start->getLine()) + ":" + " factor : LPAREN expression RPAREN\n");
		writeIntoparserLogFile($lp.text + $expr.text + $rp.text + "\n");
		$datatype = $expr.datatype;
	}
	| CONST_INT {
		writeIntoparserLogFile("Line " + std::to_string($CONST_INT->getLine()) + ":" + " factor : CONST_INT\n");
		writeIntoparserLogFile($CONST_INT->getText() + "\n");
		$datatype = "int";
	}
	| CONST_FLOAT {
		writeIntoparserLogFile("Line " + std::to_string($CONST_FLOAT->getLine()) + ":" + " factor : CONST_FLOAT\n");
		writeIntoparserLogFile($CONST_FLOAT->getText() + "\n");
		$datatype = "float";
	}
	| var=variable INCOP {
		writeIntoparserLogFile("Line " + std::to_string($INCOP->getLine()) + ":" + " factor : variable INCOP\n");
		writeIntoparserLogFile($INCOP->getText() + "\n");
		$datatype = $var.datatype;
	}
	| var=variable DECOP {
		writeIntoparserLogFile("Line " + std::to_string($DECOP->getLine()) + ":" + " factor : variable DECOP\n");
		writeIntoparserLogFile($DECOP->getText() + "\n");
		$datatype = $var.datatype;
	}
	;
	
argument_list returns [std::vector<std::string> argtypes]: args=arguments {
			writeIntoparserLogFile("Line " + std::to_string($args.start->getLine()) + ":" + " argument_list : arguments\n");
			writeIntoparserLogFile($args.text + "\n");
			$argtypes = $args.argtypes;
            }
			  | {
				$argtypes = std::vector<std::string>();
			  }
			  ;
	
arguments returns [std::vector<std::string> argtypes]: args=arguments cm=COMMA le=logic_expression {
			writeIntoparserLogFile("Line " + std::to_string($le.start->getLine()) + ":" + " arguments : arguments COMMA logic_expression\n");
			writeIntoparserLogFile($args.text + $cm.text + $le.text + "\n");
			$argtypes = $args.argtypes;
			$argtypes.push_back($le.datatype);
          }
	      | le=logic_expression {
			writeIntoparserLogFile("Line " + std::to_string($le.start->getLine()) + ":" + " arguments : logic_expression\n");
			writeIntoparserLogFile($le.text + "\n");
			$argtypes.push_back($le.datatype);
		  }
	      ;
