parser grammar C8086Parser;

options {
    tokenVocab = C8086Lexer;
}

@parser::header {
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
	#include <sstream>
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
	// string label1 = "";
	// string label2 = "";
	// string label3 = "";
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

	vector<string> split(const string& s, char delimiter) {
		vector<string> tokens;
		string token;
		istringstream tokenStream(s);
		while (getline(tokenStream, token, delimiter)) {
			tokens.push_back(token);
		}
		return tokens;
	}


	void writeIntoAssemblyFile(const std::string message) {
		if (!assemblyFile) {
			std::cout << "Error opening assemblyOutput.asm" << std::endl;
			return;
		}

		vector<string> lines = split(message, '\n');
		for(string line: lines){
			if(line.empty()) {
				continue;
			}
			if(line[0] != '.' && line.find(":") == std::string::npos && line.find("PROC") == std::string::npos && line.find("ENDP") == std::string::npos) {
				assemblyFile << "\t";
			}
			assemblyFile << line << std::endl;

		}
		// if(message[0] != '.' && message.find(":") == std::string::npos && message.find("PROC") == std::string::npos && message.find("ENDP") == std::string::npos) {
		// 	assemblyFile << "\t";
		// }
		// assemblyFile << message ;
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

program : pg=program unt=unit 
	| unt=unit 
	;
	
unit : var_dec=var_declaration 
     | {
		if(!iscodewritten){
			str = ".code\n";
			str += "MOV AX, @DATA\n";
			str += "MOV DS, AX\n";
			str += "\nCALL main\n";
			writeIntoAssemblyFile(str);
			iscodewritten = true;
		}
	 }func_dec=func_declaration 
     | {
		if(!iscodewritten){
			str = ".code\n";
			str += "\nCALL main\n";
			writeIntoAssemblyFile(str);
			iscodewritten = true;
		}
	 } func_def=func_definition 
     ;

func_declaration : t=type_specifier id=ID {
	if(symbolTable->LookUp($id.text)){
		syntaxErrorCount++;
	} 
} lp=LPAREN pl=parameter_list rp=RPAREN sm=SEMICOLON {
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
		syntaxErrorCount++;
	} 
		} lp=LPAREN rp=RPAREN sm=SEMICOLON {
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
				syntaxErrorCount++;
			}
			else if(existing->additionalInfo.isDefined) {
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
		code = $id.text + " PROC" + "\t\t;line  " + std::to_string($id->getLine()) + "\n";
		code += "PUSH BP\n";
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
					}
				}
				if(existing->additionalInfo.returnType != $t.text) {
					syntaxErrorCount++;
				}
				existing->additionalInfo.isDefined = true;
			}
			else{
				existing->additionalInfo.parameters = $pl.params;
			}
		}
 } cm_stmt=compound_statement[true] {
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
				syntaxErrorCount++;
			}
			else if(existing->additionalInfo.isDefined) {
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
        code = $id.text + " PROC" + "\t\t;line  " + std::to_string($id->getLine()) + "\n";
		code += "PUSH BP\n";
		code += "mov BP, SP\n";
		stackOffset = 0;
        writeIntoAssemblyFile(code);
} lp=LPAREN { symbolTable->Enter_scope(); } rp=RPAREN {
		existing = symbolTable->LookUp($id.text);
		if(existing && existing->additionalInfo.isFunction){
			if(!existing->additionalInfo.isDefined){
				if(existing->additionalInfo.returnType != $t.text) {
					syntaxErrorCount++;
				}
				if(existing->additionalInfo.parameters.size() > 0){
				syntaxErrorCount++;
		        }
				existing->additionalInfo.isDefined = true;
			}
		}
} cm_stmt=compound_statement[true] {
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
	$params = $pl.params;
    $params.push_back($t.text);
	$names = $pl.names;
	$names.push_back($id.text);
}       
		| pl=parameter_list cm=COMMA t=type_specifier {
	$params = $pl.params;
    $params.push_back($t.text);
	$names = $pl.names;
	$names.push_back($id.text);
		}
 		| t=type_specifier id=ID {
	$params.push_back($t.text);
	$names.push_back($id.text);
		}
		| t=type_specifier {
	$params.push_back($t.text);
	 $names.push_back("");
		}
 		;


compound_statement[bool IsFunction] : LCURL {
	if(!IsFunction){
	symbolTable->Enter_scope();
 }
} stmts=statements RCURL {
			symbolTable->PrintAllScopeTable();
			symbolTable->Remove_scope();
}
 		    | LCURL {
				 if(!IsFunction){
		 symbolTable->Enter_scope();
	 }
			} RCURL {
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
					datacode = std::string($dl.decls[i].first) + " DW " + std::to_string($dl.arrsize[i]) + " DUP(0)" + "\t\t;line  " + std::to_string($sm->getLine()) + "\n";
				}
				else{
					datacode = std::string($dl.decls[i].first) + " DW 0" + "\t\t;line  " + std::to_string($sm->getLine()) + "\n";
				}
				writeIntoAssemblyFile(datacode);
			}
			else{
				if($dl.decls[i].second){
					code = "SUB SP, " + std::to_string($dl.arrsize[i] * 2) + "\t\t;line  " + std::to_string($sm->getLine()) + "\n";
					stackOffset += $dl.arrsize[i] * 2;
					info.offset = stackOffset;
                    writeIntoAssemblyFile(code);
				}
				else{
					code = std::string("SUB SP, 2") + "\t\t;line  " + std::to_string($sm->getLine()) + "\n";
					stackOffset += 2;
					info.offset = stackOffset;
                    writeIntoAssemblyFile(code);
				}
			}
			symbolTable->Insert($dl.decls[i].first, "ID", info);
		}
      }

    | t=type_specifier de=declaration_list_err sm=SEMICOLON {
        syntaxErrorCount++;
      }
    ;

declaration_list_err returns [std::string error_name]: {
        $error_name = "Error in declaration list";
    };

 		 
type_specifier returns [std::string name_line]	
        : INT {
            $name_line = "type: INT at line" + std::to_string($INT->getLine());
        }
 		| FLOAT {
            $name_line = "type: FLOAT at line" + std::to_string($FLOAT->getLine());
        }
 		| VOID {
            $name_line = "type: VOID at line" + std::to_string($VOID->getLine());
        }
 		;
 		
declaration_list returns [std::vector<std::pair<std::string, bool>> decls, std::vector<int> arrsize]
		: decl=declaration_list COMMA ID {
			$decls = $decl.decls;
			$decls.push_back({$ID->getText(), false});
			$arrsize = $decl.arrsize;
			$arrsize.push_back(0);
		}
		| decl=declaration_list COMMA ID LTHIRD CONST_INT RTHIRD {
			$decls = $decl.decls;
			$decls.push_back({$ID->getText(), true});
			$arrsize = $decl.arrsize;
			$arrsize.push_back(std::stoi($CONST_INT->getText()));
		}
		| ID {
			$decls.push_back({$ID->getText(), false});
			$arrsize.push_back(0);
		}
		| ID LTHIRD CONST_INT RTHIRD {
			$decls.push_back({$ID->getText(), true});
			$arrsize.push_back(std::stoi($CONST_INT->getText()));
		}
		;
 		  
statements : stmt=statement 
	   | stmts=statements stmt=statement 
	   ;
	   
statement : var_dec=var_declaration 
	  | expr_stmt=expression_statement 
	  | cm_stmt=compound_statement[false] 
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
	code = "POP CX\n";
	code += "MOV SP, BP\n";
	code += "POP BP\n";
	if(functionName == "main") {
		code += "MOV AX, 4CH\n";
		code += "INT 21h\n";
	}
	code += std::string("RET") + "\t\t;line  " + std::to_string($rtn->getLine()) + "\n";
	writeIntoAssemblyFile(code);
	hasreturn = true;
	  }
	  ;
	  
expression_statement 	: SEMICOLON	
			| expr=expression SEMICOLON 
			;
	  
variable returns [std::string datatype,std::string place,std::string index]: ID  {
	existing = symbolTable->LookUp($ID->getText());
	if(existing) {
		$datatype = existing->additionalInfo.dataType;
		if(existing->additionalInfo.isArray) {
			syntaxErrorCount++;
		}
	}
	else {
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
	$datatype = $lgexpr.datatype;
 }
	   | var=variable ASSIGNOP lgexpr=logic_expression  {
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
	$datatype = $rlexpr.datatype;
}
		 | rlexpr1=rel_expression LOGICOP {
            string label1 = newLabel();
			// label3 = newLabel();
			code = "POP AX\n";
			if($LOGICOP->getText() == "&&"){
				code += "CMP AX, 0\n";
				code += "JE " + label1 + "\n";
			}
			else if($LOGICOP->getText() == "||"){
				code += "CMP AX, 0\n";
				code += "JNE " + label1 + "\n";
			}
			writeIntoAssemblyFile(code);
		 } rlexpr2=rel_expression {
	     $datatype = $rlexpr1.datatype;
		 string label2 = newLabel();
		 code = "POP AX\n";
		 if($LOGICOP->getText() == "&&"){
			 code += "CMP AX, 0\n";
			 code += "JE " + label1 + "\n";
			 code += "MOV AX, 1\n";
			 code += "JMP " + label2 + "\n";
			 code += label1 + ":\n";
			 code += "MOV AX, 0\n";
			 code += label2 + ":\n";
		 }
		 else if($LOGICOP->getText() == "||"){
			 code += "CMP AX, 0\n";
			 code += "JNE " + label1 + "\n";
			 code += "MOV AX, 0\n";
			 code += "JMP " + label2 + "\n";
			 code += label1 + ":\n";
			 code += "MOV AX, 1\n";
		     code += label2 + ":\n";
		 }
		 code += "PUSH AX\n";
		 writeIntoAssemblyFile(code);
	}	
		 ;
			
rel_expression	returns [std::string datatype]: smexpr=simple_expression {
	$datatype = $smexpr.datatype;
}
		| smexpr1=simple_expression RELOP smexpr2=simple_expression	{
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
	$datatype = $trm.datatype;
}
		  | smexpr=simple_expression ADDOP trm=term {
	if($smexpr.datatype == "float" || $trm.datatype == "float") {
		$datatype = "float";
	}
	else{
		$datatype = "int";
	}
	    code = "POP BX\n";
		code += "POP AX\n";
		if($ADDOP->getText() == "+"){
			code += std::string("ADD AX, BX") + "\t\t;line  " + std::to_string($ADDOP->getLine()) + "\n";
			code += "PUSH AX\n";
		}
		else if($ADDOP->getText() == "-"){
			code += std::string("SUB AX, BX") + "\t\t;line  " + std::to_string($ADDOP->getLine()) + "\n";
			code += "PUSH AX\n"; // difference in AX
		}
		writeIntoAssemblyFile(code);
	}
		  ;
					
term returns [std::string datatype]:	unexpr=unary_expression {
	$datatype = $unexpr.datatype;
}
     |  trm=term MULOP unexpr=unary_expression {
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
			code += std::string("MUL BX") + "\t\t;line  " + std::to_string($MULOP->getLine()) + "\n";
			code += "PUSH AX\n";
		}
		else if($MULOP->getText() == "/"){
			// code += "CWD\n"; // convert word to double word
			// code += "IDIV BX\n"; // divide AX by BX
			code += "XOR DX, DX\n";
			code += std::string("DIV BX") + "\t\t;line  " + std::to_string($MULOP->getLine()) + "\n";
			code += "PUSH AX\n"; // quotient in AX
		}
		else if($MULOP->getText() == "%"){
			// code += "CWD\n"; // convert word to double word
			// code += "IDIV BX\n"; // divide AX by BX
			code += "XOR DX, DX\n";
			code += std::string("DIV BX") + "\t\t;line  " + std::to_string($MULOP->getLine()) + "\n";
			code += "PUSH DX\n"; // remainder in DX
		}
		writeIntoAssemblyFile(code);
	 }
     ;

unary_expression returns [std::string datatype]: ADDOP unexpr=unary_expression  {
		$datatype = $unexpr.datatype;
		if($ADDOP->getText() == "-"){
			code = "POP AX\n";
			code += "NEG AX\n";
			code += "PUSH AX\n";
			writeIntoAssemblyFile(code);
		}
}
		| NOT unexpr=unary_expression {
		$datatype = "int";
		code = "POP AX\n";
		code += "NOT AX\n";
		code += "PUSH AX\n";
		writeIntoAssemblyFile(code);

		}
		| fctr=factor {
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
		$datatype = existing->additionalInfo.returnType;
		existing = symbolTable->LookUp($id.text);
		code = "CALL " + $id.text + "\t\t;line  " + std::to_string($id->getLine()) + "\n";
		for(int i = 0; i< $argl.argtypes.size(); i++) {
			code += "POP DX\n";
		}
		code += "PUSH CX\n";
		writeIntoAssemblyFile(code);
	}
	| lp=LPAREN expr=expression rp=RPAREN {
		$datatype = $expr.datatype;
	}
	| CONST_INT {
		$datatype = "int";
		code = "MOV AX, " + $CONST_INT->getText() + "\t\t;line  " + std::to_string($CONST_INT->getLine()) + "\n";
		code += "PUSH AX\n";
		writeIntoAssemblyFile(code);
	}
	| CONST_FLOAT {
		$datatype = "float";
	}
	| var=variable INCOP {
		$datatype = $var.datatype;
		existing = symbolTable->LookUp($var.place);
		if(existing){
			if(existing->additionalInfo.isArray){
				if(existing->additionalInfo.isGlobal){
					code = "LEA SI, " + $var.place + "\n";
					code += "POP AX\n";
					code += "POP BX\n";
					code += "ADD SI, BX\n";
					code += std::string("INC WORD PTR[SI]") + "\t\t;line  " + std::to_string($INCOP->getLine()) + "\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "POP AX\n";
					code += "POP BX\n";
					code += "PUSH BP\n";
					code += "SUB BP, BX\n";
					code += std::string("INC WORD PTR[BP]") + "\t\t;line  " + std::to_string($INCOP->getLine()) + "\n";
					code += "POP BP\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
			}
			else{
				if(existing->additionalInfo.isGlobal){
					code = "INC " + $var.place + "\t\t;line  " + std::to_string($INCOP->getLine()) + "\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "INC WORD PTR[BP - " + std::to_string(existing->additionalInfo.offset) + "]" + "\t\t;line  " + std::to_string($INCOP->getLine()) + "\n";
					writeIntoAssemblyFile(code);
				}
			}
		}
	}
	| var=variable DECOP {
		$datatype = $var.datatype;
		existing = symbolTable->LookUp($var.text);
		if(existing){
			if(existing->additionalInfo.isArray){
				if(existing->additionalInfo.isGlobal){
					code = "LEA SI, " + $var.place + "\n";
					code += "POP AX\n";
					code += "POP BX\n";
					code += "ADD SI, BX\n";
					code += std::string("DEC WORD PTR[SI]") + "\t\t;line  " + std::to_string($DECOP->getLine()) + "\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "POP AX\n";
					code += "POP BX\n";
					code += "PUSH BP\n";
					code += "SUB BP, BX\n";
					code += std::string("DEC WORD PTR[BP]") + "\t\t;line  " + std::to_string($DECOP->getLine()) + "\n";
					code += "POP BP\n";
					code += "PUSH AX\n";
					writeIntoAssemblyFile(code);
				}
			}
			else{
				if(existing->additionalInfo.isGlobal){
					code = "DEC " + $var.place + "\t\t;line  " + std::to_string($DECOP->getLine()) + "\n";
					writeIntoAssemblyFile(code);
				}
				else{
					code = "DEC WORD PTR[BP - " + std::to_string(existing->additionalInfo.offset) + "]" + "\t\t;line  " + std::to_string($DECOP->getLine()) + "\n";
					writeIntoAssemblyFile(code);
				}
			}
		}
	}
	;
	
argument_list returns [std::vector<std::string> argtypes]: args=arguments {
			$argtypes = $args.argtypes;
            }
			  | {
				$argtypes = std::vector<std::string>();
			  }
			  ;
	
arguments returns [std::vector<std::string> argtypes]: args=arguments cm=COMMA le=logic_expression {
			$argtypes = $args.argtypes;
			$argtypes.push_back($le.datatype);
          }
	      | le=logic_expression {
			$argtypes.push_back($le.datatype);
		  }
	      ;