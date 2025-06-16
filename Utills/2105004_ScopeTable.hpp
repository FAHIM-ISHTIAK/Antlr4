// #pragma once
#ifndef SCOPE_TABLE_HPP
#define SCOPE_TABLE_HPP
#include <string>

#include "2105004_SymbolInfo.hpp"
#include "2105004_hash.hpp"

using namespace std;

class ScopeTable
{
    SymbolInfo **hashTable;
    int bucketSize;
    int id;
    HashFunction hash_func; // Store the hash function pointer
    int collisions;
    string scope_id;
    int child_count;

public:
    ScopeTable *parent_scope;

    ScopeTable(int bucketSize, HashFunction hash_func, ScopeTable *parent_scope = nullptr)
    {
        if (bucketSize <= 0)
        {
            throw invalid_argument("Bucket size must be greater than zero.");
        }
        this->bucketSize = bucketSize;
        this->parent_scope = parent_scope;
        this->hash_func = hash_func; // Store the hash function
        this->collisions = 0;
        this->child_count = 0;
        if (parent_scope == nullptr)
        {
            this->scope_id = "1";
        }
        else
        {
            this->scope_id = parent_scope->getScopeId() + "." + to_string(parent_scope->getChildCount() + 1);
            parent_scope->setChildCount(parent_scope->getChildCount() + 1);
        }
        hashTable = new SymbolInfo *[bucketSize];
        for (int i = 0; i < bucketSize; i++)
        {
            hashTable[i] = nullptr;
        }
    }

    ~ScopeTable()
    {
        for (int i = 0; i < bucketSize; i++)
        {
            SymbolInfo *curr = hashTable[i];
            while (curr != nullptr)
            {
                SymbolInfo *tmp = curr;
                curr = curr->next;
                delete tmp;
            }
        }
        delete[] hashTable;
        parent_scope = nullptr; // Set parent_scope to nullptr to avoid dangling pointer
    }

    unsigned int getBucketIndex(string name)
    {
        return hash_func(name.c_str(), bucketSize) % this->bucketSize;
    }

    SymbolInfo *LookUp(string name, bool print = true)
    {
        int index = getBucketIndex(name.c_str());
        SymbolInfo *curr = hashTable[index];
        int position = 0;
        while (curr != nullptr)
        {
            position++;
            if (curr->getName() == name)
            {
                if (print)
                {
                    cout << "'" << name << "'" << " found in ScopeTable# " << this->id << " at position " << index + 1 << ", " << position << endl;
                }
                return curr;
            }
            curr = curr->next;
        }
        return nullptr;
    }
    SymbolInfo *LookUp2(string name, string type, bool print = true)
    {
        int index = getBucketIndex(name.c_str());
        SymbolInfo *curr = hashTable[index];
        int position = 0;
        while (curr != nullptr)
        {
            position++;
            if (curr->getName() == name)
            {
                if (print)
                {
                    cout<<"< "<<name<<" : "<<type<<" >"<<" already exists in ScopeTable# "<<this->getScopeId()<<" at position "<<index<<", "<<position - 1<<endl<<endl;
                }
                return curr;
            }
            curr = curr->next;
        }
        return nullptr;
    }

    bool Insert(string name, string type)
    {
        SymbolInfo *tmp = LookUp2(name.c_str(), type);
        int index = getBucketIndex(name);
        if (tmp == nullptr)
        {
            SymbolInfo *curr = hashTable[index];
            int position = 0;
            if (curr == nullptr)
            {
                hashTable[index] = new SymbolInfo(name, type, nullptr);
            }
            else
            {
                position = 1;
                while (curr->next != nullptr)
                {
                    curr = curr->next;
                    position++;
                }
                curr->next = new SymbolInfo(name, type, nullptr);
                collisions++;
            }
            //cout<<"Inserted in ScopeTable# "<<this->id<<" at position "<<index+1<<", "<<position+1<<endl<<endl;
            return true;
        }
        else
        {
            // cout<<"'"<<name<<"'"<<" already exists in ScopeTable#"<<this->getScopeId()<<" at position"<<endl<<endl;
            return false;
        }
    }

    bool Delete(string name)
    {
        SymbolInfo *tmp = LookUp(name.c_str(), false);
        int index = getBucketIndex(name);
        if (tmp != nullptr)
        {
            int position = 0;
            SymbolInfo *curr = hashTable[index];
            if (curr == tmp)
            {
                hashTable[index] = curr->next;
                delete tmp;
            }
            else
            {
                SymbolInfo *prev = nullptr;
                while (curr != tmp)
                {
                    prev = curr;
                    curr = curr->next;
                    position++;
                }
                prev->next = curr->next;
                delete tmp;
            }
            // cout<<"Deleted "<<"'"<<name<<"'"<<" from ScopeTable# "<<id<<" at position "<<index+1<<", "<<position+1<<endl<<endl;
            return true;
        }
        else
        {
            // cout<<"Not found in the current ScopeTable"<<endl<<endl;
            return false;
        }
    }

    void printTable(int tabcnt = 0)
    {
        string tabs = "";
        for (int i = 0; i < tabcnt; i++)
        {
            tabs += "\t";
        }
        cout << "ScopeTable # " << this->scope_id << endl;
        for (int i = 0; i < bucketSize; i++)
        {
            if (hashTable[i] == nullptr)
            {
                continue;
            }
            cout << i << " --> ";
            SymbolInfo *curr = hashTable[i];
            while (curr != nullptr)
            {
                cout << "< " << curr->getName() << " : " << curr->getType() << " >";
                curr = curr->next;
            }
            cout << endl;
        }
    }

    void setId(int id)
    {
        this->id = id;
    }

    int getId()
    {
        return id;
    }

    int getCollisions()
    {
        return collisions;
    }

    int getChildCount()
    {
        return child_count;
    }

    void setChildCount(int count)
    {
        this->child_count = count;
    }

    string getScopeId()
    {
        return scope_id;
    }
};

#endif // SCOPE_TABLE_HPP