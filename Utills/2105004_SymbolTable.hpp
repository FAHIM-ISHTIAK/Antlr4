// #pragma once
#ifndef SYMBOL_TABLE_HPP
#define SYMBOL_TABLE_HPP
#include<string>
#include<ostream>
#include "2105004_ScopeTable.hpp"

using namespace std;

class SymbolTable{
    int totalBuckets;
    ScopeTable* scopeTableList;
    ScopeTable* current;
    int scopeCount;
    HashFunction hash_func; // Store the hash function
    double collision_ratio;
    ostream& out;

    public:
    SymbolTable(int totalBuckets, ostream& out = cout, HashFunction hash_func = sdbm_hash) : out(out) {
        this->totalBuckets = totalBuckets;
        this->hash_func = hash_func; // Store the hash function
        this->scopeTableList = new ScopeTable(totalBuckets, hash_func, out, nullptr);
        this->current = scopeTableList;
        this->collision_ratio= 0.0;
        current->setId(1);
        scopeCount = 1;
        //cout<<"ScopeTable# "<<current->getId()<<" created"<<endl<<endl;
    }

    ~SymbolTable(){
        ScopeTable* tmp = current;
        while(tmp != nullptr){
            ScopeTable* next = tmp->parent_scope;
            //cout<<"ScopeTable# "<<tmp->getId()<<" removed"<<endl<<endl;
            delete tmp;
            tmp = next;
        }
    }

    void Enter_scope(){
        ScopeTable *scopeTable = new ScopeTable(totalBuckets,hash_func,out,current);
        scopeCount++;
        scopeTable->setId(scopeCount);
        current = scopeTable;
        //cout<<"ScopeTable# "<<current->getId()<<" created"<<endl<<endl;
    }

    void Remove_scope(){
        ScopeTable* tmp = current;
        current = current->parent_scope;
        //cout<<"ScopeTable# "<<tmp->getId()<<" removed"<<endl<<endl;
        collision_ratio += (double)tmp->getCollisions() / totalBuckets;
        //PrintAllScopeTable();
        delete tmp;
    }

    bool Insert(string name,string type, SymbolAdditionalInfo additionalInfo){
        return current->Insert(name,type, additionalInfo);
    }

    bool InsertInParent(string name, string type, SymbolAdditionalInfo additionalInfo){
        if(current->parent_scope == nullptr){
            //cout<<"Cannot insert in parent scope as there is no parent scope"<<endl<<endl;
            return false;
        }
        return current->parent_scope->Insert(name,type, additionalInfo);
    }

    bool Remove(string name){
        bool removed = current->Delete(name);
        return removed;
    }

    SymbolInfo* LookUp(string name){
        ScopeTable *tmp = current;
        while(tmp!=nullptr){
            SymbolInfo *obj = tmp->LookUp(name);
            if(obj != nullptr){
                return obj;
            }
            tmp = tmp->parent_scope;
        }
        //cout<<"'"<<name<<"'"<<" not found in any of the ScopeTables"<<endl<<endl;
        return nullptr;
    }

    SymbolInfo* LookUp2(string name){
        SymbolInfo *obj = current->LookUp(name);
        return obj;
    }

    void PrintCurrentScopeTable(){
        current->printTable(1);
    }

    void PrintAllScopeTable(){
        ScopeTable *tmp = current;
        int tabcnt = 1;
        while(tmp != nullptr){
            tmp->printTable(tabcnt);
            tmp = tmp->parent_scope;
            tabcnt++;
        }
        //cout<<endl;
        out<<endl<<endl<<endl<<endl;
    }

    double getMeanCollisionRatio(){
        double total_ratio = this->collision_ratio;
        ScopeTable *tmp = current;
        while(tmp != nullptr){
            total_ratio += (double)tmp->getCollisions() / totalBuckets;
            tmp = tmp->parent_scope;
        }
        return scopeCount > 0 ? total_ratio / scopeCount : 0.0;
    }
};

#endif // SYMBOL_TABLE_HPP
