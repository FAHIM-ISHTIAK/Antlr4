#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm>
#include <sstream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

// trim whitespace from both ends of a string
string trim(const string& str) {
    size_t first = str.find_first_not_of(" \t");
    if (string::npos == first) {
        return str; 
    }
    size_t last = str.find_last_not_of(" \t");
    return str.substr(first, (last - first + 1));
}

// place a comma between first two words in a string
string placeComma(string str) {
    size_t firstSpace = str.find(' ');
    if (firstSpace == string::npos) {
        return str; // no space found, return original string
    }
    str[firstSpace] = ',';
    return str;
}

// Function to split a string into tokens
vector<string> split(const string& s, char delimiter) {
    vector<string> tokens;
    string token;
    istringstream tokenStream(s);
    while (getline(tokenStream, token, delimiter)) {
        tokens.push_back(trim(token));
    }
    return tokens;
}

bool isRedundantMOV(string prevLine, string currLine) {
    if (prevLine.empty() || currLine.empty()) return false;
    string prev = placeComma(prevLine);
    string curr = placeComma(currLine);
    vector<string> prevTokens = split(prev, ',');
    vector<string> currTokens = split(curr, ',');
    if (prevTokens.size() != 3 || currTokens.size() != 3)
        return false;
    vector<string> prevtoks, currtoks;
    for(string s: prevTokens){
        prevtoks.push_back(trim(s));
    }
    for(string s: currTokens){
        currtoks.push_back(trim(s));
    }
    return (prevtoks[0] == "MOV" && currtoks[0] == "MOV" &&
            prevtoks[1] == currtoks[2] &&
            prevtoks[2] == currtoks[1]);
}

bool isRedundantPUSHPOP(string prevLine, string currLine) {
    if (prevLine.empty() || currLine.empty()) return false;
    vector<string> prevTokens = split(prevLine, ' ');
    vector<string> currTokens = split(currLine, ' ');
    if (prevTokens.size() != 2 || currTokens.size() != 2)
        return false;
    return (prevTokens[0] == "PUSH" && currTokens[0] == "POP" &&
            prevTokens[1] == currTokens[1]);
}

bool isRedundantOperation(string line){
    if (line.empty()) return false;
    string str = placeComma(line);
    vector<string> tokens = split(str, ',');
    if (tokens.size() < 3) return false;
    
    bool registerUsed = (tokens[1] == "AX" || tokens[1] == "BX" ||
                    tokens[1] == "CX" || tokens[1] == "DX");
    
    return (tokens[0] == "ADD" && tokens[2] == "0" && registerUsed) ||
           (tokens[0] == "SUB" && tokens[2] == "0" && registerUsed);    
}

bool isLabel(const string& line) {
    return !line.empty() && line.back() == ':';
}

string extractLabel(const string& line) {
    if (isLabel(line)) {
        return trim(line.substr(0, line.size() - 1));
    }
    return "";
}

string replaceLabelInLine(string line, const string& prevLabel, const string& newLabel) {
    vector<string> tokens = split(line, ' ');
    if(tokens.empty()) return line;
    if(tokens[0] == "JMP" || tokens[0] == "JZ" || tokens[0] == "JNZ" ||
       tokens[0] == "CALL" || tokens[0] == "JE" || tokens[0] == "JNE" ||
       tokens[0] == "JG" || tokens[0] == "JGE" || tokens[0] == "JL" ||
       tokens[0] == "JLE") {
        if(tokens.size() == 2 && tokens[1] == prevLabel) {
            tokens[1] = newLabel;
            string newLine;
            for(size_t i = 0; i < tokens.size(); i++) {
                if(i > 0) newLine += " ";
                newLine += tokens[i];
            }
            return newLine;
        }
    }
    return line;
}

vector<string> optimizeCode(vector<string>& lines) {
    vector<string> optimized;
    unordered_set<string> usedLabels;
    unordered_map<string, string> labelMap;
    vector<pair<string, string>> labelPairs;

    // First pass: collect all used labels and their positions
    for (const string& line : lines) {
        vector<string> tokens = split(line, ' ');
        if (tokens.empty()) continue;
        
        if (tokens[0] == "JMP" || tokens[0] == "JZ" || tokens[0] == "JNZ" ||
            tokens[0] == "CALL" || tokens[0] == "JE" || tokens[0] == "JNE" ||
            tokens[0] == "JG" || tokens[0] == "JGE" || tokens[0] == "JL" || 
            tokens[0] == "JLE") {
            if (tokens.size() >= 2) {
                usedLabels.insert(tokens[1]);
            }
        }
    }

    // Second pass: perform optimizations and collect label definitions
    for (size_t i = 0; i < lines.size(); i++) {
        string line = lines[i];
        if (trim(line).empty()) {
            continue;
        }

        // Check for redundant MOV
        if (i + 1 < lines.size() && isRedundantMOV(line, lines[i+1])) {
            i++;
            optimized.push_back(line);
            continue;
        }

        // Check for redundant PUSH/POP
        if (i + 1 < lines.size() && isRedundantPUSHPOP(line, lines[i+1])) {
            i++;
            continue;
        }

        // Check for redundant operations
        if (isRedundantOperation(line)) {
            continue;
        }

        optimized.push_back(line);
    }

    int i = 0;
    while(i < optimized.size()){
        string currLine = optimized[i];
        string nextLine = (i + 1 < optimized.size()) ? optimized[i + 1] : "";
        if(isLabel(currLine) && isLabel(nextLine)){
            string currLabel = extractLabel(currLine);
            string nextLabel = extractLabel(nextLine);
            for(int j = 0; j < optimized.size(); j++){
                if(i + 1 == j){
                    continue; // Skip the current label line
                }
                if(i == j){
                    optimized[j] = "remove"; // Mark the next label line for removal
                    continue;
                }
                optimized[j] = replaceLabelInLine(optimized[j], currLabel, nextLabel);
            }
        }
        i++;
    }

    // Remove marked lines
    vector<string> finalOptimized;
    for (const string& line : optimized) {
        if (line != "remove") {
            finalOptimized.push_back(line);
        }
    }

    return finalOptimized;
}

int main() {
    ifstream fin("output/code.asm");
    ofstream fout("output/optimized_code.asm");
    
    if (!fin) {
        cerr << "Error: output/assemblyCode.asm not found.\n";
        return 1;
    }
    
    if (!fout) {
        cerr << "Error: Could not create output/optimizedCode.asm\n";
        return 1;
    }

    vector<string> lines;
    string line;
    
    // Read all lines into vector
    while (getline(fin, line)) {
        lines.push_back(trim(line));
    }
    
    // Optimize the code
    vector<string> optimized = optimizeCode(lines);
    
    // Write optimized code to output file
    for (const string& optLine : optimized) {
        fout << optLine << endl;
    }
    
    fin.close();
    fout.close();
    
    cout << "Optimization complete. Output written to output/optimizedCode.asm" << endl;
    
    return 0;
}