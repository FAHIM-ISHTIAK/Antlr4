// Generated from /home/fahim_ishtiak/CSE 310/antlr/antlr4-resources/antlr4-skeletons/cpp/C8086Parser.g4 by ANTLR 4.13.1

    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
	#include "Utills/2105004_SymbolTable.hpp"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;

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
		WHILE=8, PRINTLN=9, RETURN=10, INT=11, FLOAT=12, VOID=13, LPAREN=14, RPAREN=15, 
		LCURL=16, RCURL=17, LTHIRD=18, RTHIRD=19, SEMICOLON=20, COMMA=21, ADDOP=22, 
		SUBOP=23, MULOP=24, INCOP=25, DECOP=26, NOT=27, RELOP=28, LOGICOP=29, 
		ASSIGNOP=30, ID=31, CONST_INT=32, CONST_FLOAT=33;
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
			null, null, null, null, null, "'if'", "'else'", "'for'", "'while'", "'printf'", 
			"'return'", "'int'", "'float'", "'void'", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "';'", "','", null, null, null, "'++'", "'--'", "'!'", 
			null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
			"FOR", "WHILE", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "LPAREN", 
			"RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COMMA", 
			"ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", 
			"ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT"
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

	public C8086Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
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
			setState(48);
			program(0);

			        writeIntoparserLogFile("Parsing completed successfully with " + std::to_string(syntaxErrorCount) + " syntax errors.");
				
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
			setState(52);
			((ProgramContext)_localctx).unt = unit();

				writeIntoparserLogFile("Line " + std::to_string((((ProgramContext)_localctx).unt!=null?(((ProgramContext)_localctx).unt.stop):null)->getLine()) + ":" + " program : unit\n");
				writeIntoparserLogFile((((ProgramContext)_localctx).unt!=null?_input.getText(((ProgramContext)_localctx).unt.start,((ProgramContext)_localctx).unt.stop):null) + "\n");
				
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
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
					setState(55);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(56);
					((ProgramContext)_localctx).unt = unit();

					          	writeIntoparserLogFile("Line " + std::to_string((((ProgramContext)_localctx).unt!=null?(((ProgramContext)_localctx).unt.stop):null)->getLine()) + ":" + " program : program unit\n");
					          	writeIntoparserLogFile((((ProgramContext)_localctx).pg!=null?_input.getText(((ProgramContext)_localctx).pg.start,((ProgramContext)_localctx).pg.stop):null) + "\n" + (((ProgramContext)_localctx).unt!=null?_input.getText(((ProgramContext)_localctx).unt.start,((ProgramContext)_localctx).unt.stop):null) + "\n");
					          
					}
					} 
				}
				setState(63);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				((UnitContext)_localctx).var_dec = var_declaration();
				 
					writeIntoparserLogFile("Line " + std::to_string((((UnitContext)_localctx).var_dec!=null?(((UnitContext)_localctx).var_dec.start):null)->getLine()) + ":" + " unit : var_declaration\n"); 
					writeIntoparserLogFile((((UnitContext)_localctx).var_dec!=null?_input.getText(((UnitContext)_localctx).var_dec.start,((UnitContext)_localctx).var_dec.stop):null) + "\n"); 

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				((UnitContext)_localctx).func_dec = func_declaration();

						writeIntoparserLogFile("Line " + std::to_string((((UnitContext)_localctx).func_dec!=null?(((UnitContext)_localctx).func_dec.stop):null)->getLine()) + ":" + " unit :  func_declaration\n");
						writeIntoparserLogFile((((UnitContext)_localctx).func_dec!=null?_input.getText(((UnitContext)_localctx).func_dec.start,((UnitContext)_localctx).func_dec.stop):null) + "\n");
					 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				((UnitContext)_localctx).func_def = func_definition();

						writeIntoparserLogFile("Line " + std::to_string((((UnitContext)_localctx).func_def!=null?(((UnitContext)_localctx).func_def.stop):null)->getLine()) + ":" + " unit :  func_definition\n");
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
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				((Func_declarationContext)_localctx).t = type_specifier();
				setState(76);
				((Func_declarationContext)_localctx).id = match(ID);

					if(symbolTable->LookUp((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null))){
						writeIntoErrorFile("Error at line " + std::to_string(((Func_declarationContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + "\n");
						syntaxErrorCount++;
					} 

				setState(78);
				((Func_declarationContext)_localctx).lp = match(LPAREN);
				setState(79);
				((Func_declarationContext)_localctx).pl = parameter_list(0);
				setState(80);
				((Func_declarationContext)_localctx).rp = match(RPAREN);
				setState(81);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

							writeIntoparserLogFile("Line " + std::to_string(((Func_declarationContext)_localctx).sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
							writeIntoparserLogFile((((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + (((Func_declarationContext)_localctx).lp!=null?((Func_declarationContext)_localctx).lp.getText():null) + (((Func_declarationContext)_localctx).pl!=null?_input.getText(((Func_declarationContext)_localctx).pl.start,((Func_declarationContext)_localctx).pl.stop):null) +(((Func_declarationContext)_localctx).rp!=null?((Func_declarationContext)_localctx).rp.getText():null) + (((Func_declarationContext)_localctx).sm!=null?((Func_declarationContext)_localctx).sm.getText():null) + "\n");
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
				setState(84);
				((Func_declarationContext)_localctx).t = type_specifier();
				setState(85);
				((Func_declarationContext)_localctx).id = match(ID);

						if(symbolTable->LookUp((((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null))){
						writeIntoErrorFile("Line " + std::to_string(((Func_declarationContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + "' already declared.");
						syntaxErrorCount++;
					} 
						
				setState(87);
				((Func_declarationContext)_localctx).lp = match(LPAREN);
				setState(88);
				((Func_declarationContext)_localctx).rp = match(RPAREN);
				setState(89);
				((Func_declarationContext)_localctx).sm = match(SEMICOLON);

							writeIntoparserLogFile("Line " + std::to_string(((Func_declarationContext)_localctx).sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
							writeIntoparserLogFile((((Func_declarationContext)_localctx).t!=null?_input.getText(((Func_declarationContext)_localctx).t.start,((Func_declarationContext)_localctx).t.stop):null) + " " + (((Func_declarationContext)_localctx).id!=null?((Func_declarationContext)_localctx).id.getText():null) + (((Func_declarationContext)_localctx).lp!=null?((Func_declarationContext)_localctx).lp.getText():null) + (((Func_declarationContext)_localctx).rp!=null?((Func_declarationContext)_localctx).rp.getText():null) + (((Func_declarationContext)_localctx).sm!=null?((Func_declarationContext)_localctx).sm.getText():null) + "\n");
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
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				((Func_definitionContext)_localctx).t = type_specifier();
				setState(95);
				((Func_definitionContext)_localctx).id = match(ID);

					existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
					if (existing) {
							if(!existing->additionalInfo.isFunction){
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
							}
							else if(existing->additionalInfo.isDefined) {
				                writeIntoErrorFile("Line# " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "' is already defined.");
				                syntaxErrorCount++;
				            }
				        }

				setState(97);
				((Func_definitionContext)_localctx).lp = match(LPAREN);
				 symbolTable->Enter_scope(); 
				setState(99);
				((Func_definitionContext)_localctx).pl = parameter_list(0);
				 
				if(((Func_definitionContext)_localctx).pl.params.size() == ((Func_definitionContext)_localctx).pl.names.size()){
						for(int i = 0; i < ((Func_definitionContext)_localctx).pl.params.size(); i++){
							if(symbolTable->LookUp2(((Func_definitionContext)_localctx).pl.names[i])){
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Multiple declaration of " + ((Func_definitionContext)_localctx).pl.names[i] + " in parameter" + "\n");
								syntaxErrorCount++;
								continue;
							}
						SymbolAdditionalInfo info = SymbolAdditionalInfo();
						info.dataType = ((Func_definitionContext)_localctx).pl.params[i];
						symbolTable->Insert(((Func_definitionContext)_localctx).pl.names[i], "ID", info);
					}
				}
				 
				setState(101);
				((Func_definitionContext)_localctx).rp = match(RPAREN);
				setState(102);
				((Func_definitionContext)_localctx).cm_stmt = compound_statement(true);

							writeIntoparserLogFile("Line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n");
							writeIntoparserLogFile((((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + (((Func_definitionContext)_localctx).lp!=null?((Func_definitionContext)_localctx).lp.getText():null) + (((Func_definitionContext)_localctx).pl!=null?_input.getText(((Func_definitionContext)_localctx).pl.start,((Func_definitionContext)_localctx).pl.stop):null) + (((Func_definitionContext)_localctx).rp!=null?((Func_definitionContext)_localctx).rp.getText():null) + (((Func_definitionContext)_localctx).cm_stmt!=null?_input.getText(((Func_definitionContext)_localctx).cm_stmt.start,((Func_definitionContext)_localctx).cm_stmt.stop):null) + "\n");
						existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
						if (!existing) {
				            SymbolAdditionalInfo info = SymbolAdditionalInfo();
				            info.isFunction = true;
				            info.isDefined = true;
				            info.returnType = (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null);
				            info.parameters = ((Func_definitionContext)_localctx).pl.params;
				            hasInserted = symbolTable->Insert((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null), "ID", info);
				        } else {
							if(existing->additionalInfo.isFunction && !existing->additionalInfo.isDefined) {
				            existing->additionalInfo.isDefined = true;
							if(existing->additionalInfo.returnType != (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null)) {
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
				        }
							if(existing->additionalInfo.parameters != ((Func_definitionContext)_localctx).pl.params) {
								syntaxErrorCount++;
								if(existing->additionalInfo.parameters.size() != ((Func_definitionContext)_localctx).pl.params.size()){
									writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								}
								}
							}
						}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				((Func_definitionContext)_localctx).t = type_specifier();
				setState(106);
				((Func_definitionContext)_localctx).id = match(ID);

					existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
					if (existing) {
				            if (existing->additionalInfo.isDefined) {
				                writeIntoErrorFile("Line# " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + " - Error: Function '" + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "' is already defined.");
				                syntaxErrorCount++;
				            }
				        }
						
				setState(108);
				((Func_definitionContext)_localctx).lp = match(LPAREN);
				 symbolTable->Enter_scope(); 
				setState(110);
				((Func_definitionContext)_localctx).rp = match(RPAREN);
				setState(111);
				((Func_definitionContext)_localctx).cm_stmt = compound_statement(true);

							writeIntoparserLogFile("Line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " func_definition : type_specifier ID LPAREN RPAREN compound_statement\n");
							writeIntoparserLogFile((((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null) + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + (((Func_definitionContext)_localctx).lp!=null?((Func_definitionContext)_localctx).lp.getText():null) + (((Func_definitionContext)_localctx).rp!=null?((Func_definitionContext)_localctx).rp.getText():null) + (((Func_definitionContext)_localctx).cm_stmt!=null?_input.getText(((Func_definitionContext)_localctx).cm_stmt.start,((Func_definitionContext)_localctx).cm_stmt.stop):null) + "\n");
						existing = symbolTable->LookUp((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null));
						if (!existing) {
							SymbolAdditionalInfo info = SymbolAdditionalInfo();
							info.isFunction = true;
							info.isDefined = true;
							info.returnType = (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null);
							hasInserted = symbolTable->Insert((((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null), "ID", info);
						}
						else{
							if(!existing->additionalInfo.isDefined) {
							existing->additionalInfo.isDefined = true;
							if(existing->additionalInfo.returnType != (((Func_definitionContext)_localctx).t!=null?_input.getText(((Func_definitionContext)_localctx).t.start,((Func_definitionContext)_localctx).t.stop):null)) {
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
						}
						if(existing->additionalInfo.parameters.size() > 0){
								writeIntoErrorFile("Error at line " + std::to_string(((Func_definitionContext)_localctx).id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (((Func_definitionContext)_localctx).id!=null?((Func_definitionContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
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
	public static class Parameter_listContext extends ParserRuleContext {
		public std::vector<std::string> params;
		public std::vector<std::string> names;
		public Parameter_listContext pl;
		public Type_specifierContext t;
		public Token id;
		public Token cm;
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode ID() { return getToken(C8086Parser.ID, 0); }
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(117);
				((Parameter_listContext)_localctx).t = type_specifier();
				setState(118);
				((Parameter_listContext)_localctx).id = match(ID);

					writeIntoparserLogFile("Line " + std::to_string((((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null)->getLine()) + ":" + " parameter_list : type_specifier ID\n");
					writeIntoparserLogFile((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + " " + (((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null) + "\n");
					_localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
					_localctx.names.push_back((((Parameter_listContext)_localctx).id!=null?((Parameter_listContext)_localctx).id.getText():null));
						
				}
				break;
			case 2:
				{
				setState(121);
				((Parameter_listContext)_localctx).t = type_specifier();

					writeIntoparserLogFile("Line " + std::to_string((((Parameter_listContext)_localctx).t!=null?(((Parameter_listContext)_localctx).t.stop):null)->getLine()) + ":" + " parameter_list : type_specifier\n");
					writeIntoparserLogFile((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null) + "\n");
					_localctx.params.push_back((((Parameter_listContext)_localctx).t!=null?_input.getText(((Parameter_listContext)_localctx).t.start,((Parameter_listContext)_localctx).t.stop):null));
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Parameter_listContext(_parentctx, _parentState);
						_localctx.pl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_parameter_list);
						setState(126);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(127);
						((Parameter_listContext)_localctx).cm = match(COMMA);
						setState(128);
						((Parameter_listContext)_localctx).t = type_specifier();
						setState(129);
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
						setState(132);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(133);
						((Parameter_listContext)_localctx).cm = match(COMMA);
						setState(134);
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
				setState(141);
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
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((Compound_statementContext)_localctx).LCURL = match(LCURL);

					if(!IsFunction){
					symbolTable->Enter_scope();
				 }

				setState(144);
				((Compound_statementContext)_localctx).stmts = statements(0);
				setState(145);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

							writeIntoparserLogFile("Line " + std::to_string(((Compound_statementContext)_localctx).LCURL->getLine()) + ":" + " compound_statement : LCURL statements RCURL\n");
							writeIntoparserLogFile(((Compound_statementContext)_localctx).LCURL->getText() + (((Compound_statementContext)_localctx).stmts!=null?_input.getText(((Compound_statementContext)_localctx).stmts.start,((Compound_statementContext)_localctx).stmts.stop):null) + ((Compound_statementContext)_localctx).RCURL->getText() + "\n");
							symbolTable->Remove_scope();

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				((Compound_statementContext)_localctx).LCURL = match(LCURL);

								 if(!IsFunction){
						 symbolTable->Enter_scope();
					 }
							
				setState(150);
				((Compound_statementContext)_localctx).RCURL = match(RCURL);

							writeIntoparserLogFile("Line " + std::to_string(((Compound_statementContext)_localctx).LCURL->getLine()) + ":" + " compound_statement : LCURL RCURL\n");
							writeIntoparserLogFile(((Compound_statementContext)_localctx).LCURL->getText() + ((Compound_statementContext)_localctx).RCURL->getText() + "\n");
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
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(155);
				((Var_declarationContext)_localctx).dl = declaration_list(0);
				setState(156);
				((Var_declarationContext)_localctx).sm = match(SEMICOLON);

						writeIntoparserLogFile("Line " + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) + ":" + " var_declaration : type_specifier declaration_list SEMICOLON\n");
						writeIntoparserLogFile((((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null) + " " + (((Var_declarationContext)_localctx).dl!=null?_input.getText(((Var_declarationContext)_localctx).dl.start,((Var_declarationContext)_localctx).dl.stop):null) + (((Var_declarationContext)_localctx).sm!=null?((Var_declarationContext)_localctx).sm.getText():null) + "\n");
						for(int i = 0; i < ((Var_declarationContext)_localctx).dl.decls.size(); i++) {
							if(symbolTable->LookUp2(((Var_declarationContext)_localctx).dl.decls[i].first)) {
								writeIntoErrorFile("Error at line " + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) + ": Multiple declaration of " + ((Var_declarationContext)_localctx).dl.decls[i].first + "\n");
								syntaxErrorCount++;
							} else {
								SymbolAdditionalInfo info = SymbolAdditionalInfo();
								info.dataType = (((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null);
								info.isArray = ((Var_declarationContext)_localctx).dl.decls[i].second;
								info.arraySize = ((Var_declarationContext)_localctx).dl.arrsize[i];
								hasInserted = symbolTable->Insert(((Var_declarationContext)_localctx).dl.decls[i].first, "ID", info);
								if((((Var_declarationContext)_localctx).t!=null?_input.getText(((Var_declarationContext)_localctx).t.start,((Var_declarationContext)_localctx).t.stop):null) == "void"){
									writeIntoErrorFile("Error at line " + std::to_string(((Var_declarationContext)_localctx).sm->getLine()) + ": Variable type cannot be void\n");
									syntaxErrorCount++;
								}
							}
						}
				      
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				((Var_declarationContext)_localctx).t = type_specifier();
				setState(160);
				((Var_declarationContext)_localctx).de = declaration_list_err();
				setState(161);
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
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				((Type_specifierContext)_localctx).INT = match(INT);

				            ((Type_specifierContext)_localctx).name_line =  "type: INT at line" + std::to_string(((Type_specifierContext)_localctx).INT->getLine());
							writeIntoparserLogFile("Line " + std::to_string(((Type_specifierContext)_localctx).INT->getLine()) + ":" + " type_specifier : INT\n");
				            writeIntoparserLogFile(((Type_specifierContext)_localctx).INT->getText() + "\n");
				        
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				((Type_specifierContext)_localctx).FLOAT = match(FLOAT);

				            ((Type_specifierContext)_localctx).name_line =  "type: FLOAT at line" + std::to_string(((Type_specifierContext)_localctx).FLOAT->getLine());
							writeIntoparserLogFile("Line " + std::to_string(((Type_specifierContext)_localctx).FLOAT->getLine()) + ":" + " type_specifier : FLOAT\n");
				            writeIntoparserLogFile(((Type_specifierContext)_localctx).FLOAT->getText() + "\n");
				        
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(177);
				((Declaration_listContext)_localctx).ID = match(ID);

							writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : ID\n");
							writeIntoparserLogFile(((Declaration_listContext)_localctx).ID->getText() + "\n");
							_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), false});
							_localctx.arrsize.push_back(0);
						
				}
				break;
			case 2:
				{
				setState(179);
				((Declaration_listContext)_localctx).ID = match(ID);
				setState(180);
				((Declaration_listContext)_localctx).LTHIRD = match(LTHIRD);
				setState(181);
				((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
				setState(182);
				((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

							writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : ID LTHIRD CONST_INT RTHIRD\n");
							writeIntoparserLogFile(((Declaration_listContext)_localctx).ID->getText() + ((Declaration_listContext)_localctx).LTHIRD->getText() + ((Declaration_listContext)_localctx).CONST_INT->getText() + ((Declaration_listContext)_localctx).RTHIRD->getText() + "\n");
							_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), true});
							_localctx.arrsize.push_back(std::stoi(((Declaration_listContext)_localctx).CONST_INT->getText()));
						
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new Declaration_listContext(_parentctx, _parentState);
						_localctx.decl = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_declaration_list);
						setState(186);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(187);
						((Declaration_listContext)_localctx).COMMA = match(COMMA);
						setState(188);
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
						setState(190);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(191);
						((Declaration_listContext)_localctx).COMMA = match(COMMA);
						setState(192);
						((Declaration_listContext)_localctx).ID = match(ID);
						setState(193);
						((Declaration_listContext)_localctx).LTHIRD = match(LTHIRD);
						setState(194);
						((Declaration_listContext)_localctx).CONST_INT = match(CONST_INT);
						setState(195);
						((Declaration_listContext)_localctx).RTHIRD = match(RTHIRD);

						          			writeIntoparserLogFile("Line " + std::to_string(((Declaration_listContext)_localctx).ID->getLine()) + ":" + " declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD\n");
						          			writeIntoparserLogFile((((Declaration_listContext)_localctx).decl!=null?_input.getText(((Declaration_listContext)_localctx).decl.start,((Declaration_listContext)_localctx).decl.stop):null) + ((Declaration_listContext)_localctx).COMMA->getText() + ((Declaration_listContext)_localctx).ID->getText() + ((Declaration_listContext)_localctx).LTHIRD->getText() + ((Declaration_listContext)_localctx).CONST_INT->getText() + ((Declaration_listContext)_localctx).RTHIRD->getText() + "\n");
						          			((Declaration_listContext)_localctx).decls =  ((Declaration_listContext)_localctx).decl.decls;
						          			_localctx.decls.push_back({((Declaration_listContext)_localctx).ID->getText(), true});
						          			((Declaration_listContext)_localctx).arrsize =  ((Declaration_listContext)_localctx).decl.arrsize;
						          			_localctx.arrsize.push_back(std::stoi(((Declaration_listContext)_localctx).CONST_INT->getText()));
						          		
						}
						break;
					}
					} 
				}
				setState(201);
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
			setState(203);
			((StatementsContext)_localctx).stmt = statement();

				writeIntoparserLogFile("Line " + std::to_string((((StatementsContext)_localctx).stmt!=null?(((StatementsContext)_localctx).stmt.stop):null)->getLine()) + ":" + " statements : statement\n");
				writeIntoparserLogFile((((StatementsContext)_localctx).stmt!=null?_input.getText(((StatementsContext)_localctx).stmt.start,((StatementsContext)_localctx).stmt.stop):null) + "\n");

			}
			_ctx.stop = _input.LT(-1);
			setState(212);
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
					setState(206);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(207);
					((StatementsContext)_localctx).stmt = statement();

					          	writeIntoparserLogFile("Line " + std::to_string((((StatementsContext)_localctx).stmt!=null?(((StatementsContext)_localctx).stmt.stop):null)->getLine()) + ":" + " statements : statements statement\n");
					          	writeIntoparserLogFile((((StatementsContext)_localctx).stmts!=null?_input.getText(((StatementsContext)_localctx).stmts.start,((StatementsContext)_localctx).stmts.stop):null) + (((StatementsContext)_localctx).stmt!=null?_input.getText(((StatementsContext)_localctx).stmt.start,((StatementsContext)_localctx).stmt.stop):null) +"\n");
					          	   
					}
					} 
				}
				setState(214);
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
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				((StatementContext)_localctx).var_dec = var_declaration();

					writeIntoparserLogFile("Line " + std::to_string((((StatementContext)_localctx).var_dec!=null?(((StatementContext)_localctx).var_dec.stop):null)->getLine()) + ":" + " statement :  var_declaration\n");
					writeIntoparserLogFile((((StatementContext)_localctx).var_dec!=null?_input.getText(((StatementContext)_localctx).var_dec.start,((StatementContext)_localctx).var_dec.stop):null) + "\n");

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				((StatementContext)_localctx).expr_stmt = expression_statement();

					writeIntoparserLogFile("Line " + std::to_string((((StatementContext)_localctx).expr_stmt!=null?(((StatementContext)_localctx).expr_stmt.stop):null)->getLine()) + ":" + " statement : expression_statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).expr_stmt!=null?_input.getText(((StatementContext)_localctx).expr_stmt.start,((StatementContext)_localctx).expr_stmt.stop):null) +"\n");
					  
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				((StatementContext)_localctx).cm_stmt = compound_statement(false);

					writeIntoparserLogFile("Line " + std::to_string((((StatementContext)_localctx).cm_stmt!=null?(((StatementContext)_localctx).cm_stmt.stop):null)->getLine()) + ":" + " statement : compound_statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).cm_stmt!=null?_input.getText(((StatementContext)_localctx).cm_stmt.start,((StatementContext)_localctx).cm_stmt.stop):null) +"\n");
					  
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				((StatementContext)_localctx).fr = match(FOR);
				setState(225);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(226);
				((StatementContext)_localctx).expr_stmt1 = expression_statement();
				setState(227);
				((StatementContext)_localctx).expr_stmt2 = expression_statement();
				setState(228);
				((StatementContext)_localctx).expr = expression();
				setState(229);
				((StatementContext)_localctx).rp = match(RPAREN);
				setState(230);
				((StatementContext)_localctx).stmt = statement();

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).fr->getLine()) + ":" + " statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).fr!=null?((StatementContext)_localctx).fr.getText():null) + (((StatementContext)_localctx).lp!=null?((StatementContext)_localctx).lp.getText():null) + (((StatementContext)_localctx).expr_stmt1!=null?_input.getText(((StatementContext)_localctx).expr_stmt1.start,((StatementContext)_localctx).expr_stmt1.stop):null) + (((StatementContext)_localctx).expr_stmt2!=null?_input.getText(((StatementContext)_localctx).expr_stmt2.start,((StatementContext)_localctx).expr_stmt2.stop):null) + (((StatementContext)_localctx).expr!=null?_input.getText(((StatementContext)_localctx).expr.start,((StatementContext)_localctx).expr.stop):null) + (((StatementContext)_localctx).rp!=null?((StatementContext)_localctx).rp.getText():null) + (((StatementContext)_localctx).stmt!=null?_input.getText(((StatementContext)_localctx).stmt.start,((StatementContext)_localctx).stmt.stop):null) +"\n");
					  
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				((StatementContext)_localctx).iff = match(IF);
				setState(234);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(235);
				((StatementContext)_localctx).expr = expression();
				setState(236);
				((StatementContext)_localctx).rp = match(RPAREN);
				setState(237);
				((StatementContext)_localctx).stmt = statement();

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).iff->getLine()) + ":" + " statement : IF LPAREN expression RPAREN statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).iff!=null?((StatementContext)_localctx).iff.getText():null) + (((StatementContext)_localctx).lp!=null?((StatementContext)_localctx).lp.getText():null) + (((StatementContext)_localctx).expr!=null?_input.getText(((StatementContext)_localctx).expr.start,((StatementContext)_localctx).expr.stop):null) + (((StatementContext)_localctx).rp!=null?((StatementContext)_localctx).rp.getText():null) + (((StatementContext)_localctx).stmt!=null?_input.getText(((StatementContext)_localctx).stmt.start,((StatementContext)_localctx).stmt.stop):null) + "\n");
					  
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(240);
				((StatementContext)_localctx).iff = match(IF);
				setState(241);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(242);
				((StatementContext)_localctx).expr = expression();
				setState(243);
				((StatementContext)_localctx).rp = match(RPAREN);
				setState(244);
				((StatementContext)_localctx).stmt1 = statement();
				setState(245);
				((StatementContext)_localctx).els = match(ELSE);
				setState(246);
				((StatementContext)_localctx).stmt2 = statement();

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).iff->getLine()) + ":" + " statement : IF LPAREN expression RPAREN statement ELSE statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).iff!=null?((StatementContext)_localctx).iff.getText():null) + (((StatementContext)_localctx).lp!=null?((StatementContext)_localctx).lp.getText():null) + (((StatementContext)_localctx).expr!=null?_input.getText(((StatementContext)_localctx).expr.start,((StatementContext)_localctx).expr.stop):null) + (((StatementContext)_localctx).rp!=null?((StatementContext)_localctx).rp.getText():null) + (((StatementContext)_localctx).stmt1!=null?_input.getText(((StatementContext)_localctx).stmt1.start,((StatementContext)_localctx).stmt1.stop):null) + (((StatementContext)_localctx).els!=null?((StatementContext)_localctx).els.getText():null) + (((StatementContext)_localctx).stmt2!=null?_input.getText(((StatementContext)_localctx).stmt2.start,((StatementContext)_localctx).stmt2.stop):null) + "\n");
					  
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(249);
				((StatementContext)_localctx).whl = match(WHILE);
				setState(250);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(251);
				((StatementContext)_localctx).expr = expression();
				setState(252);
				((StatementContext)_localctx).rp = match(RPAREN);
				setState(253);
				((StatementContext)_localctx).stmt = statement();

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).whl->getLine()) + ":" + " statement : WHILE LPAREN expression RPAREN statement\n");
					writeIntoparserLogFile((((StatementContext)_localctx).whl!=null?((StatementContext)_localctx).whl.getText():null) + (((StatementContext)_localctx).lp!=null?((StatementContext)_localctx).lp.getText():null) + (((StatementContext)_localctx).expr!=null?_input.getText(((StatementContext)_localctx).expr.start,((StatementContext)_localctx).expr.stop):null) + (((StatementContext)_localctx).rp!=null?((StatementContext)_localctx).rp.getText():null) + (((StatementContext)_localctx).stmt!=null?_input.getText(((StatementContext)_localctx).stmt.start,((StatementContext)_localctx).stmt.stop):null) + "\n");
					  
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(256);
				((StatementContext)_localctx).prln = match(PRINTLN);
				setState(257);
				((StatementContext)_localctx).lp = match(LPAREN);
				setState(258);
				((StatementContext)_localctx).id = match(ID);
				setState(259);
				((StatementContext)_localctx).rp = match(RPAREN);
				setState(260);
				((StatementContext)_localctx).sm = match(SEMICOLON);

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).prln->getLine()) + ":" + " statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n");
					writeIntoparserLogFile((((StatementContext)_localctx).prln!=null?((StatementContext)_localctx).prln.getText():null) + (((StatementContext)_localctx).lp!=null?((StatementContext)_localctx).lp.getText():null) + (((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null) + (((StatementContext)_localctx).rp!=null?((StatementContext)_localctx).rp.getText():null) + (((StatementContext)_localctx).sm!=null?((StatementContext)_localctx).sm.getText():null) + "\n");
					existing = symbolTable->LookUp((((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null));
					if(!existing) {
						writeIntoErrorFile("Error at line " + std::to_string(((StatementContext)_localctx).id->getLine()) + ":" + " Undeclared variable " + (((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null) + "\n");
						syntaxErrorCount++;
					} else {
						if(existing->additionalInfo.isArray) {
							writeIntoErrorFile("Error at line " + std::to_string(((StatementContext)_localctx).id->getLine()) + ":" + (((StatementContext)_localctx).id!=null?((StatementContext)_localctx).id.getText():null) + " is an array" + "\n");
							syntaxErrorCount++;
						}
						if(existing->additionalInfo.dataType != "int" && existing->additionalInfo.dataType != "float") {
							writeIntoErrorFile("Error at line " + std::to_string(((StatementContext)_localctx).id->getLine()) + ": Variable type not int or float in printf\n");
							syntaxErrorCount++;
						}
					}
					  
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(262);
				((StatementContext)_localctx).rtn = match(RETURN);
				setState(263);
				((StatementContext)_localctx).expr = expression();
				setState(264);
				((StatementContext)_localctx).sm = match(SEMICOLON);

					writeIntoparserLogFile("Line " + std::to_string(((StatementContext)_localctx).rtn->getLine()) + ":" + " statement : RETURN expression SEMICOLON\n");
					writeIntoparserLogFile((((StatementContext)_localctx).rtn!=null?((StatementContext)_localctx).rtn.getText():null) + " " + (((StatementContext)_localctx).expr!=null?_input.getText(((StatementContext)_localctx).expr.start,((StatementContext)_localctx).expr.stop):null) + (((StatementContext)_localctx).sm!=null?((StatementContext)_localctx).sm.getText():null) + "\n");
					  
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
			setState(275);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
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
				setState(271);
				((Expression_statementContext)_localctx).expr = expression();
				setState(272);
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
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				((VariableContext)_localctx).ID = match(ID);

					writeIntoparserLogFile("Line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ":" + " variable : ID\n");
					writeIntoparserLogFile(((VariableContext)_localctx).ID->getText() + "\n");
					existing = symbolTable->LookUp(((VariableContext)_localctx).ID->getText());
					if(existing) {
						((VariableContext)_localctx).datatype =  existing->additionalInfo.dataType;
						if(existing->additionalInfo.isArray) {
							writeIntoErrorFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ": Type mismatch," + ((VariableContext)_localctx).ID->getText() + " is an array" + "\n");
							syntaxErrorCount++;
						}
					}
					else {
						writeIntoErrorFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ":" + " Undeclared variable " + ((VariableContext)_localctx).ID->getText() + "\n");
						syntaxErrorCount++;
						((VariableContext)_localctx).datatype =  "error";
					}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				((VariableContext)_localctx).ID = match(ID);
				setState(280);
				((VariableContext)_localctx).LTHIRD = match(LTHIRD);
				setState(281);
				((VariableContext)_localctx).expr = expression();
				setState(282);
				((VariableContext)_localctx).RTHIRD = match(RTHIRD);

					writeIntoparserLogFile("Line " + std::to_string(((VariableContext)_localctx).LTHIRD->getLine()) + ":" + " variable : ID LTHIRD expression RTHIRD\n");
					writeIntoparserLogFile(((VariableContext)_localctx).ID->getText() + ((VariableContext)_localctx).LTHIRD->getText() + (((VariableContext)_localctx).expr!=null?_input.getText(((VariableContext)_localctx).expr.start,((VariableContext)_localctx).expr.stop):null) + ((VariableContext)_localctx).RTHIRD->getText() + "\n");
					existing = symbolTable->LookUp(((VariableContext)_localctx).ID->getText());
					if(existing) {
						((VariableContext)_localctx).datatype =  existing->additionalInfo.dataType;
						if(!existing->additionalInfo.isArray){
							writeIntoErrorFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ": " + ((VariableContext)_localctx).ID->getText() + " not an array" + "\n");
							syntaxErrorCount++;
						}
					}
					else{
						writeIntoErrorFile("Error at line " + std::to_string(((VariableContext)_localctx).ID->getLine()) + ":" + " Undeclared variable " + ((VariableContext)_localctx).ID->getText() + "\n");
						syntaxErrorCount++;
						((VariableContext)_localctx).datatype =  "error";
					}
					if(((VariableContext)_localctx).expr.datatype != "int") {
						writeIntoErrorFile("Error at line " + std::to_string((((VariableContext)_localctx).expr!=null?(((VariableContext)_localctx).expr.start):null)->getLine()) + ": Expression inside third brackets not an integer" + "\n");
						syntaxErrorCount++;
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
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				((ExpressionContext)_localctx).lgexpr = logic_expression();

					writeIntoparserLogFile("Line " + std::to_string((((ExpressionContext)_localctx).lgexpr!=null?(((ExpressionContext)_localctx).lgexpr.start):null)->getLine()) + ":" + " expression : logic_expression\n");
					writeIntoparserLogFile((((ExpressionContext)_localctx).lgexpr!=null?_input.getText(((ExpressionContext)_localctx).lgexpr.start,((ExpressionContext)_localctx).lgexpr.stop):null) + "\n");
					((ExpressionContext)_localctx).datatype =  ((ExpressionContext)_localctx).lgexpr.datatype;
				 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				((ExpressionContext)_localctx).var = variable();
				setState(291);
				((ExpressionContext)_localctx).ASSIGNOP = match(ASSIGNOP);
				setState(292);
				((ExpressionContext)_localctx).lgexpr = logic_expression();

					writeIntoparserLogFile("Line " + std::to_string(((ExpressionContext)_localctx).ASSIGNOP->getLine()) + ":" + " expression : variable ASSIGNOP logic_expression\n");
					writeIntoparserLogFile((((ExpressionContext)_localctx).var!=null?_input.getText(((ExpressionContext)_localctx).var.start,((ExpressionContext)_localctx).var.stop):null) + ((ExpressionContext)_localctx).ASSIGNOP->getText() + (((ExpressionContext)_localctx).lgexpr!=null?_input.getText(((ExpressionContext)_localctx).lgexpr.start,((ExpressionContext)_localctx).lgexpr.stop):null) + "\n");
					((ExpressionContext)_localctx).datatype =  ((ExpressionContext)_localctx).var.datatype;
					if((((ExpressionContext)_localctx).var.datatype == "int") && (((ExpressionContext)_localctx).lgexpr.datatype == "float")) {
						writeIntoErrorFile("Error at line " + std::to_string((((ExpressionContext)_localctx).lgexpr!=null?(((ExpressionContext)_localctx).lgexpr.start):null)->getLine()) + ": Type mismatch" + "\n");
						syntaxErrorCount++;
					}
					if(((ExpressionContext)_localctx).lgexpr.datatype == "void") {
						writeIntoErrorFile("Error at line " + std::to_string((((ExpressionContext)_localctx).lgexpr!=null?(((ExpressionContext)_localctx).lgexpr.start):null)->getLine()) + ": Void function used in expression" + "\n");
						syntaxErrorCount++;
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
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				((Logic_expressionContext)_localctx).rlexpr = rel_expression();

					writeIntoparserLogFile("Line " + std::to_string((((Logic_expressionContext)_localctx).rlexpr!=null?(((Logic_expressionContext)_localctx).rlexpr.start):null)->getLine()) + ":" + " logic_expression :  el_expression\n");
					writeIntoparserLogFile((((Logic_expressionContext)_localctx).rlexpr!=null?_input.getText(((Logic_expressionContext)_localctx).rlexpr.start,((Logic_expressionContext)_localctx).rlexpr.stop):null) + "\n");
					((Logic_expressionContext)_localctx).datatype =  ((Logic_expressionContext)_localctx).rlexpr.datatype;

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				((Logic_expressionContext)_localctx).rlexpr1 = rel_expression();
				setState(301);
				((Logic_expressionContext)_localctx).LOGICOP = match(LOGICOP);
				setState(302);
				((Logic_expressionContext)_localctx).rlexpr2 = rel_expression();

					writeIntoparserLogFile("Line " + std::to_string(((Logic_expressionContext)_localctx).LOGICOP->getLine()) + ":" + " logic_expression : rel_expression LOGICOP rel_expression\n");
					writeIntoparserLogFile((((Logic_expressionContext)_localctx).rlexpr1!=null?_input.getText(((Logic_expressionContext)_localctx).rlexpr1.start,((Logic_expressionContext)_localctx).rlexpr1.stop):null) + ((Logic_expressionContext)_localctx).LOGICOP->getText() + (((Logic_expressionContext)_localctx).rlexpr2!=null?_input.getText(((Logic_expressionContext)_localctx).rlexpr2.start,((Logic_expressionContext)_localctx).rlexpr2.stop):null) + "\n");
					((Logic_expressionContext)_localctx).datatype =  ((Logic_expressionContext)_localctx).rlexpr1.datatype;
						 
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
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				((Rel_expressionContext)_localctx).smexpr = simple_expression(0);

					writeIntoparserLogFile("Line " + std::to_string((((Rel_expressionContext)_localctx).smexpr!=null?(((Rel_expressionContext)_localctx).smexpr.start):null)->getLine()) + ":" + " rel_expression : simple_expression\n");
					writeIntoparserLogFile((((Rel_expressionContext)_localctx).smexpr!=null?_input.getText(((Rel_expressionContext)_localctx).smexpr.start,((Rel_expressionContext)_localctx).smexpr.stop):null) + "\n");
					((Rel_expressionContext)_localctx).datatype =  ((Rel_expressionContext)_localctx).smexpr.datatype;

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310);
				((Rel_expressionContext)_localctx).smexpr1 = simple_expression(0);
				setState(311);
				((Rel_expressionContext)_localctx).RELOP = match(RELOP);
				setState(312);
				((Rel_expressionContext)_localctx).smexpr2 = simple_expression(0);

					writeIntoparserLogFile("Line " + std::to_string(((Rel_expressionContext)_localctx).RELOP->getLine()) + ":" + " rel_expression : simple_expression RELOP simple_expression\n");
					writeIntoparserLogFile((((Rel_expressionContext)_localctx).smexpr1!=null?_input.getText(((Rel_expressionContext)_localctx).smexpr1.start,((Rel_expressionContext)_localctx).smexpr1.stop):null) + ((Rel_expressionContext)_localctx).RELOP->getText() + (((Rel_expressionContext)_localctx).smexpr2!=null?_input.getText(((Rel_expressionContext)_localctx).smexpr2.start,((Rel_expressionContext)_localctx).smexpr2.stop):null) + "\n");
					((Rel_expressionContext)_localctx).datatype =  ((Rel_expressionContext)_localctx).smexpr1.datatype;
						
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
			setState(318);
			((Simple_expressionContext)_localctx).trm = term(0);

				writeIntoparserLogFile("Line " + std::to_string((((Simple_expressionContext)_localctx).trm!=null?(((Simple_expressionContext)_localctx).trm.start):null)->getLine()) + ":" + " simple_expression : term\n");
				writeIntoparserLogFile((((Simple_expressionContext)_localctx).trm!=null?_input.getText(((Simple_expressionContext)_localctx).trm.start,((Simple_expressionContext)_localctx).trm.stop):null) + "\n");
				((Simple_expressionContext)_localctx).datatype =  ((Simple_expressionContext)_localctx).trm.datatype;

			}
			_ctx.stop = _input.LT(-1);
			setState(328);
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
					setState(321);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(322);
					((Simple_expressionContext)_localctx).ADDOP = match(ADDOP);
					setState(323);
					((Simple_expressionContext)_localctx).trm = term(0);

					          	writeIntoparserLogFile("Line " + std::to_string(((Simple_expressionContext)_localctx).ADDOP->getLine()) + ":" + " simple_expression : simple_expression ADDOP term\n");
					          	writeIntoparserLogFile((((Simple_expressionContext)_localctx).smexpr!=null?_input.getText(((Simple_expressionContext)_localctx).smexpr.start,((Simple_expressionContext)_localctx).smexpr.stop):null) + ((Simple_expressionContext)_localctx).ADDOP->getText() + (((Simple_expressionContext)_localctx).trm!=null?_input.getText(((Simple_expressionContext)_localctx).trm.start,((Simple_expressionContext)_localctx).trm.stop):null) + "\n");
					          	if(((Simple_expressionContext)_localctx).smexpr.datatype == "float" || ((Simple_expressionContext)_localctx).trm.datatype == "float") {
					          		((Simple_expressionContext)_localctx).datatype =  "float";
					          	}
					          	else{
					          		((Simple_expressionContext)_localctx).datatype =  "int";
					          	}
					          		  
					}
					} 
				}
				setState(330);
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
			setState(332);
			((TermContext)_localctx).unexpr = unary_expression();

				writeIntoparserLogFile("Line " + std::to_string((((TermContext)_localctx).unexpr!=null?(((TermContext)_localctx).unexpr.start):null)->getLine()) + ":" + " term : unary_expression\n");
				writeIntoparserLogFile((((TermContext)_localctx).unexpr!=null?_input.getText(((TermContext)_localctx).unexpr.start,((TermContext)_localctx).unexpr.stop):null) + "\n");
				((TermContext)_localctx).datatype =  ((TermContext)_localctx).unexpr.datatype;

			}
			_ctx.stop = _input.LT(-1);
			setState(342);
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
					setState(335);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(336);
					((TermContext)_localctx).MULOP = match(MULOP);
					setState(337);
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
					          	if(((TermContext)_localctx).MULOP->getText() == "%" && (((TermContext)_localctx).unexpr.datatype == "float" || ((TermContext)_localctx).trm.datatype == "float")) {
					          		writeIntoErrorFile("Error at line " + std::to_string(((TermContext)_localctx).MULOP->getLine()) + ": Non-Integer operand on modulus operator" + "\n");
					          		syntaxErrorCount++;
					          	}
					          	if(((TermContext)_localctx).MULOP->getText() == "%" && (((TermContext)_localctx).unexpr!=null?_input.getText(((TermContext)_localctx).unexpr.start,((TermContext)_localctx).unexpr.stop):null) == "0"){
					          		writeIntoErrorFile("Error at line " + std::to_string(((TermContext)_localctx).MULOP->getLine()) + ": Modulus by Zero" + "\n");
					          		syntaxErrorCount++;
					          	}
					          	if(((TermContext)_localctx).MULOP->getText() == "/" && (((TermContext)_localctx).unexpr!=null?_input.getText(((TermContext)_localctx).unexpr.start,((TermContext)_localctx).unexpr.stop):null) == "0"){
					          		writeIntoErrorFile("Error at line " + std::to_string(((TermContext)_localctx).MULOP->getLine()) + ": Division by Zero" + "\n");
					          		syntaxErrorCount++;
					          	}
					          	if(((TermContext)_localctx).trm.datatype == "void" || ((TermContext)_localctx).unexpr.datatype == "void") {
					          		writeIntoErrorFile("Error at line " + std::to_string(((TermContext)_localctx).MULOP->getLine()) + ": Void function used in expression" + "\n");
					          		syntaxErrorCount++;
					          	}
					          	 
					}
					} 
				}
				setState(344);
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
			setState(356);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADDOP:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				((Unary_expressionContext)_localctx).ADDOP = match(ADDOP);
				setState(346);
				((Unary_expressionContext)_localctx).unexpr = unary_expression();

						writeIntoparserLogFile("Line " + std::to_string(((Unary_expressionContext)_localctx).ADDOP->getLine()) + ":" + " unary_expression : ADDOP unary_expression\n");
						writeIntoparserLogFile(((Unary_expressionContext)_localctx).ADDOP->getText() + (((Unary_expressionContext)_localctx).unexpr!=null?_input.getText(((Unary_expressionContext)_localctx).unexpr.start,((Unary_expressionContext)_localctx).unexpr.stop):null) + "\n");
						((Unary_expressionContext)_localctx).datatype =  ((Unary_expressionContext)_localctx).unexpr.datatype;

				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				((Unary_expressionContext)_localctx).NOT = match(NOT);
				setState(350);
				((Unary_expressionContext)_localctx).unexpr = unary_expression();

						writeIntoparserLogFile("Line " + std::to_string(((Unary_expressionContext)_localctx).NOT->getLine()) + ":" + " unary_expression : NOT unary_expression\n");
						writeIntoparserLogFile(((Unary_expressionContext)_localctx).NOT->getText() + (((Unary_expressionContext)_localctx).unexpr!=null?_input.getText(((Unary_expressionContext)_localctx).unexpr.start,((Unary_expressionContext)_localctx).unexpr.stop):null) + "\n");
						((Unary_expressionContext)_localctx).datatype =  "int";
						
				}
				break;
			case LPAREN:
			case ID:
			case CONST_INT:
			case CONST_FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
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
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				((FactorContext)_localctx).var = variable();

						writeIntoparserLogFile("Line " + std::to_string((((FactorContext)_localctx).var!=null?(((FactorContext)_localctx).var.start):null)->getLine()) + ":" + " factor : variable\n");
						writeIntoparserLogFile((((FactorContext)_localctx).var!=null?_input.getText(((FactorContext)_localctx).var.start,((FactorContext)_localctx).var.stop):null) + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).var.datatype;
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				((FactorContext)_localctx).id = match(ID);
				setState(362);
				((FactorContext)_localctx).lp = match(LPAREN);
				setState(363);
				((FactorContext)_localctx).argl = argument_list();
				setState(364);
				((FactorContext)_localctx).rp = match(RPAREN);

						writeIntoparserLogFile("Line " + std::to_string((((FactorContext)_localctx).argl!=null?(((FactorContext)_localctx).argl.start):null)->getLine()) + ":" + " factor : ID LPAREN argument_list RPAREN\n");
						writeIntoparserLogFile((((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + (((FactorContext)_localctx).lp!=null?((FactorContext)_localctx).lp.getText():null) + (((FactorContext)_localctx).argl!=null?_input.getText(((FactorContext)_localctx).argl.start,((FactorContext)_localctx).argl.stop):null) + (((FactorContext)_localctx).rp!=null?((FactorContext)_localctx).rp.getText():null) + "\n");
						existing = symbolTable->LookUp((((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null));
						if(existing && existing->additionalInfo.isDefined && existing->additionalInfo.isFunction){
							((FactorContext)_localctx).datatype =  existing->additionalInfo.returnType;
							if(((FactorContext)_localctx).argl.argtypes != existing->additionalInfo.parameters){
							if(existing->additionalInfo.parameters.size() != ((FactorContext)_localctx).argl.argtypes.size()){
								writeIntoErrorFile("Error at line " + std::to_string(((FactorContext)_localctx).id->getLine()) + ":" + " Total number of argument mismatch in function " + (((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + "\n");
								syntaxErrorCount++;
							}
							else{
								for(int i = 0; i < ((FactorContext)_localctx).argl.argtypes.size(); i++){
									if(((FactorContext)_localctx).argl.argtypes[i] != existing->additionalInfo.parameters[i]){
										writeIntoErrorFile("Error at line " + std::to_string(((FactorContext)_localctx).id->getLine()) + ": " + std::to_string(i+1) + "th argument mismatch in function " + (((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + "\n");
										syntaxErrorCount++;
										break;
									}
								}
							}
						}
						}
						else{
							writeIntoErrorFile("Error at line " + std::to_string(((FactorContext)_localctx).id->getLine()) + ":" + " Undeclared function " + (((FactorContext)_localctx).id!=null?((FactorContext)_localctx).id.getText():null) + "\n");
							syntaxErrorCount++;
							((FactorContext)_localctx).datatype =  "error";
						}
					
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				((FactorContext)_localctx).lp = match(LPAREN);
				setState(368);
				((FactorContext)_localctx).expr = expression();
				setState(369);
				((FactorContext)_localctx).rp = match(RPAREN);

						writeIntoparserLogFile("Line " + std::to_string((((FactorContext)_localctx).expr!=null?(((FactorContext)_localctx).expr.start):null)->getLine()) + ":" + " factor : LPAREN expression RPAREN\n");
						writeIntoparserLogFile((((FactorContext)_localctx).lp!=null?((FactorContext)_localctx).lp.getText():null) + (((FactorContext)_localctx).expr!=null?_input.getText(((FactorContext)_localctx).expr.start,((FactorContext)_localctx).expr.stop):null) + (((FactorContext)_localctx).rp!=null?((FactorContext)_localctx).rp.getText():null) + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).expr.datatype;
					
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(372);
				((FactorContext)_localctx).CONST_INT = match(CONST_INT);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).CONST_INT->getLine()) + ":" + " factor : CONST_INT\n");
						writeIntoparserLogFile(((FactorContext)_localctx).CONST_INT->getText() + "\n");
						((FactorContext)_localctx).datatype =  "int";
					
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(374);
				((FactorContext)_localctx).CONST_FLOAT = match(CONST_FLOAT);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).CONST_FLOAT->getLine()) + ":" + " factor : CONST_FLOAT\n");
						writeIntoparserLogFile(((FactorContext)_localctx).CONST_FLOAT->getText() + "\n");
						((FactorContext)_localctx).datatype =  "float";
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(376);
				((FactorContext)_localctx).var = variable();
				setState(377);
				((FactorContext)_localctx).INCOP = match(INCOP);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).INCOP->getLine()) + ":" + " factor : variable INCOP\n");
						writeIntoparserLogFile(((FactorContext)_localctx).INCOP->getText() + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).var.datatype;
					
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(380);
				((FactorContext)_localctx).var = variable();
				setState(381);
				((FactorContext)_localctx).DECOP = match(DECOP);

						writeIntoparserLogFile("Line " + std::to_string(((FactorContext)_localctx).DECOP->getLine()) + ":" + " factor : variable DECOP\n");
						writeIntoparserLogFile(((FactorContext)_localctx).DECOP->getText() + "\n");
						((FactorContext)_localctx).datatype =  ((FactorContext)_localctx).var.datatype;
					
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
			setState(390);
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
				setState(386);
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
			setState(393);
			((ArgumentsContext)_localctx).le = logic_expression();

						writeIntoparserLogFile("Line " + std::to_string((((ArgumentsContext)_localctx).le!=null?(((ArgumentsContext)_localctx).le.start):null)->getLine()) + ":" + " arguments : logic_expression\n");
						writeIntoparserLogFile((((ArgumentsContext)_localctx).le!=null?_input.getText(((ArgumentsContext)_localctx).le.start,((ArgumentsContext)_localctx).le.stop):null) + "\n");
						_localctx.argtypes.push_back(((ArgumentsContext)_localctx).le.datatype);
					  
			}
			_ctx.stop = _input.LT(-1);
			setState(403);
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
					setState(396);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(397);
					((ArgumentsContext)_localctx).cm = match(COMMA);
					setState(398);
					((ArgumentsContext)_localctx).le = logic_expression();

					          			writeIntoparserLogFile("Line " + std::to_string((((ArgumentsContext)_localctx).le!=null?(((ArgumentsContext)_localctx).le.start):null)->getLine()) + ":" + " arguments : arguments COMMA logic_expression\n");
					          			writeIntoparserLogFile((((ArgumentsContext)_localctx).args!=null?_input.getText(((ArgumentsContext)_localctx).args.start,((ArgumentsContext)_localctx).args.stop):null) + (((ArgumentsContext)_localctx).cm!=null?((ArgumentsContext)_localctx).cm.getText():null) + (((ArgumentsContext)_localctx).le!=null?_input.getText(((ArgumentsContext)_localctx).le.start,((ArgumentsContext)_localctx).le.stop):null) + "\n");
					          			((ArgumentsContext)_localctx).argtypes =  ((ArgumentsContext)_localctx).args.argtypes;
					          			_localctx.argtypes.push_back(((ArgumentsContext)_localctx).le.datatype);
					                    
					}
					} 
				}
				setState(405);
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
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean declaration_list_sempred(Declaration_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean statements_sempred(StatementsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean simple_expression_sempred(Simple_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean arguments_sempred(ArgumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u0197\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001<\b\u0001\n\u0001\f\u0001"+
		"?\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002J\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"]\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004s\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005}\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u008a\b\u0005\n\u0005\f\u0005\u008d"+
		"\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0099"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a5"+
		"\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u00af\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00b9\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00c6\b\n\n\n\f\n\u00c9"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d3\b\u000b\n\u000b\f\u000b"+
		"\u00d6\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u010c\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u0114\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u011e\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u0128\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u0132\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u013c\b\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0147\b\u0012\n\u0012\f\u0012\u014a"+
		"\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u0155\b\u0013\n"+
		"\u0013\f\u0013\u0158\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u0165\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0181\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0187\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u0192"+
		"\b\u0017\n\u0017\f\u0017\u0195\t\u0017\u0001\u0017\u0000\u0007\u0002\n"+
		"\u0014\u0016$&.\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0000\u01a7\u0000"+
		"0\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u0004I\u0001"+
		"\u0000\u0000\u0000\u0006\\\u0001\u0000\u0000\u0000\br\u0001\u0000\u0000"+
		"\u0000\n|\u0001\u0000\u0000\u0000\f\u0098\u0001\u0000\u0000\u0000\u000e"+
		"\u00a4\u0001\u0000\u0000\u0000\u0010\u00a6\u0001\u0000\u0000\u0000\u0012"+
		"\u00ae\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000\u0000\u0016"+
		"\u00ca\u0001\u0000\u0000\u0000\u0018\u010b\u0001\u0000\u0000\u0000\u001a"+
		"\u0113\u0001\u0000\u0000\u0000\u001c\u011d\u0001\u0000\u0000\u0000\u001e"+
		"\u0127\u0001\u0000\u0000\u0000 \u0131\u0001\u0000\u0000\u0000\"\u013b"+
		"\u0001\u0000\u0000\u0000$\u013d\u0001\u0000\u0000\u0000&\u014b\u0001\u0000"+
		"\u0000\u0000(\u0164\u0001\u0000\u0000\u0000*\u0180\u0001\u0000\u0000\u0000"+
		",\u0186\u0001\u0000\u0000\u0000.\u0188\u0001\u0000\u0000\u000001\u0003"+
		"\u0002\u0001\u000012\u0006\u0000\uffff\uffff\u00002\u0001\u0001\u0000"+
		"\u0000\u000034\u0006\u0001\uffff\uffff\u000045\u0003\u0004\u0002\u0000"+
		"56\u0006\u0001\uffff\uffff\u00006=\u0001\u0000\u0000\u000078\n\u0002\u0000"+
		"\u000089\u0003\u0004\u0002\u00009:\u0006\u0001\uffff\uffff\u0000:<\u0001"+
		"\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u0003\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0003\u000e\u0007\u0000AB\u0006"+
		"\u0002\uffff\uffff\u0000BJ\u0001\u0000\u0000\u0000CD\u0003\u0006\u0003"+
		"\u0000DE\u0006\u0002\uffff\uffff\u0000EJ\u0001\u0000\u0000\u0000FG\u0003"+
		"\b\u0004\u0000GH\u0006\u0002\uffff\uffff\u0000HJ\u0001\u0000\u0000\u0000"+
		"I@\u0001\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000IF\u0001\u0000\u0000"+
		"\u0000J\u0005\u0001\u0000\u0000\u0000KL\u0003\u0012\t\u0000LM\u0005\u001f"+
		"\u0000\u0000MN\u0006\u0003\uffff\uffff\u0000NO\u0005\u000e\u0000\u0000"+
		"OP\u0003\n\u0005\u0000PQ\u0005\u000f\u0000\u0000QR\u0005\u0014\u0000\u0000"+
		"RS\u0006\u0003\uffff\uffff\u0000S]\u0001\u0000\u0000\u0000TU\u0003\u0012"+
		"\t\u0000UV\u0005\u001f\u0000\u0000VW\u0006\u0003\uffff\uffff\u0000WX\u0005"+
		"\u000e\u0000\u0000XY\u0005\u000f\u0000\u0000YZ\u0005\u0014\u0000\u0000"+
		"Z[\u0006\u0003\uffff\uffff\u0000[]\u0001\u0000\u0000\u0000\\K\u0001\u0000"+
		"\u0000\u0000\\T\u0001\u0000\u0000\u0000]\u0007\u0001\u0000\u0000\u0000"+
		"^_\u0003\u0012\t\u0000_`\u0005\u001f\u0000\u0000`a\u0006\u0004\uffff\uffff"+
		"\u0000ab\u0005\u000e\u0000\u0000bc\u0006\u0004\uffff\uffff\u0000cd\u0003"+
		"\n\u0005\u0000de\u0006\u0004\uffff\uffff\u0000ef\u0005\u000f\u0000\u0000"+
		"fg\u0003\f\u0006\u0000gh\u0006\u0004\uffff\uffff\u0000hs\u0001\u0000\u0000"+
		"\u0000ij\u0003\u0012\t\u0000jk\u0005\u001f\u0000\u0000kl\u0006\u0004\uffff"+
		"\uffff\u0000lm\u0005\u000e\u0000\u0000mn\u0006\u0004\uffff\uffff\u0000"+
		"no\u0005\u000f\u0000\u0000op\u0003\f\u0006\u0000pq\u0006\u0004\uffff\uffff"+
		"\u0000qs\u0001\u0000\u0000\u0000r^\u0001\u0000\u0000\u0000ri\u0001\u0000"+
		"\u0000\u0000s\t\u0001\u0000\u0000\u0000tu\u0006\u0005\uffff\uffff\u0000"+
		"uv\u0003\u0012\t\u0000vw\u0005\u001f\u0000\u0000wx\u0006\u0005\uffff\uffff"+
		"\u0000x}\u0001\u0000\u0000\u0000yz\u0003\u0012\t\u0000z{\u0006\u0005\uffff"+
		"\uffff\u0000{}\u0001\u0000\u0000\u0000|t\u0001\u0000\u0000\u0000|y\u0001"+
		"\u0000\u0000\u0000}\u008b\u0001\u0000\u0000\u0000~\u007f\n\u0004\u0000"+
		"\u0000\u007f\u0080\u0005\u0015\u0000\u0000\u0080\u0081\u0003\u0012\t\u0000"+
		"\u0081\u0082\u0005\u001f\u0000\u0000\u0082\u0083\u0006\u0005\uffff\uffff"+
		"\u0000\u0083\u008a\u0001\u0000\u0000\u0000\u0084\u0085\n\u0003\u0000\u0000"+
		"\u0085\u0086\u0005\u0015\u0000\u0000\u0086\u0087\u0003\u0012\t\u0000\u0087"+
		"\u0088\u0006\u0005\uffff\uffff\u0000\u0088\u008a\u0001\u0000\u0000\u0000"+
		"\u0089~\u0001\u0000\u0000\u0000\u0089\u0084\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u000b\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005\u0010\u0000\u0000\u008f"+
		"\u0090\u0006\u0006\uffff\uffff\u0000\u0090\u0091\u0003\u0016\u000b\u0000"+
		"\u0091\u0092\u0005\u0011\u0000\u0000\u0092\u0093\u0006\u0006\uffff\uffff"+
		"\u0000\u0093\u0099\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0010\u0000"+
		"\u0000\u0095\u0096\u0006\u0006\uffff\uffff\u0000\u0096\u0097\u0005\u0011"+
		"\u0000\u0000\u0097\u0099\u0006\u0006\uffff\uffff\u0000\u0098\u008e\u0001"+
		"\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0099\r\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0003\u0012\t\u0000\u009b\u009c\u0003\u0014\n"+
		"\u0000\u009c\u009d\u0005\u0014\u0000\u0000\u009d\u009e\u0006\u0007\uffff"+
		"\uffff\u0000\u009e\u00a5\u0001\u0000\u0000\u0000\u009f\u00a0\u0003\u0012"+
		"\t\u0000\u00a0\u00a1\u0003\u0010\b\u0000\u00a1\u00a2\u0005\u0014\u0000"+
		"\u0000\u00a2\u00a3\u0006\u0007\uffff\uffff\u0000\u00a3\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a4\u009a\u0001\u0000\u0000\u0000\u00a4\u009f\u0001\u0000"+
		"\u0000\u0000\u00a5\u000f\u0001\u0000\u0000\u0000\u00a6\u00a7\u0006\b\uffff"+
		"\uffff\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u000b"+
		"\u0000\u0000\u00a9\u00af\u0006\t\uffff\uffff\u0000\u00aa\u00ab\u0005\f"+
		"\u0000\u0000\u00ab\u00af\u0006\t\uffff\uffff\u0000\u00ac\u00ad\u0005\r"+
		"\u0000\u0000\u00ad\u00af\u0006\t\uffff\uffff\u0000\u00ae\u00a8\u0001\u0000"+
		"\u0000\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00af\u0013\u0001\u0000\u0000\u0000\u00b0\u00b1\u0006\n\uffff"+
		"\uffff\u0000\u00b1\u00b2\u0005\u001f\u0000\u0000\u00b2\u00b9\u0006\n\uffff"+
		"\uffff\u0000\u00b3\u00b4\u0005\u001f\u0000\u0000\u00b4\u00b5\u0005\u0012"+
		"\u0000\u0000\u00b5\u00b6\u0005 \u0000\u0000\u00b6\u00b7\u0005\u0013\u0000"+
		"\u0000\u00b7\u00b9\u0006\n\uffff\uffff\u0000\u00b8\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b3\u0001\u0000\u0000\u0000\u00b9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\n\u0004\u0000\u0000\u00bb\u00bc\u0005\u0015\u0000\u0000"+
		"\u00bc\u00bd\u0005\u001f\u0000\u0000\u00bd\u00c6\u0006\n\uffff\uffff\u0000"+
		"\u00be\u00bf\n\u0003\u0000\u0000\u00bf\u00c0\u0005\u0015\u0000\u0000\u00c0"+
		"\u00c1\u0005\u001f\u0000\u0000\u00c1\u00c2\u0005\u0012\u0000\u0000\u00c2"+
		"\u00c3\u0005 \u0000\u0000\u00c3\u00c4\u0005\u0013\u0000\u0000\u00c4\u00c6"+
		"\u0006\n\uffff\uffff\u0000\u00c5\u00ba\u0001\u0000\u0000\u0000\u00c5\u00be"+
		"\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000\u0000\u00c7\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u0015"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0006\u000b\uffff\uffff\u0000\u00cb\u00cc\u0003\u0018\f\u0000\u00cc\u00cd"+
		"\u0006\u000b\uffff\uffff\u0000\u00cd\u00d4\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\n\u0001\u0000\u0000\u00cf\u00d0\u0003\u0018\f\u0000\u00d0\u00d1"+
		"\u0006\u000b\uffff\uffff\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u0017\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d8\u0003\u000e\u0007\u0000\u00d8\u00d9\u0006\f\uffff\uffff\u0000\u00d9"+
		"\u010c\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u001a\r\u0000\u00db\u00dc"+
		"\u0006\f\uffff\uffff\u0000\u00dc\u010c\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0003\f\u0006\u0000\u00de\u00df\u0006\f\uffff\uffff\u0000\u00df\u010c"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0007\u0000\u0000\u00e1\u00e2"+
		"\u0005\u000e\u0000\u0000\u00e2\u00e3\u0003\u001a\r\u0000\u00e3\u00e4\u0003"+
		"\u001a\r\u0000\u00e4\u00e5\u0003\u001e\u000f\u0000\u00e5\u00e6\u0005\u000f"+
		"\u0000\u0000\u00e6\u00e7\u0003\u0018\f\u0000\u00e7\u00e8\u0006\f\uffff"+
		"\uffff\u0000\u00e8\u010c\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0005"+
		"\u0000\u0000\u00ea\u00eb\u0005\u000e\u0000\u0000\u00eb\u00ec\u0003\u001e"+
		"\u000f\u0000\u00ec\u00ed\u0005\u000f\u0000\u0000\u00ed\u00ee\u0003\u0018"+
		"\f\u0000\u00ee\u00ef\u0006\f\uffff\uffff\u0000\u00ef\u010c\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0005\u0005\u0000\u0000\u00f1\u00f2\u0005\u000e"+
		"\u0000\u0000\u00f2\u00f3\u0003\u001e\u000f\u0000\u00f3\u00f4\u0005\u000f"+
		"\u0000\u0000\u00f4\u00f5\u0003\u0018\f\u0000\u00f5\u00f6\u0005\u0006\u0000"+
		"\u0000\u00f6\u00f7\u0003\u0018\f\u0000\u00f7\u00f8\u0006\f\uffff\uffff"+
		"\u0000\u00f8\u010c\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\b\u0000\u0000"+
		"\u00fa\u00fb\u0005\u000e\u0000\u0000\u00fb\u00fc\u0003\u001e\u000f\u0000"+
		"\u00fc\u00fd\u0005\u000f\u0000\u0000\u00fd\u00fe\u0003\u0018\f\u0000\u00fe"+
		"\u00ff\u0006\f\uffff\uffff\u0000\u00ff\u010c\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0005\t\u0000\u0000\u0101\u0102\u0005\u000e\u0000\u0000\u0102\u0103"+
		"\u0005\u001f\u0000\u0000\u0103\u0104\u0005\u000f\u0000\u0000\u0104\u0105"+
		"\u0005\u0014\u0000\u0000\u0105\u010c\u0006\f\uffff\uffff\u0000\u0106\u0107"+
		"\u0005\n\u0000\u0000\u0107\u0108\u0003\u001e\u000f\u0000\u0108\u0109\u0005"+
		"\u0014\u0000\u0000\u0109\u010a\u0006\f\uffff\uffff\u0000\u010a\u010c\u0001"+
		"\u0000\u0000\u0000\u010b\u00d7\u0001\u0000\u0000\u0000\u010b\u00da\u0001"+
		"\u0000\u0000\u0000\u010b\u00dd\u0001\u0000\u0000\u0000\u010b\u00e0\u0001"+
		"\u0000\u0000\u0000\u010b\u00e9\u0001\u0000\u0000\u0000\u010b\u00f0\u0001"+
		"\u0000\u0000\u0000\u010b\u00f9\u0001\u0000\u0000\u0000\u010b\u0100\u0001"+
		"\u0000\u0000\u0000\u010b\u0106\u0001\u0000\u0000\u0000\u010c\u0019\u0001"+
		"\u0000\u0000\u0000\u010d\u010e\u0005\u0014\u0000\u0000\u010e\u0114\u0006"+
		"\r\uffff\uffff\u0000\u010f\u0110\u0003\u001e\u000f\u0000\u0110\u0111\u0005"+
		"\u0014\u0000\u0000\u0111\u0112\u0006\r\uffff\uffff\u0000\u0112\u0114\u0001"+
		"\u0000\u0000\u0000\u0113\u010d\u0001\u0000\u0000\u0000\u0113\u010f\u0001"+
		"\u0000\u0000\u0000\u0114\u001b\u0001\u0000\u0000\u0000\u0115\u0116\u0005"+
		"\u001f\u0000\u0000\u0116\u011e\u0006\u000e\uffff\uffff\u0000\u0117\u0118"+
		"\u0005\u001f\u0000\u0000\u0118\u0119\u0005\u0012\u0000\u0000\u0119\u011a"+
		"\u0003\u001e\u000f\u0000\u011a\u011b\u0005\u0013\u0000\u0000\u011b\u011c"+
		"\u0006\u000e\uffff\uffff\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d"+
		"\u0115\u0001\u0000\u0000\u0000\u011d\u0117\u0001\u0000\u0000\u0000\u011e"+
		"\u001d\u0001\u0000\u0000\u0000\u011f\u0120\u0003 \u0010\u0000\u0120\u0121"+
		"\u0006\u000f\uffff\uffff\u0000\u0121\u0128\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0003\u001c\u000e\u0000\u0123\u0124\u0005\u001e\u0000\u0000\u0124"+
		"\u0125\u0003 \u0010\u0000\u0125\u0126\u0006\u000f\uffff\uffff\u0000\u0126"+
		"\u0128\u0001\u0000\u0000\u0000\u0127\u011f\u0001\u0000\u0000\u0000\u0127"+
		"\u0122\u0001\u0000\u0000\u0000\u0128\u001f\u0001\u0000\u0000\u0000\u0129"+
		"\u012a\u0003\"\u0011\u0000\u012a\u012b\u0006\u0010\uffff\uffff\u0000\u012b"+
		"\u0132\u0001\u0000\u0000\u0000\u012c\u012d\u0003\"\u0011\u0000\u012d\u012e"+
		"\u0005\u001d\u0000\u0000\u012e\u012f\u0003\"\u0011\u0000\u012f\u0130\u0006"+
		"\u0010\uffff\uffff\u0000\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u0129"+
		"\u0001\u0000\u0000\u0000\u0131\u012c\u0001\u0000\u0000\u0000\u0132!\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0003$\u0012\u0000\u0134\u0135\u0006\u0011"+
		"\uffff\uffff\u0000\u0135\u013c\u0001\u0000\u0000\u0000\u0136\u0137\u0003"+
		"$\u0012\u0000\u0137\u0138\u0005\u001c\u0000\u0000\u0138\u0139\u0003$\u0012"+
		"\u0000\u0139\u013a\u0006\u0011\uffff\uffff\u0000\u013a\u013c\u0001\u0000"+
		"\u0000\u0000\u013b\u0133\u0001\u0000\u0000\u0000\u013b\u0136\u0001\u0000"+
		"\u0000\u0000\u013c#\u0001\u0000\u0000\u0000\u013d\u013e\u0006\u0012\uffff"+
		"\uffff\u0000\u013e\u013f\u0003&\u0013\u0000\u013f\u0140\u0006\u0012\uffff"+
		"\uffff\u0000\u0140\u0148\u0001\u0000\u0000\u0000\u0141\u0142\n\u0001\u0000"+
		"\u0000\u0142\u0143\u0005\u0016\u0000\u0000\u0143\u0144\u0003&\u0013\u0000"+
		"\u0144\u0145\u0006\u0012\uffff\uffff\u0000\u0145\u0147\u0001\u0000\u0000"+
		"\u0000\u0146\u0141\u0001\u0000\u0000\u0000\u0147\u014a\u0001\u0000\u0000"+
		"\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000"+
		"\u0000\u0149%\u0001\u0000\u0000\u0000\u014a\u0148\u0001\u0000\u0000\u0000"+
		"\u014b\u014c\u0006\u0013\uffff\uffff\u0000\u014c\u014d\u0003(\u0014\u0000"+
		"\u014d\u014e\u0006\u0013\uffff\uffff\u0000\u014e\u0156\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\n\u0001\u0000\u0000\u0150\u0151\u0005\u0018\u0000\u0000"+
		"\u0151\u0152\u0003(\u0014\u0000\u0152\u0153\u0006\u0013\uffff\uffff\u0000"+
		"\u0153\u0155\u0001\u0000\u0000\u0000\u0154\u014f\u0001\u0000\u0000\u0000"+
		"\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0001\u0000\u0000\u0000\u0157\'\u0001\u0000\u0000\u0000\u0158"+
		"\u0156\u0001\u0000\u0000\u0000\u0159\u015a\u0005\u0016\u0000\u0000\u015a"+
		"\u015b\u0003(\u0014\u0000\u015b\u015c\u0006\u0014\uffff\uffff\u0000\u015c"+
		"\u0165\u0001\u0000\u0000\u0000\u015d\u015e\u0005\u001b\u0000\u0000\u015e"+
		"\u015f\u0003(\u0014\u0000\u015f\u0160\u0006\u0014\uffff\uffff\u0000\u0160"+
		"\u0165\u0001\u0000\u0000\u0000\u0161\u0162\u0003*\u0015\u0000\u0162\u0163"+
		"\u0006\u0014\uffff\uffff\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164"+
		"\u0159\u0001\u0000\u0000\u0000\u0164\u015d\u0001\u0000\u0000\u0000\u0164"+
		"\u0161\u0001\u0000\u0000\u0000\u0165)\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0003\u001c\u000e\u0000\u0167\u0168\u0006\u0015\uffff\uffff\u0000\u0168"+
		"\u0181\u0001\u0000\u0000\u0000\u0169\u016a\u0005\u001f\u0000\u0000\u016a"+
		"\u016b\u0005\u000e\u0000\u0000\u016b\u016c\u0003,\u0016\u0000\u016c\u016d"+
		"\u0005\u000f\u0000\u0000\u016d\u016e\u0006\u0015\uffff\uffff\u0000\u016e"+
		"\u0181\u0001\u0000\u0000\u0000\u016f\u0170\u0005\u000e\u0000\u0000\u0170"+
		"\u0171\u0003\u001e\u000f\u0000\u0171\u0172\u0005\u000f\u0000\u0000\u0172"+
		"\u0173\u0006\u0015\uffff\uffff\u0000\u0173\u0181\u0001\u0000\u0000\u0000"+
		"\u0174\u0175\u0005 \u0000\u0000\u0175\u0181\u0006\u0015\uffff\uffff\u0000"+
		"\u0176\u0177\u0005!\u0000\u0000\u0177\u0181\u0006\u0015\uffff\uffff\u0000"+
		"\u0178\u0179\u0003\u001c\u000e\u0000\u0179\u017a\u0005\u0019\u0000\u0000"+
		"\u017a\u017b\u0006\u0015\uffff\uffff\u0000\u017b\u0181\u0001\u0000\u0000"+
		"\u0000\u017c\u017d\u0003\u001c\u000e\u0000\u017d\u017e\u0005\u001a\u0000"+
		"\u0000\u017e\u017f\u0006\u0015\uffff\uffff\u0000\u017f\u0181\u0001\u0000"+
		"\u0000\u0000\u0180\u0166\u0001\u0000\u0000\u0000\u0180\u0169\u0001\u0000"+
		"\u0000\u0000\u0180\u016f\u0001\u0000\u0000\u0000\u0180\u0174\u0001\u0000"+
		"\u0000\u0000\u0180\u0176\u0001\u0000\u0000\u0000\u0180\u0178\u0001\u0000"+
		"\u0000\u0000\u0180\u017c\u0001\u0000\u0000\u0000\u0181+\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0003.\u0017\u0000\u0183\u0184\u0006\u0016\uffff\uffff"+
		"\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185\u0187\u0006\u0016\uffff"+
		"\uffff\u0000\u0186\u0182\u0001\u0000\u0000\u0000\u0186\u0185\u0001\u0000"+
		"\u0000\u0000\u0187-\u0001\u0000\u0000\u0000\u0188\u0189\u0006\u0017\uffff"+
		"\uffff\u0000\u0189\u018a\u0003 \u0010\u0000\u018a\u018b\u0006\u0017\uffff"+
		"\uffff\u0000\u018b\u0193\u0001\u0000\u0000\u0000\u018c\u018d\n\u0002\u0000"+
		"\u0000\u018d\u018e\u0005\u0015\u0000\u0000\u018e\u018f\u0003 \u0010\u0000"+
		"\u018f\u0190\u0006\u0017\uffff\uffff\u0000\u0190\u0192\u0001\u0000\u0000"+
		"\u0000\u0191\u018c\u0001\u0000\u0000\u0000\u0192\u0195\u0001\u0000\u0000"+
		"\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000"+
		"\u0000\u0194/\u0001\u0000\u0000\u0000\u0195\u0193\u0001\u0000\u0000\u0000"+
		"\u001a=I\\r|\u0089\u008b\u0098\u00a4\u00ae\u00b8\u00c5\u00c7\u00d4\u010b"+
		"\u0113\u011d\u0127\u0131\u013b\u0148\u0156\u0164\u0180\u0186\u0193";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}