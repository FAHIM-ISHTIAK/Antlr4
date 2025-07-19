#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <unordered_map>
#include <regex>
#include <set>

// Check for MOV AX, a followed by MOV a, AX
bool isRedundantMov(const std::string& a, const std::string& b) {
    std::regex movPattern(R"(MOV\s+([A-Z]+),\s*(\w+))", std::regex::icase);
    std::smatch matchA, matchB;
    if (std::regex_match(a, matchA, movPattern) && std::regex_match(b, matchB, movPattern)) {
        return matchA[1] == matchB[2] && matchA[2] == matchB[1]; // same pair reversed
    }
    return false;
}

// Check for PUSH X followed by POP X
bool isPushPopSame(const std::string& a, const std::string& b) {
    std::regex pushPattern(R"(PUSH\s+(\w+))", std::regex::icase);
    std::regex popPattern(R"(POP\s+(\w+))", std::regex::icase);
    std::smatch pushMatch, popMatch;
    if (std::regex_match(a, pushMatch, pushPattern) && std::regex_match(b, popMatch, popPattern)) {
        return pushMatch[1] == popMatch[1];
    }
    return false;
}

// Check for ADD X, 0 or MUL X, 1
bool isNoOp(const std::string& line) {
    std::regex addZero(R"(ADD\s+\w+,\s*0)", std::regex::icase);
    std::regex mulOne(R"(MUL\s+\w+,\s*1)", std::regex::icase);
    return std::regex_match(line, addZero) || std::regex_match(line, mulOne);
}

// Check if a line is a label
bool isLabel(const std::string& line) {
    return std::regex_match(line, std::regex(R"((\w+):)"));
}

// Extract label name from "LABEL:"
std::string extractLabel(const std::string& line) {
    std::smatch match;
    std::regex labelRegex(R"((\w+):)");
    if (std::regex_match(line, match, labelRegex)) {
        return match[1];
    }
    return "";
}

// Update jump instructions like JMP L2 → JMP L1
std::string replaceJumpLabel(const std::string& line, const std::unordered_map<std::string, std::string>& labelMap) {
    std::regex jumpRegex(R"((J\w+\s+)(\w+))", std::regex::icase);
    std::smatch match;
    if (std::regex_match(line, match, jumpRegex)) {
        std::string instr = match[1];
        std::string target = match[2];
        if (labelMap.count(target)) {
            return instr + labelMap.at(target);
        }
    }
    return line;
}

int main() {
    std::ifstream fin("code.asm");
    std::ofstream fout("optimized_code.asm");

    if (!fin) {
        std::cerr << "Error: code.asm not found.\n";
        return 1;
    }

    std::vector<std::string> lines;
    std::string line;

    // Read all lines into vector
    while (std::getline(fin, line)) {
        lines.push_back(line);
    }

    // Pass 1: Detect and map redundant label chains
    std::unordered_map<std::string, std::string> labelRedirect;
    std::set<std::string> removedLabels;

    for (size_t i = 0; i < lines.size();) {
        if (isLabel(lines[i])) {
            std::string keepLabel = extractLabel(lines[i]);
            size_t j = i + 1;

            // Scan forward for consecutive labels
            while (j < lines.size() && isLabel(lines[j])) {
                std::string redundant = extractLabel(lines[j]);
                labelRedirect[redundant] = keepLabel;
                removedLabels.insert(redundant);
                ++j;
            }

            i = j;
        } else {
            ++i;
        }
    }

    // Pass 2: Emit optimized output
    for (size_t i = 0; i < lines.size(); ++i) {
        std::string curr = lines[i];
        std::string next = (i + 1 < lines.size()) ? lines[i + 1] : "";

        // Remove redundant MOV
        if (i + 1 < lines.size() && isRedundantMov(curr, next)) {
            ++i;
            continue;
        }

        // Remove PUSH/POP of same register
        if (i + 1 < lines.size() && isPushPopSame(curr, next)) {
            ++i;
            continue;
        }

        // Remove ADD AX, 0 or MUL AX, 1
        if (isNoOp(curr)) {
            continue;
        }

        // Remove redundant label
        if (isLabel(curr)) {
            std::string label = extractLabel(curr);
            if (removedLabels.count(label)) {
                continue;
            }
        }

        // Fix jump instructions
        curr = replaceJumpLabel(curr, labelRedirect);

        fout << curr << "\n";
    }

    std::cout << "✅ Optimization complete. Output written to optimized_code.asm\n";
    return 0;
}
