// #pragma once
#ifndef SYMBOLINFO_HPP
#define SYMBOLINFO_HPP
#include <string>
#include <iostream>

using namespace std;

class SymbolInfo{
    string name;
    string type;

    public:

    SymbolInfo *next;
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