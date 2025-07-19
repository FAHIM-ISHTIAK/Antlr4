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
	extern std::ofstream assemblyFile;
    extern int syntaxErrorCount;
}

@parser::members {

   	SymbolTable *symbolTable = new SymbolTable(7,parserLogFile);
	bool hasInserted = false;
	SymbolInfo *existing, *existing2;
	string code = "";
	string str = "";
	string str2 = "";
	string str3 = "";
	string forlabel = "";
	string forlabel2 = "";
	string forlabel3 = "";
	string forlabel4 = "";
	string whilelabel = "";
	string whilelabel2 = "";
	string whilelabel3 = "";
	string datacode = "";
	int labelCount = 0;
	int tempVarCount = 0;
	int stackOffset = 0;
	bool isGlobal = false;
	stack<string> labelStack;
	bool iscodewritten = false;
	bool hasreturn = false;
	string functionName = "";

	std::string newLabel() {
		return "L" + std::to_string(labelCount++);
	}
    
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


	void writeIntoAssemblyFile(const std::string message) {
		if (!assemblyFile) {
			std::cout << "Error opening assemblyOutput.asm" << std::endl;
			return;
		}

		assemblyFile << message << std::endl;
		assemblyFile.flush();
	}
}


start : {
		str = ".model small\n.stack 1000h\n.data\n";
		writeIntoAssemblyFile(str);
}pg=program
	{
		symbolTable->PrintAllScopeTable();
		delete symbolTable;
		str = "print_output PROC\n"
		"    PUSH AX\n"
		"    PUSH BX\n"
		"    PUSH CX\n"
		"    PUSH DX\n"
		"    PUSH SI\n"
		"\n"
		"    ; Check if AX is negative\n"
		"    TEST AX, 8000h      ; Check sign bit\n"
		"    JZ CONTINUE_PRINT   ; If not negative, skip \n"
		"\n"
		"    MOV BX,AX\n"
		"    ; Print '-' sign\n"
		"    MOV AH, 02H\n"
		"    MOV DL, '-'\n"
		"    INT 21H\n"
		"\n"
		"    NEG BX              ; Make AX positive\n"
		"    MOV AX,BX\n"
		"\n"
		"CONTINUE_PRINT:\n"
		"    XOR DX, DX\n"
		"    MOV BX, 10\n"
		"    MOV CX, 0\n"
		"\n"
		"EXTRACT_DIGIT:\n"
		"    DIV BX              ; AX / 10, quotient in AX, remainder in DX\n"
		"    PUSH DX             ; Store remainder (digit)\n"
		"    XOR DX, DX\n"
		"    INC CX              ; Count digits\n"
		"    CMP AX, 0\n"
		"    JNE EXTRACT_DIGIT\n"
		"\n"
		"PRINT_DIGIT:\n"
		"    POP DX\n"
		"    ADD DL, '0'\n"
		"    MOV AH, 02H\n"
		"    INT 21H\n"
		"    LOOP PRINT_DIGIT\n"
		"\n"
		"    ; New line\n"
		"    MOV DL, 0DH\n"
		"    MOV AH, 02H\n"
		"    INT 21H\n"
		"    MOV DL, 0AH\n"
		"    MOV AH, 02H\n"
		"    INT 21H\n"
		"\n"
		"    POP SI\n"
		"    POP DX\n"
		"    POP CX\n"
		"    POP BX\n"
		"    POP AX\n"
		"    RET\n"
		"print_output ENDP\n";
		writeIntoAssemblyFile(str);
	}
	;

program : pg=program unt=unit {
	writeIntoparserLogFile("Line " + std::to_string($unt.stop->getLine()) + ":" + " program : program unit\n");
	writeIntoparserLogFile($pg.text + "\n" + $unt.text + "\n\n");
}
	| unt=unit {
	writeIntoparserLogFile("Line " + std::to_string($unt.stop->getLine()) + ":" + " program : unit\n");
	writeIntoparserLogFile($unt.text + "\n");
	}
	;
	
unit : var_dec=var_declaration { 
	writeIntoparserLogFile("Line " + std::to_string($var_dec.start->getLine()) + ":" + " unit : var_declaration\n"); 
	writeIntoparserLogFile($var_dec.text + "\n\n"); 
}
     | {
		if(!iscodewritten){
			str = ".code\n";
			str += "MOV AX, @DATA\n";
			str += "MOV DS, AX\n";
			str += "\nCALL main\n";
			writeIntoAssemblyFile(str);
			iscodewritten = true;
		}
	 }func_dec=func_declaration {
		writeIntoparserLogFile("Line " + std::to_string($func_dec.stop->getLine()) + ":" + " unit : func_declaration\n");
		writeIntoparserLogFile($func_dec.text + "\n\n");
	 }
     | {
		if(!iscodewritten){
			str = ".code\n";
			str += "\nCALL main\n";
			writeIntoAssemblyFile(str);
			iscodewritten = true;
		}
	 } func_def=func_definition {
		writeIntoparserLogFile("Line " + std::to_string($func_def.stop->getLine()) + ":" + " unit : func_definition\n");
		writeIntoparserLogFile($func_def.text + "\n");
	 }
     ;

func_declaration : t=type_specifier id=ID {
	if(symbolTable->LookUp($id.text)){
		writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
		writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
		syntaxErrorCount++;
	} 
} lp=LPAREN pl=parameter_list rp=RPAREN sm=SEMICOLON {
			writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
			writeIntoparserLogFile($t.text + " " + $id.text + $lp.text + $pl.text +$rp.text + $sm.text + "\n\n");
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
		writeIntoparserLogFile("Line " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' already declared.");
		syntaxErrorCount++;
	} 
		} lp=LPAREN rp=RPAREN sm=SEMICOLON {
			writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
			writeIntoparserLogFile($t.text + " " + $id.text + $lp.text + $rp.text + $sm.text + "\n\n");
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
				writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
				syntaxErrorCount++;
			}
			else if(existing->additionalInfo.isDefined) {
				writeIntoparserLogFile("Line# " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' is already defined.");
                writeIntoErrorFile("Line# " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' is already defined.");
                syntaxErrorCount++;
            }
        }
		else{
			SymbolAdditionalInfo info = SymbolAdditionalInfo();
			info.deleted = true;
			info.isFunction = true;
			info.isDefined = true;
			info.returnType = $t.text;
			symbolTable->Insert($id.text, "ID",  info);
		}
		functionName = $id.text;
		code = $id.text + " PROC\n";
		code += "push BP\n";
		code += "mov BP, SP\n";
		stackOffset = 0;
        writeIntoAssemblyFile(code);
} lp=LPAREN { symbolTable->Enter_scope(); } pl=parameter_list { 
if($pl.params.size() == $pl.names.size()){
		for(int i = 0; i < $pl.params.size(); i++){
		SymbolAdditionalInfo info = SymbolAdditionalInfo();
		info.dataType = $pl.params[i];
		info.isGlobal = (symbolTable->getCurrentScopeId() == "1")? true : false;
		stackOffset += 2;
		info.offset = stackOffset;
		code = "SUB SP, 2\n";
		code += "MOV AX, [BP + " + std::to_string(($pl.params.size() - i) * 2 + 2) + "]" + "\n";
		code += "MOV [BP - " + std::to_string(stackOffset) + "], AX\n";
		writeIntoAssemblyFile(code);
		symbolTable->Insert($pl.names[i], "ID", info);
	}
}
 } rp=RPAREN {
		existing = symbolTable->LookUp($id.text);
		if(existing && existing->additionalInfo.isFunction){
			if(!existing->additionalInfo.isDefined){
				if(existing->additionalInfo.parameters != $pl.params) {
					syntaxErrorCount++;
					if(existing->additionalInfo.parameters.size() != $pl.params.size()){
						writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + $id.text + "\n");
						writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + $id.text + "\n");
					}
					}
				if(existing->additionalInfo.returnType != $t.text) {
					writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Return type mismatch with function declaration in function " + $id.text + "\n");
					writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Return type mismatch with function declaration in function " + $id.text + "\n");
					syntaxErrorCount++;
				}
				existing->additionalInfo.isDefined = true;
			}
			else{
				existing->additionalInfo.parameters = $pl.params;
			}
		}
 } cm_stmt=compound_statement[true] {
			writeIntoparserLogFile("Line " + std::to_string($cm_stmt.stop->getLine()) + ":" + " func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n");
			writeIntoparserLogFile($t.text + " " + $id.text + $lp.text + $pl.text + $rp.text + $cm_stmt.text + "\n");
			code ="";
			if(!hasreturn){
				code += "MOV SP, BP\n";
			    code += "POP BP\n";
				code += "RET\n";
			}
			else{
				hasreturn = false;
			}
			code += $id.text + " ENDP\n";
            writeIntoAssemblyFile(code);
}
		| t=type_specifier id=ID {
	existing = symbolTable->LookUp($id.text);
	if (existing) {
			if(!existing->additionalInfo.isFunction){
				writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Multiple declaration of " + $id.text + "\n");
				syntaxErrorCount++;
			}
			else if(existing->additionalInfo.isDefined) {
				writeIntoparserLogFile("Line# " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' is already defined.");
                writeIntoErrorFile("Line# " + std::to_string($id->getLine()) + " - Error: Function '" + $id.text + "' is already defined.");
                syntaxErrorCount++;
            }
        }
		else{
			SymbolAdditionalInfo info = SymbolAdditionalInfo();
			info.deleted = true;
			info.isFunction = true;
			info.isDefined = true;
			info.returnType = $t.text;
			symbolTable->Insert($id.text, "ID",  info);
		}
		functionName = $id.text;
        code = $id.text + " PROC\n";
		code += "push BP\n";
		code += "mov BP, SP\n";
		stackOffset = 0;
        writeIntoAssemblyFile(code);
} lp=LPAREN { symbolTable->Enter_scope(); } rp=RPAREN {
		existing = symbolTable->LookUp($id.text);
		if(existing && existing->additionalInfo.isFunction){
			if(!existing->additionalInfo.isDefined){
				if(existing->additionalInfo.returnType != $t.text) {
					writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Return type mismatch with function declaration in function " + $id.text + "\n");
					writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Return type mismatch with function declaration in function " + $id.text + "\n");
					syntaxErrorCount++;
				}
				if(existing->additionalInfo.parameters.size() > 0){
				writeIntoparserLogFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + $id.text + "\n");				
				writeIntoErrorFile("Error at line " + std::to_string($id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + $id.text + "\n");
				syntaxErrorCount++;
		        }
				existing->additionalInfo.isDefined = true;
			}
		}
} cm_stmt=compound_statement[true] {
			writeIntoparserLogFile("Line " + std::to_string($cm_stmt.stop->getLine()) + ":" + " func_definition : type_specifier ID LPAREN RPAREN compound_statement\n");
			writeIntoparserLogFile($t.text + " " + $id.text + $lp.text + $rp.text + $cm_stmt.text + "\n");
			code ="";
			if(!hasreturn){
				code += "MOV SP, BP\n";
			    code += "POP BP\n";
				code += "RET\n";
			}
			else{
				hasreturn = false;
			}
			code += $id.text + " ENDP\n";
            writeIntoAssemblyFile(code);
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
        | pl=parameter_list cm=COMMA t=type_specifier op=(ADDOP|MULOP|ASSIGNOP|LOGICOP|RELOP) {
			$params = $pl.params;
			$names = $pl.names;
			$params.push_back($t.text);
			$names.push_back("error");
			// $text = $pl.text + $cm.text + $t.text;
			writeIntoparserLogFile("Line " + std::to_string($cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier ID\n");
	        writeIntoparserLogFile($pl.text + $cm.text + $t.text + " " + "\n");
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
	 $names.push_back("");
		}
		| t=type_specifier op=(ADDOP|MULOP|ASSIGNOP|LOGICOP|RELOP) {
			$params.push_back($t.text);
			$names.push_back("error");
			// $text = $t.text;
			writeIntoparserLogFile("Line " + std::to_string($t.stop->getLine()) + ":" + " parameter_list : type_specifier\n");
	        writeIntoparserLogFile($t.text + "\n");
		}
 		;


compound_statement[bool IsFunction] : LCURL {
	if(!IsFunction){
	symbolTable->Enter_scope();
 }
} stmts=statements RCURL {
			writeIntoparserLogFile("Line " + std::to_string($RCURL->getLine()) + ":" + " compound_statement : LCURL statements RCURL\n");
			writeIntoparserLogFile($LCURL->getText() + "\n" + $stmts.text + "\n" + $RCURL->getText() + "\n");
			symbolTable->PrintAllScopeTable();
			symbolTable->Remove_scope();
}
 		    | LCURL {
				 if(!IsFunction){
		 symbolTable->Enter_scope();
	 }
			} RCURL {
			writeIntoparserLogFile("Line " + std::to_string($RCURL->getLine()) + ":" + " compound_statement : LCURL RCURL\n");
			writeIntoparserLogFile($LCURL->getText() + $RCURL->getText() + "\n");
			symbolTable->PrintAllScopeTable();
			symbolTable->Remove_scope();
			}
 		    ;
 		    
var_declaration 
    : t=type_specifier dl=declaration_list sm=SEMICOLON {
        cout << $dl.decls.size() << endl;
		for(int i = 0; i < $dl.decls.size(); i++) {

			SymbolAdditionalInfo info = SymbolAdditionalInfo();
			info.dataType = $t.text;
			info.isArray = $dl.decls[i].second;
			info.arraySize = $dl.arrsize[i];
			info.isGlobal = (symbolTable->getCurrentScopeId() == "1")? true : false;

			if(info.isGlobal){
				if($dl.decls[i].second){
					datacode = $dl.decls[i].first + " DW " + std::to_string($dl.arrsize[i]) + " DUP(0)\n";
				}
				else{
					datacode = $dl.decls[i].first + " DW 0\n";
				}
				writeIntoAssemblyFile(datacode);
			}
			else{
				if($dl.decls[i].second){
					code = "SUB SP, " + std::to_string($dl.arrsize[i] * 2) + "\n";
					stackOffset += $dl.arrsize[i] * 2;
					info.offset = stackOffset;
                    writeIntoAssemblyFile(code);
				}
				else{
					code = "SUB SP, 2\n";
					stackOffset += 2;
					info.offset = stackOffset;
                    writeIntoAssemblyFile(code);
				}
			}
			symbolTable->Insert($dl.decls[i].first, "ID", info);
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
		| decl=declaration_list (ASSIGNOP|MULOP|LOGICOP|RELOP|ADDOP) ID {
			// writeIntoparserLogFile("Error at line " + std::to_string($ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
			// writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
			writeIntoparserLogFile("Error at line " + std::to_string($ID->getLine()) + ":" + " syntax error\n");
			writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ":" + " syntax error\n");
			syntaxErrorCount++;
			$decls = $decl.decls;
			$arrsize = $decl.arrsize;
			$decls.push_back({"error_id", false});
			$arrsize.push_back(0);
		}
		| decl=declaration_list (ASSIGNOP|MULOP|LOGICOP|RELOP|ADDOP) ID LTHIRD CONST_INT RTHIRD {
			// writeIntoparserLogFile("Error at line " + std::to_string($ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
			// writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
			writeIntoparserLogFile("Error at line " + std::to_string($ID->getLine()) + ":" + " syntax error\n");
			writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ":" + " syntax error\n");
			syntaxErrorCount++;
			$decls = $decl.decls;
			$arrsize = $decl.arrsize;
			$decls.push_back({"error_id", true});
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
	writeIntoparserLogFile($stmt.text + "\n\n");
}
	   | stmts=statements stmt=statement {
	writeIntoparserLogFile("Line " + std::to_string($stmt.stop->getLine()) + ":" + " statements : statements statement\n");
	writeIntoparserLogFile($stmts.text + "\n" + $stmt.text +"\n");
	   }
	   ;
	   
statement : var_dec=var_declaration {
	writeIntoparserLogFile("Line " + std::to_string($var_dec.stop->getLine()) + ":" + " statement : var_declaration\n");
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
	  | fr=FOR lp=LPAREN expr_stmt1=expression_statement {
		forlabel = newLabel();
		code = forlabel + ":\n";
		writeIntoAssemblyFile(code);
	  } expr_stmt2=expression_statement {
		code = "POP AX\n";
		code += "CMP AX, 0\n";
		forlabel2 = newLabel();
		code += "JE " + forlabel2 + "\n";
		forlabel3 = newLabel();
		code += "JMP " + forlabel3 + "\n";
		forlabel4 = newLabel();
		code += forlabel4 + ":\n";
		writeIntoAssemblyFile(code);
	  } expr=expression {
		code = "JMP " + forlabel + "\n";
		writeIntoAssemblyFile(code);
	  } rp=RPAREN {
		code = forlabel3 + ":\n";
		writeIntoAssemblyFile(code);
	  } stmt=statement {
		code = "JMP " + forlabel4 + "\n";
		code += forlabel2 + ":\n";
		writeIntoAssemblyFile(code);
	  }
	  | iff=IF lp=LPAREN expr=expression rp=RPAREN {

		code = "POP AX\n";
		code += "CMP AX, 0\n";
		str = newLabel();
		code += "JE " + str + "\n";
		writeIntoAssemblyFile(code);
	  } stmt=statement {
		code = str + ":\n";
		writeIntoAssemblyFile(code);
	  }
	  | iff=IF lp=LPAREN expr=expression rp=RPAREN {

		code = "POP AX\n";
		code += "CMP AX, 0\n";
		str = newLabel();
		code += "JE " + str + "\n";
		writeIntoAssemblyFile(code);

	  } stmt1=statement {

		str2 = newLabel();
		code = "JMP " + str2 + "\n";
		writeIntoAssemblyFile(code);
		labelStack.push(str2);

	  } els=ELSE {

		code = str + ":\n";
		writeIntoAssemblyFile(code);

	  } stmt2=statement {

		code = labelStack.top() + ":\n";
		labelStack.pop();
		writeIntoAssemblyFile(code);
	  }
	  | whl=WHILE lp=LPAREN {
		whilelabel = newLabel();
		code = whilelabel + ":\n";
		writeIntoAssemblyFile(code);
	  } expr=expression rp=RPAREN {
		code = "POP AX\n";
		code += "CMP AX, 0\n";
		whilelabel2 = newLabel();
		code += "JE " + whilelabel2 + "\n";
		writeIntoAssemblyFile(code);
	  } stmt=statement {
		code = "JMP " + whilelabel + "\n";
		code += whilelabel2 + ":\n";
		writeIntoAssemblyFile(code);
	  }
	  | prln=PRINTLN lp=LPAREN id=ID rp=RPAREN sm=SEMICOLON {
	writeIntoparserLogFile("Line " + std::to_string($prln->getLine()) + ":" + " statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n");
	writeIntoparserLogFile($prln.text + $lp.text + $id.text + $rp.text + $sm.text + "\n");
	existing = symbolTable->LookUp($id.text);
	if(existing) {
		if(existing->additionalInfo.isArray) {

		}
		else{
			if(existing->additionalInfo.isGlobal){
				code = "MOV AX, " + $id.text + "\n";
				code += "CALL print_output\n";
				writeIntoAssemblyFile(code);
			}
			else{
				code = "MOV AX, [BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
				code += "CALL print_output\n";
				writeIntoAssemblyFile(code);
			}
		}
	}
	  }
	  | rtn=RETURN expr=expression sm=SEMICOLON {
	writeIntoparserLogFile("Line " + std::to_string($rtn->getLine()) + ":" + " statement : RETURN expression SEMICOLON\n");
	writeIntoparserLogFile($rtn.text + " " + $expr.text + $sm.text + "\n\n");
	code = "POP CX\n";
	code += "MOV SP, BP\n";
	code += "POP BP\n";
	if(functionName == "main") {
		code += "MOV AX, 4CH\n";
		code += "INT 21h\n";
	}
	code += "RET\n";
	writeIntoAssemblyFile(code);
	hasreturn = true;
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
	  
variable returns [std::string datatype,std::string place,std::string index]: ID  {
	writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " variable : ID\n");
	writeIntoparserLogFile($ID->getText() + "\n");
	existing = symbolTable->LookUp($ID->getText());
	if(existing) {
		$datatype = existing->additionalInfo.dataType;
		if(existing->additionalInfo.isArray) {
			writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ": Type mismatch," + $ID->getText() + " is an array" + "\n");
			writeIntoparserLogFile("Error at line " + std::to_string($ID->getLine()) + ": Type mismatch," + $ID->getText() + " is an array" + "\n");
			syntaxErrorCount++;
		}
	}
	else {
		writeIntoErrorFile("Error at line " + std::to_string($ID->getLine()) + ":" + " Undeclared variable " + $ID->getText() + "\n");
		writeIntoparserLogFile("Error at line " + std::to_string($ID->getLine()) + ":" + " Undeclared variable " + $ID->getText() + "\n");
		syntaxErrorCount++;
		$datatype = "error";
	}
    existing = symbolTable->LookUp($ID->getText());
    if(existing){
        if(existing->additionalInfo.isGlobal){
            code = "MOV AX, " + $ID->getText() + "\n";
            code += "PUSH AX\n";
            writeIntoAssemblyFile(code);
        }
        else{
            code = "MOV AX, [BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
            code += "PUSH AX\n";
            writeIntoAssemblyFile(code);
        }
    }
	$place = $ID->getText();
	$index = "";
}		
	 | ID LTHIRD expr=expression RTHIRD {
	writeIntoparserLogFile("Line " + std::to_string($LTHIRD->getLine()) + ":" + " variable : ID LTHIRD expression RTHIRD\n");
	writeIntoparserLogFile($ID->getText() + $LTHIRD->getText() + $expr.text + $RTHIRD->getText() + "\n");
	existing = symbolTable->LookUp($ID->getText());
	if(existing) {
		$datatype = existing->additionalInfo.dataType;
		if(existing->additionalInfo.isGlobal){
			code = "LEA SI, " + $ID->getText() + "\n";
			code += "POP AX\n";
			code += "SHL AX, 1\n";
			code += "ADD SI, AX\n";
			code += "PUSH AX\n";
			code += "MOV AX, [SI]\n";
			code += "PUSH AX\n";
			writeIntoAssemblyFile(code);
		}
		else{
			code = "POP AX\n";
			code += "SHL AX, 1\n";
			code += std::string("MOV BX, ") + std::to_string(existing->additionalInfo.offset) + "\n";
			code += "SUB BX, AX\n";
			code += "PUSH BX\n";
			code += "PUSH BP\n";
			code += "SUB BP, BX\n";
			code += "MOV AX, [BP]\n";
			code += "POP BP\n";
			code += "PUSH AX\n";
			writeIntoAssemblyFile(code);
		}
	}
	$place = $ID->getText();
	$index = $expr.text;
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
	existing = symbolTable->LookUp($var.place);
	if(existing){
		if(existing->additionalInfo.isArray){
			if(existing->additionalInfo.isGlobal){
				code = "POP AX\n";
				code += "POP BX\n";
				code += "POP BX\n";
				code += "LEA SI, " + $var.place + "\n";
				code += "ADD SI, BX\n";
				code += "MOV [SI], AX\n";
				code += "PUSH AX\n";
				writeIntoAssemblyFile(code);
			}
			else{
				code = "POP AX\n";
				code += "POP BX\n";
				code += "POP BX\n";
				code += "PUSH BP\n";
				code += "SUB BP, BX\n";
				code += "MOV [BP], AX\n";
				code += "POP BP\n";
				code += "PUSH AX\n";
				writeIntoAssemblyFile(code);
			}
		}
		if(existing->additionalInfo.isGlobal){
			code = "POP BX\n";
	        code += "POP AX\n";
			code += "MOV " + $var.place + ", BX\n";
			code += "PUSH BX\n";
		}
		else{
			code = "POP BX\n";
	        code += "POP AX\n";
			code += "MOV [BP - " + std::to_string(existing->additionalInfo.offset) + "], BX\n";
			code += "PUSH BX\n";
		}
		writeIntoAssemblyFile(code);
	}
	   }	
	   ;
			
logic_expression returns [std::string datatype]: rlexpr=rel_expression {
	writeIntoparserLogFile("Line " + std::to_string($rlexpr.start->getLine()) + ":" + " logic_expression : rel_expression\n");
	writeIntoparserLogFile($rlexpr.text + "\n");
	$datatype = $rlexpr.datatype;
} 	
		 | rlexpr1=rel_expression LOGICOP rlexpr2=rel_expression {
	writeIntoparserLogFile("Line " + std::to_string($LOGICOP->getLine()) + ":" + " logic_expression : rel_expression LOGICOP rel_expression\n");
	writeIntoparserLogFile($rlexpr1.text + $LOGICOP->getText() + $rlexpr2.text + "\n");
	$datatype = $rlexpr1.datatype;
		code = "POP BX\n";
		code += "POP AX\n";
		if($LOGICOP->getText() == "&&"){
			code += "AND AX, BX\n";
			code += "PUSH AX\n";
		}
		else if($LOGICOP->getText() == "||"){
			code += "OR AX, BX\n";
			code += "PUSH AX\n";
		}
		writeIntoAssemblyFile(code);
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

	    code = "POP BX\n";
		code += "POP AX\n";
		str = newLabel();
		if($RELOP->getText() == "=="){
			code += "CMP AX, BX\n";
			code += std::string("JE ") + str + "\n";
			code += "MOV AX, 0\n";
			code += std::string("JMP ") + str + "_end\n";
			code += str + ":\n";
			code += "MOV AX, 1\n";
			code += str + "_end:\n";
			code += "PUSH AX\n";
		}
		else if($RELOP->getText() == "!="){
			code += "CMP AX, BX\n";
			code += std::string("JNE ") + str + "\n";
			code += "MOV AX, 0\n";
			code += std::string("JMP ") + str + "_end\n";
			code += str + ":\n";
			code += "MOV AX, 1\n";
			code += str + "_end:\n";
			code += "PUSH AX\n";
		}
		else if($RELOP->getText() == "<"){
			code += "CMP AX, BX\n";
			code += std::string("JL ") + str + "\n";
			code += "MOV AX, 0\n";
			code += std::string("JMP ") + str + "_end\n";
			code += str + ":\n";
			code += "MOV AX, 1\n";
			code += str + "_end:\n";
			code += "PUSH AX\n";
		}
		else if($RELOP->getText() == "<="){
			code += "CMP AX, BX\n";
			code += std::string("JLE ") + str + "\n";
			code += "MOV AX, 0\n";
			code += std::string("JMP ") + str + "_end\n";
			code += str + ":\n";
			code += "MOV AX, 1\n";
			code += str + "_end:\n";
			code += "PUSH AX\n";
		}
		else if($RELOP->getText() == ">"){
			code += "CMP AX, BX\n";
			code += std::string("JG ") + str + "\n";
			code += "MOV AX, 0\n";
			code += std::string("JMP ") + str + "_end\n";
			code += str + ":\n";
			code += "MOV AX, 1\n";
			code += str + "_end:\n";
			code += "PUSH AX\n"; // result in AX
		}
		else if($RELOP->getText() == ">="){
			code += "CMP AX, BX\n";
			code += std::string("JGE ") + str + "\n";
			code += "MOV AX, 0\n";
			code += std::string("JMP ") + str + "_end\n";
			code += str + ":\n";
			code += "MOV AX, 1\n";
			code += str + "_end:\n";
			code += "PUSH AX\n"; // result in AX
		}
		writeIntoAssemblyFile(code);
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
	    code = "POP BX\n";
		code += "POP AX\n";
		if($ADDOP->getText() == "+"){
			code += "ADD AX, BX\n";
			code += "PUSH AX\n";
		}
		else if($ADDOP->getText() == "-"){
			code += "SUB AX, BX\n";
			code += "PUSH AX\n"; // difference in AX
		}
		writeIntoAssemblyFile(code);
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
		code = "POP BX\n";
		code += "POP AX\n";
		if($MULOP->getText() == "*"){
			code += "MUL BX\n";
			code += "PUSH AX\n";
		}
		else if($MULOP->getText() == "/"){
			code += "XOR DX, DX\n";
			code += "DIV BX\n";
			code += "PUSH AX\n"; // quotient in AX
		}
		else if($MULOP->getText() == "%"){
			code += "XOR DX, DX\n";
			code += "DIV BX\n";
			code += "PUSH DX\n"; // remainder in DX
		}
		writeIntoAssemblyFile(code);
	 }
     ;

unary_expression returns [std::string datatype]: ADDOP unexpr=unary_expression  {
		writeIntoparserLogFile("Line " + std::to_string($ADDOP->getLine()) + ":" + " unary_expression : ADDOP unary_expression\n");
		writeIntoparserLogFile($ADDOP->getText() + $unexpr.text + "\n");
		$datatype = $unexpr.datatype;
		if($ADDOP->getText() == "-"){
			code = "POP AX\n";
			code += "NEG AX\n";
			code += "PUSH AX\n";
			writeIntoAssemblyFile(code);
		}
}
		| NOT unexpr=unary_expression {
		writeIntoparserLogFile("Line " + std::to_string($NOT->getLine()) + ":" + " unary_expression : NOT unary_expression\n");
		writeIntoparserLogFile($NOT->getText() + $unexpr.text + "\n");
		$datatype = "int";
		code = "POP AX\n";
		code += "NOT AX\n";
		code += "PUSH AX\n";
		writeIntoAssemblyFile(code);

		}
		| fctr=factor {
		writeIntoparserLogFile("Line " + std::to_string($fctr.start->getLine()) + ":" + " unary_expression : factor\n");
		writeIntoparserLogFile($fctr.text + "\n");
		$datatype = $fctr.datatype;
		}
		 ;
	
factor returns [std::string datatype]	: var=variable {
		$datatype = $var.datatype;
		existing = symbolTable->LookUp($var.text);
		if(existing){
			if(existing->additionalInfo.isArray){
				code = "POP AX\n";
				code += "POP BX\n";
				code += "PUSH AX\n";
				writeIntoAssemblyFile(code);
			}
		}
    }
	| id=ID lp=LPAREN argl=argument_list rp=RPAREN {
		writeIntoparserLogFile("Line " + std::to_string($argl.start->getLine()) + ":" + " factor : ID LPAREN argument_list RPAREN\n");
		writeIntoparserLogFile($id.text + $lp.text + $argl.text + $rp.text + "\n");
		$datatype = existing->additionalInfo.returnType;
		existing = symbolTable->LookUp($id.text);
		code = "CALL " + $id.text + "\n";
		for(int i = 0; i< $argl.argtypes.size(); i++) {
			code += "POP DX\n";
		}
		// if(hasreturn){
		// 	code += "PUSH CX\n";
		// 	hasreturn = false;
		// }

		code += "PUSH CX\n";
		writeIntoAssemblyFile(code);
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
		code = "MOV AX, " + $CONST_INT->getText() + "\n";
		code += "PUSH AX\n";
		writeIntoAssemblyFile(code);
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
		existing = symbolTable->LookUp($var.place);
		if(existing){
			if(existing->additionalInfo.isArray){
				if(existing->additionalInfo.isGlobal){
					code = "LEA SI, " + $var.text + "\n";
					code += "POP AX\n";
					code += "POP BX\n";
					code += "ADD SI, BX\n";
					code += "INC WORD PTR[SI]\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "POP AX\n";
					code += "POP BX\n";
					code += "PUSH BP\n";
					code += "SUB BP, BX\n";
					code += "INC WORD PTR[BP]\n";
					code += "POP BP\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
			}
			else{
				if(existing->additionalInfo.isGlobal){
					code = "INC " + $var.text + "\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "INC WORD PTR[BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
					writeIntoAssemblyFile(code);
				}
			}
		}
	}
	| var=variable DECOP {
		writeIntoparserLogFile("Line " + std::to_string($DECOP->getLine()) + ":" + " factor : variable DECOP\n");
		writeIntoparserLogFile($DECOP->getText() + "\n");
		$datatype = $var.datatype;
		existing = symbolTable->LookUp($var.text);
		if(existing){
			if(existing->additionalInfo.isArray){
				if(existing->additionalInfo.isGlobal){
					code = "LEA SI, " + $var.text + "\n";
					code += "POP AX\n";
					code += "POP BX\n";
					code += "ADD SI, BX\n";
					code += "DEC WORD PTR[SI]\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "POP AX\n";
					code += "POP BX\n";
					code += "PUSH BP\n";
					code += "SUB BP, BX\n";
					code += "DEC WORD PTR[BP]\n";
					code += "POP BP\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
			}
			else{
				if(existing->additionalInfo.isGlobal){
					code = "DEC " + $var.text + "\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "DEC WORD PTR[BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
					writeIntoAssemblyFile(code);
				}
			}
		}
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