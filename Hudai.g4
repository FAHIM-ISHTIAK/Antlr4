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

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;

    extern int syntaxErrorCount ;
}

@parser::members {
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

program 
    : pg=program unt=unit {
        writeIntoparserLogFile("Line: " + std::to_string($unt.start->getLine()) + " program : program unit\n");

        auto input = $pg.start->getInputStream();
        antlr4::misc::Interval interval($pg.start->getTokenIndex(), $unt.stop->getTokenIndex());
        std::string fullText = input->getText(interval);

        writeIntoparserLogFile(fullText + "\n");
    }
    | unt=unit {
        writeIntoparserLogFile("Line: " + std::to_string($unt.start->getLine()) + " program : unit\n");

        auto input = $unt.start->getInputStream();
        antlr4::misc::Interval interval($unt.start->getTokenIndex(), $unt.stop->getTokenIndex());
        std::string fullText = input->getText(interval);

        writeIntoparserLogFile(fullText + "\n");
    }
    ;


	
unit 
    : var_dec=var_declaration {
        writeIntoparserLogFile("Line " + std::to_string($var_dec.start->getLine()) + ":" + " unit : var_declaration\n");

        auto input = $var_dec.start->getInputStream();
        antlr4::misc::Interval interval($var_dec.start->getTokenIndex(), $var_dec.stop->getTokenIndex());
        std::string fullText = input->getText(interval);

        writeIntoparserLogFile(fullText + "\n");
    }
    | func_declaration
    | func_definition
    ;



     
func_declaration : type_specifier ID LPAREN parameter_list RPAREN SEMICOLON
		| t=type_specifier id=ID lp=LPAREN rp=RPAREN sm=SEMICOLON {
			writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
			writeIntoparserLogFile($t.text + $id.text + $lp.text + $rp.text + $sm.text + "\n");
		}
		;
		 
func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement
		| t=type_specifier id=ID lp=LPAREN rp=RPAREN cs=compound_statement {
			writeIntoparserLogFile("Line " + std::to_string($cs.start->getLine()) + ":" + " func_definition : type_specifier ID LPAREN RPAREN compound_statement\n");
			writeIntoparserLogFile($t.text + $id.text + $lp.text + $rp.text + $cs.text + "\n");
		}
 		;				


parameter_list  : parameter_list COMMA type_specifier ID
		| parameter_list COMMA type_specifier
 		| type_specifier ID
		| type_specifier
 		;

 		
compound_statement : LCURL statements RCURL
 		    | LCURL RCURL
 		    ;
 		    
var_declaration 
    : t=type_specifier dl=declaration_list sm=SEMICOLON {
		writeIntoparserLogFile("Line " + std::to_string($sm->getLine()) + ":" + " var_declaration : type_specifier declaration_list SEMICOLON\n");
		writeIntoparserLogFile($t.text + " " + $dl.text + $sm.text + "\n");
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
 		
declaration_list 
		: decl=declaration_list COMMA ID {
			writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " declaration_list : declaration_list COMMA ID\n");
			writeIntoparserLogFile($decl.text + $COMMA->getText() + $ID->getText() + "\n");
		}
		| declaration_list COMMA ID LTHIRD CONST_INT RTHIRD
		| ID {
			writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " declaration_list : ID\n");
			writeIntoparserLogFile($ID->getText() + "\n");
		}
		| ID LTHIRD CONST_INT RTHIRD
		;

 		  
statements : statement
	   | statements statement
	   ;
	   
statement : var_declaration {

}
	  | expression_statement {

	  }
	  | compound_statement
	  | FOR LPAREN expression_statement expression_statement expression RPAREN statement
	  | IF LPAREN expression RPAREN statement
	  | IF LPAREN expression RPAREN statement ELSE statement
	  | WHILE LPAREN expression RPAREN statement
	  | PRINTLN LPAREN ID RPAREN SEMICOLON
	  | RETURN expression SEMICOLON
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
	  
variable : ID  {
	writeIntoparserLogFile("Line " + std::to_string($ID->getLine()) + ":" + " variable : ID\n");
	writeIntoparserLogFile($ID->getText() + "\n");
}		
	 | ID LTHIRD expr=expression RTHIRD {
	writeIntoparserLogFile("Line " + std::to_string($LTHIRD->getLine()) + ":" + " variable :  ID LTHIRD expression RTHIRD\n");
	writeIntoparserLogFile($ID->getText() + $LTHIRD->getText() + $expr.text + $RTHIRD->getText() + "\n");
	 }
	 ;
	 
 expression : lgexpr=logic_expression	{
	writeIntoparserLogFile("Line " + std::to_string($lgexpr.start->getLine()) + ":" + " expression :  logic_expression\n");
	writeIntoparserLogFile($lgexpr.text + "\n");
 }
	   | var=variable ASSIGNOP lgexpr=logic_expression  {
	writeIntoparserLogFile("Line " + std::to_string($ASSIGNOP->getLine()) + ":" + " expression :  variable ASSIGNOP logic_expression\n");
	writeIntoparserLogFile($var.text + $ASSIGNOP->getText() + $lgexpr.text + "\n");
	   }	
	   ;
			
logic_expression : rlexpr=rel_expression {
	writeIntoparserLogFile("Line " + std::to_string($rlexpr.start->getLine()) + ":" + " logic_expression :  rel_expression\n");
	writeIntoparserLogFile($rlexpr.text + "\n");
} 	
		 | rlexpr1=rel_expression LOGICOP rlexpr2=rel_expression {
	writeIntoparserLogFile("Line " + std::to_string($LOGICOP->getLine()) + ":" + " logic_expression :  rel_expression LOGICOP rel_expression\n");
	writeIntoparserLogFile($rlexpr1.text + $LOGICOP->getText() + $rlexpr2.text + "\n");
		 }	
		 ;
			
rel_expression	: smexpr=simple_expression {
	writeIntoparserLogFile("Line " + std::to_string($smexpr.start->getLine()) + ":" + " rel_expression :  simple_expression\n");
	writeIntoparserLogFile($smexpr.text + "\n");
}
		| smexpr1=simple_expression RELOP smexpr2=simple_expression	{
	writeIntoparserLogFile("Line " + std::to_string($RELOP->getLine()) + ":" + " rel_expression :  simple_expression RELOP simple_expression\n");
	writeIntoparserLogFile($smexpr1.text + $RELOP->getText() + $smexpr2.text + "\n");
		}
		;
				
simple_expression : trm=term {
	writeIntoparserLogFile("Line " + std::to_string($trm.start->getLine()) + ":" + " simple_expression :  term\n");
	writeIntoparserLogFile($trm.text + "\n");
}
		  | smexpr=simple_expression ADDOP trm=term {
	writeIntoparserLogFile("Line " + std::to_string($ADDOP->getLine()) + ":" + " simple_expression :  simple_expression ADDOP term\n");
	writeIntoparserLogFile($smexpr.text + $ADDOP->getText() + $trm.text + "\n");
		  }
		  ;
					
term :	unexpr=unary_expression {
	writeIntoparserLogFile("Line " + std::to_string($unexpr.start->getLine()) + ":" + " term :  unary_expression\n");
	writeIntoparserLogFile($unexpr.text + "\n");
}
     |  trm=term MULOP unexpr=unary_expression {
	writeIntoparserLogFile("Line " + std::to_string($MULOP->getLine()) + ":" + " term :  term MULOP unary_expression\n");
	writeIntoparserLogFile($trm.text + $MULOP->getText() + $unexpr.text + "\n");
	 }
     ;

unary_expression : ADDOP unexpr=unary_expression  {
		writeIntoparserLogFile("Line " + std::to_string($ADDOP->getLine()) + ":" + " unary_expression : ADDOP unary_expression\n");
		writeIntoparserLogFile($ADDOP->getText() + $unexpr.text + "\n");
}
		| NOT unexpr=unary_expression {
		writeIntoparserLogFile("Line " + std::to_string($NOT->getLine()) + ":" + " unary_expression : NOT unary_expression\n");
		writeIntoparserLogFile($NOT->getText() + $unexpr.text + "\n");
		}
		| fctr=factor {
		writeIntoparserLogFile("Line " + std::to_string($fctr.start->getLine()) + ":" + " unary_expression : factor\n");
		writeIntoparserLogFile($fctr.text + "\n");
		}
		 ;
	
factor	: var=variable {
		writeIntoparserLogFile("Line " + std::to_string($var.start->getLine()) + ":" + " factor : variable\n");
		writeIntoparserLogFile($var.text + "\n");
    }
	| id=ID lp=LPAREN argl=argument_list rp=RPAREN {
		writeIntoparserLogFile("Line " + std::to_string($argl.start->getLine()) + ":" + " factor : ID LPAREN argument_list RPAREN\n");
		writeIntoparserLogFile($id.text + $lp.text + $argl.text + $rp.text + "\n");
	}
	| lp=LPAREN expr=expression rp=RPAREN {
		writeIntoparserLogFile("Line " + std::to_string($expr.start->getLine()) + ":" + " factor : LPAREN expression RPAREN\n");
		writeIntoparserLogFile($lp.text + $expr.text + $rp.text + "\n");
	}
	| CONST_INT {
		writeIntoparserLogFile("Line " + std::to_string($CONST_INT->getLine()) + ":" + " factor : CONST_INT\n");
		writeIntoparserLogFile($CONST_INT->getText() + "\n");
	}
	| CONST_FLOAT {
		writeIntoparserLogFile("Line " + std::to_string($CONST_FLOAT->getLine()) + ":" + " factor : CONST_FLOAT\n");
		writeIntoparserLogFile($CONST_FLOAT->getText() + "\n");
	}
	| var=variable INCOP {
		writeIntoparserLogFile("Line " + std::to_string($INCOP->getLine()) + ":" + " factor : variable INCOP\n");
		writeIntoparserLogFile($INCOP->getText() + "\n");
	}
	| variable DECOP {
		writeIntoparserLogFile("Line " + std::to_string($DECOP->getLine()) + ":" + " factor : variable DECOP\n");
		writeIntoparserLogFile($DECOP->getText() + "\n");
	}
	;
	
argument_list : args=arguments {
			writeIntoparserLogFile("Line " + std::to_string($args.start->getLine()) + ":" + " argument_list : arguments\n");
			writeIntoparserLogFile($args.text + "\n");
            }
			  |
			  ;
	
arguments : args=arguments cm=COMMA le=logic_expression {
			writeIntoparserLogFile("Line " + std::to_string($le.start->getLine()) + ":" + " arguments : arguments COMMA logic_expression\n");
			writeIntoparserLogFile($args.text + $cm.text + $le.text + "\n");
          }
	      | le=logic_expression {
			writeIntoparserLogFile("Line " + std::to_string($le.start->getLine()) + ":" + " arguments : logic_expression\n");
			writeIntoparserLogFile($le.text + "\n");
		  }
	      ;
