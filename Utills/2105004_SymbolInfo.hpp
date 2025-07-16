// #pragma once
#ifndef SYMBOLINFO_HPP
#define SYMBOLINFO_HPP
#include <string>
#include <iostream>
#include <vector>

using namespace std;

class SymbolAdditionalInfo{
    public:
    bool isFunction = false; // Flag to indicate if the symbol is a function
    bool isDefined = false; // Flag to indicate if the symbol is defined
    string returnType = ""; // Return type of the function if it is a function
    //vector<pair<string, string>> parameters; // Parameters of the function if it is a function
    vector<string> parameters; // Parameters of the function if it is a function
    vector<string> paramnames; // Names of the parameters of the function if it is a function
    // vector<string> matchingParameters; // Parameters that match the function signature
    string dataType = ""; // Data type of the symbol if it is a variable
    bool isArray = false;   // Flag to indicate if the symbol is an array
    int arraySize = 0; // Size of the array if it is an array 
    bool deleted = false;
    int offset = 0; // Offset of the symbol in the stack or data segment
    bool isGlobal = false; // Flag to indicate if the symbol is global

    SymbolAdditionalInfo(){
        // Default constructor
    }
};

class SymbolInfo{
    string name;
    string type;

    public:

    SymbolInfo *next;
    SymbolAdditionalInfo additionalInfo; // Additional information about the symbol
    SymbolInfo(string name, string type, SymbolInfo *next = nullptr){
        this->name = name;
        this->type = type;
        this->next = next;
    }

    ~SymbolInfo(){
        // if(next != NULL){
        //     delete next;  //recursively delete the next node
        // }
    }

    string getName(){
        return name;
    }

    string getType(){
        return type;
    }

    void setName(string name){
        this->name = name;
    }

    void setType(string type){
        this->type = type;
    }

    // Function to print the information of the symbol
    void printInfo(){
        cout << "<" << name << " : " << type << ">" << endl;
    }
};

#endif // SYMBOLINFO_HPP