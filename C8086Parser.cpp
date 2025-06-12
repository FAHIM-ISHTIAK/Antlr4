
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"

    extern std::ofstream parserLogFile;
    extern std::ofstream errorFile;

    extern int syntaxErrorCount;


// Generated from C8086Parser.g4 by ANTLR 4.13.2


#include "C8086ParserListener.h"

#include "C8086Parser.h"


using namespace antlrcpp;

using namespace antlr4;

namespace {

struct C8086ParserStaticData final {
  C8086ParserStaticData(std::vector<std::string> ruleNames,
                        std::vector<std::string> literalNames,
                        std::vector<std::string> symbolicNames)
      : ruleNames(std::move(ruleNames)), literalNames(std::move(literalNames)),
        symbolicNames(std::move(symbolicNames)),
        vocabulary(this->literalNames, this->symbolicNames) {}

  C8086ParserStaticData(const C8086ParserStaticData&) = delete;
  C8086ParserStaticData(C8086ParserStaticData&&) = delete;
  C8086ParserStaticData& operator=(const C8086ParserStaticData&) = delete;
  C8086ParserStaticData& operator=(C8086ParserStaticData&&) = delete;

  std::vector<antlr4::dfa::DFA> decisionToDFA;
  antlr4::atn::PredictionContextCache sharedContextCache;
  const std::vector<std::string> ruleNames;
  const std::vector<std::string> literalNames;
  const std::vector<std::string> symbolicNames;
  const antlr4::dfa::Vocabulary vocabulary;
  antlr4::atn::SerializedATNView serializedATN;
  std::unique_ptr<antlr4::atn::ATN> atn;
};

::antlr4::internal::OnceFlag c8086parserParserOnceFlag;
#if ANTLR4_USE_THREAD_LOCAL_CACHE
static thread_local
#endif
std::unique_ptr<C8086ParserStaticData> c8086parserParserStaticData = nullptr;

void c8086parserParserInitialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  if (c8086parserParserStaticData != nullptr) {
    return;
  }
#else
  assert(c8086parserParserStaticData == nullptr);
#endif
  auto staticData = std::make_unique<C8086ParserStaticData>(
    std::vector<std::string>{
      "start", "program", "unit", "func_declaration", "func_definition", 
      "parameter_list", "compound_statement", "var_declaration", "declaration_list_err", 
      "type_specifier", "declaration_list", "statements", "statement", "expression_statement", 
      "variable", "expression", "logic_expression", "rel_expression", "simple_expression", 
      "term", "unary_expression", "factor", "argument_list", "arguments"
    },
    std::vector<std::string>{
      "", "", "", "", "", "'if'", "'else'", "'for'", "'while'", "'println'", 
      "'return'", "'int'", "'float'", "'void'", "'('", "')'", "'{'", "'}'", 
      "'['", "']'", "';'", "','", "", "", "", "'++'", "'--'", "'!'", "", 
      "", "'='"
    },
    std::vector<std::string>{
      "", "LINE_COMMENT", "BLOCK_COMMENT", "STRING", "WS", "IF", "ELSE", 
      "FOR", "WHILE", "PRINTLN", "RETURN", "INT", "FLOAT", "VOID", "LPAREN", 
      "RPAREN", "LCURL", "RCURL", "LTHIRD", "RTHIRD", "SEMICOLON", "COMMA", 
      "ADDOP", "SUBOP", "MULOP", "INCOP", "DECOP", "NOT", "RELOP", "LOGICOP", 
      "ASSIGNOP", "ID", "CONST_INT", "CONST_FLOAT"
    }
  );
  static const int32_t serializedATNSegment[] = {
  	4,1,33,320,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,2,
  	7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,
  	14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,7,
  	21,2,22,7,22,2,23,7,23,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,5,1,57,8,1,10,
  	1,12,1,60,9,1,1,2,1,2,1,2,3,2,65,8,2,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,
  	1,3,1,3,1,3,1,3,1,3,3,3,80,8,3,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,
  	4,1,4,1,4,1,4,3,4,95,8,4,1,5,1,5,1,5,1,5,1,5,3,5,102,8,5,1,5,1,5,1,5,
  	1,5,1,5,1,5,1,5,1,5,5,5,112,8,5,10,5,12,5,115,9,5,1,6,1,6,1,6,1,6,1,6,
  	1,6,3,6,123,8,6,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,3,7,135,8,7,1,
  	8,1,8,1,9,1,9,1,9,1,9,1,9,1,9,3,9,145,8,9,1,10,1,10,1,10,1,10,1,10,1,
  	10,3,10,153,8,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,5,10,164,
  	8,10,10,10,12,10,167,9,10,1,11,1,11,1,11,1,11,1,11,5,11,174,8,11,10,11,
  	12,11,177,9,11,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,3,12,219,8,12,1,13,1,13,1,13,1,13,3,13,225,8,13,1,14,1,14,1,14,1,
  	14,1,14,1,14,3,14,233,8,14,1,15,1,15,1,15,1,15,1,15,3,15,240,8,15,1,16,
  	1,16,1,16,1,16,1,16,3,16,247,8,16,1,17,1,17,1,17,1,17,1,17,3,17,254,8,
  	17,1,18,1,18,1,18,1,18,1,18,1,18,5,18,262,8,18,10,18,12,18,265,9,18,1,
  	19,1,19,1,19,1,19,1,19,1,19,5,19,273,8,19,10,19,12,19,276,9,19,1,20,1,
  	20,1,20,1,20,1,20,3,20,283,8,20,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,
  	21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,3,21,303,8,21,1,
  	22,1,22,3,22,307,8,22,1,23,1,23,1,23,1,23,1,23,1,23,5,23,315,8,23,10,
  	23,12,23,318,9,23,1,23,0,7,2,10,20,22,36,38,46,24,0,2,4,6,8,10,12,14,
  	16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,0,0,336,0,48,1,0,0,0,
  	2,51,1,0,0,0,4,64,1,0,0,0,6,79,1,0,0,0,8,94,1,0,0,0,10,101,1,0,0,0,12,
  	122,1,0,0,0,14,134,1,0,0,0,16,136,1,0,0,0,18,144,1,0,0,0,20,152,1,0,0,
  	0,22,168,1,0,0,0,24,218,1,0,0,0,26,224,1,0,0,0,28,232,1,0,0,0,30,239,
  	1,0,0,0,32,246,1,0,0,0,34,253,1,0,0,0,36,255,1,0,0,0,38,266,1,0,0,0,40,
  	282,1,0,0,0,42,302,1,0,0,0,44,306,1,0,0,0,46,308,1,0,0,0,48,49,3,2,1,
  	0,49,50,6,0,-1,0,50,1,1,0,0,0,51,52,6,1,-1,0,52,53,3,4,2,0,53,58,1,0,
  	0,0,54,55,10,2,0,0,55,57,3,4,2,0,56,54,1,0,0,0,57,60,1,0,0,0,58,56,1,
  	0,0,0,58,59,1,0,0,0,59,3,1,0,0,0,60,58,1,0,0,0,61,65,3,14,7,0,62,65,3,
  	6,3,0,63,65,3,8,4,0,64,61,1,0,0,0,64,62,1,0,0,0,64,63,1,0,0,0,65,5,1,
  	0,0,0,66,67,3,18,9,0,67,68,5,31,0,0,68,69,5,14,0,0,69,70,3,10,5,0,70,
  	71,5,15,0,0,71,72,5,20,0,0,72,80,1,0,0,0,73,74,3,18,9,0,74,75,5,31,0,
  	0,75,76,5,14,0,0,76,77,5,15,0,0,77,78,5,20,0,0,78,80,1,0,0,0,79,66,1,
  	0,0,0,79,73,1,0,0,0,80,7,1,0,0,0,81,82,3,18,9,0,82,83,5,31,0,0,83,84,
  	5,14,0,0,84,85,3,10,5,0,85,86,5,15,0,0,86,87,3,12,6,0,87,95,1,0,0,0,88,
  	89,3,18,9,0,89,90,5,31,0,0,90,91,5,14,0,0,91,92,5,15,0,0,92,93,3,12,6,
  	0,93,95,1,0,0,0,94,81,1,0,0,0,94,88,1,0,0,0,95,9,1,0,0,0,96,97,6,5,-1,
  	0,97,98,3,18,9,0,98,99,5,31,0,0,99,102,1,0,0,0,100,102,3,18,9,0,101,96,
  	1,0,0,0,101,100,1,0,0,0,102,113,1,0,0,0,103,104,10,4,0,0,104,105,5,21,
  	0,0,105,106,3,18,9,0,106,107,5,31,0,0,107,112,1,0,0,0,108,109,10,3,0,
  	0,109,110,5,21,0,0,110,112,3,18,9,0,111,103,1,0,0,0,111,108,1,0,0,0,112,
  	115,1,0,0,0,113,111,1,0,0,0,113,114,1,0,0,0,114,11,1,0,0,0,115,113,1,
  	0,0,0,116,117,5,16,0,0,117,118,3,22,11,0,118,119,5,17,0,0,119,123,1,0,
  	0,0,120,121,5,16,0,0,121,123,5,17,0,0,122,116,1,0,0,0,122,120,1,0,0,0,
  	123,13,1,0,0,0,124,125,3,18,9,0,125,126,3,20,10,0,126,127,5,20,0,0,127,
  	128,6,7,-1,0,128,135,1,0,0,0,129,130,3,18,9,0,130,131,3,16,8,0,131,132,
  	5,20,0,0,132,133,6,7,-1,0,133,135,1,0,0,0,134,124,1,0,0,0,134,129,1,0,
  	0,0,135,15,1,0,0,0,136,137,6,8,-1,0,137,17,1,0,0,0,138,139,5,11,0,0,139,
  	145,6,9,-1,0,140,141,5,12,0,0,141,145,6,9,-1,0,142,143,5,13,0,0,143,145,
  	6,9,-1,0,144,138,1,0,0,0,144,140,1,0,0,0,144,142,1,0,0,0,145,19,1,0,0,
  	0,146,147,6,10,-1,0,147,153,5,31,0,0,148,149,5,31,0,0,149,150,5,18,0,
  	0,150,151,5,32,0,0,151,153,5,19,0,0,152,146,1,0,0,0,152,148,1,0,0,0,153,
  	165,1,0,0,0,154,155,10,4,0,0,155,156,5,21,0,0,156,164,5,31,0,0,157,158,
  	10,3,0,0,158,159,5,21,0,0,159,160,5,31,0,0,160,161,5,18,0,0,161,162,5,
  	32,0,0,162,164,5,19,0,0,163,154,1,0,0,0,163,157,1,0,0,0,164,167,1,0,0,
  	0,165,163,1,0,0,0,165,166,1,0,0,0,166,21,1,0,0,0,167,165,1,0,0,0,168,
  	169,6,11,-1,0,169,170,3,24,12,0,170,175,1,0,0,0,171,172,10,1,0,0,172,
  	174,3,24,12,0,173,171,1,0,0,0,174,177,1,0,0,0,175,173,1,0,0,0,175,176,
  	1,0,0,0,176,23,1,0,0,0,177,175,1,0,0,0,178,219,3,14,7,0,179,219,3,26,
  	13,0,180,219,3,12,6,0,181,182,5,7,0,0,182,183,5,14,0,0,183,184,3,26,13,
  	0,184,185,3,26,13,0,185,186,3,30,15,0,186,187,5,15,0,0,187,188,3,24,12,
  	0,188,219,1,0,0,0,189,190,5,5,0,0,190,191,5,14,0,0,191,192,3,30,15,0,
  	192,193,5,15,0,0,193,194,3,24,12,0,194,219,1,0,0,0,195,196,5,5,0,0,196,
  	197,5,14,0,0,197,198,3,30,15,0,198,199,5,15,0,0,199,200,3,24,12,0,200,
  	201,5,6,0,0,201,202,3,24,12,0,202,219,1,0,0,0,203,204,5,8,0,0,204,205,
  	5,14,0,0,205,206,3,30,15,0,206,207,5,15,0,0,207,208,3,24,12,0,208,219,
  	1,0,0,0,209,210,5,9,0,0,210,211,5,14,0,0,211,212,5,31,0,0,212,213,5,15,
  	0,0,213,219,5,20,0,0,214,215,5,10,0,0,215,216,3,30,15,0,216,217,5,20,
  	0,0,217,219,1,0,0,0,218,178,1,0,0,0,218,179,1,0,0,0,218,180,1,0,0,0,218,
  	181,1,0,0,0,218,189,1,0,0,0,218,195,1,0,0,0,218,203,1,0,0,0,218,209,1,
  	0,0,0,218,214,1,0,0,0,219,25,1,0,0,0,220,225,5,20,0,0,221,222,3,30,15,
  	0,222,223,5,20,0,0,223,225,1,0,0,0,224,220,1,0,0,0,224,221,1,0,0,0,225,
  	27,1,0,0,0,226,233,5,31,0,0,227,228,5,31,0,0,228,229,5,18,0,0,229,230,
  	3,30,15,0,230,231,5,19,0,0,231,233,1,0,0,0,232,226,1,0,0,0,232,227,1,
  	0,0,0,233,29,1,0,0,0,234,240,3,32,16,0,235,236,3,28,14,0,236,237,5,30,
  	0,0,237,238,3,32,16,0,238,240,1,0,0,0,239,234,1,0,0,0,239,235,1,0,0,0,
  	240,31,1,0,0,0,241,247,3,34,17,0,242,243,3,34,17,0,243,244,5,29,0,0,244,
  	245,3,34,17,0,245,247,1,0,0,0,246,241,1,0,0,0,246,242,1,0,0,0,247,33,
  	1,0,0,0,248,254,3,36,18,0,249,250,3,36,18,0,250,251,5,28,0,0,251,252,
  	3,36,18,0,252,254,1,0,0,0,253,248,1,0,0,0,253,249,1,0,0,0,254,35,1,0,
  	0,0,255,256,6,18,-1,0,256,257,3,38,19,0,257,263,1,0,0,0,258,259,10,1,
  	0,0,259,260,5,22,0,0,260,262,3,38,19,0,261,258,1,0,0,0,262,265,1,0,0,
  	0,263,261,1,0,0,0,263,264,1,0,0,0,264,37,1,0,0,0,265,263,1,0,0,0,266,
  	267,6,19,-1,0,267,268,3,40,20,0,268,274,1,0,0,0,269,270,10,1,0,0,270,
  	271,5,24,0,0,271,273,3,40,20,0,272,269,1,0,0,0,273,276,1,0,0,0,274,272,
  	1,0,0,0,274,275,1,0,0,0,275,39,1,0,0,0,276,274,1,0,0,0,277,278,5,22,0,
  	0,278,283,3,40,20,0,279,280,5,27,0,0,280,283,3,40,20,0,281,283,3,42,21,
  	0,282,277,1,0,0,0,282,279,1,0,0,0,282,281,1,0,0,0,283,41,1,0,0,0,284,
  	303,3,28,14,0,285,286,5,31,0,0,286,287,5,14,0,0,287,288,3,44,22,0,288,
  	289,5,15,0,0,289,303,1,0,0,0,290,291,5,14,0,0,291,292,3,30,15,0,292,293,
  	5,15,0,0,293,303,1,0,0,0,294,303,5,32,0,0,295,303,5,33,0,0,296,297,3,
  	28,14,0,297,298,5,25,0,0,298,303,1,0,0,0,299,300,3,28,14,0,300,301,5,
  	26,0,0,301,303,1,0,0,0,302,284,1,0,0,0,302,285,1,0,0,0,302,290,1,0,0,
  	0,302,294,1,0,0,0,302,295,1,0,0,0,302,296,1,0,0,0,302,299,1,0,0,0,303,
  	43,1,0,0,0,304,307,3,46,23,0,305,307,1,0,0,0,306,304,1,0,0,0,306,305,
  	1,0,0,0,307,45,1,0,0,0,308,309,6,23,-1,0,309,310,3,32,16,0,310,316,1,
  	0,0,0,311,312,10,2,0,0,312,313,5,21,0,0,313,315,3,32,16,0,314,311,1,0,
  	0,0,315,318,1,0,0,0,316,314,1,0,0,0,316,317,1,0,0,0,317,47,1,0,0,0,318,
  	316,1,0,0,0,26,58,64,79,94,101,111,113,122,134,144,152,163,165,175,218,
  	224,232,239,246,253,263,274,282,302,306,316
  };
  staticData->serializedATN = antlr4::atn::SerializedATNView(serializedATNSegment, sizeof(serializedATNSegment) / sizeof(serializedATNSegment[0]));

  antlr4::atn::ATNDeserializer deserializer;
  staticData->atn = deserializer.deserialize(staticData->serializedATN);

  const size_t count = staticData->atn->getNumberOfDecisions();
  staticData->decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    staticData->decisionToDFA.emplace_back(staticData->atn->getDecisionState(i), i);
  }
  c8086parserParserStaticData = std::move(staticData);
}

}

C8086Parser::C8086Parser(TokenStream *input) : C8086Parser(input, antlr4::atn::ParserATNSimulatorOptions()) {}

C8086Parser::C8086Parser(TokenStream *input, const antlr4::atn::ParserATNSimulatorOptions &options) : Parser(input) {
  C8086Parser::initialize();
  _interpreter = new atn::ParserATNSimulator(this, *c8086parserParserStaticData->atn, c8086parserParserStaticData->decisionToDFA, c8086parserParserStaticData->sharedContextCache, options);
}

C8086Parser::~C8086Parser() {
  delete _interpreter;
}

const atn::ATN& C8086Parser::getATN() const {
  return *c8086parserParserStaticData->atn;
}

std::string C8086Parser::getGrammarFileName() const {
  return "C8086Parser.g4";
}

const std::vector<std::string>& C8086Parser::getRuleNames() const {
  return c8086parserParserStaticData->ruleNames;
}

const dfa::Vocabulary& C8086Parser::getVocabulary() const {
  return c8086parserParserStaticData->vocabulary;
}

antlr4::atn::SerializedATNView C8086Parser::getSerializedATN() const {
  return c8086parserParserStaticData->serializedATN;
}


//----------------- StartContext ------------------------------------------------------------------

C8086Parser::StartContext::StartContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::ProgramContext* C8086Parser::StartContext::program() {
  return getRuleContext<C8086Parser::ProgramContext>(0);
}


size_t C8086Parser::StartContext::getRuleIndex() const {
  return C8086Parser::RuleStart;
}

void C8086Parser::StartContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStart(this);
}

void C8086Parser::StartContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStart(this);
}

C8086Parser::StartContext* C8086Parser::start() {
  StartContext *_localctx = _tracker.createInstance<StartContext>(_ctx, getState());
  enterRule(_localctx, 0, C8086Parser::RuleStart);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(48);
    program(0);

            writeIntoparserLogFile("Parsing completed successfully with " + std::to_string(syntaxErrorCount) + " syntax errors.");
    	
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ProgramContext ------------------------------------------------------------------

C8086Parser::ProgramContext::ProgramContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::UnitContext* C8086Parser::ProgramContext::unit() {
  return getRuleContext<C8086Parser::UnitContext>(0);
}

C8086Parser::ProgramContext* C8086Parser::ProgramContext::program() {
  return getRuleContext<C8086Parser::ProgramContext>(0);
}


size_t C8086Parser::ProgramContext::getRuleIndex() const {
  return C8086Parser::RuleProgram;
}

void C8086Parser::ProgramContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterProgram(this);
}

void C8086Parser::ProgramContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitProgram(this);
}


C8086Parser::ProgramContext* C8086Parser::program() {
   return program(0);
}

C8086Parser::ProgramContext* C8086Parser::program(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::ProgramContext *_localctx = _tracker.createInstance<ProgramContext>(_ctx, parentState);
  C8086Parser::ProgramContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 2;
  enterRecursionRule(_localctx, 2, C8086Parser::RuleProgram, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(52);
    unit();
    _ctx->stop = _input->LT(-1);
    setState(58);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 0, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<ProgramContext>(parentContext, parentState);
        pushNewRecursionContext(_localctx, startState, RuleProgram);
        setState(54);

        if (!(precpred(_ctx, 2))) throw FailedPredicateException(this, "precpred(_ctx, 2)");
        setState(55);
        unit(); 
      }
      setState(60);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 0, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- UnitContext ------------------------------------------------------------------

C8086Parser::UnitContext::UnitContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Var_declarationContext* C8086Parser::UnitContext::var_declaration() {
  return getRuleContext<C8086Parser::Var_declarationContext>(0);
}

C8086Parser::Func_declarationContext* C8086Parser::UnitContext::func_declaration() {
  return getRuleContext<C8086Parser::Func_declarationContext>(0);
}

C8086Parser::Func_definitionContext* C8086Parser::UnitContext::func_definition() {
  return getRuleContext<C8086Parser::Func_definitionContext>(0);
}


size_t C8086Parser::UnitContext::getRuleIndex() const {
  return C8086Parser::RuleUnit;
}

void C8086Parser::UnitContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterUnit(this);
}

void C8086Parser::UnitContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitUnit(this);
}

C8086Parser::UnitContext* C8086Parser::unit() {
  UnitContext *_localctx = _tracker.createInstance<UnitContext>(_ctx, getState());
  enterRule(_localctx, 4, C8086Parser::RuleUnit);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(64);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 1, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(61);
      var_declaration();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(62);
      func_declaration();
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(63);
      func_definition();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Func_declarationContext ------------------------------------------------------------------

C8086Parser::Func_declarationContext::Func_declarationContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Type_specifierContext* C8086Parser::Func_declarationContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

C8086Parser::Parameter_listContext* C8086Parser::Func_declarationContext::parameter_list() {
  return getRuleContext<C8086Parser::Parameter_listContext>(0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

tree::TerminalNode* C8086Parser::Func_declarationContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}


size_t C8086Parser::Func_declarationContext::getRuleIndex() const {
  return C8086Parser::RuleFunc_declaration;
}

void C8086Parser::Func_declarationContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterFunc_declaration(this);
}

void C8086Parser::Func_declarationContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitFunc_declaration(this);
}

C8086Parser::Func_declarationContext* C8086Parser::func_declaration() {
  Func_declarationContext *_localctx = _tracker.createInstance<Func_declarationContext>(_ctx, getState());
  enterRule(_localctx, 6, C8086Parser::RuleFunc_declaration);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(79);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 2, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(66);
      type_specifier();
      setState(67);
      match(C8086Parser::ID);
      setState(68);
      match(C8086Parser::LPAREN);
      setState(69);
      parameter_list(0);
      setState(70);
      match(C8086Parser::RPAREN);
      setState(71);
      match(C8086Parser::SEMICOLON);
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(73);
      type_specifier();
      setState(74);
      match(C8086Parser::ID);
      setState(75);
      match(C8086Parser::LPAREN);
      setState(76);
      match(C8086Parser::RPAREN);
      setState(77);
      match(C8086Parser::SEMICOLON);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Func_definitionContext ------------------------------------------------------------------

C8086Parser::Func_definitionContext::Func_definitionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Type_specifierContext* C8086Parser::Func_definitionContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

tree::TerminalNode* C8086Parser::Func_definitionContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Func_definitionContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

C8086Parser::Parameter_listContext* C8086Parser::Func_definitionContext::parameter_list() {
  return getRuleContext<C8086Parser::Parameter_listContext>(0);
}

tree::TerminalNode* C8086Parser::Func_definitionContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

C8086Parser::Compound_statementContext* C8086Parser::Func_definitionContext::compound_statement() {
  return getRuleContext<C8086Parser::Compound_statementContext>(0);
}


size_t C8086Parser::Func_definitionContext::getRuleIndex() const {
  return C8086Parser::RuleFunc_definition;
}

void C8086Parser::Func_definitionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterFunc_definition(this);
}

void C8086Parser::Func_definitionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitFunc_definition(this);
}

C8086Parser::Func_definitionContext* C8086Parser::func_definition() {
  Func_definitionContext *_localctx = _tracker.createInstance<Func_definitionContext>(_ctx, getState());
  enterRule(_localctx, 8, C8086Parser::RuleFunc_definition);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(94);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 3, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(81);
      type_specifier();
      setState(82);
      match(C8086Parser::ID);
      setState(83);
      match(C8086Parser::LPAREN);
      setState(84);
      parameter_list(0);
      setState(85);
      match(C8086Parser::RPAREN);
      setState(86);
      compound_statement();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(88);
      type_specifier();
      setState(89);
      match(C8086Parser::ID);
      setState(90);
      match(C8086Parser::LPAREN);
      setState(91);
      match(C8086Parser::RPAREN);
      setState(92);
      compound_statement();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Parameter_listContext ------------------------------------------------------------------

C8086Parser::Parameter_listContext::Parameter_listContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Type_specifierContext* C8086Parser::Parameter_listContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

tree::TerminalNode* C8086Parser::Parameter_listContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

C8086Parser::Parameter_listContext* C8086Parser::Parameter_listContext::parameter_list() {
  return getRuleContext<C8086Parser::Parameter_listContext>(0);
}

tree::TerminalNode* C8086Parser::Parameter_listContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}


size_t C8086Parser::Parameter_listContext::getRuleIndex() const {
  return C8086Parser::RuleParameter_list;
}

void C8086Parser::Parameter_listContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterParameter_list(this);
}

void C8086Parser::Parameter_listContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitParameter_list(this);
}


C8086Parser::Parameter_listContext* C8086Parser::parameter_list() {
   return parameter_list(0);
}

C8086Parser::Parameter_listContext* C8086Parser::parameter_list(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Parameter_listContext *_localctx = _tracker.createInstance<Parameter_listContext>(_ctx, parentState);
  C8086Parser::Parameter_listContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 10;
  enterRecursionRule(_localctx, 10, C8086Parser::RuleParameter_list, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(101);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 4, _ctx)) {
    case 1: {
      setState(97);
      type_specifier();
      setState(98);
      match(C8086Parser::ID);
      break;
    }

    case 2: {
      setState(100);
      type_specifier();
      break;
    }

    default:
      break;
    }
    _ctx->stop = _input->LT(-1);
    setState(113);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 6, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        setState(111);
        _errHandler->sync(this);
        switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 5, _ctx)) {
        case 1: {
          _localctx = _tracker.createInstance<Parameter_listContext>(parentContext, parentState);
          pushNewRecursionContext(_localctx, startState, RuleParameter_list);
          setState(103);

          if (!(precpred(_ctx, 4))) throw FailedPredicateException(this, "precpred(_ctx, 4)");
          setState(104);
          match(C8086Parser::COMMA);
          setState(105);
          type_specifier();
          setState(106);
          match(C8086Parser::ID);
          break;
        }

        case 2: {
          _localctx = _tracker.createInstance<Parameter_listContext>(parentContext, parentState);
          pushNewRecursionContext(_localctx, startState, RuleParameter_list);
          setState(108);

          if (!(precpred(_ctx, 3))) throw FailedPredicateException(this, "precpred(_ctx, 3)");
          setState(109);
          match(C8086Parser::COMMA);
          setState(110);
          type_specifier();
          break;
        }

        default:
          break;
        } 
      }
      setState(115);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 6, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- Compound_statementContext ------------------------------------------------------------------

C8086Parser::Compound_statementContext::Compound_statementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Compound_statementContext::LCURL() {
  return getToken(C8086Parser::LCURL, 0);
}

C8086Parser::StatementsContext* C8086Parser::Compound_statementContext::statements() {
  return getRuleContext<C8086Parser::StatementsContext>(0);
}

tree::TerminalNode* C8086Parser::Compound_statementContext::RCURL() {
  return getToken(C8086Parser::RCURL, 0);
}


size_t C8086Parser::Compound_statementContext::getRuleIndex() const {
  return C8086Parser::RuleCompound_statement;
}

void C8086Parser::Compound_statementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterCompound_statement(this);
}

void C8086Parser::Compound_statementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitCompound_statement(this);
}

C8086Parser::Compound_statementContext* C8086Parser::compound_statement() {
  Compound_statementContext *_localctx = _tracker.createInstance<Compound_statementContext>(_ctx, getState());
  enterRule(_localctx, 12, C8086Parser::RuleCompound_statement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(122);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 7, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(116);
      match(C8086Parser::LCURL);
      setState(117);
      statements(0);
      setState(118);
      match(C8086Parser::RCURL);
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(120);
      match(C8086Parser::LCURL);
      setState(121);
      match(C8086Parser::RCURL);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Var_declarationContext ------------------------------------------------------------------

C8086Parser::Var_declarationContext::Var_declarationContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Type_specifierContext* C8086Parser::Var_declarationContext::type_specifier() {
  return getRuleContext<C8086Parser::Type_specifierContext>(0);
}

C8086Parser::Declaration_listContext* C8086Parser::Var_declarationContext::declaration_list() {
  return getRuleContext<C8086Parser::Declaration_listContext>(0);
}

tree::TerminalNode* C8086Parser::Var_declarationContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

C8086Parser::Declaration_list_errContext* C8086Parser::Var_declarationContext::declaration_list_err() {
  return getRuleContext<C8086Parser::Declaration_list_errContext>(0);
}


size_t C8086Parser::Var_declarationContext::getRuleIndex() const {
  return C8086Parser::RuleVar_declaration;
}

void C8086Parser::Var_declarationContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterVar_declaration(this);
}

void C8086Parser::Var_declarationContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitVar_declaration(this);
}

C8086Parser::Var_declarationContext* C8086Parser::var_declaration() {
  Var_declarationContext *_localctx = _tracker.createInstance<Var_declarationContext>(_ctx, getState());
  enterRule(_localctx, 14, C8086Parser::RuleVar_declaration);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(134);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 8, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(124);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->t = type_specifier();
      setState(125);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl = declaration_list(0);
      setState(126);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

              writeIntoparserLogFile(
                  std::string("Variable Declaration: type_specifier declaration_list ") +
                  std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getType()) +
                  " at line " + std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine())
              );

              writeIntoparserLogFile("type_specifier name_line: " + antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->name_line);
            
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(129);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->t = type_specifier();
      setState(130);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->de = declaration_list_err();
      setState(131);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

              writeIntoErrorFile(
                  std::string("Line# ") + std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine()) +
                  " with error name: " + antlrcpp::downCast<Var_declarationContext *>(_localctx)->de->error_name +
                  " - Syntax error at declaration list of variable declaration"
              );

              syntaxErrorCount++;
            
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Declaration_list_errContext ------------------------------------------------------------------

C8086Parser::Declaration_list_errContext::Declaration_list_errContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t C8086Parser::Declaration_list_errContext::getRuleIndex() const {
  return C8086Parser::RuleDeclaration_list_err;
}

void C8086Parser::Declaration_list_errContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaration_list_err(this);
}

void C8086Parser::Declaration_list_errContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaration_list_err(this);
}

C8086Parser::Declaration_list_errContext* C8086Parser::declaration_list_err() {
  Declaration_list_errContext *_localctx = _tracker.createInstance<Declaration_list_errContext>(_ctx, getState());
  enterRule(_localctx, 16, C8086Parser::RuleDeclaration_list_err);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);

            antlrcpp::downCast<Declaration_list_errContext *>(_localctx)->error_name =  "Error in declaration list";
        
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Type_specifierContext ------------------------------------------------------------------

C8086Parser::Type_specifierContext::Type_specifierContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Type_specifierContext::INT() {
  return getToken(C8086Parser::INT, 0);
}

tree::TerminalNode* C8086Parser::Type_specifierContext::FLOAT() {
  return getToken(C8086Parser::FLOAT, 0);
}

tree::TerminalNode* C8086Parser::Type_specifierContext::VOID() {
  return getToken(C8086Parser::VOID, 0);
}


size_t C8086Parser::Type_specifierContext::getRuleIndex() const {
  return C8086Parser::RuleType_specifier;
}

void C8086Parser::Type_specifierContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterType_specifier(this);
}

void C8086Parser::Type_specifierContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitType_specifier(this);
}

C8086Parser::Type_specifierContext* C8086Parser::type_specifier() {
  Type_specifierContext *_localctx = _tracker.createInstance<Type_specifierContext>(_ctx, getState());
  enterRule(_localctx, 18, C8086Parser::RuleType_specifier);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(144);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::INT: {
        enterOuterAlt(_localctx, 1);
        setState(138);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken = match(C8086Parser::INT);

                    antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  "type: INT at line" + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getLine());
                
        break;
      }

      case C8086Parser::FLOAT: {
        enterOuterAlt(_localctx, 2);
        setState(140);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken = match(C8086Parser::FLOAT);

                    antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  "type: FLOAT at line" + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getLine());
                
        break;
      }

      case C8086Parser::VOID: {
        enterOuterAlt(_localctx, 3);
        setState(142);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken = match(C8086Parser::VOID);

                    antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  "type: VOID at line" + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getLine());
                
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Declaration_listContext ------------------------------------------------------------------

C8086Parser::Declaration_listContext::Declaration_listContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Declaration_listContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::LTHIRD() {
  return getToken(C8086Parser::LTHIRD, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::CONST_INT() {
  return getToken(C8086Parser::CONST_INT, 0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::RTHIRD() {
  return getToken(C8086Parser::RTHIRD, 0);
}

C8086Parser::Declaration_listContext* C8086Parser::Declaration_listContext::declaration_list() {
  return getRuleContext<C8086Parser::Declaration_listContext>(0);
}

tree::TerminalNode* C8086Parser::Declaration_listContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}


size_t C8086Parser::Declaration_listContext::getRuleIndex() const {
  return C8086Parser::RuleDeclaration_list;
}

void C8086Parser::Declaration_listContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterDeclaration_list(this);
}

void C8086Parser::Declaration_listContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitDeclaration_list(this);
}


C8086Parser::Declaration_listContext* C8086Parser::declaration_list() {
   return declaration_list(0);
}

C8086Parser::Declaration_listContext* C8086Parser::declaration_list(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Declaration_listContext *_localctx = _tracker.createInstance<Declaration_listContext>(_ctx, parentState);
  C8086Parser::Declaration_listContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 20;
  enterRecursionRule(_localctx, 20, C8086Parser::RuleDeclaration_list, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(152);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 10, _ctx)) {
    case 1: {
      setState(147);
      match(C8086Parser::ID);
      break;
    }

    case 2: {
      setState(148);
      match(C8086Parser::ID);
      setState(149);
      match(C8086Parser::LTHIRD);
      setState(150);
      match(C8086Parser::CONST_INT);
      setState(151);
      match(C8086Parser::RTHIRD);
      break;
    }

    default:
      break;
    }
    _ctx->stop = _input->LT(-1);
    setState(165);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 12, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        setState(163);
        _errHandler->sync(this);
        switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 11, _ctx)) {
        case 1: {
          _localctx = _tracker.createInstance<Declaration_listContext>(parentContext, parentState);
          pushNewRecursionContext(_localctx, startState, RuleDeclaration_list);
          setState(154);

          if (!(precpred(_ctx, 4))) throw FailedPredicateException(this, "precpred(_ctx, 4)");
          setState(155);
          match(C8086Parser::COMMA);
          setState(156);
          match(C8086Parser::ID);
          break;
        }

        case 2: {
          _localctx = _tracker.createInstance<Declaration_listContext>(parentContext, parentState);
          pushNewRecursionContext(_localctx, startState, RuleDeclaration_list);
          setState(157);

          if (!(precpred(_ctx, 3))) throw FailedPredicateException(this, "precpred(_ctx, 3)");
          setState(158);
          match(C8086Parser::COMMA);
          setState(159);
          match(C8086Parser::ID);
          setState(160);
          match(C8086Parser::LTHIRD);
          setState(161);
          match(C8086Parser::CONST_INT);
          setState(162);
          match(C8086Parser::RTHIRD);
          break;
        }

        default:
          break;
        } 
      }
      setState(167);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 12, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- StatementsContext ------------------------------------------------------------------

C8086Parser::StatementsContext::StatementsContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::StatementContext* C8086Parser::StatementsContext::statement() {
  return getRuleContext<C8086Parser::StatementContext>(0);
}

C8086Parser::StatementsContext* C8086Parser::StatementsContext::statements() {
  return getRuleContext<C8086Parser::StatementsContext>(0);
}


size_t C8086Parser::StatementsContext::getRuleIndex() const {
  return C8086Parser::RuleStatements;
}

void C8086Parser::StatementsContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStatements(this);
}

void C8086Parser::StatementsContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStatements(this);
}


C8086Parser::StatementsContext* C8086Parser::statements() {
   return statements(0);
}

C8086Parser::StatementsContext* C8086Parser::statements(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::StatementsContext *_localctx = _tracker.createInstance<StatementsContext>(_ctx, parentState);
  C8086Parser::StatementsContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 22;
  enterRecursionRule(_localctx, 22, C8086Parser::RuleStatements, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(169);
    statement();
    _ctx->stop = _input->LT(-1);
    setState(175);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 13, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<StatementsContext>(parentContext, parentState);
        pushNewRecursionContext(_localctx, startState, RuleStatements);
        setState(171);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(172);
        statement(); 
      }
      setState(177);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 13, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- StatementContext ------------------------------------------------------------------

C8086Parser::StatementContext::StatementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Var_declarationContext* C8086Parser::StatementContext::var_declaration() {
  return getRuleContext<C8086Parser::Var_declarationContext>(0);
}

std::vector<C8086Parser::Expression_statementContext *> C8086Parser::StatementContext::expression_statement() {
  return getRuleContexts<C8086Parser::Expression_statementContext>();
}

C8086Parser::Expression_statementContext* C8086Parser::StatementContext::expression_statement(size_t i) {
  return getRuleContext<C8086Parser::Expression_statementContext>(i);
}

C8086Parser::Compound_statementContext* C8086Parser::StatementContext::compound_statement() {
  return getRuleContext<C8086Parser::Compound_statementContext>(0);
}

tree::TerminalNode* C8086Parser::StatementContext::FOR() {
  return getToken(C8086Parser::FOR, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

C8086Parser::ExpressionContext* C8086Parser::StatementContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}

tree::TerminalNode* C8086Parser::StatementContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

std::vector<C8086Parser::StatementContext *> C8086Parser::StatementContext::statement() {
  return getRuleContexts<C8086Parser::StatementContext>();
}

C8086Parser::StatementContext* C8086Parser::StatementContext::statement(size_t i) {
  return getRuleContext<C8086Parser::StatementContext>(i);
}

tree::TerminalNode* C8086Parser::StatementContext::IF() {
  return getToken(C8086Parser::IF, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::ELSE() {
  return getToken(C8086Parser::ELSE, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::WHILE() {
  return getToken(C8086Parser::WHILE, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::PRINTLN() {
  return getToken(C8086Parser::PRINTLN, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

tree::TerminalNode* C8086Parser::StatementContext::RETURN() {
  return getToken(C8086Parser::RETURN, 0);
}


size_t C8086Parser::StatementContext::getRuleIndex() const {
  return C8086Parser::RuleStatement;
}

void C8086Parser::StatementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterStatement(this);
}

void C8086Parser::StatementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitStatement(this);
}

C8086Parser::StatementContext* C8086Parser::statement() {
  StatementContext *_localctx = _tracker.createInstance<StatementContext>(_ctx, getState());
  enterRule(_localctx, 24, C8086Parser::RuleStatement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(218);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 14, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(178);
      var_declaration();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(179);
      expression_statement();
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(180);
      compound_statement();
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(181);
      match(C8086Parser::FOR);
      setState(182);
      match(C8086Parser::LPAREN);
      setState(183);
      expression_statement();
      setState(184);
      expression_statement();
      setState(185);
      expression();
      setState(186);
      match(C8086Parser::RPAREN);
      setState(187);
      statement();
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(189);
      match(C8086Parser::IF);
      setState(190);
      match(C8086Parser::LPAREN);
      setState(191);
      expression();
      setState(192);
      match(C8086Parser::RPAREN);
      setState(193);
      statement();
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(195);
      match(C8086Parser::IF);
      setState(196);
      match(C8086Parser::LPAREN);
      setState(197);
      expression();
      setState(198);
      match(C8086Parser::RPAREN);
      setState(199);
      statement();
      setState(200);
      match(C8086Parser::ELSE);
      setState(201);
      statement();
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(203);
      match(C8086Parser::WHILE);
      setState(204);
      match(C8086Parser::LPAREN);
      setState(205);
      expression();
      setState(206);
      match(C8086Parser::RPAREN);
      setState(207);
      statement();
      break;
    }

    case 8: {
      enterOuterAlt(_localctx, 8);
      setState(209);
      match(C8086Parser::PRINTLN);
      setState(210);
      match(C8086Parser::LPAREN);
      setState(211);
      match(C8086Parser::ID);
      setState(212);
      match(C8086Parser::RPAREN);
      setState(213);
      match(C8086Parser::SEMICOLON);
      break;
    }

    case 9: {
      enterOuterAlt(_localctx, 9);
      setState(214);
      match(C8086Parser::RETURN);
      setState(215);
      expression();
      setState(216);
      match(C8086Parser::SEMICOLON);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Expression_statementContext ------------------------------------------------------------------

C8086Parser::Expression_statementContext::Expression_statementContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Expression_statementContext::SEMICOLON() {
  return getToken(C8086Parser::SEMICOLON, 0);
}

C8086Parser::ExpressionContext* C8086Parser::Expression_statementContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}


size_t C8086Parser::Expression_statementContext::getRuleIndex() const {
  return C8086Parser::RuleExpression_statement;
}

void C8086Parser::Expression_statementContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterExpression_statement(this);
}

void C8086Parser::Expression_statementContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitExpression_statement(this);
}

C8086Parser::Expression_statementContext* C8086Parser::expression_statement() {
  Expression_statementContext *_localctx = _tracker.createInstance<Expression_statementContext>(_ctx, getState());
  enterRule(_localctx, 26, C8086Parser::RuleExpression_statement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(224);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::SEMICOLON: {
        enterOuterAlt(_localctx, 1);
        setState(220);
        match(C8086Parser::SEMICOLON);
        break;
      }

      case C8086Parser::LPAREN:
      case C8086Parser::ADDOP:
      case C8086Parser::NOT:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 2);
        setState(221);
        expression();
        setState(222);
        match(C8086Parser::SEMICOLON);
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- VariableContext ------------------------------------------------------------------

C8086Parser::VariableContext::VariableContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::VariableContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::VariableContext::LTHIRD() {
  return getToken(C8086Parser::LTHIRD, 0);
}

C8086Parser::ExpressionContext* C8086Parser::VariableContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}

tree::TerminalNode* C8086Parser::VariableContext::RTHIRD() {
  return getToken(C8086Parser::RTHIRD, 0);
}


size_t C8086Parser::VariableContext::getRuleIndex() const {
  return C8086Parser::RuleVariable;
}

void C8086Parser::VariableContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterVariable(this);
}

void C8086Parser::VariableContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitVariable(this);
}

C8086Parser::VariableContext* C8086Parser::variable() {
  VariableContext *_localctx = _tracker.createInstance<VariableContext>(_ctx, getState());
  enterRule(_localctx, 28, C8086Parser::RuleVariable);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(232);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 16, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(226);
      match(C8086Parser::ID);
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(227);
      match(C8086Parser::ID);
      setState(228);
      match(C8086Parser::LTHIRD);
      setState(229);
      expression();
      setState(230);
      match(C8086Parser::RTHIRD);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ExpressionContext ------------------------------------------------------------------

C8086Parser::ExpressionContext::ExpressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Logic_expressionContext* C8086Parser::ExpressionContext::logic_expression() {
  return getRuleContext<C8086Parser::Logic_expressionContext>(0);
}

C8086Parser::VariableContext* C8086Parser::ExpressionContext::variable() {
  return getRuleContext<C8086Parser::VariableContext>(0);
}

tree::TerminalNode* C8086Parser::ExpressionContext::ASSIGNOP() {
  return getToken(C8086Parser::ASSIGNOP, 0);
}


size_t C8086Parser::ExpressionContext::getRuleIndex() const {
  return C8086Parser::RuleExpression;
}

void C8086Parser::ExpressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterExpression(this);
}

void C8086Parser::ExpressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitExpression(this);
}

C8086Parser::ExpressionContext* C8086Parser::expression() {
  ExpressionContext *_localctx = _tracker.createInstance<ExpressionContext>(_ctx, getState());
  enterRule(_localctx, 30, C8086Parser::RuleExpression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(239);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 17, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(234);
      logic_expression();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(235);
      variable();
      setState(236);
      match(C8086Parser::ASSIGNOP);
      setState(237);
      logic_expression();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Logic_expressionContext ------------------------------------------------------------------

C8086Parser::Logic_expressionContext::Logic_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<C8086Parser::Rel_expressionContext *> C8086Parser::Logic_expressionContext::rel_expression() {
  return getRuleContexts<C8086Parser::Rel_expressionContext>();
}

C8086Parser::Rel_expressionContext* C8086Parser::Logic_expressionContext::rel_expression(size_t i) {
  return getRuleContext<C8086Parser::Rel_expressionContext>(i);
}

tree::TerminalNode* C8086Parser::Logic_expressionContext::LOGICOP() {
  return getToken(C8086Parser::LOGICOP, 0);
}


size_t C8086Parser::Logic_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleLogic_expression;
}

void C8086Parser::Logic_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterLogic_expression(this);
}

void C8086Parser::Logic_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitLogic_expression(this);
}

C8086Parser::Logic_expressionContext* C8086Parser::logic_expression() {
  Logic_expressionContext *_localctx = _tracker.createInstance<Logic_expressionContext>(_ctx, getState());
  enterRule(_localctx, 32, C8086Parser::RuleLogic_expression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(246);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 18, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(241);
      rel_expression();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(242);
      rel_expression();
      setState(243);
      match(C8086Parser::LOGICOP);
      setState(244);
      rel_expression();
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Rel_expressionContext ------------------------------------------------------------------

C8086Parser::Rel_expressionContext::Rel_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<C8086Parser::Simple_expressionContext *> C8086Parser::Rel_expressionContext::simple_expression() {
  return getRuleContexts<C8086Parser::Simple_expressionContext>();
}

C8086Parser::Simple_expressionContext* C8086Parser::Rel_expressionContext::simple_expression(size_t i) {
  return getRuleContext<C8086Parser::Simple_expressionContext>(i);
}

tree::TerminalNode* C8086Parser::Rel_expressionContext::RELOP() {
  return getToken(C8086Parser::RELOP, 0);
}


size_t C8086Parser::Rel_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleRel_expression;
}

void C8086Parser::Rel_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterRel_expression(this);
}

void C8086Parser::Rel_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitRel_expression(this);
}

C8086Parser::Rel_expressionContext* C8086Parser::rel_expression() {
  Rel_expressionContext *_localctx = _tracker.createInstance<Rel_expressionContext>(_ctx, getState());
  enterRule(_localctx, 34, C8086Parser::RuleRel_expression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(253);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 19, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(248);
      simple_expression(0);
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(249);
      simple_expression(0);
      setState(250);
      match(C8086Parser::RELOP);
      setState(251);
      simple_expression(0);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Simple_expressionContext ------------------------------------------------------------------

C8086Parser::Simple_expressionContext::Simple_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::TermContext* C8086Parser::Simple_expressionContext::term() {
  return getRuleContext<C8086Parser::TermContext>(0);
}

C8086Parser::Simple_expressionContext* C8086Parser::Simple_expressionContext::simple_expression() {
  return getRuleContext<C8086Parser::Simple_expressionContext>(0);
}

tree::TerminalNode* C8086Parser::Simple_expressionContext::ADDOP() {
  return getToken(C8086Parser::ADDOP, 0);
}


size_t C8086Parser::Simple_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleSimple_expression;
}

void C8086Parser::Simple_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterSimple_expression(this);
}

void C8086Parser::Simple_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitSimple_expression(this);
}


C8086Parser::Simple_expressionContext* C8086Parser::simple_expression() {
   return simple_expression(0);
}

C8086Parser::Simple_expressionContext* C8086Parser::simple_expression(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::Simple_expressionContext *_localctx = _tracker.createInstance<Simple_expressionContext>(_ctx, parentState);
  C8086Parser::Simple_expressionContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 36;
  enterRecursionRule(_localctx, 36, C8086Parser::RuleSimple_expression, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(256);
    term(0);
    _ctx->stop = _input->LT(-1);
    setState(263);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 20, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<Simple_expressionContext>(parentContext, parentState);
        pushNewRecursionContext(_localctx, startState, RuleSimple_expression);
        setState(258);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(259);
        match(C8086Parser::ADDOP);
        setState(260);
        term(0); 
      }
      setState(265);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 20, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- TermContext ------------------------------------------------------------------

C8086Parser::TermContext::TermContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Unary_expressionContext* C8086Parser::TermContext::unary_expression() {
  return getRuleContext<C8086Parser::Unary_expressionContext>(0);
}

C8086Parser::TermContext* C8086Parser::TermContext::term() {
  return getRuleContext<C8086Parser::TermContext>(0);
}

tree::TerminalNode* C8086Parser::TermContext::MULOP() {
  return getToken(C8086Parser::MULOP, 0);
}


size_t C8086Parser::TermContext::getRuleIndex() const {
  return C8086Parser::RuleTerm;
}

void C8086Parser::TermContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterTerm(this);
}

void C8086Parser::TermContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitTerm(this);
}


C8086Parser::TermContext* C8086Parser::term() {
   return term(0);
}

C8086Parser::TermContext* C8086Parser::term(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::TermContext *_localctx = _tracker.createInstance<TermContext>(_ctx, parentState);
  C8086Parser::TermContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 38;
  enterRecursionRule(_localctx, 38, C8086Parser::RuleTerm, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(267);
    unary_expression();
    _ctx->stop = _input->LT(-1);
    setState(274);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 21, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<TermContext>(parentContext, parentState);
        pushNewRecursionContext(_localctx, startState, RuleTerm);
        setState(269);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(270);
        match(C8086Parser::MULOP);
        setState(271);
        unary_expression(); 
      }
      setState(276);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 21, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- Unary_expressionContext ------------------------------------------------------------------

C8086Parser::Unary_expressionContext::Unary_expressionContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* C8086Parser::Unary_expressionContext::ADDOP() {
  return getToken(C8086Parser::ADDOP, 0);
}

C8086Parser::Unary_expressionContext* C8086Parser::Unary_expressionContext::unary_expression() {
  return getRuleContext<C8086Parser::Unary_expressionContext>(0);
}

tree::TerminalNode* C8086Parser::Unary_expressionContext::NOT() {
  return getToken(C8086Parser::NOT, 0);
}

C8086Parser::FactorContext* C8086Parser::Unary_expressionContext::factor() {
  return getRuleContext<C8086Parser::FactorContext>(0);
}


size_t C8086Parser::Unary_expressionContext::getRuleIndex() const {
  return C8086Parser::RuleUnary_expression;
}

void C8086Parser::Unary_expressionContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterUnary_expression(this);
}

void C8086Parser::Unary_expressionContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitUnary_expression(this);
}

C8086Parser::Unary_expressionContext* C8086Parser::unary_expression() {
  Unary_expressionContext *_localctx = _tracker.createInstance<Unary_expressionContext>(_ctx, getState());
  enterRule(_localctx, 40, C8086Parser::RuleUnary_expression);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(282);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::ADDOP: {
        enterOuterAlt(_localctx, 1);
        setState(277);
        match(C8086Parser::ADDOP);
        setState(278);
        unary_expression();
        break;
      }

      case C8086Parser::NOT: {
        enterOuterAlt(_localctx, 2);
        setState(279);
        match(C8086Parser::NOT);
        setState(280);
        unary_expression();
        break;
      }

      case C8086Parser::LPAREN:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 3);
        setState(281);
        factor();
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- FactorContext ------------------------------------------------------------------

C8086Parser::FactorContext::FactorContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::VariableContext* C8086Parser::FactorContext::variable() {
  return getRuleContext<C8086Parser::VariableContext>(0);
}

tree::TerminalNode* C8086Parser::FactorContext::ID() {
  return getToken(C8086Parser::ID, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::LPAREN() {
  return getToken(C8086Parser::LPAREN, 0);
}

C8086Parser::Argument_listContext* C8086Parser::FactorContext::argument_list() {
  return getRuleContext<C8086Parser::Argument_listContext>(0);
}

tree::TerminalNode* C8086Parser::FactorContext::RPAREN() {
  return getToken(C8086Parser::RPAREN, 0);
}

C8086Parser::ExpressionContext* C8086Parser::FactorContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
}

tree::TerminalNode* C8086Parser::FactorContext::CONST_INT() {
  return getToken(C8086Parser::CONST_INT, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::CONST_FLOAT() {
  return getToken(C8086Parser::CONST_FLOAT, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::INCOP() {
  return getToken(C8086Parser::INCOP, 0);
}

tree::TerminalNode* C8086Parser::FactorContext::DECOP() {
  return getToken(C8086Parser::DECOP, 0);
}


size_t C8086Parser::FactorContext::getRuleIndex() const {
  return C8086Parser::RuleFactor;
}

void C8086Parser::FactorContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterFactor(this);
}

void C8086Parser::FactorContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitFactor(this);
}

C8086Parser::FactorContext* C8086Parser::factor() {
  FactorContext *_localctx = _tracker.createInstance<FactorContext>(_ctx, getState());
  enterRule(_localctx, 42, C8086Parser::RuleFactor);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(302);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 23, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(284);
      variable();
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(285);
      match(C8086Parser::ID);
      setState(286);
      match(C8086Parser::LPAREN);
      setState(287);
      argument_list();
      setState(288);
      match(C8086Parser::RPAREN);
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(290);
      match(C8086Parser::LPAREN);
      setState(291);
      expression();
      setState(292);
      match(C8086Parser::RPAREN);
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(294);
      match(C8086Parser::CONST_INT);
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(295);
      match(C8086Parser::CONST_FLOAT);
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(296);
      variable();
      setState(297);
      match(C8086Parser::INCOP);
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(299);
      variable();
      setState(300);
      match(C8086Parser::DECOP);
      break;
    }

    default:
      break;
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- Argument_listContext ------------------------------------------------------------------

C8086Parser::Argument_listContext::Argument_listContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::ArgumentsContext* C8086Parser::Argument_listContext::arguments() {
  return getRuleContext<C8086Parser::ArgumentsContext>(0);
}


size_t C8086Parser::Argument_listContext::getRuleIndex() const {
  return C8086Parser::RuleArgument_list;
}

void C8086Parser::Argument_listContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterArgument_list(this);
}

void C8086Parser::Argument_listContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitArgument_list(this);
}

C8086Parser::Argument_listContext* C8086Parser::argument_list() {
  Argument_listContext *_localctx = _tracker.createInstance<Argument_listContext>(_ctx, getState());
  enterRule(_localctx, 44, C8086Parser::RuleArgument_list);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(306);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::LPAREN:
      case C8086Parser::ADDOP:
      case C8086Parser::NOT:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 1);
        setState(304);
        arguments(0);
        break;
      }

      case C8086Parser::RPAREN: {
        enterOuterAlt(_localctx, 2);

        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- ArgumentsContext ------------------------------------------------------------------

C8086Parser::ArgumentsContext::ArgumentsContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

C8086Parser::Logic_expressionContext* C8086Parser::ArgumentsContext::logic_expression() {
  return getRuleContext<C8086Parser::Logic_expressionContext>(0);
}

C8086Parser::ArgumentsContext* C8086Parser::ArgumentsContext::arguments() {
  return getRuleContext<C8086Parser::ArgumentsContext>(0);
}

tree::TerminalNode* C8086Parser::ArgumentsContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}


size_t C8086Parser::ArgumentsContext::getRuleIndex() const {
  return C8086Parser::RuleArguments;
}

void C8086Parser::ArgumentsContext::enterRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->enterArguments(this);
}

void C8086Parser::ArgumentsContext::exitRule(tree::ParseTreeListener *listener) {
  auto parserListener = dynamic_cast<C8086ParserListener *>(listener);
  if (parserListener != nullptr)
    parserListener->exitArguments(this);
}


C8086Parser::ArgumentsContext* C8086Parser::arguments() {
   return arguments(0);
}

C8086Parser::ArgumentsContext* C8086Parser::arguments(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  C8086Parser::ArgumentsContext *_localctx = _tracker.createInstance<ArgumentsContext>(_ctx, parentState);
  C8086Parser::ArgumentsContext *previousContext = _localctx;
  (void)previousContext; // Silence compiler, in case the context is not used by generated code.
  size_t startState = 46;
  enterRecursionRule(_localctx, 46, C8086Parser::RuleArguments, precedence);

    

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(309);
    logic_expression();
    _ctx->stop = _input->LT(-1);
    setState(316);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 25, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<ArgumentsContext>(parentContext, parentState);
        pushNewRecursionContext(_localctx, startState, RuleArguments);
        setState(311);

        if (!(precpred(_ctx, 2))) throw FailedPredicateException(this, "precpred(_ctx, 2)");
        setState(312);
        match(C8086Parser::COMMA);
        setState(313);
        logic_expression(); 
      }
      setState(318);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 25, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

bool C8086Parser::sempred(RuleContext *context, size_t ruleIndex, size_t predicateIndex) {
  switch (ruleIndex) {
    case 1: return programSempred(antlrcpp::downCast<ProgramContext *>(context), predicateIndex);
    case 5: return parameter_listSempred(antlrcpp::downCast<Parameter_listContext *>(context), predicateIndex);
    case 10: return declaration_listSempred(antlrcpp::downCast<Declaration_listContext *>(context), predicateIndex);
    case 11: return statementsSempred(antlrcpp::downCast<StatementsContext *>(context), predicateIndex);
    case 18: return simple_expressionSempred(antlrcpp::downCast<Simple_expressionContext *>(context), predicateIndex);
    case 19: return termSempred(antlrcpp::downCast<TermContext *>(context), predicateIndex);
    case 23: return argumentsSempred(antlrcpp::downCast<ArgumentsContext *>(context), predicateIndex);

  default:
    break;
  }
  return true;
}

bool C8086Parser::programSempred(ProgramContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 0: return precpred(_ctx, 2);

  default:
    break;
  }
  return true;
}

bool C8086Parser::parameter_listSempred(Parameter_listContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 1: return precpred(_ctx, 4);
    case 2: return precpred(_ctx, 3);

  default:
    break;
  }
  return true;
}

bool C8086Parser::declaration_listSempred(Declaration_listContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 3: return precpred(_ctx, 4);
    case 4: return precpred(_ctx, 3);

  default:
    break;
  }
  return true;
}

bool C8086Parser::statementsSempred(StatementsContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 5: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::simple_expressionSempred(Simple_expressionContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 6: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::termSempred(TermContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 7: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

bool C8086Parser::argumentsSempred(ArgumentsContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 8: return precpred(_ctx, 2);

  default:
    break;
  }
  return true;
}

void C8086Parser::initialize() {
#if ANTLR4_USE_THREAD_LOCAL_CACHE
  c8086parserParserInitialize();
#else
  ::antlr4::internal::call_once(c8086parserParserOnceFlag, c8086parserParserInitialize);
#endif
}
