#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <algorithm>
#include <sstream>
#include <unordered_set>

using namespace std;

// Function to trim whitespace from both ends of a string
string trim(const string& str) {
    size_t first = str.find_first_not_of(" \t");
    if (string::npos == first) {
        return str;
    }
    size_t last = str.find_last_not_of(" \t");
    return str.substr(first, (last - first + 1));
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

// Function to check if a line is a label
bool isLabel(const string& line) {
    if (line.empty()) return false;
    return line.back() == ':';
}

// Function to check if two instructions are redundant MOV operations
bool isRedundantMOV(const string& prevLine, const string& currLine) {
    vector<string> prevTokens = split(prevLine, ' ');
    vector<string> currTokens = split(currLine, ' ');
    
    if (prevTokens.empty() || currTokens.empty()) return false;
    
    if (prevTokens[0] == "MOV" && currTokens[0] == "MOV" && prevTokens.size() >= 3 && currTokens.size() >= 3) {
        string prevDest = prevTokens[1];
        string prevSrc = prevTokens[2];
        string currDest = currTokens[1];
        string currSrc = currTokens[2];
        
        return (prevDest == currSrc) && (prevSrc == currDest);
    }
    return false;
}

// Function to check if two instructions are redundant PUSH/POP operations
bool isRedundantPUSHPOP(const string& prevLine, const string& currLine) {
    vector<string> prevTokens = split(prevLine, ' ');
    vector<string> currTokens = split(currLine, ' ');
    
    if (prevTokens.empty() || currTokens.empty()) return false;
    
    if (prevTokens[0] == "PUSH" && currTokens[0] == "POP" && prevTokens.size() >= 2 && currTokens.size() >= 2) {
        return prevTokens[1] == currTokens[1];
    }
    return false;
}

// Function to check if an instruction is a redundant operation (ADD with 0, MUL with 1, etc.)
bool isRedundantOperation(const string& line) {
    vector<string> tokens = split(line, ' ');
    if (tokens.empty()) return false;
    
    if (tokens[0] == "ADD" && tokens.size() >= 3) {
        return tokens[2] == "0";
    }
    else if (tokens[0] == "MUL" && tokens.size() >= 3) {
        return tokens[2] == "1";
    }
    // Add more redundant operations if needed
    return false;
}

// Function to optimize the assembly code
vector<string> optimizeASM(const vector<string>& lines) {
    vector<string> optimized;
    unordered_set<string> usedLabels;
    vector<string> labelDefinitions;
    
    // First pass: collect all used labels (from jumps/calls)
    for (const string& line : lines) {
        vector<string> tokens = split(line, ' ');
        if (tokens.empty()) continue;
        
        // Check for JMP, JZ, JNZ, CALL, etc. that reference labels
        if (tokens[0] == "JMP" || tokens[0] == "JZ" || tokens[0] == "JNZ" || 
            tokens[0] == "CALL" || tokens[0] == "JE" || tokens[0] == "JNE" ||
            tokens[0] == "JG" || tokens[0] == "JGE" || tokens[0] == "JL" || 
            tokens[0] == "JLE") {
            if (tokens.size() >= 2) {
                usedLabels.insert(tokens[1]);
            }
        }
    }
    
    // Second pass: perform optimizations
    for (size_t i = 0; i < lines.size(); i++) {
        string line = lines[i];
        string nextLine = (i + 1 < lines.size()) ? lines[i + 1] : "";
        
        // Skip empty lines
        if (trim(line).empty()) {
            continue;
        }
        
        // Check for redundant MOV
        if (!nextLine.empty() && isRedundantMOV(line, nextLine)) {
            i++; // Skip the next line as it's redundant
            continue;
        }
        
        // Check for redundant PUSH/POP
        if (!nextLine.empty() && isRedundantPUSHPOP(line, nextLine)) {
            i++; // Skip both lines
            continue;
        }
        
        // Check for redundant operations
        if (isRedundantOperation(line)) {
            continue;
        }
        
        // Handle labels - only keep those that are actually used
        if (isLabel(line)) {
            string label = line.substr(0, line.size() - 1);
            label = trim(label);
            
            if (usedLabels.find(label) != usedLabels.end()) {
                optimized.push_back(line);
            }
            continue;
        }
        
        // If none of the above, keep the line
        optimized.push_back(line);
    }
    
    return optimized;
}

int main(int argc, char* argv[]) {
    if (argc != 3) {
        cerr << "Usage: " << argv[0] << " <input_asm_file> <output_asm_file>" << endl;
        return 1;
    }
    
    string inputFile = argv[1];
    string outputFile = argv[2];
    
    // Read input ASM file
    ifstream inFile(inputFile);
    if (!inFile) {
        cerr << "Error: Could not open input file " << inputFile << endl;
        return 1;
    }
    
    vector<string> lines;
    string line;
    while (getline(inFile, line)) {
        lines.push_back(line);
    }
    inFile.close();
    
    // Optimize the code
    vector<string> optimizedLines = optimizeASM(lines);
    
    // Write optimized code to output file
    ofstream outFile(outputFile);
    if (!outFile) {
        cerr << "Error: Could not open output file " << outputFile << endl;
        return 1;
    }
    
    for (const string& optLine : optimizedLines) {
        outFile << optLine << endl;
    }
    outFile.close();
    
    cout << "Optimization complete. Output written to " << outputFile << endl;
    
    return 0;
}