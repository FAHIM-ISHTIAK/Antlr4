
    #include <iostream>
    #include <fstream>
    #include <string>
    #include <cstdlib>
    #include "C8086Lexer.h"
	#include "Utills/2105004_SymbolTable.hpp"

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
      "", "", "", "", "", "'if'", "'else'", "'for'", "'while'", "'printf'", 
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
  	4,1,33,407,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,6,7,6,2,
  	7,7,7,2,8,7,8,2,9,7,9,2,10,7,10,2,11,7,11,2,12,7,12,2,13,7,13,2,14,7,
  	14,2,15,7,15,2,16,7,16,2,17,7,17,2,18,7,18,2,19,7,19,2,20,7,20,2,21,7,
  	21,2,22,7,22,2,23,7,23,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,
  	1,60,8,1,10,1,12,1,63,9,1,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,3,2,74,
  	8,2,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,3,1,
  	3,3,3,93,8,3,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,1,4,
  	1,4,1,4,1,4,1,4,1,4,1,4,3,4,115,8,4,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,3,
  	5,125,8,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,1,5,5,5,138,8,5,10,
  	5,12,5,141,9,5,1,6,1,6,1,6,1,6,1,6,1,6,1,6,1,6,1,6,1,6,3,6,153,8,6,1,
  	7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,1,7,3,7,165,8,7,1,8,1,8,1,9,1,9,1,9,
  	1,9,1,9,1,9,3,9,175,8,9,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,3,10,
  	185,8,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,1,10,5,10,
  	198,8,10,10,10,12,10,201,9,10,1,11,1,11,1,11,1,11,1,11,1,11,1,11,1,11,
  	5,11,211,8,11,10,11,12,11,214,9,11,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,1,12,
  	1,12,1,12,1,12,3,12,268,8,12,1,13,1,13,1,13,1,13,1,13,1,13,3,13,276,8,
  	13,1,14,1,14,1,14,1,14,1,14,1,14,1,14,1,14,3,14,286,8,14,1,15,1,15,1,
  	15,1,15,1,15,1,15,1,15,1,15,3,15,296,8,15,1,16,1,16,1,16,1,16,1,16,1,
  	16,1,16,1,16,3,16,306,8,16,1,17,1,17,1,17,1,17,1,17,1,17,1,17,1,17,3,
  	17,316,8,17,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,1,18,5,18,327,8,18,
  	10,18,12,18,330,9,18,1,19,1,19,1,19,1,19,1,19,1,19,1,19,1,19,1,19,5,19,
  	341,8,19,10,19,12,19,344,9,19,1,20,1,20,1,20,1,20,1,20,1,20,1,20,1,20,
  	1,20,1,20,1,20,3,20,357,8,20,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,
  	1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,1,21,
  	1,21,1,21,1,21,1,21,3,21,385,8,21,1,22,1,22,1,22,1,22,3,22,391,8,22,1,
  	23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,1,23,5,23,402,8,23,10,23,12,23,
  	405,9,23,1,23,0,7,2,10,20,22,36,38,46,24,0,2,4,6,8,10,12,14,16,18,20,
  	22,24,26,28,30,32,34,36,38,40,42,44,46,0,0,423,0,48,1,0,0,0,2,51,1,0,
  	0,0,4,73,1,0,0,0,6,92,1,0,0,0,8,114,1,0,0,0,10,124,1,0,0,0,12,152,1,0,
  	0,0,14,164,1,0,0,0,16,166,1,0,0,0,18,174,1,0,0,0,20,184,1,0,0,0,22,202,
  	1,0,0,0,24,267,1,0,0,0,26,275,1,0,0,0,28,285,1,0,0,0,30,295,1,0,0,0,32,
  	305,1,0,0,0,34,315,1,0,0,0,36,317,1,0,0,0,38,331,1,0,0,0,40,356,1,0,0,
  	0,42,384,1,0,0,0,44,390,1,0,0,0,46,392,1,0,0,0,48,49,3,2,1,0,49,50,6,
  	0,-1,0,50,1,1,0,0,0,51,52,6,1,-1,0,52,53,3,4,2,0,53,54,6,1,-1,0,54,61,
  	1,0,0,0,55,56,10,2,0,0,56,57,3,4,2,0,57,58,6,1,-1,0,58,60,1,0,0,0,59,
  	55,1,0,0,0,60,63,1,0,0,0,61,59,1,0,0,0,61,62,1,0,0,0,62,3,1,0,0,0,63,
  	61,1,0,0,0,64,65,3,14,7,0,65,66,6,2,-1,0,66,74,1,0,0,0,67,68,3,6,3,0,
  	68,69,6,2,-1,0,69,74,1,0,0,0,70,71,3,8,4,0,71,72,6,2,-1,0,72,74,1,0,0,
  	0,73,64,1,0,0,0,73,67,1,0,0,0,73,70,1,0,0,0,74,5,1,0,0,0,75,76,3,18,9,
  	0,76,77,5,31,0,0,77,78,6,3,-1,0,78,79,5,14,0,0,79,80,3,10,5,0,80,81,5,
  	15,0,0,81,82,5,20,0,0,82,83,6,3,-1,0,83,93,1,0,0,0,84,85,3,18,9,0,85,
  	86,5,31,0,0,86,87,6,3,-1,0,87,88,5,14,0,0,88,89,5,15,0,0,89,90,5,20,0,
  	0,90,91,6,3,-1,0,91,93,1,0,0,0,92,75,1,0,0,0,92,84,1,0,0,0,93,7,1,0,0,
  	0,94,95,3,18,9,0,95,96,5,31,0,0,96,97,6,4,-1,0,97,98,5,14,0,0,98,99,6,
  	4,-1,0,99,100,3,10,5,0,100,101,6,4,-1,0,101,102,5,15,0,0,102,103,3,12,
  	6,0,103,104,6,4,-1,0,104,115,1,0,0,0,105,106,3,18,9,0,106,107,5,31,0,
  	0,107,108,6,4,-1,0,108,109,5,14,0,0,109,110,6,4,-1,0,110,111,5,15,0,0,
  	111,112,3,12,6,0,112,113,6,4,-1,0,113,115,1,0,0,0,114,94,1,0,0,0,114,
  	105,1,0,0,0,115,9,1,0,0,0,116,117,6,5,-1,0,117,118,3,18,9,0,118,119,5,
  	31,0,0,119,120,6,5,-1,0,120,125,1,0,0,0,121,122,3,18,9,0,122,123,6,5,
  	-1,0,123,125,1,0,0,0,124,116,1,0,0,0,124,121,1,0,0,0,125,139,1,0,0,0,
  	126,127,10,4,0,0,127,128,5,21,0,0,128,129,3,18,9,0,129,130,5,31,0,0,130,
  	131,6,5,-1,0,131,138,1,0,0,0,132,133,10,3,0,0,133,134,5,21,0,0,134,135,
  	3,18,9,0,135,136,6,5,-1,0,136,138,1,0,0,0,137,126,1,0,0,0,137,132,1,0,
  	0,0,138,141,1,0,0,0,139,137,1,0,0,0,139,140,1,0,0,0,140,11,1,0,0,0,141,
  	139,1,0,0,0,142,143,5,16,0,0,143,144,6,6,-1,0,144,145,3,22,11,0,145,146,
  	5,17,0,0,146,147,6,6,-1,0,147,153,1,0,0,0,148,149,5,16,0,0,149,150,6,
  	6,-1,0,150,151,5,17,0,0,151,153,6,6,-1,0,152,142,1,0,0,0,152,148,1,0,
  	0,0,153,13,1,0,0,0,154,155,3,18,9,0,155,156,3,20,10,0,156,157,5,20,0,
  	0,157,158,6,7,-1,0,158,165,1,0,0,0,159,160,3,18,9,0,160,161,3,16,8,0,
  	161,162,5,20,0,0,162,163,6,7,-1,0,163,165,1,0,0,0,164,154,1,0,0,0,164,
  	159,1,0,0,0,165,15,1,0,0,0,166,167,6,8,-1,0,167,17,1,0,0,0,168,169,5,
  	11,0,0,169,175,6,9,-1,0,170,171,5,12,0,0,171,175,6,9,-1,0,172,173,5,13,
  	0,0,173,175,6,9,-1,0,174,168,1,0,0,0,174,170,1,0,0,0,174,172,1,0,0,0,
  	175,19,1,0,0,0,176,177,6,10,-1,0,177,178,5,31,0,0,178,185,6,10,-1,0,179,
  	180,5,31,0,0,180,181,5,18,0,0,181,182,5,32,0,0,182,183,5,19,0,0,183,185,
  	6,10,-1,0,184,176,1,0,0,0,184,179,1,0,0,0,185,199,1,0,0,0,186,187,10,
  	4,0,0,187,188,5,21,0,0,188,189,5,31,0,0,189,198,6,10,-1,0,190,191,10,
  	3,0,0,191,192,5,21,0,0,192,193,5,31,0,0,193,194,5,18,0,0,194,195,5,32,
  	0,0,195,196,5,19,0,0,196,198,6,10,-1,0,197,186,1,0,0,0,197,190,1,0,0,
  	0,198,201,1,0,0,0,199,197,1,0,0,0,199,200,1,0,0,0,200,21,1,0,0,0,201,
  	199,1,0,0,0,202,203,6,11,-1,0,203,204,3,24,12,0,204,205,6,11,-1,0,205,
  	212,1,0,0,0,206,207,10,1,0,0,207,208,3,24,12,0,208,209,6,11,-1,0,209,
  	211,1,0,0,0,210,206,1,0,0,0,211,214,1,0,0,0,212,210,1,0,0,0,212,213,1,
  	0,0,0,213,23,1,0,0,0,214,212,1,0,0,0,215,216,3,14,7,0,216,217,6,12,-1,
  	0,217,268,1,0,0,0,218,219,3,26,13,0,219,220,6,12,-1,0,220,268,1,0,0,0,
  	221,222,3,12,6,0,222,223,6,12,-1,0,223,268,1,0,0,0,224,225,5,7,0,0,225,
  	226,5,14,0,0,226,227,3,26,13,0,227,228,3,26,13,0,228,229,3,30,15,0,229,
  	230,5,15,0,0,230,231,3,24,12,0,231,232,6,12,-1,0,232,268,1,0,0,0,233,
  	234,5,5,0,0,234,235,5,14,0,0,235,236,3,30,15,0,236,237,5,15,0,0,237,238,
  	3,24,12,0,238,239,6,12,-1,0,239,268,1,0,0,0,240,241,5,5,0,0,241,242,5,
  	14,0,0,242,243,3,30,15,0,243,244,5,15,0,0,244,245,3,24,12,0,245,246,5,
  	6,0,0,246,247,3,24,12,0,247,248,6,12,-1,0,248,268,1,0,0,0,249,250,5,8,
  	0,0,250,251,5,14,0,0,251,252,3,30,15,0,252,253,5,15,0,0,253,254,3,24,
  	12,0,254,255,6,12,-1,0,255,268,1,0,0,0,256,257,5,9,0,0,257,258,5,14,0,
  	0,258,259,5,31,0,0,259,260,5,15,0,0,260,261,5,20,0,0,261,268,6,12,-1,
  	0,262,263,5,10,0,0,263,264,3,30,15,0,264,265,5,20,0,0,265,266,6,12,-1,
  	0,266,268,1,0,0,0,267,215,1,0,0,0,267,218,1,0,0,0,267,221,1,0,0,0,267,
  	224,1,0,0,0,267,233,1,0,0,0,267,240,1,0,0,0,267,249,1,0,0,0,267,256,1,
  	0,0,0,267,262,1,0,0,0,268,25,1,0,0,0,269,270,5,20,0,0,270,276,6,13,-1,
  	0,271,272,3,30,15,0,272,273,5,20,0,0,273,274,6,13,-1,0,274,276,1,0,0,
  	0,275,269,1,0,0,0,275,271,1,0,0,0,276,27,1,0,0,0,277,278,5,31,0,0,278,
  	286,6,14,-1,0,279,280,5,31,0,0,280,281,5,18,0,0,281,282,3,30,15,0,282,
  	283,5,19,0,0,283,284,6,14,-1,0,284,286,1,0,0,0,285,277,1,0,0,0,285,279,
  	1,0,0,0,286,29,1,0,0,0,287,288,3,32,16,0,288,289,6,15,-1,0,289,296,1,
  	0,0,0,290,291,3,28,14,0,291,292,5,30,0,0,292,293,3,32,16,0,293,294,6,
  	15,-1,0,294,296,1,0,0,0,295,287,1,0,0,0,295,290,1,0,0,0,296,31,1,0,0,
  	0,297,298,3,34,17,0,298,299,6,16,-1,0,299,306,1,0,0,0,300,301,3,34,17,
  	0,301,302,5,29,0,0,302,303,3,34,17,0,303,304,6,16,-1,0,304,306,1,0,0,
  	0,305,297,1,0,0,0,305,300,1,0,0,0,306,33,1,0,0,0,307,308,3,36,18,0,308,
  	309,6,17,-1,0,309,316,1,0,0,0,310,311,3,36,18,0,311,312,5,28,0,0,312,
  	313,3,36,18,0,313,314,6,17,-1,0,314,316,1,0,0,0,315,307,1,0,0,0,315,310,
  	1,0,0,0,316,35,1,0,0,0,317,318,6,18,-1,0,318,319,3,38,19,0,319,320,6,
  	18,-1,0,320,328,1,0,0,0,321,322,10,1,0,0,322,323,5,22,0,0,323,324,3,38,
  	19,0,324,325,6,18,-1,0,325,327,1,0,0,0,326,321,1,0,0,0,327,330,1,0,0,
  	0,328,326,1,0,0,0,328,329,1,0,0,0,329,37,1,0,0,0,330,328,1,0,0,0,331,
  	332,6,19,-1,0,332,333,3,40,20,0,333,334,6,19,-1,0,334,342,1,0,0,0,335,
  	336,10,1,0,0,336,337,5,24,0,0,337,338,3,40,20,0,338,339,6,19,-1,0,339,
  	341,1,0,0,0,340,335,1,0,0,0,341,344,1,0,0,0,342,340,1,0,0,0,342,343,1,
  	0,0,0,343,39,1,0,0,0,344,342,1,0,0,0,345,346,5,22,0,0,346,347,3,40,20,
  	0,347,348,6,20,-1,0,348,357,1,0,0,0,349,350,5,27,0,0,350,351,3,40,20,
  	0,351,352,6,20,-1,0,352,357,1,0,0,0,353,354,3,42,21,0,354,355,6,20,-1,
  	0,355,357,1,0,0,0,356,345,1,0,0,0,356,349,1,0,0,0,356,353,1,0,0,0,357,
  	41,1,0,0,0,358,359,3,28,14,0,359,360,6,21,-1,0,360,385,1,0,0,0,361,362,
  	5,31,0,0,362,363,5,14,0,0,363,364,3,44,22,0,364,365,5,15,0,0,365,366,
  	6,21,-1,0,366,385,1,0,0,0,367,368,5,14,0,0,368,369,3,30,15,0,369,370,
  	5,15,0,0,370,371,6,21,-1,0,371,385,1,0,0,0,372,373,5,32,0,0,373,385,6,
  	21,-1,0,374,375,5,33,0,0,375,385,6,21,-1,0,376,377,3,28,14,0,377,378,
  	5,25,0,0,378,379,6,21,-1,0,379,385,1,0,0,0,380,381,3,28,14,0,381,382,
  	5,26,0,0,382,383,6,21,-1,0,383,385,1,0,0,0,384,358,1,0,0,0,384,361,1,
  	0,0,0,384,367,1,0,0,0,384,372,1,0,0,0,384,374,1,0,0,0,384,376,1,0,0,0,
  	384,380,1,0,0,0,385,43,1,0,0,0,386,387,3,46,23,0,387,388,6,22,-1,0,388,
  	391,1,0,0,0,389,391,6,22,-1,0,390,386,1,0,0,0,390,389,1,0,0,0,391,45,
  	1,0,0,0,392,393,6,23,-1,0,393,394,3,32,16,0,394,395,6,23,-1,0,395,403,
  	1,0,0,0,396,397,10,2,0,0,397,398,5,21,0,0,398,399,3,32,16,0,399,400,6,
  	23,-1,0,400,402,1,0,0,0,401,396,1,0,0,0,402,405,1,0,0,0,403,401,1,0,0,
  	0,403,404,1,0,0,0,404,47,1,0,0,0,405,403,1,0,0,0,26,61,73,92,114,124,
  	137,139,152,164,174,184,197,199,212,267,275,285,295,305,315,328,342,356,
  	384,390,403
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
    antlrcpp::downCast<ProgramContext *>(_localctx)->unt = unit();

    	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<ProgramContext *>(_localctx)->unt != nullptr ? (antlrcpp::downCast<ProgramContext *>(_localctx)->unt->stop) : nullptr)->getLine()) + ":" + " program : unit\n");
    	writeIntoparserLogFile((antlrcpp::downCast<ProgramContext *>(_localctx)->unt != nullptr ? _input->getText(antlrcpp::downCast<ProgramContext *>(_localctx)->unt->start, antlrcpp::downCast<ProgramContext *>(_localctx)->unt->stop) : nullptr) + "\n");
    	
    _ctx->stop = _input->LT(-1);
    setState(61);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 0, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<ProgramContext>(parentContext, parentState);
        _localctx->pg = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleProgram);
        setState(55);

        if (!(precpred(_ctx, 2))) throw FailedPredicateException(this, "precpred(_ctx, 2)");
        setState(56);
        antlrcpp::downCast<ProgramContext *>(_localctx)->unt = unit();

                  	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<ProgramContext *>(_localctx)->unt != nullptr ? (antlrcpp::downCast<ProgramContext *>(_localctx)->unt->stop) : nullptr)->getLine()) + ":" + " program : program unit\n");
                  	writeIntoparserLogFile((antlrcpp::downCast<ProgramContext *>(_localctx)->pg != nullptr ? _input->getText(antlrcpp::downCast<ProgramContext *>(_localctx)->pg->start, antlrcpp::downCast<ProgramContext *>(_localctx)->pg->stop) : nullptr) + "\n" + (antlrcpp::downCast<ProgramContext *>(_localctx)->unt != nullptr ? _input->getText(antlrcpp::downCast<ProgramContext *>(_localctx)->unt->start, antlrcpp::downCast<ProgramContext *>(_localctx)->unt->stop) : nullptr) + "\n");
                   
      }
      setState(63);
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
    setState(73);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 1, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(64);
      antlrcpp::downCast<UnitContext *>(_localctx)->var_dec = var_declaration();
       
      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<UnitContext *>(_localctx)->var_dec != nullptr ? (antlrcpp::downCast<UnitContext *>(_localctx)->var_dec->start) : nullptr)->getLine()) + ":" + " unit : var_declaration\n"); 
      	writeIntoparserLogFile((antlrcpp::downCast<UnitContext *>(_localctx)->var_dec != nullptr ? _input->getText(antlrcpp::downCast<UnitContext *>(_localctx)->var_dec->start, antlrcpp::downCast<UnitContext *>(_localctx)->var_dec->stop) : nullptr) + "\n"); 

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(67);
      antlrcpp::downCast<UnitContext *>(_localctx)->func_dec = func_declaration();

      		writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<UnitContext *>(_localctx)->func_dec != nullptr ? (antlrcpp::downCast<UnitContext *>(_localctx)->func_dec->stop) : nullptr)->getLine()) + ":" + " unit :  func_declaration\n");
      		writeIntoparserLogFile((antlrcpp::downCast<UnitContext *>(_localctx)->func_dec != nullptr ? _input->getText(antlrcpp::downCast<UnitContext *>(_localctx)->func_dec->start, antlrcpp::downCast<UnitContext *>(_localctx)->func_dec->stop) : nullptr) + "\n");
      	 
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(70);
      antlrcpp::downCast<UnitContext *>(_localctx)->func_def = func_definition();

      		writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<UnitContext *>(_localctx)->func_def != nullptr ? (antlrcpp::downCast<UnitContext *>(_localctx)->func_def->stop) : nullptr)->getLine()) + ":" + " unit :  func_definition\n");
      		writeIntoparserLogFile((antlrcpp::downCast<UnitContext *>(_localctx)->func_def != nullptr ? _input->getText(antlrcpp::downCast<UnitContext *>(_localctx)->func_def->start, antlrcpp::downCast<UnitContext *>(_localctx)->func_def->stop) : nullptr) + "\n");
      	 
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
    setState(92);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 2, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(75);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->t = type_specifier();
      setState(76);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->id = match(C8086Parser::ID);

      	if(symbolTable->LookUp((antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : ""))){
      		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getLine()) + ":" + " Multiple declaration of " + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : "") + "\n");
      		syntaxErrorCount++;
      	} 

      setState(78);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(79);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl = parameter_list(0);
      setState(80);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(81);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
      			writeIntoparserLogFile((antlrcpp::downCast<Func_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->stop) : nullptr) + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : "") + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl != nullptr ? _input->getText(antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl->start, antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl->stop) : nullptr) +(antlrcpp::downCast<Func_declarationContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getText() : "") + "\n");
      			if(!symbolTable->LookUp((antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : ""))){
      				SymbolAdditionalInfo info = SymbolAdditionalInfo();
      				info.isFunction = true;
      				info.parameters = antlrcpp::downCast<Func_declarationContext *>(_localctx)->pl->params;
      				info.returnType = (antlrcpp::downCast<Func_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->stop) : nullptr);
      				symbolTable->Insert((antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : ""), "ID", info);
      			}

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(84);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->t = type_specifier();
      setState(85);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->id = match(C8086Parser::ID);

      		if(symbolTable->LookUp((antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : ""))){
      		writeIntoErrorFile("Line " + std::to_string(antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getLine()) + " - Error: Function '" + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : "") + "' already declared.");
      		syntaxErrorCount++;
      	} 
      		
      setState(87);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(88);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(89);
      antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getLine()) + ":" + " func_declaration : type_specifier ID LPAREN RPAREN SEMICOLON\n");
      			writeIntoparserLogFile((antlrcpp::downCast<Func_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->stop) : nullptr) + " " + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : "") + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->sm->getText() : "") + "\n");
      			if(!symbolTable->LookUp((antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : ""))){
      				SymbolAdditionalInfo info = SymbolAdditionalInfo();
      				info.isFunction = true;
      				info.returnType = (antlrcpp::downCast<Func_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Func_declarationContext *>(_localctx)->t->stop) : nullptr);
      				hasInserted = symbolTable->Insert((antlrcpp::downCast<Func_declarationContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_declarationContext *>(_localctx)->id->getText() : ""), "ID", info);
      			}
      		
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
    setState(114);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 3, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(94);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->t = type_specifier();
      setState(95);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->id = match(C8086Parser::ID);

      	existing = symbolTable->LookUp((antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : ""));
      	if (existing) {
      			if(!existing->additionalInfo.isFunction){
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " Multiple declaration of " + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "\n");
      				syntaxErrorCount++;
      			}
      			else if(existing->additionalInfo.isDefined) {
                      writeIntoErrorFile("Line# " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + " - Error: Function '" + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "' is already defined.");
                      syntaxErrorCount++;
                  }
              }

      setState(97);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
       symbolTable->Enter_scope(); 
      setState(99);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl = parameter_list(0);
       
      if(antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->params.size() == antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->names.size()){
      		for(int i = 0; i < antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->params.size(); i++){
      			if(symbolTable->LookUp2(antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->names[i])){
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " Multiple declaration of " + antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->names[i] + " in parameter" + "\n");
      				syntaxErrorCount++;
      				continue;
      			}
      		SymbolAdditionalInfo info = SymbolAdditionalInfo();
      		info.dataType = antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->params[i];
      		symbolTable->Insert(antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->names[i], "ID", info);
      	}
      }
       
      setState(101);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(102);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt = compound_statement(true);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " func_definition : type_specifier ID LPAREN parameter_list RPAREN compound_statement\n");
      			writeIntoparserLogFile((antlrcpp::downCast<Func_definitionContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->stop) : nullptr) + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->stop) : nullptr) + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt->stop) : nullptr) + "\n");
      		existing = symbolTable->LookUp((antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : ""));
      		if (!existing) {
                  SymbolAdditionalInfo info = SymbolAdditionalInfo();
                  info.isFunction = true;
                  info.isDefined = true;
                  info.returnType = (antlrcpp::downCast<Func_definitionContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->stop) : nullptr);
                  info.parameters = antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->params;
                  hasInserted = symbolTable->Insert((antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : ""), "ID", info);
              } else {
      			if(existing->additionalInfo.isFunction && !existing->additionalInfo.isDefined) {
                  existing->additionalInfo.isDefined = true;
      			if(existing->additionalInfo.returnType != (antlrcpp::downCast<Func_definitionContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->stop) : nullptr)) {
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "\n");
      				syntaxErrorCount++;
              }
      			if(existing->additionalInfo.parameters != antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->params) {
      				syntaxErrorCount++;
      				if(existing->additionalInfo.parameters.size() != antlrcpp::downCast<Func_definitionContext *>(_localctx)->pl->params.size()){
      					writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "\n");
      				}
      				}
      			}
      		}

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(105);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->t = type_specifier();
      setState(106);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->id = match(C8086Parser::ID);

      	existing = symbolTable->LookUp((antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : ""));
      	if (existing) {
                  if (existing->additionalInfo.isDefined) {
                      writeIntoErrorFile("Line# " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + " - Error: Function '" + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "' is already defined.");
                      syntaxErrorCount++;
                  }
              }
      		
      setState(108);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
       symbolTable->Enter_scope(); 
      setState(110);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(111);
      antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt = compound_statement(true);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " func_definition : type_specifier ID LPAREN RPAREN compound_statement\n");
      			writeIntoparserLogFile((antlrcpp::downCast<Func_definitionContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->stop) : nullptr) + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->cm_stmt->stop) : nullptr) + "\n");
      		existing = symbolTable->LookUp((antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : ""));
      		if (!existing) {
      			SymbolAdditionalInfo info = SymbolAdditionalInfo();
      			info.isFunction = true;
      			info.isDefined = true;
      			info.returnType = (antlrcpp::downCast<Func_definitionContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->stop) : nullptr);
      			hasInserted = symbolTable->Insert((antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : ""), "ID", info);
      		}
      		else{
      			if(!existing->additionalInfo.isDefined) {
      			existing->additionalInfo.isDefined = true;
      			if(existing->additionalInfo.returnType != (antlrcpp::downCast<Func_definitionContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->start, antlrcpp::downCast<Func_definitionContext *>(_localctx)->t->stop) : nullptr)) {
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " Return type mismatch with function declaration in function " + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "\n");
      				syntaxErrorCount++;
      		}
      		if(existing->additionalInfo.parameters.size() > 0){
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getLine()) + ":" + " Total number of arguments mismatch with declaration in function " + (antlrcpp::downCast<Func_definitionContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Func_definitionContext *>(_localctx)->id->getText() : "") + "\n");
      				syntaxErrorCount++;
      		}
      		}
      		}
      	
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
    setState(124);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 4, _ctx)) {
    case 1: {
      setState(117);
      antlrcpp::downCast<Parameter_listContext *>(_localctx)->t = type_specifier();
      setState(118);
      antlrcpp::downCast<Parameter_listContext *>(_localctx)->id = match(C8086Parser::ID);

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? (antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr)->getLine()) + ":" + " parameter_list : type_specifier ID\n");
      	writeIntoparserLogFile((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr) + " " + (antlrcpp::downCast<Parameter_listContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->id->getText() : "") + "\n");
      	_localctx->params.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr));
      	_localctx->names.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->id->getText() : ""));
      		
      break;
    }

    case 2: {
      setState(121);
      antlrcpp::downCast<Parameter_listContext *>(_localctx)->t = type_specifier();

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? (antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr)->getLine()) + ":" + " parameter_list : type_specifier\n");
      	writeIntoparserLogFile((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr) + "\n");
      	_localctx->params.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr));
      		
      break;
    }

    default:
      break;
    }
    _ctx->stop = _input->LT(-1);
    setState(139);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 6, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        setState(137);
        _errHandler->sync(this);
        switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 5, _ctx)) {
        case 1: {
          _localctx = _tracker.createInstance<Parameter_listContext>(parentContext, parentState);
          _localctx->pl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleParameter_list);
          setState(126);

          if (!(precpred(_ctx, 4))) throw FailedPredicateException(this, "precpred(_ctx, 4)");
          setState(127);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm = match(C8086Parser::COMMA);
          setState(128);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->t = type_specifier();
          setState(129);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->id = match(C8086Parser::ID);

                    	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier ID\n");
                    	writeIntoparserLogFile((antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->stop) : nullptr) + (antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm->getText() : "") + (antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr) + " " +(antlrcpp::downCast<Parameter_listContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->id->getText() : "") + "\n");
                    	antlrcpp::downCast<Parameter_listContext *>(_localctx)->params =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->params;
                        _localctx->params.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr));
                    	antlrcpp::downCast<Parameter_listContext *>(_localctx)->names =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->names;
                    	_localctx->names.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->id->getText() : ""));
                    
          break;
        }

        case 2: {
          _localctx = _tracker.createInstance<Parameter_listContext>(parentContext, parentState);
          _localctx->pl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleParameter_list);
          setState(132);

          if (!(precpred(_ctx, 3))) throw FailedPredicateException(this, "precpred(_ctx, 3)");
          setState(133);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm = match(C8086Parser::COMMA);
          setState(134);
          antlrcpp::downCast<Parameter_listContext *>(_localctx)->t = type_specifier();

                    	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm->getLine()) + ":" + " parameter_list : parameter_list COMMA type_specifier\n");
                    	writeIntoparserLogFile((antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->stop) : nullptr) + (antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->cm->getText() : "") + (antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr) + "\n");
                    	antlrcpp::downCast<Parameter_listContext *>(_localctx)->params =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->params;
                        _localctx->params.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->start, antlrcpp::downCast<Parameter_listContext *>(_localctx)->t->stop) : nullptr));
                    	antlrcpp::downCast<Parameter_listContext *>(_localctx)->names =  antlrcpp::downCast<Parameter_listContext *>(_localctx)->pl->names;
                    	_localctx->names.push_back((antlrcpp::downCast<Parameter_listContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<Parameter_listContext *>(_localctx)->id->getText() : ""));
                    		
          break;
        }

        default:
          break;
        } 
      }
      setState(141);
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

C8086Parser::Compound_statementContext::Compound_statementContext(ParserRuleContext *parent, size_t invokingState, bool IsFunction)
  : ParserRuleContext(parent, invokingState) {
  this->IsFunction = IsFunction;
}

tree::TerminalNode* C8086Parser::Compound_statementContext::LCURL() {
  return getToken(C8086Parser::LCURL, 0);
}

tree::TerminalNode* C8086Parser::Compound_statementContext::RCURL() {
  return getToken(C8086Parser::RCURL, 0);
}

C8086Parser::StatementsContext* C8086Parser::Compound_statementContext::statements() {
  return getRuleContext<C8086Parser::StatementsContext>(0);
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

C8086Parser::Compound_statementContext* C8086Parser::compound_statement(bool IsFunction) {
  Compound_statementContext *_localctx = _tracker.createInstance<Compound_statementContext>(_ctx, getState(), IsFunction);
  enterRule(_localctx, 12, C8086Parser::RuleCompound_statement);

#if __cplusplus > 201703L
  auto onExit = finally([=, this] {
#else
  auto onExit = finally([=] {
#endif
    exitRule();
  });
  try {
    setState(152);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 7, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(142);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken = match(C8086Parser::LCURL);

      	if(!IsFunction){
      	symbolTable->Enter_scope();
       }

      setState(144);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->stmts = statements(0);
      setState(145);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken = match(C8086Parser::RCURL);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken->getLine()) + ":" + " compound_statement : LCURL statements RCURL\n");
      			writeIntoparserLogFile(antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken->getText() + (antlrcpp::downCast<Compound_statementContext *>(_localctx)->stmts != nullptr ? _input->getText(antlrcpp::downCast<Compound_statementContext *>(_localctx)->stmts->start, antlrcpp::downCast<Compound_statementContext *>(_localctx)->stmts->stop) : nullptr) + antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken->getText() + "\n");
      			symbolTable->Remove_scope();

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(148);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken = match(C8086Parser::LCURL);

      				 if(!IsFunction){
      		 symbolTable->Enter_scope();
      	 }
      			
      setState(150);
      antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken = match(C8086Parser::RCURL);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken->getLine()) + ":" + " compound_statement : LCURL RCURL\n");
      			writeIntoparserLogFile(antlrcpp::downCast<Compound_statementContext *>(_localctx)->lcurlToken->getText() + antlrcpp::downCast<Compound_statementContext *>(_localctx)->rcurlToken->getText() + "\n");
      			symbolTable->Remove_scope();
      			
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
    setState(164);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 8, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(154);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->t = type_specifier();
      setState(155);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl = declaration_list(0);
      setState(156);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

      		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine()) + ":" + " var_declaration : type_specifier declaration_list SEMICOLON\n");
      		writeIntoparserLogFile((antlrcpp::downCast<Var_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->stop) : nullptr) + " " + (antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl != nullptr ? _input->getText(antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->start, antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->stop) : nullptr) + (antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm != nullptr ? antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getText() : "") + "\n");
      		for(int i = 0; i < antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->decls.size(); i++) {
      			if(symbolTable->LookUp2(antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->decls[i].first)) {
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine()) + ": Multiple declaration of " + antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->decls[i].first + "\n");
      				syntaxErrorCount++;
      			} else {
      				SymbolAdditionalInfo info = SymbolAdditionalInfo();
      				info.dataType = (antlrcpp::downCast<Var_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->stop) : nullptr);
      				info.isArray = antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->decls[i].second;
      				info.arraySize = antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->arrsize[i];
      				hasInserted = symbolTable->Insert(antlrcpp::downCast<Var_declarationContext *>(_localctx)->dl->decls[i].first, "ID", info);
      				if((antlrcpp::downCast<Var_declarationContext *>(_localctx)->t != nullptr ? _input->getText(antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->start, antlrcpp::downCast<Var_declarationContext *>(_localctx)->t->stop) : nullptr) == "void"){
      					writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<Var_declarationContext *>(_localctx)->sm->getLine()) + ": Variable type cannot be void\n");
      					syntaxErrorCount++;
      				}
      			}
      		}
            
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(159);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->t = type_specifier();
      setState(160);
      antlrcpp::downCast<Var_declarationContext *>(_localctx)->de = declaration_list_err();
      setState(161);
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
    setState(174);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::INT: {
        enterOuterAlt(_localctx, 1);
        setState(168);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken = match(C8086Parser::INT);

                    antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  "type: INT at line" + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getLine());
        			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getLine()) + ":" + " type_specifier : INT\n");
                    writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->intToken->getText() + "\n");
                
        break;
      }

      case C8086Parser::FLOAT: {
        enterOuterAlt(_localctx, 2);
        setState(170);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken = match(C8086Parser::FLOAT);

                    antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  "type: FLOAT at line" + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getLine());
        			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getLine()) + ":" + " type_specifier : FLOAT\n");
                    writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->floatToken->getText() + "\n");
                
        break;
      }

      case C8086Parser::VOID: {
        enterOuterAlt(_localctx, 3);
        setState(172);
        antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken = match(C8086Parser::VOID);

                    antlrcpp::downCast<Type_specifierContext *>(_localctx)->name_line =  "type: VOID at line" + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getLine());
        			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getLine()) + ":" + " type_specifier : VOID\n");
                    writeIntoparserLogFile(antlrcpp::downCast<Type_specifierContext *>(_localctx)->voidToken->getText() + "\n");
                
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

tree::TerminalNode* C8086Parser::Declaration_listContext::COMMA() {
  return getToken(C8086Parser::COMMA, 0);
}

C8086Parser::Declaration_listContext* C8086Parser::Declaration_listContext::declaration_list() {
  return getRuleContext<C8086Parser::Declaration_listContext>(0);
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
    setState(184);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 10, _ctx)) {
    case 1: {
      setState(177);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine()) + ":" + " declaration_list : ID\n");
      			writeIntoparserLogFile(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + "\n");
      			_localctx->decls.push_back({antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText(), false});
      			_localctx->arrsize.push_back(0);
      		
      break;
    }

    case 2: {
      setState(179);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(180);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->lthirdToken = match(C8086Parser::LTHIRD);
      setState(181);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken = match(C8086Parser::CONST_INT);
      setState(182);
      antlrcpp::downCast<Declaration_listContext *>(_localctx)->rthirdToken = match(C8086Parser::RTHIRD);

      			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine()) + ":" + " declaration_list : ID LTHIRD CONST_INT RTHIRD\n");
      			writeIntoparserLogFile(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->lthirdToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->rthirdToken->getText() + "\n");
      			_localctx->decls.push_back({antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText(), true});
      			_localctx->arrsize.push_back(std::stoi(antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText()));
      		
      break;
    }

    default:
      break;
    }
    _ctx->stop = _input->LT(-1);
    setState(199);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 12, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        setState(197);
        _errHandler->sync(this);
        switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 11, _ctx)) {
        case 1: {
          _localctx = _tracker.createInstance<Declaration_listContext>(parentContext, parentState);
          _localctx->decl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleDeclaration_list);
          setState(186);

          if (!(precpred(_ctx, 4))) throw FailedPredicateException(this, "precpred(_ctx, 4)");
          setState(187);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->commaToken = match(C8086Parser::COMMA);
          setState(188);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);

                    			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine()) + ":" + " declaration_list : declaration_list COMMA ID\n");
                    			writeIntoparserLogFile((antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl != nullptr ? _input->getText(antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->start, antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->stop) : nullptr) + antlrcpp::downCast<Declaration_listContext *>(_localctx)->commaToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + "\n");
                    			antlrcpp::downCast<Declaration_listContext *>(_localctx)->decls =  antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->decls;
                    			_localctx->decls.push_back({antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText(), false});
                    			antlrcpp::downCast<Declaration_listContext *>(_localctx)->arrsize =  antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->arrsize;
                    			_localctx->arrsize.push_back(0);
                    		
          break;
        }

        case 2: {
          _localctx = _tracker.createInstance<Declaration_listContext>(parentContext, parentState);
          _localctx->decl = previousContext;
          pushNewRecursionContext(_localctx, startState, RuleDeclaration_list);
          setState(190);

          if (!(precpred(_ctx, 3))) throw FailedPredicateException(this, "precpred(_ctx, 3)");
          setState(191);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->commaToken = match(C8086Parser::COMMA);
          setState(192);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken = match(C8086Parser::ID);
          setState(193);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->lthirdToken = match(C8086Parser::LTHIRD);
          setState(194);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken = match(C8086Parser::CONST_INT);
          setState(195);
          antlrcpp::downCast<Declaration_listContext *>(_localctx)->rthirdToken = match(C8086Parser::RTHIRD);

                    			writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getLine()) + ":" + " declaration_list : declaration_list COMMA ID LTHIRD CONST_INT RTHIRD\n");
                    			writeIntoparserLogFile((antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl != nullptr ? _input->getText(antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->start, antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->stop) : nullptr) + antlrcpp::downCast<Declaration_listContext *>(_localctx)->commaToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->lthirdToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText() + antlrcpp::downCast<Declaration_listContext *>(_localctx)->rthirdToken->getText() + "\n");
                    			antlrcpp::downCast<Declaration_listContext *>(_localctx)->decls =  antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->decls;
                    			_localctx->decls.push_back({antlrcpp::downCast<Declaration_listContext *>(_localctx)->idToken->getText(), true});
                    			antlrcpp::downCast<Declaration_listContext *>(_localctx)->arrsize =  antlrcpp::downCast<Declaration_listContext *>(_localctx)->decl->arrsize;
                    			_localctx->arrsize.push_back(std::stoi(antlrcpp::downCast<Declaration_listContext *>(_localctx)->const_intToken->getText()));
                    		
          break;
        }

        default:
          break;
        } 
      }
      setState(201);
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
    setState(203);
    antlrcpp::downCast<StatementsContext *>(_localctx)->stmt = statement();

    	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<StatementsContext *>(_localctx)->stmt != nullptr ? (antlrcpp::downCast<StatementsContext *>(_localctx)->stmt->stop) : nullptr)->getLine()) + ":" + " statements : statement\n");
    	writeIntoparserLogFile((antlrcpp::downCast<StatementsContext *>(_localctx)->stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementsContext *>(_localctx)->stmt->start, antlrcpp::downCast<StatementsContext *>(_localctx)->stmt->stop) : nullptr) + "\n");

    _ctx->stop = _input->LT(-1);
    setState(212);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 13, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<StatementsContext>(parentContext, parentState);
        _localctx->stmts = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleStatements);
        setState(206);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(207);
        antlrcpp::downCast<StatementsContext *>(_localctx)->stmt = statement();

                  	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<StatementsContext *>(_localctx)->stmt != nullptr ? (antlrcpp::downCast<StatementsContext *>(_localctx)->stmt->stop) : nullptr)->getLine()) + ":" + " statements : statements statement\n");
                  	writeIntoparserLogFile((antlrcpp::downCast<StatementsContext *>(_localctx)->stmts != nullptr ? _input->getText(antlrcpp::downCast<StatementsContext *>(_localctx)->stmts->start, antlrcpp::downCast<StatementsContext *>(_localctx)->stmts->stop) : nullptr) + (antlrcpp::downCast<StatementsContext *>(_localctx)->stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementsContext *>(_localctx)->stmt->start, antlrcpp::downCast<StatementsContext *>(_localctx)->stmt->stop) : nullptr) +"\n");
                  	    
      }
      setState(214);
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
    setState(267);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 14, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(215);
      antlrcpp::downCast<StatementContext *>(_localctx)->var_dec = var_declaration();

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<StatementContext *>(_localctx)->var_dec != nullptr ? (antlrcpp::downCast<StatementContext *>(_localctx)->var_dec->stop) : nullptr)->getLine()) + ":" + " statement :  var_declaration\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->var_dec != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->var_dec->start, antlrcpp::downCast<StatementContext *>(_localctx)->var_dec->stop) : nullptr) + "\n");

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(218);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt = expression_statement();

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt != nullptr ? (antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt->stop) : nullptr)->getLine()) + ":" + " statement : expression_statement\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt->stop) : nullptr) +"\n");
      	  
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(221);
      antlrcpp::downCast<StatementContext *>(_localctx)->cm_stmt = compound_statement(false);

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<StatementContext *>(_localctx)->cm_stmt != nullptr ? (antlrcpp::downCast<StatementContext *>(_localctx)->cm_stmt->stop) : nullptr)->getLine()) + ":" + " statement : compound_statement\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->cm_stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->cm_stmt->start, antlrcpp::downCast<StatementContext *>(_localctx)->cm_stmt->stop) : nullptr) +"\n");
      	  
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(224);
      antlrcpp::downCast<StatementContext *>(_localctx)->fr = match(C8086Parser::FOR);
      setState(225);
      antlrcpp::downCast<StatementContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(226);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt1 = expression_statement();
      setState(227);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt2 = expression_statement();
      setState(228);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr = expression();
      setState(229);
      antlrcpp::downCast<StatementContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(230);
      antlrcpp::downCast<StatementContext *>(_localctx)->stmt = statement();

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->fr->getLine()) + ":" + " statement : FOR LPAREN expression_statement expression_statement expression RPAREN statement\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->fr != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->fr->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt1 != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt1->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt1->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt2 != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt2->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr_stmt2->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->stmt->start, antlrcpp::downCast<StatementContext *>(_localctx)->stmt->stop) : nullptr) +"\n");
      	  
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(233);
      antlrcpp::downCast<StatementContext *>(_localctx)->iff = match(C8086Parser::IF);
      setState(234);
      antlrcpp::downCast<StatementContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(235);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr = expression();
      setState(236);
      antlrcpp::downCast<StatementContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(237);
      antlrcpp::downCast<StatementContext *>(_localctx)->stmt = statement();

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->iff->getLine()) + ":" + " statement : IF LPAREN expression RPAREN statement\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->iff != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->iff->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->stmt->start, antlrcpp::downCast<StatementContext *>(_localctx)->stmt->stop) : nullptr) + "\n");
      	  
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(240);
      antlrcpp::downCast<StatementContext *>(_localctx)->iff = match(C8086Parser::IF);
      setState(241);
      antlrcpp::downCast<StatementContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(242);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr = expression();
      setState(243);
      antlrcpp::downCast<StatementContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(244);
      antlrcpp::downCast<StatementContext *>(_localctx)->stmt1 = statement();
      setState(245);
      antlrcpp::downCast<StatementContext *>(_localctx)->els = match(C8086Parser::ELSE);
      setState(246);
      antlrcpp::downCast<StatementContext *>(_localctx)->stmt2 = statement();

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->iff->getLine()) + ":" + " statement : IF LPAREN expression RPAREN statement ELSE statement\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->iff != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->iff->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->stmt1 != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->stmt1->start, antlrcpp::downCast<StatementContext *>(_localctx)->stmt1->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->els != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->els->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->stmt2 != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->stmt2->start, antlrcpp::downCast<StatementContext *>(_localctx)->stmt2->stop) : nullptr) + "\n");
      	  
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(249);
      antlrcpp::downCast<StatementContext *>(_localctx)->whl = match(C8086Parser::WHILE);
      setState(250);
      antlrcpp::downCast<StatementContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(251);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr = expression();
      setState(252);
      antlrcpp::downCast<StatementContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(253);
      antlrcpp::downCast<StatementContext *>(_localctx)->stmt = statement();

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->whl->getLine()) + ":" + " statement : WHILE LPAREN expression RPAREN statement\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->whl != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->whl->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->stmt != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->stmt->start, antlrcpp::downCast<StatementContext *>(_localctx)->stmt->stop) : nullptr) + "\n");
      	  
      break;
    }

    case 8: {
      enterOuterAlt(_localctx, 8);
      setState(256);
      antlrcpp::downCast<StatementContext *>(_localctx)->prln = match(C8086Parser::PRINTLN);
      setState(257);
      antlrcpp::downCast<StatementContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(258);
      antlrcpp::downCast<StatementContext *>(_localctx)->id = match(C8086Parser::ID);
      setState(259);
      antlrcpp::downCast<StatementContext *>(_localctx)->rp = match(C8086Parser::RPAREN);
      setState(260);
      antlrcpp::downCast<StatementContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->prln->getLine()) + ":" + " statement : PRINTLN LPAREN ID RPAREN SEMICOLON\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->prln != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->prln->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->id->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->rp->getText() : "") + (antlrcpp::downCast<StatementContext *>(_localctx)->sm != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->sm->getText() : "") + "\n");
      	existing = symbolTable->LookUp((antlrcpp::downCast<StatementContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->id->getText() : ""));
      	if(!existing) {
      		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->id->getLine()) + ":" + " Undeclared variable " + (antlrcpp::downCast<StatementContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->id->getText() : "") + "\n");
      		syntaxErrorCount++;
      	} else {
      		if(existing->additionalInfo.isArray) {
      			writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->id->getLine()) + ":" + (antlrcpp::downCast<StatementContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->id->getText() : "") + " is an array" + "\n");
      			syntaxErrorCount++;
      		}
      		if(existing->additionalInfo.dataType != "int" && existing->additionalInfo.dataType != "float") {
      			writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->id->getLine()) + ": Variable type not int or float in printf\n");
      			syntaxErrorCount++;
      		}
      	}
      	  
      break;
    }

    case 9: {
      enterOuterAlt(_localctx, 9);
      setState(262);
      antlrcpp::downCast<StatementContext *>(_localctx)->rtn = match(C8086Parser::RETURN);
      setState(263);
      antlrcpp::downCast<StatementContext *>(_localctx)->expr = expression();
      setState(264);
      antlrcpp::downCast<StatementContext *>(_localctx)->sm = match(C8086Parser::SEMICOLON);

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<StatementContext *>(_localctx)->rtn->getLine()) + ":" + " statement : RETURN expression SEMICOLON\n");
      	writeIntoparserLogFile((antlrcpp::downCast<StatementContext *>(_localctx)->rtn != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->rtn->getText() : "") + " " + (antlrcpp::downCast<StatementContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<StatementContext *>(_localctx)->expr->start, antlrcpp::downCast<StatementContext *>(_localctx)->expr->stop) : nullptr) + (antlrcpp::downCast<StatementContext *>(_localctx)->sm != nullptr ? antlrcpp::downCast<StatementContext *>(_localctx)->sm->getText() : "") + "\n");
      	  
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
    setState(275);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::SEMICOLON: {
        enterOuterAlt(_localctx, 1);
        setState(269);
        antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken = match(C8086Parser::SEMICOLON);

        	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken->getLine()) + ":" + " expression_statement : SEMICOLON\n");
        	writeIntoparserLogFile(antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken->getText() + "\n");

        break;
      }

      case C8086Parser::LPAREN:
      case C8086Parser::ADDOP:
      case C8086Parser::NOT:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 2);
        setState(271);
        antlrcpp::downCast<Expression_statementContext *>(_localctx)->expr = expression();
        setState(272);
        antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken = match(C8086Parser::SEMICOLON);

        	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken->getLine()) + ":" + " expression_statement : expression SEMICOLON\n");
        	writeIntoparserLogFile((antlrcpp::downCast<Expression_statementContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<Expression_statementContext *>(_localctx)->expr->start, antlrcpp::downCast<Expression_statementContext *>(_localctx)->expr->stop) : nullptr) + antlrcpp::downCast<Expression_statementContext *>(_localctx)->semicolonToken->getText() + "\n");
        			
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

tree::TerminalNode* C8086Parser::VariableContext::RTHIRD() {
  return getToken(C8086Parser::RTHIRD, 0);
}

C8086Parser::ExpressionContext* C8086Parser::VariableContext::expression() {
  return getRuleContext<C8086Parser::ExpressionContext>(0);
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
    setState(285);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 16, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(277);
      antlrcpp::downCast<VariableContext *>(_localctx)->idToken = match(C8086Parser::ID);

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine()) + ":" + " variable : ID\n");
      	writeIntoparserLogFile(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + "\n");
      	existing = symbolTable->LookUp(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText());
      	if(existing) {
      		antlrcpp::downCast<VariableContext *>(_localctx)->datatype =  existing->additionalInfo.dataType;
      		if(existing->additionalInfo.isArray) {
      			writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine()) + ": Type mismatch," + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + " is an array" + "\n");
      			syntaxErrorCount++;
      		}
      	}
      	else {
      		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine()) + ":" + " Undeclared variable " + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + "\n");
      		syntaxErrorCount++;
      		antlrcpp::downCast<VariableContext *>(_localctx)->datatype =  "error";
      	}

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(279);
      antlrcpp::downCast<VariableContext *>(_localctx)->idToken = match(C8086Parser::ID);
      setState(280);
      antlrcpp::downCast<VariableContext *>(_localctx)->lthirdToken = match(C8086Parser::LTHIRD);
      setState(281);
      antlrcpp::downCast<VariableContext *>(_localctx)->expr = expression();
      setState(282);
      antlrcpp::downCast<VariableContext *>(_localctx)->rthirdToken = match(C8086Parser::RTHIRD);

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<VariableContext *>(_localctx)->lthirdToken->getLine()) + ":" + " variable : ID LTHIRD expression RTHIRD\n");
      	writeIntoparserLogFile(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + antlrcpp::downCast<VariableContext *>(_localctx)->lthirdToken->getText() + (antlrcpp::downCast<VariableContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<VariableContext *>(_localctx)->expr->start, antlrcpp::downCast<VariableContext *>(_localctx)->expr->stop) : nullptr) + antlrcpp::downCast<VariableContext *>(_localctx)->rthirdToken->getText() + "\n");
      	existing = symbolTable->LookUp(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText());
      	if(existing) {
      		antlrcpp::downCast<VariableContext *>(_localctx)->datatype =  existing->additionalInfo.dataType;
      		if(!existing->additionalInfo.isArray){
      			writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine()) + ": " + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + " not an array" + "\n");
      			syntaxErrorCount++;
      		}
      	}
      	else{
      		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getLine()) + ":" + " Undeclared variable " + antlrcpp::downCast<VariableContext *>(_localctx)->idToken->getText() + "\n");
      		syntaxErrorCount++;
      		antlrcpp::downCast<VariableContext *>(_localctx)->datatype =  "error";
      	}
      	if(antlrcpp::downCast<VariableContext *>(_localctx)->expr->datatype != "int") {
      		writeIntoErrorFile("Error at line " + std::to_string((antlrcpp::downCast<VariableContext *>(_localctx)->expr != nullptr ? (antlrcpp::downCast<VariableContext *>(_localctx)->expr->start) : nullptr)->getLine()) + ": Expression inside third brackets not an integer" + "\n");
      		syntaxErrorCount++;
      	}
      	 
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

tree::TerminalNode* C8086Parser::ExpressionContext::ASSIGNOP() {
  return getToken(C8086Parser::ASSIGNOP, 0);
}

C8086Parser::VariableContext* C8086Parser::ExpressionContext::variable() {
  return getRuleContext<C8086Parser::VariableContext>(0);
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
    setState(295);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 17, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(287);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr = logic_expression();

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr != nullptr ? (antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->start) : nullptr)->getLine()) + ":" + " expression : logic_expression\n");
      	writeIntoparserLogFile((antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr != nullptr ? _input->getText(antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->start, antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->stop) : nullptr) + "\n");
      	antlrcpp::downCast<ExpressionContext *>(_localctx)->datatype =  antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->datatype;
       
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(290);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->var = variable();
      setState(291);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->assignopToken = match(C8086Parser::ASSIGNOP);
      setState(292);
      antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr = logic_expression();

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<ExpressionContext *>(_localctx)->assignopToken->getLine()) + ":" + " expression : variable ASSIGNOP logic_expression\n");
      	writeIntoparserLogFile((antlrcpp::downCast<ExpressionContext *>(_localctx)->var != nullptr ? _input->getText(antlrcpp::downCast<ExpressionContext *>(_localctx)->var->start, antlrcpp::downCast<ExpressionContext *>(_localctx)->var->stop) : nullptr) + antlrcpp::downCast<ExpressionContext *>(_localctx)->assignopToken->getText() + (antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr != nullptr ? _input->getText(antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->start, antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->stop) : nullptr) + "\n");
      	antlrcpp::downCast<ExpressionContext *>(_localctx)->datatype =  antlrcpp::downCast<ExpressionContext *>(_localctx)->var->datatype;
      	if((antlrcpp::downCast<ExpressionContext *>(_localctx)->var->datatype == "int") && (antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->datatype == "float")) {
      		writeIntoErrorFile("Error at line " + std::to_string((antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr != nullptr ? (antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->start) : nullptr)->getLine()) + ": Type mismatch" + "\n");
      		syntaxErrorCount++;
      	}
      	if(antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->datatype == "void") {
      		writeIntoErrorFile("Error at line " + std::to_string((antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr != nullptr ? (antlrcpp::downCast<ExpressionContext *>(_localctx)->lgexpr->start) : nullptr)->getLine()) + ": Void function used in expression" + "\n");
      		syntaxErrorCount++;
      	}
      	   
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
    setState(305);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 18, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(297);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr = rel_expression();

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr != nullptr ? (antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr->start) : nullptr)->getLine()) + ":" + " logic_expression :  el_expression\n");
      	writeIntoparserLogFile((antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr != nullptr ? _input->getText(antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr->start, antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr->stop) : nullptr) + "\n");
      	antlrcpp::downCast<Logic_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr->datatype;

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(300);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr1 = rel_expression();
      setState(301);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->logicopToken = match(C8086Parser::LOGICOP);
      setState(302);
      antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr2 = rel_expression();

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Logic_expressionContext *>(_localctx)->logicopToken->getLine()) + ":" + " logic_expression : rel_expression LOGICOP rel_expression\n");
      	writeIntoparserLogFile((antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr1 != nullptr ? _input->getText(antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr1->start, antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr1->stop) : nullptr) + antlrcpp::downCast<Logic_expressionContext *>(_localctx)->logicopToken->getText() + (antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr2 != nullptr ? _input->getText(antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr2->start, antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr2->stop) : nullptr) + "\n");
      	antlrcpp::downCast<Logic_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Logic_expressionContext *>(_localctx)->rlexpr1->datatype;
      		 
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
    setState(315);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 19, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(307);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr = simple_expression(0);

      	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr != nullptr ? (antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr->start) : nullptr)->getLine()) + ":" + " rel_expression : simple_expression\n");
      	writeIntoparserLogFile((antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr != nullptr ? _input->getText(antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr->start, antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr->stop) : nullptr) + "\n");
      	antlrcpp::downCast<Rel_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr->datatype;

      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(310);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr1 = simple_expression(0);
      setState(311);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->relopToken = match(C8086Parser::RELOP);
      setState(312);
      antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr2 = simple_expression(0);

      	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Rel_expressionContext *>(_localctx)->relopToken->getLine()) + ":" + " rel_expression : simple_expression RELOP simple_expression\n");
      	writeIntoparserLogFile((antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr1 != nullptr ? _input->getText(antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr1->start, antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr1->stop) : nullptr) + antlrcpp::downCast<Rel_expressionContext *>(_localctx)->relopToken->getText() + (antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr2 != nullptr ? _input->getText(antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr2->start, antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr2->stop) : nullptr) + "\n");
      	antlrcpp::downCast<Rel_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Rel_expressionContext *>(_localctx)->smexpr1->datatype;
      		
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

tree::TerminalNode* C8086Parser::Simple_expressionContext::ADDOP() {
  return getToken(C8086Parser::ADDOP, 0);
}

C8086Parser::Simple_expressionContext* C8086Parser::Simple_expressionContext::simple_expression() {
  return getRuleContext<C8086Parser::Simple_expressionContext>(0);
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
    setState(318);
    antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm = term(0);

    	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm != nullptr ? (antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->start) : nullptr)->getLine()) + ":" + " simple_expression : term\n");
    	writeIntoparserLogFile((antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm != nullptr ? _input->getText(antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->start, antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->stop) : nullptr) + "\n");
    	antlrcpp::downCast<Simple_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->datatype;

    _ctx->stop = _input->LT(-1);
    setState(328);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 20, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<Simple_expressionContext>(parentContext, parentState);
        _localctx->smexpr = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleSimple_expression);
        setState(321);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(322);
        antlrcpp::downCast<Simple_expressionContext *>(_localctx)->addopToken = match(C8086Parser::ADDOP);
        setState(323);
        antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm = term(0);

                  	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Simple_expressionContext *>(_localctx)->addopToken->getLine()) + ":" + " simple_expression : simple_expression ADDOP term\n");
                  	writeIntoparserLogFile((antlrcpp::downCast<Simple_expressionContext *>(_localctx)->smexpr != nullptr ? _input->getText(antlrcpp::downCast<Simple_expressionContext *>(_localctx)->smexpr->start, antlrcpp::downCast<Simple_expressionContext *>(_localctx)->smexpr->stop) : nullptr) + antlrcpp::downCast<Simple_expressionContext *>(_localctx)->addopToken->getText() + (antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm != nullptr ? _input->getText(antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->start, antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->stop) : nullptr) + "\n");
                  	if(antlrcpp::downCast<Simple_expressionContext *>(_localctx)->smexpr->datatype == "float" || antlrcpp::downCast<Simple_expressionContext *>(_localctx)->trm->datatype == "float") {
                  		antlrcpp::downCast<Simple_expressionContext *>(_localctx)->datatype =  "float";
                  	}
                  	else{
                  		antlrcpp::downCast<Simple_expressionContext *>(_localctx)->datatype =  "int";
                  	}
                  		   
      }
      setState(330);
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

tree::TerminalNode* C8086Parser::TermContext::MULOP() {
  return getToken(C8086Parser::MULOP, 0);
}

C8086Parser::TermContext* C8086Parser::TermContext::term() {
  return getRuleContext<C8086Parser::TermContext>(0);
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
    setState(332);
    antlrcpp::downCast<TermContext *>(_localctx)->unexpr = unary_expression();

    	writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<TermContext *>(_localctx)->unexpr != nullptr ? (antlrcpp::downCast<TermContext *>(_localctx)->unexpr->start) : nullptr)->getLine()) + ":" + " term : unary_expression\n");
    	writeIntoparserLogFile((antlrcpp::downCast<TermContext *>(_localctx)->unexpr != nullptr ? _input->getText(antlrcpp::downCast<TermContext *>(_localctx)->unexpr->start, antlrcpp::downCast<TermContext *>(_localctx)->unexpr->stop) : nullptr) + "\n");
    	antlrcpp::downCast<TermContext *>(_localctx)->datatype =  antlrcpp::downCast<TermContext *>(_localctx)->unexpr->datatype;

    _ctx->stop = _input->LT(-1);
    setState(342);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 21, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<TermContext>(parentContext, parentState);
        _localctx->trm = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleTerm);
        setState(335);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(336);
        antlrcpp::downCast<TermContext *>(_localctx)->mulopToken = match(C8086Parser::MULOP);
        setState(337);
        antlrcpp::downCast<TermContext *>(_localctx)->unexpr = unary_expression();

                  	writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getLine()) + ":" + " term : term MULOP unary_expression\n");
                  	writeIntoparserLogFile((antlrcpp::downCast<TermContext *>(_localctx)->trm != nullptr ? _input->getText(antlrcpp::downCast<TermContext *>(_localctx)->trm->start, antlrcpp::downCast<TermContext *>(_localctx)->trm->stop) : nullptr) + antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() + (antlrcpp::downCast<TermContext *>(_localctx)->unexpr != nullptr ? _input->getText(antlrcpp::downCast<TermContext *>(_localctx)->unexpr->start, antlrcpp::downCast<TermContext *>(_localctx)->unexpr->stop) : nullptr) + "\n");
                  	if(antlrcpp::downCast<TermContext *>(_localctx)->trm->datatype == "float" || antlrcpp::downCast<TermContext *>(_localctx)->unexpr->datatype == "float") {
                  		antlrcpp::downCast<TermContext *>(_localctx)->datatype =  "float";
                  	}
                  	if(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() == "%"){
                  		antlrcpp::downCast<TermContext *>(_localctx)->datatype =  "int";
                  	}
                  	else{
                  		antlrcpp::downCast<TermContext *>(_localctx)->datatype =  "int";
                  	}
                  	if(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() == "%" && (antlrcpp::downCast<TermContext *>(_localctx)->unexpr->datatype == "float" || antlrcpp::downCast<TermContext *>(_localctx)->trm->datatype == "float")) {
                  		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getLine()) + ": Non-Integer operand on modulus operator" + "\n");
                  		syntaxErrorCount++;
                  	}
                  	if(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() == "%" && (antlrcpp::downCast<TermContext *>(_localctx)->unexpr != nullptr ? _input->getText(antlrcpp::downCast<TermContext *>(_localctx)->unexpr->start, antlrcpp::downCast<TermContext *>(_localctx)->unexpr->stop) : nullptr) == "0"){
                  		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getLine()) + ": Modulus by Zero" + "\n");
                  		syntaxErrorCount++;
                  	}
                  	if(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getText() == "/" && (antlrcpp::downCast<TermContext *>(_localctx)->unexpr != nullptr ? _input->getText(antlrcpp::downCast<TermContext *>(_localctx)->unexpr->start, antlrcpp::downCast<TermContext *>(_localctx)->unexpr->stop) : nullptr) == "0"){
                  		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getLine()) + ": Division by Zero" + "\n");
                  		syntaxErrorCount++;
                  	}
                  	if(antlrcpp::downCast<TermContext *>(_localctx)->trm->datatype == "void" || antlrcpp::downCast<TermContext *>(_localctx)->unexpr->datatype == "void") {
                  		writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<TermContext *>(_localctx)->mulopToken->getLine()) + ": Void function used in expression" + "\n");
                  		syntaxErrorCount++;
                  	}
                  	  
      }
      setState(344);
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
    setState(356);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::ADDOP: {
        enterOuterAlt(_localctx, 1);
        setState(345);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->addopToken = match(C8086Parser::ADDOP);
        setState(346);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr = unary_expression();

        		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->addopToken->getLine()) + ":" + " unary_expression : ADDOP unary_expression\n");
        		writeIntoparserLogFile(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->addopToken->getText() + (antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr != nullptr ? _input->getText(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr->start, antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr->stop) : nullptr) + "\n");
        		antlrcpp::downCast<Unary_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr->datatype;

        break;
      }

      case C8086Parser::NOT: {
        enterOuterAlt(_localctx, 2);
        setState(349);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->notToken = match(C8086Parser::NOT);
        setState(350);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr = unary_expression();

        		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->notToken->getLine()) + ":" + " unary_expression : NOT unary_expression\n");
        		writeIntoparserLogFile(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->notToken->getText() + (antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr != nullptr ? _input->getText(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr->start, antlrcpp::downCast<Unary_expressionContext *>(_localctx)->unexpr->stop) : nullptr) + "\n");
        		antlrcpp::downCast<Unary_expressionContext *>(_localctx)->datatype =  "int";
        		
        break;
      }

      case C8086Parser::LPAREN:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 3);
        setState(353);
        antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr = factor();

        		writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr != nullptr ? (antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr->start) : nullptr)->getLine()) + ":" + " unary_expression : factor\n");
        		writeIntoparserLogFile((antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr != nullptr ? _input->getText(antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr->start, antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr->stop) : nullptr) + "\n");
        		antlrcpp::downCast<Unary_expressionContext *>(_localctx)->datatype =  antlrcpp::downCast<Unary_expressionContext *>(_localctx)->fctr->datatype;
        		
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
    setState(384);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 23, _ctx)) {
    case 1: {
      enterOuterAlt(_localctx, 1);
      setState(358);
      antlrcpp::downCast<FactorContext *>(_localctx)->var = variable();

      		writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<FactorContext *>(_localctx)->var != nullptr ? (antlrcpp::downCast<FactorContext *>(_localctx)->var->start) : nullptr)->getLine()) + ":" + " factor : variable\n");
      		writeIntoparserLogFile((antlrcpp::downCast<FactorContext *>(_localctx)->var != nullptr ? _input->getText(antlrcpp::downCast<FactorContext *>(_localctx)->var->start, antlrcpp::downCast<FactorContext *>(_localctx)->var->stop) : nullptr) + "\n");
      		antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  antlrcpp::downCast<FactorContext *>(_localctx)->var->datatype;
          
      break;
    }

    case 2: {
      enterOuterAlt(_localctx, 2);
      setState(361);
      antlrcpp::downCast<FactorContext *>(_localctx)->id = match(C8086Parser::ID);
      setState(362);
      antlrcpp::downCast<FactorContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(363);
      antlrcpp::downCast<FactorContext *>(_localctx)->argl = argument_list();
      setState(364);
      antlrcpp::downCast<FactorContext *>(_localctx)->rp = match(C8086Parser::RPAREN);

      		writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<FactorContext *>(_localctx)->argl != nullptr ? (antlrcpp::downCast<FactorContext *>(_localctx)->argl->start) : nullptr)->getLine()) + ":" + " factor : ID LPAREN argument_list RPAREN\n");
      		writeIntoparserLogFile((antlrcpp::downCast<FactorContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->id->getText() : "") + (antlrcpp::downCast<FactorContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<FactorContext *>(_localctx)->argl != nullptr ? _input->getText(antlrcpp::downCast<FactorContext *>(_localctx)->argl->start, antlrcpp::downCast<FactorContext *>(_localctx)->argl->stop) : nullptr) + (antlrcpp::downCast<FactorContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->rp->getText() : "") + "\n");
      		existing = symbolTable->LookUp((antlrcpp::downCast<FactorContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->id->getText() : ""));
      		if(existing && existing->additionalInfo.isDefined && existing->additionalInfo.isFunction){
      			antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  existing->additionalInfo.returnType;
      			if(antlrcpp::downCast<FactorContext *>(_localctx)->argl->argtypes != existing->additionalInfo.parameters){
      			if(existing->additionalInfo.parameters.size() != antlrcpp::downCast<FactorContext *>(_localctx)->argl->argtypes.size()){
      				writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->id->getLine()) + ":" + " Total number of argument mismatch in function " + (antlrcpp::downCast<FactorContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->id->getText() : "") + "\n");
      				syntaxErrorCount++;
      			}
      			else{
      				for(int i = 0; i < antlrcpp::downCast<FactorContext *>(_localctx)->argl->argtypes.size(); i++){
      					if(antlrcpp::downCast<FactorContext *>(_localctx)->argl->argtypes[i] != existing->additionalInfo.parameters[i]){
      						writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->id->getLine()) + ": " + std::to_string(i+1) + "th argument mismatch in function " + (antlrcpp::downCast<FactorContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->id->getText() : "") + "\n");
      						syntaxErrorCount++;
      						break;
      					}
      				}
      			}
      		}
      		}
      		else{
      			writeIntoErrorFile("Error at line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->id->getLine()) + ":" + " Undeclared function " + (antlrcpp::downCast<FactorContext *>(_localctx)->id != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->id->getText() : "") + "\n");
      			syntaxErrorCount++;
      			antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  "error";
      		}
      	
      break;
    }

    case 3: {
      enterOuterAlt(_localctx, 3);
      setState(367);
      antlrcpp::downCast<FactorContext *>(_localctx)->lp = match(C8086Parser::LPAREN);
      setState(368);
      antlrcpp::downCast<FactorContext *>(_localctx)->expr = expression();
      setState(369);
      antlrcpp::downCast<FactorContext *>(_localctx)->rp = match(C8086Parser::RPAREN);

      		writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<FactorContext *>(_localctx)->expr != nullptr ? (antlrcpp::downCast<FactorContext *>(_localctx)->expr->start) : nullptr)->getLine()) + ":" + " factor : LPAREN expression RPAREN\n");
      		writeIntoparserLogFile((antlrcpp::downCast<FactorContext *>(_localctx)->lp != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->lp->getText() : "") + (antlrcpp::downCast<FactorContext *>(_localctx)->expr != nullptr ? _input->getText(antlrcpp::downCast<FactorContext *>(_localctx)->expr->start, antlrcpp::downCast<FactorContext *>(_localctx)->expr->stop) : nullptr) + (antlrcpp::downCast<FactorContext *>(_localctx)->rp != nullptr ? antlrcpp::downCast<FactorContext *>(_localctx)->rp->getText() : "") + "\n");
      		antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  antlrcpp::downCast<FactorContext *>(_localctx)->expr->datatype;
      	
      break;
    }

    case 4: {
      enterOuterAlt(_localctx, 4);
      setState(372);
      antlrcpp::downCast<FactorContext *>(_localctx)->const_intToken = match(C8086Parser::CONST_INT);

      		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->const_intToken->getLine()) + ":" + " factor : CONST_INT\n");
      		writeIntoparserLogFile(antlrcpp::downCast<FactorContext *>(_localctx)->const_intToken->getText() + "\n");
      		antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  "int";
      	
      break;
    }

    case 5: {
      enterOuterAlt(_localctx, 5);
      setState(374);
      antlrcpp::downCast<FactorContext *>(_localctx)->const_floatToken = match(C8086Parser::CONST_FLOAT);

      		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->const_floatToken->getLine()) + ":" + " factor : CONST_FLOAT\n");
      		writeIntoparserLogFile(antlrcpp::downCast<FactorContext *>(_localctx)->const_floatToken->getText() + "\n");
      		antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  "float";
      	
      break;
    }

    case 6: {
      enterOuterAlt(_localctx, 6);
      setState(376);
      antlrcpp::downCast<FactorContext *>(_localctx)->var = variable();
      setState(377);
      antlrcpp::downCast<FactorContext *>(_localctx)->incopToken = match(C8086Parser::INCOP);

      		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->incopToken->getLine()) + ":" + " factor : variable INCOP\n");
      		writeIntoparserLogFile(antlrcpp::downCast<FactorContext *>(_localctx)->incopToken->getText() + "\n");
      		antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  antlrcpp::downCast<FactorContext *>(_localctx)->var->datatype;
      	
      break;
    }

    case 7: {
      enterOuterAlt(_localctx, 7);
      setState(380);
      antlrcpp::downCast<FactorContext *>(_localctx)->var = variable();
      setState(381);
      antlrcpp::downCast<FactorContext *>(_localctx)->decopToken = match(C8086Parser::DECOP);

      		writeIntoparserLogFile("Line " + std::to_string(antlrcpp::downCast<FactorContext *>(_localctx)->decopToken->getLine()) + ":" + " factor : variable DECOP\n");
      		writeIntoparserLogFile(antlrcpp::downCast<FactorContext *>(_localctx)->decopToken->getText() + "\n");
      		antlrcpp::downCast<FactorContext *>(_localctx)->datatype =  antlrcpp::downCast<FactorContext *>(_localctx)->var->datatype;
      	
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
    setState(390);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case C8086Parser::LPAREN:
      case C8086Parser::ADDOP:
      case C8086Parser::NOT:
      case C8086Parser::ID:
      case C8086Parser::CONST_INT:
      case C8086Parser::CONST_FLOAT: {
        enterOuterAlt(_localctx, 1);
        setState(386);
        antlrcpp::downCast<Argument_listContext *>(_localctx)->args = arguments(0);

        			writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<Argument_listContext *>(_localctx)->args != nullptr ? (antlrcpp::downCast<Argument_listContext *>(_localctx)->args->start) : nullptr)->getLine()) + ":" + " argument_list : arguments\n");
        			writeIntoparserLogFile((antlrcpp::downCast<Argument_listContext *>(_localctx)->args != nullptr ? _input->getText(antlrcpp::downCast<Argument_listContext *>(_localctx)->args->start, antlrcpp::downCast<Argument_listContext *>(_localctx)->args->stop) : nullptr) + "\n");
        			antlrcpp::downCast<Argument_listContext *>(_localctx)->argtypes =  antlrcpp::downCast<Argument_listContext *>(_localctx)->args->argtypes;
                    
        break;
      }

      case C8086Parser::RPAREN: {
        enterOuterAlt(_localctx, 2);

        				antlrcpp::downCast<Argument_listContext *>(_localctx)->argtypes =  std::vector<std::string>();
        			  
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
    setState(393);
    antlrcpp::downCast<ArgumentsContext *>(_localctx)->le = logic_expression();

    			writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<ArgumentsContext *>(_localctx)->le != nullptr ? (antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->start) : nullptr)->getLine()) + ":" + " arguments : logic_expression\n");
    			writeIntoparserLogFile((antlrcpp::downCast<ArgumentsContext *>(_localctx)->le != nullptr ? _input->getText(antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->start, antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->stop) : nullptr) + "\n");
    			_localctx->argtypes.push_back(antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->datatype);
    		  
    _ctx->stop = _input->LT(-1);
    setState(403);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 25, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<ArgumentsContext>(parentContext, parentState);
        _localctx->args = previousContext;
        pushNewRecursionContext(_localctx, startState, RuleArguments);
        setState(396);

        if (!(precpred(_ctx, 2))) throw FailedPredicateException(this, "precpred(_ctx, 2)");
        setState(397);
        antlrcpp::downCast<ArgumentsContext *>(_localctx)->cm = match(C8086Parser::COMMA);
        setState(398);
        antlrcpp::downCast<ArgumentsContext *>(_localctx)->le = logic_expression();

                  			writeIntoparserLogFile("Line " + std::to_string((antlrcpp::downCast<ArgumentsContext *>(_localctx)->le != nullptr ? (antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->start) : nullptr)->getLine()) + ":" + " arguments : arguments COMMA logic_expression\n");
                  			writeIntoparserLogFile((antlrcpp::downCast<ArgumentsContext *>(_localctx)->args != nullptr ? _input->getText(antlrcpp::downCast<ArgumentsContext *>(_localctx)->args->start, antlrcpp::downCast<ArgumentsContext *>(_localctx)->args->stop) : nullptr) + (antlrcpp::downCast<ArgumentsContext *>(_localctx)->cm != nullptr ? antlrcpp::downCast<ArgumentsContext *>(_localctx)->cm->getText() : "") + (antlrcpp::downCast<ArgumentsContext *>(_localctx)->le != nullptr ? _input->getText(antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->start, antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->stop) : nullptr) + "\n");
                  			antlrcpp::downCast<ArgumentsContext *>(_localctx)->argtypes =  antlrcpp::downCast<ArgumentsContext *>(_localctx)->args->argtypes;
                  			_localctx->argtypes.push_back(antlrcpp::downCast<ArgumentsContext *>(_localctx)->le->datatype);
                             
      }
      setState(405);
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
