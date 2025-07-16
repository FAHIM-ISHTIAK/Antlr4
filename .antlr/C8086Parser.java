// Generated from /home/fahim_ishtiak/CSE 310/antlr/antlr4-resources/antlr4-skeletons/cpp/C8086Parser.g4 by ANTLR 4.13.1

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class C8086Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BLOCK_COMMENT=2, STRING=3, WS=4, IF=5, ELSE=6, FOR=7, 
		WHILE=8, PRINTLN=9, RETURN=10, INT=11, FLOAT=12, VOID=13, SWITCH=14, CASE=15, 
		DEFAULT=16, BREAK=17, CONTINUE=18, FORIN=19, FOREACH=20, IN=21, TO=22, 
		LPAREN=23, RPAREN=24, LCURL=25, RCURL=26, LTHIRD=27, RTHIRD=28, SEMICOLON=29, 
		COMMA=30, COLON=31, ADDOP=32, SUBOP=33, MULOP=34, INCOP=35, DECOP=36, 
		NOT=37, RELOP=38, LOGICOP=39, ASSIGNOP=40, ID=41, CONST_INT=42, CONST_FLOAT=43, 
		HASH=44;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_unit = 2, RULE_func_declaration = 3, 
		RULE_func_definition = 4, RULE_parameter_list = 5, RULE_compound_statement = 6, 
		RULE_var_declaration = 7, RULE_declaration_list_err = 8, RULE_type_specifier = 9, 
		RULE_declaration_list = 10, RULE_statements = 11, RULE_statement = 12, 
		RULE_expression_statement = 13, RULE_variable = 14, RULE_expression = 15, 
		RULE_logic_expression = 16, RULE_rel_expression = 17, RULE_simple_expression = 18, 
		RULE_term = 19, RULE_unary_expression = 20, RULE_factor = 21, RULE_argument_list = 22, 
		RULE_arguments = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "program", "unit", "func_declaration", "func_definition", "parameter_list", 
			"compound_statement", "var_declaration", "declaration_list_err", "type_specifier", 
			"declaration_list", "statements", "statement", "expression_statement", 
			"variable", "expression", "logic_expression", "rel_expression", "simple_expression", 
			"term", "unary_expression", "factor", "argument_list", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'if'", "'else'", "'for'", "'while'", "'println'", 
			"'return'", "'int'", "'float'", "'void'", "'switch'", "'case'", "'default'", 
			"'break'", "'continue'", "'forin'", "'foreach'", "'in'", "'to'", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "';'", "','", "':'", null, null, null, 
			"'++'", "'--'", "'!'", null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"FOR", "WHILE", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "SWITCH", 
			"CASE", "DEFAULT", "BREAK", "CONTINUE", "FORIN", "FOREACH", "IN", "TO", 
			"LPAREN", "RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", 
			"COMMA", "COLON", "ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", "NOT", 
			"RELOP", "LOGICOP", "ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT", "HASH"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C8086Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



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

	public C8086Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ProgramContext pg;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{

					str = ".model small\n.stack 1000h\n.data\n";
					writeIntoAssemblyFile(str);

			setState(49);
			((StartContext)_localctx).pg = program(0);

					symbolTable->PrintAllScopeTable();
					delete symbolTable;
					str = "new_line proc\n"
					"    push ax\n"
					"    push dx\n"
					"    mov ah,2\n"
					"    mov dl,0Dh\n"
					"    int 21h\n"
					"    mov ah,2\n"
					"    mov dl,0Ah\n"
					"    int 21h\n"
					"    pop dx\n"
					"    pop ax\n"
					"    ret\n"
					"    new_line endp\n"
					"print_output proc  ;print what is in ax\n"
					"    push ax\n"
					"    push bx\n"
					"    push cx\n"
					"    push dx\n"
					"    push si\n"
					"    lea si,number\n"
					"    mov bx,10\n"
					"    add si,4\n"
					"    cmp ax,0\n"
					"    jnge negate\n"
					"print:\n"
					"    xor dx,dx\n"
					"    div bx\n"
					"    mov [si],dl\n"
					"    add [si],'0'\n"
					"    dec si\n"
					"    cmp ax,0\n"
					"    jne print\n"
					"    inc si\n"
					"    lea dx,si\n"
					"    mov ah,9\n"
					"    int 21h\n"
					"    pop si\n"
					"    pop dx\n"
					"    pop cx\n"
					"    pop bx\n"
					"    pop ax\n"
					"    ret\n"
					"negate:\n"
					"    push ax\n"
					"    mov ah,2\n"
					"    mov dl,'-'\n"
					"    int 21h\n"
					"    pop ax\n"
					"    neg ax\n"
					"    jmp print\n"
					"print_output endp\n";
					writeIntoAssemblyFile(str);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext pg;
		public UnitContext unt;
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		return program(0);
	}

	private ProgramContext program(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ProgramContext _localctx = new ProgramContext(_ctx, _parentState);
		ProgramContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_program, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(53);
			((ProgramContext)_localctx).unt = unit();

				writeIntoparserLogFile("Line " + std::to_string((((ProgramContext)_localctx).unt!=null?(((ProgramContext)_localctx).unt.stop):null)->getLine()) + ":" + " program : unit\n");
				writeIntoparserLogFile((((ProgramContext)_localctx).unt!=null?_input.getText(((ProgramContext)_localctx).unt.start,((ProgramContext)_localctx).unt.stop):null) + "\n");
				
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ProgramContext(_parentctx, _parentState);
					_localctx.pg = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_program);
					setState(56);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(57);
					((ProgramContext)_localctx).unt = unit();

					          	writeIntoparserLogFile("Line " + std::to_string((((ProgramContext)_localctx).unt!=null?(((ProgramContext)_localctx).unt.stop):null)->getLine()) + ":" + " program : program unit\n");
					          	writeIntoparserLogFile((((ProgramContext)_localctx).pg!=null?_input.getText(((ProgramContext)_localctx).pg.start,((ProgramContext)_localctx).pg.stop):null) + "\n" + (((ProgramContext)_localctx).unt!=null?_input.getText(((ProgramContext)_localctx).unt.start,((ProgramContext)_localctx).unt.stop):null) + "\n\n");
					          
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnitContext extends ParserRuleContext {
		public Var_declarationContext var_dec;
		public Func_declarationContext func_dec;
		public Func_definitionContext func_def;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public Func_definitionContext func_definition() {
			return getRuleContext(Func_definitionContext.class,0);
		}
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unit);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				((UnitContext)_localctx).var_dec = var_declaration();
				 
					writeIntoparserLogFile("Line " + std::to_string((((UnitContext)_localctx).var_dec!=null?(((UnitContext)_localctx).var_dec.start):null)->getLine()) + ":" + " unit : var_declaration\n"); 
					writeIntoparserLogFile((((UnitContext)_localctx).var_dec!=null?_input.getText(((UnitContext)_localctx).var_dec.start,((UnitContext)_localctx).var_dec.stop):null) + "\n\n"); 

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{

						if(!iscodewritten){
							str = ".code\n";
							str += "MOV AX, @DATA\n";
							str += "MOV DS, AX\n";
							str += "\nCALL main\n";
							writeIntoAssemblyFile(str);
							iscodewritten = true;
						}
					 
				setState(69);
				((UnitContext)_localctx).func_dec = func_declaration();

						writeIntoparserLogFile("Line " + std::to_string((((UnitContext)_localctx).func_dec!=null?(((UnitContext)_localctx).func_dec.stop):null)->getLine()) + ":" + " unit : func_declaration\n");
						writeIntoparserLogFile((((UnitContext)_localctx).func_dec!=null?_input.getText(((UnitContext)_localctx).func_dec.start,((UnitContext)_localctx).func_dec.stop):null) + "\n\n");
					 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{

						if(!iscodewritten){
							str = ".code\n";
							str += "\nCALL main\n";
							writeIntoAssemblyFile(str);
							iscodewritten = true;
						}
					 
				setState(73);
				((UnitContext)_localctx).func_def = func_definition();

						writeIntoparserLogFile("Line " + std::to_string((((UnitContext)_localctx).func_def!=null?(((UnitContext)_localctx).func_def.stop):null)->getLine()) + ":" + " unit : func_definition\n");
						writeIntoparserLogFile((((UnitContext)_localctx).func_def!=null?_input.getText(((UnitContext)_localctx).func_def.start,((UnitContext)_localctx).func_def.stop):null) + "\n");
					 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_declarationContext extends ParserRuleContext {
		public Type_specifierContext t;
		public Token id;
		public Token lp;
		public Parameter_listContext pl;
		public Token rp;
		public Token sm;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_declaration);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				((Func_declarationContext)_localctx).t = type_specifier();
				setState(79);
				((Func_declarationContext)_localctx).id = match(ID);

					if(symbolTable->LookUp((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null))){
						writeIntoparserLogFile("Error at line " + std::to_string(((Func_declarationContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + "\n");
						writeIntoErrorFile("Error at line " + std::to_string(((Func_declarationContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + "\n");
						syntaxErrorCount++;
					} 

				setState(81);
				((Func_declarationContext)_localctx).lp = match(LPAREN);
				setState(82);
				((Func_declarationContext)_localctx).pl = parameter_list(0);
				setState(83);
				((Func_declarationContext)_localctx).rp = match(RPAREN);
				setState(84);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

							writeIntoparserLogFile("Line " + std::to_string(((Func_declarationContext)_localctx).sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
							writeIntoparserLogFile((((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " " + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + (((Func_declarationContext)_localctx).lp!=null?((Func_declarationContext)_localctx).lp.getText():null) + (((Func_declarationContext)_localctx).pl!=null?_input.getText(((Func_declarationContext)_localctx).pl.start,((Func_declarationContext)_localctx).pl.stop):null) +(((Func_declarationContext)_localctx).rp!=null?((Func_declarationContext)_localctx).rp.getText():null) + (((Func_declarationContext)_localctx).sm!=null?((Func_declarationContext)_localctx).sm.getText():null) + "\n\n");
							if(!symbolTable->LookUp((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null))){
								SymbolAdditionalInfo info = SymbolAdditionalInfo();
								info.isFunction = true;
								info.parameters = ((Func_declarationContext)_localctx).pl.params;
								info.returnType = (((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null);
								symbolTable->Insert((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null), "ID", info);
							}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				((Func_declarationContext)_localctx).t = type_specifier();
				setState(88);
				((Func_declarationContext)_localctx).id = match(ID);

						if(symbolTable->LookUp((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null))){
						writeIntoErrorFile("Line " + std::to_string(((Func_declarationContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + "' already declared.");
						writeIntoparserLogFile("Line " + std::to_string(((Func_declarationContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + "' already declared.");
						syntaxErrorCount++;
					} 
						
				setState(90);
				((Func_declarationContext)_localctx).lp = match(LPAREN);
				setState(91);
				((Func_declarationContext)_localctx).rp = match(RPAREN);
				setState(92);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

							writeIntoparserLogFile("Line " + std::to_string(((Func_declarationContext)_localctx).sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
							writeIntoparserLogFile((((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " " + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + (((Func_declarationContext)_localctx).lp!=null?((Func_declarationContext)_localctx).lp.getText():null) + (((Func_declarationContext)_localctx).rp!=null?((Func_declarationContext)_localctx).rp.getText():null) + (((Func_declarationContext)_localctx).sm!=null?((Func_declarationContext)_localctx).sm.getText():null) + "\n\n");
							if(!symbolTable->LookUp((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null))){
								SymbolAdditionalInfo info = SymbolAdditionalInfo();
								info.isFunction = true;
								info.returnType = (((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null);
								hasInserted = symbolTable->Insert((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null), "ID", info);
							}
						
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Func_definitionContext extends ParserRuleContext {
		public Type_specifierContext t;
		public Token id;
		public Token lp;
		public Parameter_listContext pl;
		public Token rp;
		public Compound_statementContext cm_stmt;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Func_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_definition; }
	}

	public final Func_definitionContext func_definition() throws RecognitionException {
		Func_definitionContext _localctx = new Func_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_definition);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				((Func_definitionContext)_localctx).t = type_specifier();
				setState(98);
				((Func_definitionContext)_localctx).id = match(ID);

					existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
					if (existing) {
							if(!existing->additionalInfo.isFunction){
								writeIntoparserLogFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
							}
							else if(existing->additionalInfo.isDefined) {
								writeIntoparserLogFile("Line# " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "' is already defined.");
				                writeIntoErrorFile("Line# " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "' is already defined.");
				                syntaxErrorCount++;
				            }
				        }
						else{
							SymbolAdditionalInfo info = SymbolAdditionalInfo();
							info.deleted = true;
							info.isFunction = true;
							info.isDefined = true;
							info.returnType = (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null);
							symbolTable->Insert((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null), "ID",  info);
						}
						code = (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + " PROC\n";
						code += "push BP\n";
						code += "mov BP, SP\n";
						stackOffset = 0;
				        writeIntoAssemblyFile(code);

				setState(100);
				((Func_definitionContext)_localctx).lp = match(LPAREN);
				 symbolTable->Enter_scope(); 
				setState(102);
				((Func_definitionContext)_localctx).pl = parameter_list(0);
				 
				if(((Func_definitionContext)_localctx).pl.params.size() == ((Func_definitionContext)_localctx).pl.names.size()){
						for(int i = 0; i < ((Func_definitionContext)_localctx).pl.params.size(); i++){
						SymbolAdditionalInfo info = SymbolAdditionalInfo();
						info.dataType = ((Func_definitionContext)_localctx).pl.params[i];
						info.isGlobal = (symbolTable->getCurrentScopeId() == "1")? true : false;
						stackOffset += 2;
						info.offset = stackOffset;
						code = "SUB SP, 2\n";
						code += "MOV AX, [BP + " + std::to_string((((Func_definitionContext)_localctx).pl.params.size() - i) * 2 + 2) + "]" + "\n";
						code += "MOV [BP - " + std::to_string(stackOffset) + "], AX\n";
						writeIntoAssemblyFile(code);
						symbolTable->Insert(((Func_definitionContext)_localctx).pl.names[i], "ID", info);
					}
				}
				 
				setState(104);
				((Func_definitionContext)_localctx).rp = match(RPAREN);

						existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
						if(existing && existing->additionalInfo.isFunction){
							if(!existing->additionalInfo.isDefined){
								if(existing->additionalInfo.parameters != ((Func_definitionContext)_localctx).pl.params) {
									syntaxErrorCount++;
									if(existing->additionalInfo.parameters.size() != ((Func_definitionContext)_localctx).pl.params.size()){
										writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
										writeIntoparserLogFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
									}
									}
								if(existing->additionalInfo.returnType != (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null)) {
									writeIntoparserLogFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
									writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
									syntaxErrorCount++;
								}
								existing->additionalInfo.isDefined = true;
							}
							else{
								existing->additionalInfo.parameters = ((Func_definitionContext)_localctx).pl.params;
							}
						}
				 
				setState(106);
				((Func_definitionContext)_localctx).cm_stmt = compound_statement(true);

							writeIntoparserLogFile("Line " + std::to_string((((Func_definitionContext)_localctx).cm_stmt!=null?(((Func_definitionContext)_localctx).cm_stmt.stop):null)->getLine()) + ":" + " func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n");
							writeIntoparserLogFile((((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + " " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + (((Func_definitionContext)_localctx).lp!=null?((Func_definitionContext)_localctx).lp.getText():null) + (((Func_definitionContext)_localctx).pl!=null?_input.getText(((Func_definitionContext)_localctx).pl.start,((Func_definitionContext)_localctx).pl.stop):null) + (((Func_definitionContext)_localctx).rp!=null?((Func_definitionContext)_localctx).rp.getText():null) + (((Func_definitionContext)_localctx).cm_stmt!=null?_input.getText(((Func_definitionContext)_localctx).cm_stmt.start,((Func_definitionContext)_localctx).cm_stmt.stop):null) + "\n");
							code = "MOV SP, BP\n";
							code += "POP BP\n";
							if((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) == "main"){
								code += "MOV AX, 4CH\n";
								code += "INT 21h\n";
							}
							else{
								code += "RET\n";
							}
							code += (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + " ENDP\n";
				            writeIntoAssemblyFile(code);

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((Func_definitionContext)_localctx).t = type_specifier();
				setState(110);
				((Func_definitionContext)_localctx).id = match(ID);

					existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
					if (existing) {
							if(!existing->additionalInfo.isFunction){
								writeIntoparserLogFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
							}
							else if(existing->additionalInfo.isDefined) {
								writeIntoparserLogFile("Line# " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "' is already defined.");
				                writeIntoErrorFile("Line# " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "' is already defined.");
				                syntaxErrorCount++;
				            }
				        }
						else{
							SymbolAdditionalInfo info = SymbolAdditionalInfo();
							info.deleted = true;
							info.isFunction = true;
							info.isDefined = true;
							info.returnType = (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null);
							symbolTable->Insert((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null), "ID",  info);
						}
				        code = (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + " PROC\n";
						code += "push BP\n";
						code += "mov BP, SP\n";
						stackOffset = 0;
				        writeIntoAssemblyFile(code);

				setState(112);
				((Func_definitionContext)_localctx).lp = match(LPAREN);
				 symbolTable->Enter_scope(); 
				setState(114);
				((Func_definitionContext)_localctx).rp = match(RPAREN);

						existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
						if(existing && existing->additionalInfo.isFunction){
							if(!existing->additionalInfo.isDefined){
								if(existing->additionalInfo.returnType != (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null)) {
									writeIntoparserLogFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
									writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
									syntaxErrorCount++;
								}
								if(existing->additionalInfo.parameters.size() > 0){
								writeIntoparserLogFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");				
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
						        }
								existing->additionalInfo.isDefined = true;
							}
						}

				setState(116);
				((Func_definitionContext)_localctx).cm_stmt = compound_statement(true);

							writeIntoparserLogFile("Line " + std::to_string((((Func_definitionContext)_localctx).cm_stmt!=null?(((Func_definitionContext)_localctx).cm_stmt.stop):null)->getLine()) + ":" + " func_definition : type_specifier ID LPAREN RPAREN compound_statement\n");
							writeIntoparserLogFile((((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + " " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + (((Func_definitionContext)_localctx).lp!=null?((Func_definitionContext)_localctx).lp.getText():null) + (((Func_definitionContext)_localctx).rp!=null?((Func_definitionContext)_localctx).rp.getText():null) + (((Func_definitionContext)_localctx).cm_stmt!=null?_input.getText(((Func_definitionContext)_localctx).cm_stmt.start,((Func_definitionContext)_localctx).cm_stmt.stop):null) + "\n");
				            code = "MOV SP, BP\n";
							code += "POP BP\n";
							if((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) == "main"){
								code += "MOV AX, 4CH\n";
								code += "INT 21h\n";
							}
							else{
								code += "RET\n";
							}
							code += (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + " ENDP\n";
				            writeIntoAssemblyFile(code);
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public std::vector<std::string> params;
		public std::vector<std::string> names;
		public Parameter_listContext pl;
		public Type_specifierContext t;
		public Token id;
		public Token op;
		public Token cm;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public TerminalNode MULOP() { return getToken(C8086Parser.MULOP, 0); }
		public TerminalNode ASSIGNOP() { return getToken(C8086Parser.ASSIGNOP, 0); }
		public TerminalNode LOGICOP() { return getToken(C8086Parser.LOGICOP, 0); }
		public TerminalNode RELOP() { return getToken(C8086Parser.RELOP, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		return parameter_list(0);
	}

	private Parameter_listContext parameter_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, _parentState);
		Parameter_listContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_parameter_list, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(122);
				((Parameter_listContext)_localctx).t = type_specifier();
				setState(123);
				((Parameter_listContext)_localctx).id = match(ID);

					writeIntoparserLogFile("Line " + std::to_string((((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null)->getLine()) + ":" + " parameter_list : type_specifier ID\n");
					writeIntoparserLogFile((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + (((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null) + "\n");
					_localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
					_localctx.names.push_back((((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null));
						
				}
				break;
			case 2:
				{
				setState(126);
				((Parameter_listContext)_localctx).t = type_specifier();

					writeIntoparserLogFile("Line " + std::to_string((((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null)->getLine()) + ":" + " parameter_list : type_specifier\n");
					writeIntoparserLogFile((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n");
					_localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
					 _localctx.names.push_back("");
						
				}
				break;
			case 3:
				{
				setState(129);
				((Parameter_listContext)_localctx).t = type_specifier();
				setState(130);
				((Parameter_listContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1945620185088L) != 0)) ) {
					((Parameter_listContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

							_localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
							_localctx.names.push_back("error");
							// ((Parameter_listContext)_localctx).text =  (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null);
							writeIntoparserLogFile("Line " + std::to_string((((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null)->getLine()) + ":" + " parameter_list : type_specifier\n");
					        writeIntoparserLogFile((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n");
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(135);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(136);
						((Parameter_listContext)_localctx).cm = match(COMMA);
						setState(137);
						((Parameter_listContext)_localctx).t = type_specifier();
						setState(138);
						((Parameter_listContext)_localctx).id = match(ID);

						          	writeIntoparserLogFile("Line " + std::to_string(((Parameter_listContext)_localctx).cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier ID\n");
						          	writeIntoparserLogFile((((Parameter_listContext)_localctx).pl!=null?_input.getText(((Parameter_listContext)_localctx).pl.start,((Parameter_listContext)_localctx).pl.stop):null) + (((Parameter_listContext)_localctx).cm!=null?((Parameter_listContext)_localctx).cm.getText():null) + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " +(((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null) + "\n");
						          	((Parameter_listContext)_localctx).params =  ((Parameter_listContext)_localctx).pl.params;
						              _localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
						          	((Parameter_listContext)_localctx).names =  ((Parameter_listContext)_localctx).pl.names;
						          	_localctx.names.push_back((((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null));
						          
						}
						break;
					case 2:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(141);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(142);
						((Parameter_listContext)_localctx).cm = match(COMMA);
						setState(143);
						((Parameter_listContext)_localctx).t = type_specifier();
						setState(144);
						((Parameter_listContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1945620185088L) != 0)) ) {
							((Parameter_listContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}

						          			((Parameter_listContext)_localctx).params =  ((Parameter_listContext)_localctx).pl.params;
						          			((Parameter_listContext)_localctx).names =  ((Parameter_listContext)_localctx).pl.names;
						          			_localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
						          			_localctx.names.push_back("error");
						          			// ((Parameter_listContext)_localctx).text =  (((Parameter_listContext)_localctx).pl!=null?_input.getText(((Parameter_listContext)_localctx).pl.start,((Parameter_listContext)_localctx).pl.stop):null) + (((Parameter_listContext)_localctx).cm!=null?((Parameter_listContext)_localctx).cm.getText():null) + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null);
						          			writeIntoparserLogFile("Line " + std::to_string(((Parameter_listContext)_localctx).cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier ID\n");
						          	        writeIntoparserLogFile((((Parameter_listContext)_localctx).pl!=null?_input.getText(((Parameter_listContext)_localctx).pl.start,((Parameter_listContext)_localctx).pl.stop):null) + (((Parameter_listContext)_localctx).cm!=null?((Parameter_listContext)_localctx).cm.getText():null) + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + "\n");
						          		
						}
						break;
					case 3:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(147);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(148);
						((Parameter_listContext)_localctx).cm = match(COMMA);
						setState(149);
						((Parameter_listContext)_localctx).t = type_specifier();

						          	writeIntoparserLogFile("Line " + std::to_string(((Parameter_listContext)_localctx).cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier\n");
						          	writeIntoparserLogFile((((Parameter_listContext)_localctx).pl!=null?_input.getText(((Parameter_listContext)_localctx).pl.start,((Parameter_listContext)_localctx).pl.stop):null) + (((Parameter_listContext)_localctx).cm!=null?((Parameter_listContext)_localctx).cm.getText():null) + (((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n");
						          	((Parameter_listContext)_localctx).params =  ((Parameter_listContext)_localctx).pl.params;
						              _localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
						          	((Parameter_listContext)_localctx).names =  ((Parameter_listContext)_localctx).pl.names;
						          	_localctx.names.push_back((((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null));
						          		
						}
						break;
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Compound_statementContext extends ParserRuleContext {
		public bool IsFunction;
		public Token LCURL;
		public StatementsContext stmts;
		public Token RCURL;
		public TerminalNode LCURL() { return getToken(C8086Parser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(C8086Parser.RCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Compound_statementContext(ParserRuleContext parent, int invokingState, bool IsFunction) {
			super(parent, invokingState);
			this.IsFunction = IsFunction;
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
	}

	public final Compound_statementContext compound_statement(bool IsFunction) throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState(), IsFunction);
		enterRule(_localctx, 12, RULE_compound_statement);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				((Compound_statementContext)_localctx).LCURL = match(LCURL);

					if(!IsFunction){
					symbolTable->Enter_scope();
				 }

				setState(159);
				((Compound_statementContext)_localctx).stmts = statements(0);
				setState(160);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

							writeIntoparserLogFile("Line " + std::to_string(((Compound_statementContext)_localctx).RCURL->getLine()) + ":" + " compound_statement : LCURL statements RCURL\n");
							writeIntoparserLogFile(((Compound_statementContext)_localctx).LCURL->getText() + "\n" + (((Compound_statementContext)_localctx).stmts!=null?_input.getText(((Compound_statementContext)_localctx).stmts.start,((Compound_statementContext)_localctx).stmts.stop):null) + "\n" + ((Compound_statementContext)_localctx).RCURL->getText() + "\n");
							symbolTable->PrintAllScopeTable();
							symbolTable->Remove_scope();

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				((Compound_statementContext)_localctx).LCURL = match(LCURL);

								 if(!IsFunction){
						 symbolTable->Enter_scope();
					 }
							
				setState(165);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

							writeIntoparserLogFile("Line " + std::to_string(((Compound_statementContext)_localctx).RCURL->getLine()) + ":" + " compound_statement : LCURL RCURL\n");
							writeIntoparserLogFile(((Compound_statementContext)_localctx).LCURL->getText() + ((Compound_statementContext)_localctx).RCURL->getText() + "\n");
							symbolTable->PrintAllScopeTable();
							symbolTable->Remove_scope();
							
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declarationContext extends ParserRuleContext {
		public Type_specifierContext t;
		public Declaration_listContext dl;
		public Token sm;
		public Declaration_list_errContext de;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public Declaration_list_errContext declaration_list_err() {
			return getRuleContext(Declaration_list_errContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_declaration);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(170);
				((Var_declarationContext)_localctx).dl = declaration_list(0);
				setState(171);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        cout << ((Var_declarationContext)_localctx).dl.decls.size() << endl;
						for(int i = 0; i < ((Var_declarationContext)_localctx).dl.decls.size(); i++) {

							SymbolAdditionalInfo info = SymbolAdditionalInfo();
							info.dataType = (((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null);
							info.isArray = ((Var_declarationContext)_localctx).dl.decls[i].second;
							info.arraySize = ((Var_declarationContext)_localctx).dl.arrsize[i];
							info.isGlobal = (symbolTable->getCurrentScopeId() == "1")? true : false;

							if(info.isGlobal){
								if(((Var_declarationContext)_localctx).dl.decls[i].second){
									datacode = ((Var_declarationContext)_localctx).dl.decls[i].first + " DW " + std::to_string(((Var_declarationContext)_localctx).dl.arrsize[i]) + " DUP(0)\n";
								}
								else{
									datacode = ((Var_declarationContext)_localctx).dl.decls[i].first + " DW 0\n";
								}
								writeIntoAssemblyFile(datacode);
							}
							else{
								if(((Var_declarationContext)_localctx).dl.decls[i].second){
									code = "SUB SP, " + std::to_string(((Var_declarationContext)_localctx).dl.arrsize[i] * 2) + "\n";
									stackOffset += ((Var_declarationContext)_localctx).dl.arrsize[i] * 2;
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
							symbolTable->Insert(((Var_declarationContext)_localctx).dl.decls[i].first, "ID", info);
						}
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(175);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(176);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

				        writeIntoErrorFile(
				            std::string("Line# ") + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) +
				            " with error name: " + ((Var_declarationContext)_localctx).de.error_name +
				            " - Syntax error at declaration list of variable declaration"
				        );

				        syntaxErrorCount++;
				      
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_list_errContext extends ParserRuleContext {
		public std::string error_name;
		public Declaration_list_errContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list_err; }
	}

	public final Declaration_list_errContext declaration_list_err() throws RecognitionException {
		Declaration_list_errContext _localctx = new Declaration_list_errContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration_list_err);
		try {
			enterOuterAlt(_localctx, 1);
			{

			        ((Declaration_list_errContext)_localctx).error_name =  "Error in declaration list";
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public std::string name_line;
		public Token INT;
		public Token FLOAT;
		public Token VOID;
		public TerminalNode INT() { return getToken(C8086Parser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(C8086Parser.FLOAT, 0); }
		public TerminalNode VOID() { return getToken(C8086Parser.VOID, 0); }
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_specifier);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((Type_specifierContext)_localctx).INT = match(INT);

				            ((Type_specifierContext)_localctx).name_line =  "type: INT at line" + std::to_string(((Type_specifierContext)_localctx).INT->getLine());
							writeIntoparserLogFile("Line " + std::to_string(((Type_specifierContext)_localctx).INT->getLine()) + ":" + " type_specifier : INT\n");
				            writeIntoparserLogFile(((Type_specifierContext)_localctx).INT->getText() + "\n");
				        
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				((Type_specifierContext)_localctx).FLOAT = match(FLOAT);

				            ((Type_specifierContext)_localctx).name_line =  "type: FLOAT at line" + std::to_string(((Type_specifierContext)_localctx).FLOAT->getLine());
							writeIntoparserLogFile("Line " + std::to_string(((Type_specifierContext)_localctx).FLOAT->getLine()) + ":" + " type_specifier : FLOAT\n");
				            writeIntoparserLogFile(((Type_specifierContext)_localctx).FLOAT->getText() + "\n");
				        
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				((Type_specifierContext)_localctx).VOID = match(VOID);

				            ((Type_specifierContext)_localctx).name_line =  "type: VOID at line" + std::to_string(((Type_specifierContext)_localctx).VOID->getLine());
							writeIntoparserLogFile("Line " + std::to_string(((Type_specifierContext)_localctx).VOID->getLine()) + ":" + " type_specifier : VOID\n");
				            writeIntoparserLogFile(((Type_specifierContext)_localctx).VOID->getText() + "\n");
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Declaration_listContext extends ParserRuleContext {
		public std::vector<std::pair<std::string, bool>> decls;
		public std::vector<int> arrsize;
		public Declaration_listContext decl;
		public Token ID;
		public Token LTHIRD;
		public Token CONST_INT;
		public Token RTHIRD;
		public Token COMMA;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086Parser.LTHIRD, 0); }
		public TerminalNode CONST_INT() { return getToken(C8086Parser.CONST_INT, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086Parser.RTHIRD, 0); }
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public Declaration_listContext declaration_list() {
			return getRuleContext(Declaration_listContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C8086Parser.ASSIGNOP, 0); }
		public TerminalNode MULOP() { return getToken(C8086Parser.MULOP, 0); }
		public TerminalNode LOGICOP() { return getToken(C8086Parser.LOGICOP, 0); }
		public TerminalNode RELOP() { return getToken(C8086Parser.RELOP, 0); }
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public Declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_list; }
	}

	public final Declaration_listContext declaration_list() throws RecognitionException {
		return declaration_list(0);
	}

	private Declaration_listContext declaration_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Declaration_listContext _localctx = new Declaration_listContext(_ctx, _parentState);
		Declaration_listContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_declaration_list, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(192);
				((Declaration_listContext)_localctx).ID = match(ID);

							writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : ID\n");
							writeIntoparserLogFile(((Declaration_listContext)_localctx).ID->getText() + "\n");
							_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), false});
							_localctx.arrsize.push_back(0);
						
				}
				break;
			case 2:
				{
				setState(194);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(195);
				((Declaration_listContext)_localctx).LTHIRD = match(LTHIRD);
				setState(196);
				((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
				setState(197);
				((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

							writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : ID LTHIRD CONST_INT RTHIRD\n");
							writeIntoparserLogFile(((Declaration_listContext)_localctx).ID->getText() + ((Declaration_listContext)_localctx).LTHIRD->getText() + ((Declaration_listContext)_localctx).CONST_INT->getText() + ((Declaration_listContext)_localctx).RTHIRD->getText() + "\n");
							_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), true});
							_localctx.arrsize.push_back(std::stoi(((Declaration_listContext)_localctx).CONST_INT->getText()));
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(223);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.decl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(201);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(202);
						((Declaration_listContext)_localctx).COMMA = match(COMMA);
						setState(203);
						((Declaration_listContext)_localctx).ID = match(ID);

						          			writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : declaration_list COMMA ID\n");
						          			writeIntoparserLogFile((((Declaration_listContext)_localctx).decl!=null?_input.getText(((Declaration_listContext)_localctx).decl.start,((Declaration_listContext)_localctx).decl.stop):null) + ((Declaration_listContext)_localctx).COMMA->getText() + ((Declaration_listContext)_localctx).ID->getText() + "\n");
						          			((Declaration_listContext)_localctx).decls =  ((Declaration_listContext)_localctx).decl.decls;
						          			_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), false});
						          			((Declaration_listContext)_localctx).arrsize =  ((Declaration_listContext)_localctx).decl.arrsize;
						          			_localctx.arrsize.push_back(0);
						          		
						}
						break;
					case 2:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.decl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(205);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(206);
						((Declaration_listContext)_localctx).COMMA = match(COMMA);
						setState(207);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(208);
						((Declaration_listContext)_localctx).LTHIRD = match(LTHIRD);
						setState(209);
						((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
						setState(210);
						((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

						          			writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD\n");
						          			writeIntoparserLogFile((((Declaration_listContext)_localctx).decl!=null?_input.getText(((Declaration_listContext)_localctx).decl.start,((Declaration_listContext)_localctx).decl.stop):null) + ((Declaration_listContext)_localctx).COMMA->getText() + ((Declaration_listContext)_localctx).ID->getText() + ((Declaration_listContext)_localctx).LTHIRD->getText() + ((Declaration_listContext)_localctx).CONST_INT->getText() + ((Declaration_listContext)_localctx).RTHIRD->getText() + "\n");
						          			((Declaration_listContext)_localctx).decls =  ((Declaration_listContext)_localctx).decl.decls;
						          			_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), true});
						          			((Declaration_listContext)_localctx).arrsize =  ((Declaration_listContext)_localctx).decl.arrsize;
						          			_localctx.arrsize.push_back(std::stoi(((Declaration_listContext)_localctx).CONST_INT->getText()));
						          		
						}
						break;
					case 3:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.decl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(212);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(213);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1945620185088L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(214);
						((Declaration_listContext)_localctx).ID = match(ID);

						          			// writeIntoparserLogFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
						          			// writeIntoErrorFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
						          			writeIntoparserLogFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " syntax error\n");
						          			writeIntoErrorFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " syntax error\n");
						          			syntaxErrorCount++;
						          			((Declaration_listContext)_localctx).decls =  ((Declaration_listContext)_localctx).decl.decls;
						          			((Declaration_listContext)_localctx).arrsize =  ((Declaration_listContext)_localctx).decl.arrsize;
						          			_localctx.decls.push_back({"error_id", false});
						          			_localctx.arrsize.push_back(0);
						          		
						}
						break;
					case 4:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.decl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(216);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(217);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1945620185088L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(219);
						((Declaration_listContext)_localctx).LTHIRD = match(LTHIRD);
						setState(220);
						((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
						setState(221);
						((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

						          			// writeIntoparserLogFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
						          			// writeIntoErrorFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ": syntax error, unexpected ADDOP, expecting COMMA or SEMICOLON\n");
						          			writeIntoparserLogFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " syntax error\n");
						          			writeIntoErrorFile("Error at line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " syntax error\n");
						          			syntaxErrorCount++;
						          			((Declaration_listContext)_localctx).decls =  ((Declaration_listContext)_localctx).decl.decls;
						          			((Declaration_listContext)_localctx).arrsize =  ((Declaration_listContext)_localctx).decl.arrsize;
						          			_localctx.decls.push_back({"error_id", true});
						          			_localctx.arrsize.push_back(std::stoi(((Declaration_listContext)_localctx).CONST_INT->getText()));
						          		
						}
						break;
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext stmts;
		public StatementContext stmt;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		return statements(0);
	}

	private StatementsContext statements(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementsContext _localctx = new StatementsContext(_ctx, _parentState);
		StatementsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_statements, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(229);
			((StatementsContext)_localctx).stmt = statement();

				writeIntoparserLogFile("Line " + std::to_string((((StatementsContext)_localctx).stmt!=null?(((StatementsContext)_localctx).stmt.stop):null)->getLine()) + ":" + " statements : statement\n");
				writeIntoparserLogFile((((StatementsContext)_localctx).stmt!=null?_input.getText(((StatementsContext)_localctx).stmt.start,((StatementsContext)_localctx).stmt.stop):null) + "\n\n");

			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementsContext(_parentctx, _parentState);
					_localctx.stmts = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statements);
					setState(232);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(233);
					((StatementsContext)_localctx).stmt = statement();

					          	writeIntoparserLogFile("Line " + std::to_string((((StatementsContext)_localctx).stmt!=null?(((StatementsContext)_localctx).stmt.stop):null)->getLine()) + ":" + " statements : statements statement\n");
					          	writeIntoparserLogFile((((StatementsContext)_localctx).stmts!=null?_input.getText(((StatementsContext)_localctx).stmts.start,((StatementsContext)_localctx).stmts.stop):null) + "\n" + (((StatementsContext)_localctx).stmt!=null?_input.getText(((StatementsContext)_localctx).stmt.start,((StatementsContext)_localctx).stmt.stop):null) +"\n");
					          	   
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Var_declarationContext var_dec;
		public Expression_statementContext expr_stmt;
		public Compound_statementContext cm_stmt;
		public Token fr;
		public Token lp;
		public Expression_statementContext expr_stmt1;
		public Expression_statementContext expr_stmt2;
		public ExpressionContext expr;
		public Token rp;
		public StatementContext stmt;
		public Token iff;
		public StatementContext stmt1;
		public Token els;
		public StatementContext stmt2;
		public Token whl;
		public Token prln;
		public Token id;
		public Token sm;
		public Token rtn;
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public List<Expression_statementContext> expression_statement() {
			return getRuleContexts(Expression_statementContext.class);
		}
		public Expression_statementContext expression_statement(int i) {
			return getRuleContext(Expression_statementContext.class,i);
		}
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public TerminalNode FOR() { return getToken(C8086Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IF() { return getToken(C8086Parser.IF, 0); }
		public TerminalNode ELSE() { return getToken(C8086Parser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(C8086Parser.WHILE, 0); }
		public TerminalNode PRINTLN() { return getToken(C8086Parser.PRINTLN, 0); }
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public TerminalNode RETURN() { return getToken(C8086Parser.RETURN, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				((StatementContext)_localctx).var_dec = var_declaration();

					writeIntoparserLogFile("Line " + std::to_string((((StatementContext)_localctx).var_dec!=null?(((StatementContext)_localctx).var_dec.stop):null)->getLine()) + ":" + " statement : var_declaration\n");
					writeIntoparserLogFile((((StatementContext)_localctx).var_dec!=null?_input.getText(((StatementContext)_localctx).var_dec.start,((StatementContext)_localctx).var_dec.stop):null) + "\n");

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				((StatementContext)_localctx).expr_stmt = expression_statement();

					writeIntoparserLogFile("Line " + std::to_string((((StatementContext)_localctx).expr_stmt!=null?(((StatementContext)_localctx).expr_stmt.stop):null)->getLine()) + ":" + " statement : expression_statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).expr_stmt!=null?_input.getText(((StatementContext)_localctx).expr_stmt.start,((StatementContext)_localctx).expr_stmt.stop):null) +"\n");
					  
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				((StatementContext)_localctx).cm_stmt = compound_statement(false);

					writeIntoparserLogFile("Line " + std::to_string((((StatementContext)_localctx).cm_stmt!=null?(((StatementContext)_localctx).cm_stmt.stop):null)->getLine()) + ":" + " statement : compound_statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).cm_stmt!=null?_input.getText(((StatementContext)_localctx).cm_stmt.start,((StatementContext)_localctx).cm_stmt.stop):null) +"\n");
					  
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				((StatementContext)_localctx).fr = match(FOR);
				setState(251);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(252);
				((StatementContext)_localctx).expr_stmt1 = expression_statement();

						forlabel = newLabel();
						code = forlabel + ":\n";
						writeIntoAssemblyFile(code);
					  
				setState(254);
				((StatementContext)_localctx).expr_stmt2 = expression_statement();

						code = "POP AX\n";
						code += "CMP AX, 0\n";
						forlabel2 = newLabel();
						code += "JE " + forlabel2 + "\n";
						forlabel3 = newLabel();
						code += "JMP " + forlabel3 + "\n";
						forlabel4 = newLabel();
						code += forlabel4 + ":\n";
						writeIntoAssemblyFile(code);
					  
				setState(256);
				((StatementContext)_localctx).expr = expression();

						code = "JMP " + forlabel + "\n";
						writeIntoAssemblyFile(code);
					  
				setState(258);
				((StatementContext)_localctx).rp = match(RPAREN);

						code = forlabel3 + ":\n";
						writeIntoAssemblyFile(code);
					  
				setState(260);
				((StatementContext)_localctx).stmt = statement();

						code = "JMP " + forlabel4 + "\n";
						code += forlabel2 + ":\n";
						writeIntoAssemblyFile(code);
					  
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				((StatementContext)_localctx).iff = match(IF);
				setState(264);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(265);
				((StatementContext)_localctx).expr = expression();
				setState(266);
				((StatementContext)_localctx).rp = match(RPAREN);


						code = "POP AX\n";
						code += "CMP AX, 0\n";
						str = newLabel();
						code += "JE " + str + "\n";
						writeIntoAssemblyFile(code);
					  
				setState(268);
				((StatementContext)_localctx).stmt = statement();

						code = str + ":\n";
						writeIntoAssemblyFile(code);
					  
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(271);
				((StatementContext)_localctx).iff = match(IF);
				setState(272);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(273);
				((StatementContext)_localctx).expr = expression();
				setState(274);
				((StatementContext)_localctx).rp = match(RPAREN);


						code = "POP AX\n";
						code += "CMP AX, 0\n";
						str = newLabel();
						code += "JE " + str + "\n";
						writeIntoAssemblyFile(code);

					  
				setState(276);
				((StatementContext)_localctx).stmt1 = statement();


						str2 = newLabel();
						code = "JMP " + str2 + "\n";
						writeIntoAssemblyFile(code);
						labelStack.push(str2);

					  
				setState(278);
				((StatementContext)_localctx).els = match(ELSE);


						code = str + ":\n";
						writeIntoAssemblyFile(code);

					  
				setState(280);
				((StatementContext)_localctx).stmt2 = statement();


						code = labelStack.top() + ":\n";
						labelStack.pop();
						writeIntoAssemblyFile(code);
					  
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(283);
				((StatementContext)_localctx).whl = match(WHILE);
				setState(284);
				((StatementContext)_localctx).lp = match(LPAREN);

						whilelabel = newLabel();
						code = whilelabel + ":\n";
						writeIntoAssemblyFile(code);
					  
				setState(286);
				((StatementContext)_localctx).expr = expression();
				setState(287);
				((StatementContext)_localctx).rp = match(RPAREN);

						code = "POP AX\n";
						code += "CMP AX, 0\n";
						whilelabel2 = newLabel();
						code += "JE " + whilelabel2 + "\n";
						writeIntoAssemblyFile(code);
					  
				setState(289);
				((StatementContext)_localctx).stmt = statement();

						code = "JMP " + whilelabel + "\n";
						code += whilelabel2 + ":\n";
						writeIntoAssemblyFile(code);
					  
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(292);
				((StatementContext)_localctx).prln = match(PRINTLN);
				setState(293);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(294);
				((StatementContext)_localctx).id = match(ID);
				setState(295);
				((StatementContext)_localctx).rp = match(RPAREN);
				setState(296);
				((StatementContext)_localctx).sm = match(SEMICOLON);

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).prln->getLine()) + ":" + " statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n");
					writeIntoparserLogFile((((StatementContext)_localctx).prln!=null?((StatementContext)_localctx).prln.getText():null) + (((StatementContext)_localctx).lp!=null?((StatementContext)_localctx).lp.getText():null) + (((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null) + (((StatementContext)_localctx).rp!=null?((StatementContext)_localctx).rp.getText():null) + (((StatementContext)_localctx).sm!=null?((StatementContext)_localctx).sm.getText():null) + "\n");
					existing = symbolTable->LookUp((((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null));
					if(existing) {
						if(existing->additionalInfo.isArray) {

						}
						else{
							if(existing->additionalInfo.isGlobal){
								code = "MOV AX, " + (((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null) + "\n";
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
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(298);
				((StatementContext)_localctx).rtn = match(RETURN);
				setState(299);
				((StatementContext)_localctx).expr = expression();
				setState(300);
				((StatementContext)_localctx).sm = match(SEMICOLON);

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).rtn->getLine()) + ":" + " statement : RETURN expression SEMICOLON\n");
					writeIntoparserLogFile((((StatementContext)_localctx).rtn!=null?((StatementContext)_localctx).rtn.getText():null) + " " + (((StatementContext)_localctx).expr!=null?_input.getText(((StatementContext)_localctx).expr.start,((StatementContext)_localctx).expr.stop):null) + (((StatementContext)_localctx).sm!=null?((StatementContext)_localctx).sm.getText():null) + "\n\n");
					code = "POP CX\n";
					writeIntoAssemblyFile(code);
					hasreturn = true;
					  
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public Token SEMICOLON;
		public ExpressionContext expr;
		public TerminalNode SEMICOLON() { return getToken(C8086Parser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression_statement);
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				((Expression_statementContext)_localctx).SEMICOLON = match(SEMICOLON);

					writeIntoparserLogFile("Line " + std::to_string(((Expression_statementContext)_localctx).SEMICOLON->getLine()) + ":" + " expression_statement : SEMICOLON\n");
					writeIntoparserLogFile(((Expression_statementContext)_localctx).SEMICOLON->getText() + "\n");

				}
				break;
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				((Expression_statementContext)_localctx).expr = expression();
				setState(308);
				((Expression_statementContext)_localctx).SEMICOLON = match(SEMICOLON);

					writeIntoparserLogFile("Line " + std::to_string(((Expression_statementContext)_localctx).SEMICOLON->getLine()) + ":" + " expression_statement : expression SEMICOLON\n");
					writeIntoparserLogFile((((Expression_statementContext)_localctx).expr!=null?_input.getText(((Expression_statementContext)_localctx).expr.start,((Expression_statementContext)_localctx).expr.stop):null) + ((Expression_statementContext)_localctx).SEMICOLON->getText() + "\n");
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public std::string datatype;
		public std::string place;
		public std::string index;
		public Token ID;
		public Token LTHIRD;
		public ExpressionContext expr;
		public Token RTHIRD;
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LTHIRD() { return getToken(C8086Parser.LTHIRD, 0); }
		public TerminalNode RTHIRD() { return getToken(C8086Parser.RTHIRD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_variable);
		try {
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				((VariableContext)_localctx).ID = match(ID);

					writeIntoparserLogFile("Line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ":" + " variable : ID\n");
					writeIntoparserLogFile(((VariableContext)_localctx).ID->getText() + "\n");
					existing = symbolTable->LookUp(((VariableContext)_localctx).ID->getText());
					if(existing) {
						((VariableContext)_localctx).datatype =  existing->additionalInfo.dataType;
						if(existing->additionalInfo.isArray) {
							writeIntoErrorFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ": Type mismatch," + ((VariableContext)_localctx).ID->getText() + " is an array" + "\n");
							writeIntoparserLogFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ": Type mismatch," + ((VariableContext)_localctx).ID->getText() + " is an array" + "\n");
							syntaxErrorCount++;
						}
					}
					else {
						writeIntoErrorFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ":" + " Undeclared variable " + ((VariableContext)_localctx).ID->getText() + "\n");
						writeIntoparserLogFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ":" + " Undeclared variable " + ((VariableContext)_localctx).ID->getText() + "\n");
						syntaxErrorCount++;
						((VariableContext)_localctx).datatype =  "error";
					}
				    existing = symbolTable->LookUp(((VariableContext)_localctx).ID->getText());
				    if(existing){
				        if(existing->additionalInfo.isGlobal){
				            code = "MOV AX, " + ((VariableContext)_localctx).ID->getText() + "\n";
				            code += "PUSH AX\n";
				            writeIntoAssemblyFile(code);
				        }
				        else{
				            code = "MOV AX, [BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
				            code += "PUSH AX\n";
				            writeIntoAssemblyFile(code);
				        }
				    }
					((VariableContext)_localctx).place =  ((VariableContext)_localctx).ID->getText();
					((VariableContext)_localctx).index =  "";

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				((VariableContext)_localctx).ID = match(ID);
				setState(316);
				((VariableContext)_localctx).LTHIRD = match(LTHIRD);
				setState(317);
				((VariableContext)_localctx).expr = expression();
				setState(318);
				((VariableContext)_localctx).RTHIRD = match(RTHIRD);

					writeIntoparserLogFile("Line " + std::to_string(((VariableContext)_localctx).LTHIRD->getLine()) + ":" + " variable : ID LTHIRD expression RTHIRD\n");
					writeIntoparserLogFile(((VariableContext)_localctx).ID->getText() + ((VariableContext)_localctx).LTHIRD->getText() + (((VariableContext)_localctx).expr!=null?_input.getText(((VariableContext)_localctx).expr.start,((VariableContext)_localctx).expr.stop):null) + ((VariableContext)_localctx).RTHIRD->getText() + "\n");
					existing = symbolTable->LookUp(((VariableContext)_localctx).ID->getText());
					if(existing) {
						((VariableContext)_localctx).datatype =  existing->additionalInfo.dataType;
						if(existing->additionalInfo.isGlobal){
							code = "LEA SI, " + ((VariableContext)_localctx).ID->getText() + "\n";
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
					((VariableContext)_localctx).place =  ((VariableContext)_localctx).ID->getText();
					((VariableContext)_localctx).index =  (((VariableContext)_localctx).expr!=null?_input.getText(((VariableContext)_localctx).expr.start,((VariableContext)_localctx).expr.stop):null);
					 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public std::string datatype;
		public Logic_expressionContext lgexpr;
		public VariableContext var;
		public Token ASSIGNOP;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public TerminalNode ASSIGNOP() { return getToken(C8086Parser.ASSIGNOP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				((ExpressionContext)_localctx).lgexpr = logic_expression();

					writeIntoparserLogFile("Line " + std::to_string((((ExpressionContext)_localctx).lgexpr!=null?(((ExpressionContext)_localctx).lgexpr.start):null)->getLine()) + ":" + " expression : logic_expression\n");
					writeIntoparserLogFile((((ExpressionContext)_localctx).lgexpr!=null?_input.getText(((ExpressionContext)_localctx).lgexpr.start,((ExpressionContext)_localctx).lgexpr.stop):null) + "\n");
					((ExpressionContext)_localctx).datatype =  ((ExpressionContext)_localctx).lgexpr.datatype;
				 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				((ExpressionContext)_localctx).var = variable();
				setState(327);
				((ExpressionContext)_localctx).ASSIGNOP = match(ASSIGNOP);
				setState(328);
				((ExpressionContext)_localctx).lgexpr = logic_expression();

					writeIntoparserLogFile("Line " + std::to_string(((ExpressionContext)_localctx).ASSIGNOP->getLine()) + ":" + " expression : variable ASSIGNOP logic_expression\n");
					writeIntoparserLogFile((((ExpressionContext)_localctx).var!=null?_input.getText(((ExpressionContext)_localctx).var.start,((ExpressionContext)_localctx).var.stop):null) + ((ExpressionContext)_localctx).ASSIGNOP->getText() + (((ExpressionContext)_localctx).lgexpr!=null?_input.getText(((ExpressionContext)_localctx).lgexpr.start,((ExpressionContext)_localctx).lgexpr.stop):null) + "\n");
					((ExpressionContext)_localctx).datatype =  ((ExpressionContext)_localctx).var.datatype;
					existing = symbolTable->LookUp(((ExpressionContext)_localctx).var.place);
					if(existing){
						if(existing->additionalInfo.isArray){
							if(existing->additionalInfo.isGlobal){
								code = "POP AX\n";
								code += "POP BX\n";
								code += "POP BX\n";
								code += "LEA SI, " + ((ExpressionContext)_localctx).var.place + "\n";
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
							code += "MOV " + ((ExpressionContext)_localctx).var.place + ", BX\n";
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
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logic_expressionContext extends ParserRuleContext {
		public std::string datatype;
		public Rel_expressionContext rlexpr;
		public Rel_expressionContext rlexpr1;
		public Token LOGICOP;
		public Rel_expressionContext rlexpr2;
		public List<Rel_expressionContext> rel_expression() {
			return getRuleContexts(Rel_expressionContext.class);
		}
		public Rel_expressionContext rel_expression(int i) {
			return getRuleContext(Rel_expressionContext.class,i);
		}
		public TerminalNode LOGICOP() { return getToken(C8086Parser.LOGICOP, 0); }
		public Logic_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_expression; }
	}

	public final Logic_expressionContext logic_expression() throws RecognitionException {
		Logic_expressionContext _localctx = new Logic_expressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logic_expression);
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				((Logic_expressionContext)_localctx).rlexpr = rel_expression();

					writeIntoparserLogFile("Line " + std::to_string((((Logic_expressionContext)_localctx).rlexpr!=null?(((Logic_expressionContext)_localctx).rlexpr.start):null)->getLine()) + ":" + " logic_expression : rel_expression\n");
					writeIntoparserLogFile((((Logic_expressionContext)_localctx).rlexpr!=null?_input.getText(((Logic_expressionContext)_localctx).rlexpr.start,((Logic_expressionContext)_localctx).rlexpr.stop):null) + "\n");
					((Logic_expressionContext)_localctx).datatype =  ((Logic_expressionContext)_localctx).rlexpr.datatype;

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				((Logic_expressionContext)_localctx).rlexpr1 = rel_expression();
				setState(337);
				((Logic_expressionContext)_localctx).LOGICOP = match(LOGICOP);
				setState(338);
				((Logic_expressionContext)_localctx).rlexpr2 = rel_expression();

					writeIntoparserLogFile("Line " + std::to_string(((Logic_expressionContext)_localctx).LOGICOP->getLine()) + ":" + " logic_expression : rel_expression LOGICOP rel_expression\n");
					writeIntoparserLogFile((((Logic_expressionContext)_localctx).rlexpr1!=null?_input.getText(((Logic_expressionContext)_localctx).rlexpr1.start,((Logic_expressionContext)_localctx).rlexpr1.stop):null) + ((Logic_expressionContext)_localctx).LOGICOP->getText() + (((Logic_expressionContext)_localctx).rlexpr2!=null?_input.getText(((Logic_expressionContext)_localctx).rlexpr2.start,((Logic_expressionContext)_localctx).rlexpr2.stop):null) + "\n");
					((Logic_expressionContext)_localctx).datatype =  ((Logic_expressionContext)_localctx).rlexpr1.datatype;
						code = "POP BX\n";
						code += "POP AX\n";
						if(((Logic_expressionContext)_localctx).LOGICOP->getText() == "&&"){
							code += "AND AX, BX\n";
							code += "PUSH AX\n";
						}
						else if(((Logic_expressionContext)_localctx).LOGICOP->getText() == "||"){
							code += "OR AX, BX\n";
							code += "PUSH AX\n";
						}
						writeIntoAssemblyFile(code);
						 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rel_expressionContext extends ParserRuleContext {
		public std::string datatype;
		public Simple_expressionContext smexpr;
		public Simple_expressionContext smexpr1;
		public Token RELOP;
		public Simple_expressionContext smexpr2;
		public List<Simple_expressionContext> simple_expression() {
			return getRuleContexts(Simple_expressionContext.class);
		}
		public Simple_expressionContext simple_expression(int i) {
			return getRuleContext(Simple_expressionContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(C8086Parser.RELOP, 0); }
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_rel_expression);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				((Rel_expressionContext)_localctx).smexpr = simple_expression(0);

					writeIntoparserLogFile("Line " + std::to_string((((Rel_expressionContext)_localctx).smexpr!=null?(((Rel_expressionContext)_localctx).smexpr.start):null)->getLine()) + ":" + " rel_expression : simple_expression\n");
					writeIntoparserLogFile((((Rel_expressionContext)_localctx).smexpr!=null?_input.getText(((Rel_expressionContext)_localctx).smexpr.start,((Rel_expressionContext)_localctx).smexpr.stop):null) + "\n");
					((Rel_expressionContext)_localctx).datatype =  ((Rel_expressionContext)_localctx).smexpr.datatype;

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				((Rel_expressionContext)_localctx).smexpr1 = simple_expression(0);
				setState(347);
				((Rel_expressionContext)_localctx).RELOP = match(RELOP);
				setState(348);
				((Rel_expressionContext)_localctx).smexpr2 = simple_expression(0);

					writeIntoparserLogFile("Line " + std::to_string(((Rel_expressionContext)_localctx).RELOP->getLine()) + ":" + " rel_expression : simple_expression RELOP simple_expression\n");
					writeIntoparserLogFile((((Rel_expressionContext)_localctx).smexpr1!=null?_input.getText(((Rel_expressionContext)_localctx).smexpr1.start,((Rel_expressionContext)_localctx).smexpr1.stop):null) + ((Rel_expressionContext)_localctx).RELOP->getText() + (((Rel_expressionContext)_localctx).smexpr2!=null?_input.getText(((Rel_expressionContext)_localctx).smexpr2.start,((Rel_expressionContext)_localctx).smexpr2.stop):null) + "\n");
					((Rel_expressionContext)_localctx).datatype =  ((Rel_expressionContext)_localctx).smexpr1.datatype;

					    code = "POP BX\n";
						code += "POP AX\n";
						str = newLabel();
						if(((Rel_expressionContext)_localctx).RELOP->getText() == "=="){
							code += "CMP AX, BX\n";
							code += std::string("JE ") + str + "\n";
							code += "MOV AX, 0\n";
							code += std::string("JMP ") + str + "_end\n";
							code += str + ":\n";
							code += "MOV AX, 1\n";
							code += str + "_end:\n";
							code += "PUSH AX\n";
						}
						else if(((Rel_expressionContext)_localctx).RELOP->getText() == "!="){
							code += "CMP AX, BX\n";
							code += std::string("JNE ") + str + "\n";
							code += "MOV AX, 0\n";
							code += std::string("JMP ") + str + "_end\n";
							code += str + ":\n";
							code += "MOV AX, 1\n";
							code += str + "_end:\n";
							code += "PUSH AX\n";
						}
						else if(((Rel_expressionContext)_localctx).RELOP->getText() == "<"){
							code += "CMP AX, BX\n";
							code += std::string("JL ") + str + "\n";
							code += "MOV AX, 0\n";
							code += std::string("JMP ") + str + "_end\n";
							code += str + ":\n";
							code += "MOV AX, 1\n";
							code += str + "_end:\n";
							code += "PUSH AX\n";
						}
						else if(((Rel_expressionContext)_localctx).RELOP->getText() == "<="){
							code += "CMP AX, BX\n";
							code += std::string("JLE ") + str + "\n";
							code += "MOV AX, 0\n";
							code += std::string("JMP ") + str + "_end\n";
							code += str + ":\n";
							code += "MOV AX, 1\n";
							code += str + "_end:\n";
							code += "PUSH AX\n";
						}
						else if(((Rel_expressionContext)_localctx).RELOP->getText() == ">"){
							code += "CMP AX, BX\n";
							code += std::string("JG ") + str + "\n";
							code += "MOV AX, 0\n";
							code += std::string("JMP ") + str + "_end\n";
							code += str + ":\n";
							code += "MOV AX, 1\n";
							code += str + "_end:\n";
							code += "PUSH AX\n"; // result in AX
						}
						else if(((Rel_expressionContext)_localctx).RELOP->getText() == ">="){
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
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_expressionContext extends ParserRuleContext {
		public std::string datatype;
		public Simple_expressionContext smexpr;
		public TermContext trm;
		public Token ADDOP;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public Simple_expressionContext simple_expression() {
			return getRuleContext(Simple_expressionContext.class,0);
		}
		public Simple_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_expression; }
	}

	public final Simple_expressionContext simple_expression() throws RecognitionException {
		return simple_expression(0);
	}

	private Simple_expressionContext simple_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Simple_expressionContext _localctx = new Simple_expressionContext(_ctx, _parentState);
		Simple_expressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_simple_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(354);
			((Simple_expressionContext)_localctx).trm = term(0);

				writeIntoparserLogFile("Line " + std::to_string((((Simple_expressionContext)_localctx).trm!=null?(((Simple_expressionContext)_localctx).trm.start):null)->getLine()) + ":" + " simple_expression : term\n");
				writeIntoparserLogFile((((Simple_expressionContext)_localctx).trm!=null?_input.getText(((Simple_expressionContext)_localctx).trm.start,((Simple_expressionContext)_localctx).trm.stop):null) + "\n");
				((Simple_expressionContext)_localctx).datatype =  ((Simple_expressionContext)_localctx).trm.datatype;

			}
			_ctx.stop = _input.LT(-1);
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Simple_expressionContext(_parentctx, _parentState);
					_localctx.smexpr = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_simple_expression);
					setState(357);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(358);
					((Simple_expressionContext)_localctx).ADDOP = match(ADDOP);
					setState(359);
					((Simple_expressionContext)_localctx).trm = term(0);

					          	writeIntoparserLogFile("Line " + std::to_string(((Simple_expressionContext)_localctx).ADDOP->getLine()) + ":" + " simple_expression : simple_expression ADDOP term\n");
					          	writeIntoparserLogFile((((Simple_expressionContext)_localctx).smexpr!=null?_input.getText(((Simple_expressionContext)_localctx).smexpr.start,((Simple_expressionContext)_localctx).smexpr.stop):null) + ((Simple_expressionContext)_localctx).ADDOP->getText() + (((Simple_expressionContext)_localctx).trm!=null?_input.getText(((Simple_expressionContext)_localctx).trm.start,((Simple_expressionContext)_localctx).trm.stop):null) + "\n");
					          	if(((Simple_expressionContext)_localctx).smexpr.datatype == "float" || ((Simple_expressionContext)_localctx).trm.datatype == "float") {
					          		((Simple_expressionContext)_localctx).datatype =  "float";
					          	}
					          	else{
					          		((Simple_expressionContext)_localctx).datatype =  "int";
					          	}
					          	    code = "POP BX\n";
					          		code += "POP AX\n";
					          		if(((Simple_expressionContext)_localctx).ADDOP->getText() == "+"){
					          			code += "ADD AX, BX\n";
					          			code += "PUSH AX\n";
					          		}
					          		else if(((Simple_expressionContext)_localctx).ADDOP->getText() == "-"){
					          			code += "SUB AX, BX\n";
					          			code += "PUSH AX\n"; // difference in AX
					          		}
					          		writeIntoAssemblyFile(code);
					          	
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public std::string datatype;
		public TermContext trm;
		public Unary_expressionContext unexpr;
		public Token MULOP;
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode MULOP() { return getToken(C8086Parser.MULOP, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(368);
			((TermContext)_localctx).unexpr = unary_expression();

				writeIntoparserLogFile("Line " + std::to_string((((TermContext)_localctx).unexpr!=null?(((TermContext)_localctx).unexpr.start):null)->getLine()) + ":" + " term : unary_expression\n");
				writeIntoparserLogFile((((TermContext)_localctx).unexpr!=null?_input.getText(((TermContext)_localctx).unexpr.start,((TermContext)_localctx).unexpr.stop):null) + "\n");
				((TermContext)_localctx).datatype =  ((TermContext)_localctx).unexpr.datatype;

			}
			_ctx.stop = _input.LT(-1);
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.trm = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(371);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(372);
					((TermContext)_localctx).MULOP = match(MULOP);
					setState(373);
					((TermContext)_localctx).unexpr = unary_expression();

					          	writeIntoparserLogFile("Line " + std::to_string(((TermContext)_localctx).MULOP->getLine()) + ":" + " term : term MULOP unary_expression\n");
					          	writeIntoparserLogFile((((TermContext)_localctx).trm!=null?_input.getText(((TermContext)_localctx).trm.start,((TermContext)_localctx).trm.stop):null) + ((TermContext)_localctx).MULOP->getText() + (((TermContext)_localctx).unexpr!=null?_input.getText(((TermContext)_localctx).unexpr.start,((TermContext)_localctx).unexpr.stop):null) + "\n");
					          	if(((TermContext)_localctx).trm.datatype == "float" || ((TermContext)_localctx).unexpr.datatype == "float") {
					          		((TermContext)_localctx).datatype =  "float";
					          	}
					          	if(((TermContext)_localctx).MULOP->getText() == "%"){
					          		((TermContext)_localctx).datatype =  "int";
					          	}
					          	else{
					          		((TermContext)_localctx).datatype =  "int";
					          	}
					          		code = "POP BX\n";
					          		code += "POP AX\n";
					          		if(((TermContext)_localctx).MULOP->getText() == "*"){
					          			code += "MUL BX\n";
					          			code += "PUSH AX\n";
					          		}
					          		else if(((TermContext)_localctx).MULOP->getText() == "/"){
					          			code += "XOR DX, DX\n";
					          			code += "DIV BX\n";
					          			code += "PUSH AX\n"; // quotient in AX
					          		}
					          		else if(((TermContext)_localctx).MULOP->getText() == "%"){
					          			code += "XOR DX, DX\n";
					          			code += "DIV BX\n";
					          			code += "PUSH DX\n"; // remainder in DX
					          		}
					          		writeIntoAssemblyFile(code);
					          	 
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Unary_expressionContext extends ParserRuleContext {
		public std::string datatype;
		public Token ADDOP;
		public Unary_expressionContext unexpr;
		public Token NOT;
		public FactorContext fctr;
		public TerminalNode ADDOP() { return getToken(C8086Parser.ADDOP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(C8086Parser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unary_expression);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				((Unary_expressionContext)_localctx).ADDOP = match(ADDOP);
				setState(382);
				((Unary_expressionContext)_localctx).unexpr = unary_expression();

						writeIntoparserLogFile("Line " + std::to_string(((Unary_expressionContext)_localctx).ADDOP->getLine()) + ":" + " unary_expression : ADDOP unary_expression\n");
						writeIntoparserLogFile(((Unary_expressionContext)_localctx).ADDOP->getText() + (((Unary_expressionContext)_localctx).unexpr!=null?_input.getText(((Unary_expressionContext)_localctx).unexpr.start,((Unary_expressionContext)_localctx).unexpr.stop):null) + "\n");
						((Unary_expressionContext)_localctx).datatype =  ((Unary_expressionContext)_localctx).unexpr.datatype;
						if(((Unary_expressionContext)_localctx).ADDOP->getText() == "-"){
							code = "POP AX\n";
							code += "NEG AX\n";
							code += "PUSH AX\n";
							writeIntoAssemblyFile(code);
						}

				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				((Unary_expressionContext)_localctx).NOT = match(NOT);
				setState(386);
				((Unary_expressionContext)_localctx).unexpr = unary_expression();

						writeIntoparserLogFile("Line " + std::to_string(((Unary_expressionContext)_localctx).NOT->getLine()) + ":" + " unary_expression : NOT unary_expression\n");
						writeIntoparserLogFile(((Unary_expressionContext)_localctx).NOT->getText() + (((Unary_expressionContext)_localctx).unexpr!=null?_input.getText(((Unary_expressionContext)_localctx).unexpr.start,((Unary_expressionContext)_localctx).unexpr.stop):null) + "\n");
						((Unary_expressionContext)_localctx).datatype =  "int";
						code = "POP AX\n";
						code += "NOT AX\n";
						code += "PUSH AX\n";
						writeIntoAssemblyFile(code);

						
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				((Unary_expressionContext)_localctx).fctr = factor();

						writeIntoparserLogFile("Line " + std::to_string((((Unary_expressionContext)_localctx).fctr!=null?(((Unary_expressionContext)_localctx).fctr.start):null)->getLine()) + ":" + " unary_expression : factor\n");
						writeIntoparserLogFile((((Unary_expressionContext)_localctx).fctr!=null?_input.getText(((Unary_expressionContext)_localctx).fctr.start,((Unary_expressionContext)_localctx).fctr.stop):null) + "\n");
						((Unary_expressionContext)_localctx).datatype =  ((Unary_expressionContext)_localctx).fctr.datatype;
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public std::string datatype;
		public VariableContext var;
		public Token id;
		public Token lp;
		public Argument_listContext argl;
		public Token rp;
		public ExpressionContext expr;
		public Token CONST_INT;
		public Token CONST_FLOAT;
		public Token INCOP;
		public Token DECOP;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(C8086Parser.LPAREN, 0); }
		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(C8086Parser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST_INT() { return getToken(C8086Parser.CONST_INT, 0); }
		public TerminalNode CONST_FLOAT() { return getToken(C8086Parser.CONST_FLOAT, 0); }
		public TerminalNode INCOP() { return getToken(C8086Parser.INCOP, 0); }
		public TerminalNode DECOP() { return getToken(C8086Parser.DECOP, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		try {
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				((FactorContext)_localctx).var = variable();

						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).var.datatype;
						existing = symbolTable->LookUp((((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null));
						if(existing){
							if(existing->additionalInfo.isArray){
								code = "POP AX\n";
								code += "POP BX\n";
								code += "PUSH AX\n";
								writeIntoAssemblyFile(code);
							}
						}
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				((FactorContext)_localctx).id = match(ID);
				setState(398);
				((FactorContext)_localctx).lp = match(LPAREN);
				setState(399);
				((FactorContext)_localctx).argl = argument_list();
				setState(400);
				((FactorContext)_localctx).rp = match(RPAREN);

						writeIntoparserLogFile("Line " + std::to_string((((FactorContext)_localctx).argl!=null?(((FactorContext)_localctx).argl.start):null)->getLine()) + ":" + " factor : ID LPAREN argument_list RPAREN\n");
						writeIntoparserLogFile((((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + (((FactorContext)_localctx).lp!=null?((FactorContext)_localctx).lp.getText():null) + (((FactorContext)_localctx).argl!=null?_input.getText(((FactorContext)_localctx).argl.start,((FactorContext)_localctx).argl.stop):null) + (((FactorContext)_localctx).rp!=null?((FactorContext)_localctx).rp.getText():null) + "\n");
						((FactorContext)_localctx).datatype =  existing->additionalInfo.returnType;
						existing = symbolTable->LookUp((((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null));
						code = "CALL " + (((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + "\n";
						for(int i = 0; i< ((FactorContext)_localctx).argl.argtypes.size(); i++) {
							code += "POP DX\n";
						}
						// if(hasreturn){
						// 	code += "PUSH CX\n";
						// 	hasreturn = false;
						// }

						code += "PUSH CX\n";
						writeIntoAssemblyFile(code);
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				((FactorContext)_localctx).lp = match(LPAREN);
				setState(404);
				((FactorContext)_localctx).expr = expression();
				setState(405);
				((FactorContext)_localctx).rp = match(RPAREN);

						writeIntoparserLogFile("Line " + std::to_string((((FactorContext)_localctx).expr!=null?(((FactorContext)_localctx).expr.start):null)->getLine()) + ":" + " factor : LPAREN expression RPAREN\n");
						writeIntoparserLogFile((((FactorContext)_localctx).lp!=null?((FactorContext)_localctx).lp.getText():null) + (((FactorContext)_localctx).expr!=null?_input.getText(((FactorContext)_localctx).expr.start,((FactorContext)_localctx).expr.stop):null) + (((FactorContext)_localctx).rp!=null?((FactorContext)_localctx).rp.getText():null) + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).expr.datatype;
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(408);
				((FactorContext)_localctx).CONST_INT = match(CONST_INT);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).CONST_INT->getLine()) + ":" + " factor : CONST_INT\n");
						writeIntoparserLogFile(((FactorContext)_localctx).CONST_INT->getText() + "\n");
						((FactorContext)_localctx).datatype =  "int";
						code = "MOV AX, " + ((FactorContext)_localctx).CONST_INT->getText() + "\n";
						code += "PUSH AX\n";
						writeIntoAssemblyFile(code);
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(410);
				((FactorContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).CONST_FLOAT->getLine()) + ":" + " factor : CONST_FLOAT\n");
						writeIntoparserLogFile(((FactorContext)_localctx).CONST_FLOAT->getText() + "\n");
						((FactorContext)_localctx).datatype =  "float";
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(412);
				((FactorContext)_localctx).var = variable();
				setState(413);
				((FactorContext)_localctx).INCOP = match(INCOP);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).INCOP->getLine()) + ":" + " factor : variable INCOP\n");
						writeIntoparserLogFile(((FactorContext)_localctx).INCOP->getText() + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).var.datatype;
						existing = symbolTable->LookUp(((FactorContext)_localctx).var.place);
						if(existing){
							if(existing->additionalInfo.isArray){
								if(existing->additionalInfo.isGlobal){
									code = "LEA SI, " + (((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null) + "\n";
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
									code = "INC " + (((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null) + "\n";
									writeIntoAssemblyFile(code);
								}
								else{
									code = "INC WORD PTR[BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
									writeIntoAssemblyFile(code);
								}
							}
						}
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(416);
				((FactorContext)_localctx).var = variable();
				setState(417);
				((FactorContext)_localctx).DECOP = match(DECOP);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).DECOP->getLine()) + ":" + " factor : variable DECOP\n");
						writeIntoparserLogFile(((FactorContext)_localctx).DECOP->getText() + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).var.datatype;
						existing = symbolTable->LookUp((((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null));
						if(existing){
							if(existing->additionalInfo.isArray){
								if(existing->additionalInfo.isGlobal){
									code = "LEA SI, " + (((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null) + "\n";
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
									code = "DEC " + (((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null) + "\n";
									writeIntoAssemblyFile(code);
								}
								else{
									code = "DEC WORD PTR[BP - " + std::to_string(existing->additionalInfo.offset) + "]\n";
									writeIntoAssemblyFile(code);
								}
							}
						}
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_listContext extends ParserRuleContext {
		public std::vector<std::string> argtypes;
		public ArgumentsContext args;
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_list; }
	}

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_argument_list);
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case ADDOP:
			case NOT:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				((Argument_listContext)_localctx).args = arguments(0);

							writeIntoparserLogFile("Line " + std::to_string((((Argument_listContext)_localctx).args!=null?(((Argument_listContext)_localctx).args.start):null)->getLine()) + ":" + " argument_list : arguments\n");
							writeIntoparserLogFile((((Argument_listContext)_localctx).args!=null?_input.getText(((Argument_listContext)_localctx).args.start,((Argument_listContext)_localctx).args.stop):null) + "\n");
							((Argument_listContext)_localctx).argtypes =  ((Argument_listContext)_localctx).args.argtypes;
				            
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{

								((Argument_listContext)_localctx).argtypes =  std::vector<std::string>();
							  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public std::vector<std::string> argtypes;
		public ArgumentsContext args;
		public Logic_expressionContext le;
		public Token cm;
		public Logic_expressionContext logic_expression() {
			return getRuleContext(Logic_expressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(C8086Parser.COMMA, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		return arguments(0);
	}

	private ArgumentsContext arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, _parentState);
		ArgumentsContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(429);
			((ArgumentsContext)_localctx).le = logic_expression();

						writeIntoparserLogFile("Line " + std::to_string((((ArgumentsContext)_localctx).le!=null?(((ArgumentsContext)_localctx).le.start):null)->getLine()) + ":" + " arguments : logic_expression\n");
						writeIntoparserLogFile((((ArgumentsContext)_localctx).le!=null?_input.getText(((ArgumentsContext)_localctx).le.start,((ArgumentsContext)_localctx).le.stop):null) + "\n");
						_localctx.argtypes.push_back(((ArgumentsContext)_localctx).le.datatype);
					  
			}
			_ctx.stop = _input.LT(-1);
			setState(439);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentsContext(_parentctx, _parentState);
					_localctx.args = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_arguments);
					setState(432);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(433);
					((ArgumentsContext)_localctx).cm = match(COMMA);
					setState(434);
					((ArgumentsContext)_localctx).le = logic_expression();

					          			writeIntoparserLogFile("Line " + std::to_string((((ArgumentsContext)_localctx).le!=null?(((ArgumentsContext)_localctx).le.start):null)->getLine()) + ":" + " arguments : arguments COMMA logic_expression\n");
					          			writeIntoparserLogFile((((ArgumentsContext)_localctx).args!=null?_input.getText(((ArgumentsContext)_localctx).args.start,((ArgumentsContext)_localctx).args.stop):null) + (((ArgumentsContext)_localctx).cm!=null?((ArgumentsContext)_localctx).cm.getText():null) + (((ArgumentsContext)_localctx).le!=null?_input.getText(((ArgumentsContext)_localctx).le.start,((ArgumentsContext)_localctx).le.stop):null) + "\n");
					          			((ArgumentsContext)_localctx).argtypes =  ((ArgumentsContext)_localctx).args.argtypes;
					          			_localctx.argtypes.push_back(((ArgumentsContext)_localctx).le.datatype);
					                    
					}
					} 
				}
				setState(441);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return program_sempred((ProgramContext)_localctx, predIndex);
		case 5:
			return parameter_list_sempred((Parameter_listContext)_localctx, predIndex);
		case 10:
			return declaration_list_sempred((Declaration_listContext)_localctx, predIndex);
		case 11:
			return statements_sempred((StatementsContext)_localctx, predIndex);
		case 18:
			return simple_expression_sempred((Simple_expressionContext)_localctx, predIndex);
		case 19:
			return term_sempred((TermContext)_localctx, predIndex);
		case 23:
			return arguments_sempred((ArgumentsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean program_sempred(ProgramContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean parameter_list_sempred(Parameter_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001,\u01bb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001=\b\u0001"+
		"\n\u0001\f\u0001@\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002M\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003`\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004x\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0086\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0099\b\u0005\n\u0005\f\u0005\u009c\t\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00a8\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00b4\b\u0007\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00be\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c8\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u00e0\b\n\n\n\f\n\u00e3\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00ed\b\u000b\n\u000b\f\u000b\u00f0\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0130"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0138\b\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0142\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u014c\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0156\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u0160\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u016b\b\u0012\n\u0012\f\u0012\u016e\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0179\b\u0013\n\u0013\f\u0013"+
		"\u017c\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u0189\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u01a5\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u01ab\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u01b6\b\u0017\n\u0017"+
		"\f\u0017\u01b9\t\u0017\u0001\u0017\u0000\u0007\u0002\n\u0014\u0016$&."+
		"\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.\u0000\u0001\u0003\u0000  \"\"&(\u01cf\u0000"+
		"0\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004L\u0001"+
		"\u0000\u0000\u0000\u0006_\u0001\u0000\u0000\u0000\bw\u0001\u0000\u0000"+
		"\u0000\n\u0085\u0001\u0000\u0000\u0000\f\u00a7\u0001\u0000\u0000\u0000"+
		"\u000e\u00b3\u0001\u0000\u0000\u0000\u0010\u00b5\u0001\u0000\u0000\u0000"+
		"\u0012\u00bd\u0001\u0000\u0000\u0000\u0014\u00c7\u0001\u0000\u0000\u0000"+
		"\u0016\u00e4\u0001\u0000\u0000\u0000\u0018\u012f\u0001\u0000\u0000\u0000"+
		"\u001a\u0137\u0001\u0000\u0000\u0000\u001c\u0141\u0001\u0000\u0000\u0000"+
		"\u001e\u014b\u0001\u0000\u0000\u0000 \u0155\u0001\u0000\u0000\u0000\""+
		"\u015f\u0001\u0000\u0000\u0000$\u0161\u0001\u0000\u0000\u0000&\u016f\u0001"+
		"\u0000\u0000\u0000(\u0188\u0001\u0000\u0000\u0000*\u01a4\u0001\u0000\u0000"+
		"\u0000,\u01aa\u0001\u0000\u0000\u0000.\u01ac\u0001\u0000\u0000\u00000"+
		"1\u0006\u0000\uffff\uffff\u000012\u0003\u0002\u0001\u000023\u0006\u0000"+
		"\uffff\uffff\u00003\u0001\u0001\u0000\u0000\u000045\u0006\u0001\uffff"+
		"\uffff\u000056\u0003\u0004\u0002\u000067\u0006\u0001\uffff\uffff\u0000"+
		"7>\u0001\u0000\u0000\u000089\n\u0002\u0000\u00009:\u0003\u0004\u0002\u0000"+
		":;\u0006\u0001\uffff\uffff\u0000;=\u0001\u0000\u0000\u0000<8\u0001\u0000"+
		"\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000>?\u0001"+
		"\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000"+
		"\u0000AB\u0003\u000e\u0007\u0000BC\u0006\u0002\uffff\uffff\u0000CM\u0001"+
		"\u0000\u0000\u0000DE\u0006\u0002\uffff\uffff\u0000EF\u0003\u0006\u0003"+
		"\u0000FG\u0006\u0002\uffff\uffff\u0000GM\u0001\u0000\u0000\u0000HI\u0006"+
		"\u0002\uffff\uffff\u0000IJ\u0003\b\u0004\u0000JK\u0006\u0002\uffff\uffff"+
		"\u0000KM\u0001\u0000\u0000\u0000LA\u0001\u0000\u0000\u0000LD\u0001\u0000"+
		"\u0000\u0000LH\u0001\u0000\u0000\u0000M\u0005\u0001\u0000\u0000\u0000"+
		"NO\u0003\u0012\t\u0000OP\u0005)\u0000\u0000PQ\u0006\u0003\uffff\uffff"+
		"\u0000QR\u0005\u0017\u0000\u0000RS\u0003\n\u0005\u0000ST\u0005\u0018\u0000"+
		"\u0000TU\u0005\u001d\u0000\u0000UV\u0006\u0003\uffff\uffff\u0000V`\u0001"+
		"\u0000\u0000\u0000WX\u0003\u0012\t\u0000XY\u0005)\u0000\u0000YZ\u0006"+
		"\u0003\uffff\uffff\u0000Z[\u0005\u0017\u0000\u0000[\\\u0005\u0018\u0000"+
		"\u0000\\]\u0005\u001d\u0000\u0000]^\u0006\u0003\uffff\uffff\u0000^`\u0001"+
		"\u0000\u0000\u0000_N\u0001\u0000\u0000\u0000_W\u0001\u0000\u0000\u0000"+
		"`\u0007\u0001\u0000\u0000\u0000ab\u0003\u0012\t\u0000bc\u0005)\u0000\u0000"+
		"cd\u0006\u0004\uffff\uffff\u0000de\u0005\u0017\u0000\u0000ef\u0006\u0004"+
		"\uffff\uffff\u0000fg\u0003\n\u0005\u0000gh\u0006\u0004\uffff\uffff\u0000"+
		"hi\u0005\u0018\u0000\u0000ij\u0006\u0004\uffff\uffff\u0000jk\u0003\f\u0006"+
		"\u0000kl\u0006\u0004\uffff\uffff\u0000lx\u0001\u0000\u0000\u0000mn\u0003"+
		"\u0012\t\u0000no\u0005)\u0000\u0000op\u0006\u0004\uffff\uffff\u0000pq"+
		"\u0005\u0017\u0000\u0000qr\u0006\u0004\uffff\uffff\u0000rs\u0005\u0018"+
		"\u0000\u0000st\u0006\u0004\uffff\uffff\u0000tu\u0003\f\u0006\u0000uv\u0006"+
		"\u0004\uffff\uffff\u0000vx\u0001\u0000\u0000\u0000wa\u0001\u0000\u0000"+
		"\u0000wm\u0001\u0000\u0000\u0000x\t\u0001\u0000\u0000\u0000yz\u0006\u0005"+
		"\uffff\uffff\u0000z{\u0003\u0012\t\u0000{|\u0005)\u0000\u0000|}\u0006"+
		"\u0005\uffff\uffff\u0000}\u0086\u0001\u0000\u0000\u0000~\u007f\u0003\u0012"+
		"\t\u0000\u007f\u0080\u0006\u0005\uffff\uffff\u0000\u0080\u0086\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0003\u0012\t\u0000\u0082\u0083\u0007\u0000\u0000"+
		"\u0000\u0083\u0084\u0006\u0005\uffff\uffff\u0000\u0084\u0086\u0001\u0000"+
		"\u0000\u0000\u0085y\u0001\u0000\u0000\u0000\u0085~\u0001\u0000\u0000\u0000"+
		"\u0085\u0081\u0001\u0000\u0000\u0000\u0086\u009a\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\n\u0006\u0000\u0000\u0088\u0089\u0005\u001e\u0000\u0000\u0089"+
		"\u008a\u0003\u0012\t\u0000\u008a\u008b\u0005)\u0000\u0000\u008b\u008c"+
		"\u0006\u0005\uffff\uffff\u0000\u008c\u0099\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\n\u0005\u0000\u0000\u008e\u008f\u0005\u001e\u0000\u0000\u008f\u0090"+
		"\u0003\u0012\t\u0000\u0090\u0091\u0007\u0000\u0000\u0000\u0091\u0092\u0006"+
		"\u0005\uffff\uffff\u0000\u0092\u0099\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\n\u0004\u0000\u0000\u0094\u0095\u0005\u001e\u0000\u0000\u0095\u0096\u0003"+
		"\u0012\t\u0000\u0096\u0097\u0006\u0005\uffff\uffff\u0000\u0097\u0099\u0001"+
		"\u0000\u0000\u0000\u0098\u0087\u0001\u0000\u0000\u0000\u0098\u008d\u0001"+
		"\u0000\u0000\u0000\u0098\u0093\u0001\u0000\u0000\u0000\u0099\u009c\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u000b\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u0019\u0000\u0000\u009e\u009f\u0006"+
		"\u0006\uffff\uffff\u0000\u009f\u00a0\u0003\u0016\u000b\u0000\u00a0\u00a1"+
		"\u0005\u001a\u0000\u0000\u00a1\u00a2\u0006\u0006\uffff\uffff\u0000\u00a2"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0019\u0000\u0000\u00a4"+
		"\u00a5\u0006\u0006\uffff\uffff\u0000\u00a5\u00a6\u0005\u001a\u0000\u0000"+
		"\u00a6\u00a8\u0006\u0006\uffff\uffff\u0000\u00a7\u009d\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a8\r\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0003\u0012\t\u0000\u00aa\u00ab\u0003\u0014\n\u0000\u00ab"+
		"\u00ac\u0005\u001d\u0000\u0000\u00ac\u00ad\u0006\u0007\uffff\uffff\u0000"+
		"\u00ad\u00b4\u0001\u0000\u0000\u0000\u00ae\u00af\u0003\u0012\t\u0000\u00af"+
		"\u00b0\u0003\u0010\b\u0000\u00b0\u00b1\u0005\u001d\u0000\u0000\u00b1\u00b2"+
		"\u0006\u0007\uffff\uffff\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3"+
		"\u00a9\u0001\u0000\u0000\u0000\u00b3\u00ae\u0001\u0000\u0000\u0000\u00b4"+
		"\u000f\u0001\u0000\u0000\u0000\u00b5\u00b6\u0006\b\uffff\uffff\u0000\u00b6"+
		"\u0011\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u000b\u0000\u0000\u00b8"+
		"\u00be\u0006\t\uffff\uffff\u0000\u00b9\u00ba\u0005\f\u0000\u0000\u00ba"+
		"\u00be\u0006\t\uffff\uffff\u0000\u00bb\u00bc\u0005\r\u0000\u0000\u00bc"+
		"\u00be\u0006\t\uffff\uffff\u0000\u00bd\u00b7\u0001\u0000\u0000\u0000\u00bd"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be"+
		"\u0013\u0001\u0000\u0000\u0000\u00bf\u00c0\u0006\n\uffff\uffff\u0000\u00c0"+
		"\u00c1\u0005)\u0000\u0000\u00c1\u00c8\u0006\n\uffff\uffff\u0000\u00c2"+
		"\u00c3\u0005)\u0000\u0000\u00c3\u00c4\u0005\u001b\u0000\u0000\u00c4\u00c5"+
		"\u0005*\u0000\u0000\u00c5\u00c6\u0005\u001c\u0000\u0000\u00c6\u00c8\u0006"+
		"\n\uffff\uffff\u0000\u00c7\u00bf\u0001\u0000\u0000\u0000\u00c7\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c8\u00e1\u0001\u0000\u0000\u0000\u00c9\u00ca\n\u0006"+
		"\u0000\u0000\u00ca\u00cb\u0005\u001e\u0000\u0000\u00cb\u00cc\u0005)\u0000"+
		"\u0000\u00cc\u00e0\u0006\n\uffff\uffff\u0000\u00cd\u00ce\n\u0005\u0000"+
		"\u0000\u00ce\u00cf\u0005\u001e\u0000\u0000\u00cf\u00d0\u0005)\u0000\u0000"+
		"\u00d0\u00d1\u0005\u001b\u0000\u0000\u00d1\u00d2\u0005*\u0000\u0000\u00d2"+
		"\u00d3\u0005\u001c\u0000\u0000\u00d3\u00e0\u0006\n\uffff\uffff\u0000\u00d4"+
		"\u00d5\n\u0004\u0000\u0000\u00d5\u00d6\u0007\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0005)\u0000\u0000\u00d7\u00e0\u0006\n\uffff\uffff\u0000\u00d8\u00d9"+
		"\n\u0003\u0000\u0000\u00d9\u00da\u0007\u0000\u0000\u0000\u00da\u00db\u0005"+
		")\u0000\u0000\u00db\u00dc\u0005\u001b\u0000\u0000\u00dc\u00dd\u0005*\u0000"+
		"\u0000\u00dd\u00de\u0005\u001c\u0000\u0000\u00de\u00e0\u0006\n\uffff\uffff"+
		"\u0000\u00df\u00c9\u0001\u0000\u0000\u0000\u00df\u00cd\u0001\u0000\u0000"+
		"\u0000\u00df\u00d4\u0001\u0000\u0000\u0000\u00df\u00d8\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u0015\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e5\u0006\u000b\uffff"+
		"\uffff\u0000\u00e5\u00e6\u0003\u0018\f\u0000\u00e6\u00e7\u0006\u000b\uffff"+
		"\uffff\u0000\u00e7\u00ee\u0001\u0000\u0000\u0000\u00e8\u00e9\n\u0001\u0000"+
		"\u0000\u00e9\u00ea\u0003\u0018\f\u0000\u00ea\u00eb\u0006\u000b\uffff\uffff"+
		"\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u0017\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f2\u0003\u000e\u0007"+
		"\u0000\u00f2\u00f3\u0006\f\uffff\uffff\u0000\u00f3\u0130\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0003\u001a\r\u0000\u00f5\u00f6\u0006\f\uffff\uffff"+
		"\u0000\u00f6\u0130\u0001\u0000\u0000\u0000\u00f7\u00f8\u0003\f\u0006\u0000"+
		"\u00f8\u00f9\u0006\f\uffff\uffff\u0000\u00f9\u0130\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb\u00fc\u0005\u0017\u0000\u0000"+
		"\u00fc\u00fd\u0003\u001a\r\u0000\u00fd\u00fe\u0006\f\uffff\uffff\u0000"+
		"\u00fe\u00ff\u0003\u001a\r\u0000\u00ff\u0100\u0006\f\uffff\uffff\u0000"+
		"\u0100\u0101\u0003\u001e\u000f\u0000\u0101\u0102\u0006\f\uffff\uffff\u0000"+
		"\u0102\u0103\u0005\u0018\u0000\u0000\u0103\u0104\u0006\f\uffff\uffff\u0000"+
		"\u0104\u0105\u0003\u0018\f\u0000\u0105\u0106\u0006\f\uffff\uffff\u0000"+
		"\u0106\u0130\u0001\u0000\u0000\u0000\u0107\u0108\u0005\u0005\u0000\u0000"+
		"\u0108\u0109\u0005\u0017\u0000\u0000\u0109\u010a\u0003\u001e\u000f\u0000"+
		"\u010a\u010b\u0005\u0018\u0000\u0000\u010b\u010c\u0006\f\uffff\uffff\u0000"+
		"\u010c\u010d\u0003\u0018\f\u0000\u010d\u010e\u0006\f\uffff\uffff\u0000"+
		"\u010e\u0130\u0001\u0000\u0000\u0000\u010f\u0110\u0005\u0005\u0000\u0000"+
		"\u0110\u0111\u0005\u0017\u0000\u0000\u0111\u0112\u0003\u001e\u000f\u0000"+
		"\u0112\u0113\u0005\u0018\u0000\u0000\u0113\u0114\u0006\f\uffff\uffff\u0000"+
		"\u0114\u0115\u0003\u0018\f\u0000\u0115\u0116\u0006\f\uffff\uffff\u0000"+
		"\u0116\u0117\u0005\u0006\u0000\u0000\u0117\u0118\u0006\f\uffff\uffff\u0000"+
		"\u0118\u0119\u0003\u0018\f\u0000\u0119\u011a\u0006\f\uffff\uffff\u0000"+
		"\u011a\u0130\u0001\u0000\u0000\u0000\u011b\u011c\u0005\b\u0000\u0000\u011c"+
		"\u011d\u0005\u0017\u0000\u0000\u011d\u011e\u0006\f\uffff\uffff\u0000\u011e"+
		"\u011f\u0003\u001e\u000f\u0000\u011f\u0120\u0005\u0018\u0000\u0000\u0120"+
		"\u0121\u0006\f\uffff\uffff\u0000\u0121\u0122\u0003\u0018\f\u0000\u0122"+
		"\u0123\u0006\f\uffff\uffff\u0000\u0123\u0130\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0005\t\u0000\u0000\u0125\u0126\u0005\u0017\u0000\u0000\u0126\u0127"+
		"\u0005)\u0000\u0000\u0127\u0128\u0005\u0018\u0000\u0000\u0128\u0129\u0005"+
		"\u001d\u0000\u0000\u0129\u0130\u0006\f\uffff\uffff\u0000\u012a\u012b\u0005"+
		"\n\u0000\u0000\u012b\u012c\u0003\u001e\u000f\u0000\u012c\u012d\u0005\u001d"+
		"\u0000\u0000\u012d\u012e\u0006\f\uffff\uffff\u0000\u012e\u0130\u0001\u0000"+
		"\u0000\u0000\u012f\u00f1\u0001\u0000\u0000\u0000\u012f\u00f4\u0001\u0000"+
		"\u0000\u0000\u012f\u00f7\u0001\u0000\u0000\u0000\u012f\u00fa\u0001\u0000"+
		"\u0000\u0000\u012f\u0107\u0001\u0000\u0000\u0000\u012f\u010f\u0001\u0000"+
		"\u0000\u0000\u012f\u011b\u0001\u0000\u0000\u0000\u012f\u0124\u0001\u0000"+
		"\u0000\u0000\u012f\u012a\u0001\u0000\u0000\u0000\u0130\u0019\u0001\u0000"+
		"\u0000\u0000\u0131\u0132\u0005\u001d\u0000\u0000\u0132\u0138\u0006\r\uffff"+
		"\uffff\u0000\u0133\u0134\u0003\u001e\u000f\u0000\u0134\u0135\u0005\u001d"+
		"\u0000\u0000\u0135\u0136\u0006\r\uffff\uffff\u0000\u0136\u0138\u0001\u0000"+
		"\u0000\u0000\u0137\u0131\u0001\u0000\u0000\u0000\u0137\u0133\u0001\u0000"+
		"\u0000\u0000\u0138\u001b\u0001\u0000\u0000\u0000\u0139\u013a\u0005)\u0000"+
		"\u0000\u013a\u0142\u0006\u000e\uffff\uffff\u0000\u013b\u013c\u0005)\u0000"+
		"\u0000\u013c\u013d\u0005\u001b\u0000\u0000\u013d\u013e\u0003\u001e\u000f"+
		"\u0000\u013e\u013f\u0005\u001c\u0000\u0000\u013f\u0140\u0006\u000e\uffff"+
		"\uffff\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141\u0139\u0001\u0000"+
		"\u0000\u0000\u0141\u013b\u0001\u0000\u0000\u0000\u0142\u001d\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0003 \u0010\u0000\u0144\u0145\u0006\u000f\uffff"+
		"\uffff\u0000\u0145\u014c\u0001\u0000\u0000\u0000\u0146\u0147\u0003\u001c"+
		"\u000e\u0000\u0147\u0148\u0005(\u0000\u0000\u0148\u0149\u0003 \u0010\u0000"+
		"\u0149\u014a\u0006\u000f\uffff\uffff\u0000\u014a\u014c\u0001\u0000\u0000"+
		"\u0000\u014b\u0143\u0001\u0000\u0000\u0000\u014b\u0146\u0001\u0000\u0000"+
		"\u0000\u014c\u001f\u0001\u0000\u0000\u0000\u014d\u014e\u0003\"\u0011\u0000"+
		"\u014e\u014f\u0006\u0010\uffff\uffff\u0000\u014f\u0156\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0003\"\u0011\u0000\u0151\u0152\u0005\'\u0000\u0000"+
		"\u0152\u0153\u0003\"\u0011\u0000\u0153\u0154\u0006\u0010\uffff\uffff\u0000"+
		"\u0154\u0156\u0001\u0000\u0000\u0000\u0155\u014d\u0001\u0000\u0000\u0000"+
		"\u0155\u0150\u0001\u0000\u0000\u0000\u0156!\u0001\u0000\u0000\u0000\u0157"+
		"\u0158\u0003$\u0012\u0000\u0158\u0159\u0006\u0011\uffff\uffff\u0000\u0159"+
		"\u0160\u0001\u0000\u0000\u0000\u015a\u015b\u0003$\u0012\u0000\u015b\u015c"+
		"\u0005&\u0000\u0000\u015c\u015d\u0003$\u0012\u0000\u015d\u015e\u0006\u0011"+
		"\uffff\uffff\u0000\u015e\u0160\u0001\u0000\u0000\u0000\u015f\u0157\u0001"+
		"\u0000\u0000\u0000\u015f\u015a\u0001\u0000\u0000\u0000\u0160#\u0001\u0000"+
		"\u0000\u0000\u0161\u0162\u0006\u0012\uffff\uffff\u0000\u0162\u0163\u0003"+
		"&\u0013\u0000\u0163\u0164\u0006\u0012\uffff\uffff\u0000\u0164\u016c\u0001"+
		"\u0000\u0000\u0000\u0165\u0166\n\u0001\u0000\u0000\u0166\u0167\u0005 "+
		"\u0000\u0000\u0167\u0168\u0003&\u0013\u0000\u0168\u0169\u0006\u0012\uffff"+
		"\uffff\u0000\u0169\u016b\u0001\u0000\u0000\u0000\u016a\u0165\u0001\u0000"+
		"\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c\u016a\u0001\u0000"+
		"\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d%\u0001\u0000\u0000"+
		"\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f\u0170\u0006\u0013\uffff"+
		"\uffff\u0000\u0170\u0171\u0003(\u0014\u0000\u0171\u0172\u0006\u0013\uffff"+
		"\uffff\u0000\u0172\u017a\u0001\u0000\u0000\u0000\u0173\u0174\n\u0001\u0000"+
		"\u0000\u0174\u0175\u0005\"\u0000\u0000\u0175\u0176\u0003(\u0014\u0000"+
		"\u0176\u0177\u0006\u0013\uffff\uffff\u0000\u0177\u0179\u0001\u0000\u0000"+
		"\u0000\u0178\u0173\u0001\u0000\u0000\u0000\u0179\u017c\u0001\u0000\u0000"+
		"\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000"+
		"\u0000\u017b\'\u0001\u0000\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000"+
		"\u017d\u017e\u0005 \u0000\u0000\u017e\u017f\u0003(\u0014\u0000\u017f\u0180"+
		"\u0006\u0014\uffff\uffff\u0000\u0180\u0189\u0001\u0000\u0000\u0000\u0181"+
		"\u0182\u0005%\u0000\u0000\u0182\u0183\u0003(\u0014\u0000\u0183\u0184\u0006"+
		"\u0014\uffff\uffff\u0000\u0184\u0189\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0003*\u0015\u0000\u0186\u0187\u0006\u0014\uffff\uffff\u0000\u0187\u0189"+
		"\u0001\u0000\u0000\u0000\u0188\u017d\u0001\u0000\u0000\u0000\u0188\u0181"+
		"\u0001\u0000\u0000\u0000\u0188\u0185\u0001\u0000\u0000\u0000\u0189)\u0001"+
		"\u0000\u0000\u0000\u018a\u018b\u0003\u001c\u000e\u0000\u018b\u018c\u0006"+
		"\u0015\uffff\uffff\u0000\u018c\u01a5\u0001\u0000\u0000\u0000\u018d\u018e"+
		"\u0005)\u0000\u0000\u018e\u018f\u0005\u0017\u0000\u0000\u018f\u0190\u0003"+
		",\u0016\u0000\u0190\u0191\u0005\u0018\u0000\u0000\u0191\u0192\u0006\u0015"+
		"\uffff\uffff\u0000\u0192\u01a5\u0001\u0000\u0000\u0000\u0193\u0194\u0005"+
		"\u0017\u0000\u0000\u0194\u0195\u0003\u001e\u000f\u0000\u0195\u0196\u0005"+
		"\u0018\u0000\u0000\u0196\u0197\u0006\u0015\uffff\uffff\u0000\u0197\u01a5"+
		"\u0001\u0000\u0000\u0000\u0198\u0199\u0005*\u0000\u0000\u0199\u01a5\u0006"+
		"\u0015\uffff\uffff\u0000\u019a\u019b\u0005+\u0000\u0000\u019b\u01a5\u0006"+
		"\u0015\uffff\uffff\u0000\u019c\u019d\u0003\u001c\u000e\u0000\u019d\u019e"+
		"\u0005#\u0000\u0000\u019e\u019f\u0006\u0015\uffff\uffff\u0000\u019f\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a0\u01a1\u0003\u001c\u000e\u0000\u01a1\u01a2"+
		"\u0005$\u0000\u0000\u01a2\u01a3\u0006\u0015\uffff\uffff\u0000\u01a3\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a4\u018a\u0001\u0000\u0000\u0000\u01a4\u018d"+
		"\u0001\u0000\u0000\u0000\u01a4\u0193\u0001\u0000\u0000\u0000\u01a4\u0198"+
		"\u0001\u0000\u0000\u0000\u01a4\u019a\u0001\u0000\u0000\u0000\u01a4\u019c"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a0\u0001\u0000\u0000\u0000\u01a5+\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a7\u0003.\u0017\u0000\u01a7\u01a8\u0006\u0016"+
		"\uffff\uffff\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000\u01a9\u01ab\u0006"+
		"\u0016\uffff\uffff\u0000\u01aa\u01a6\u0001\u0000\u0000\u0000\u01aa\u01a9"+
		"\u0001\u0000\u0000\u0000\u01ab-\u0001\u0000\u0000\u0000\u01ac\u01ad\u0006"+
		"\u0017\uffff\uffff\u0000\u01ad\u01ae\u0003 \u0010\u0000\u01ae\u01af\u0006"+
		"\u0017\uffff\uffff\u0000\u01af\u01b7\u0001\u0000\u0000\u0000\u01b0\u01b1"+
		"\n\u0002\u0000\u0000\u01b1\u01b2\u0005\u001e\u0000\u0000\u01b2\u01b3\u0003"+
		" \u0010\u0000\u01b3\u01b4\u0006\u0017\uffff\uffff\u0000\u01b4\u01b6\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b0\u0001\u0000\u0000\u0000\u01b6\u01b9\u0001"+
		"\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b8/\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000"+
		"\u0000\u0000\u001a>L_w\u0085\u0098\u009a\u00a7\u00b3\u00bd\u00c7\u00df"+
		"\u00e1\u00ee\u012f\u0137\u0141\u014b\u0155\u015f\u016c\u017a\u0188\u01a4"+
		"\u01aa\u01b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}