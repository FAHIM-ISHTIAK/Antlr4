#ifndef HASH_HPP
#define HASH_HPP

#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>
#include <cctype>
#include <cstring>
#include <cstdlib>

using namespace std;

inline unsigned int sdbm_hash(const char *p, int bucket_size)
{
    unsigned int hash = 0;
    auto *str = (unsigned char *)p;
    int c{};
    while ((c = *str++))
    {
        hash = c + (hash << 6) + (hash << 16) - hash;
    }
    return hash % bucket_size;
}

inline unsigned int djb2_hash(const char *str, int bucket_size)
{
    unsigned long long hash = 5381;
    for (int i = 0; i < strlen(str); i++)
    {
        int c = str[i];
        hash = ((hash << 5) + hash) + c; // hash * 33 + c
        hash = hash % bucket_size;
    }
    return hash;
}

inline unsigned int fnv1a_hash(const char *str, int bucket_size)
{
    unsigned long long hash = 14695981039346656037ULL;
    const unsigned long long fnv_prime = 1099511628211ULL;
    for (int i = 0; i < strlen(str); i++)
    {
        int c = str[i];
        hash ^= c;
        hash *= fnv_prime;
        hash = hash % bucket_size;
    }
    return hash;
}

// Function pointer type for hash functions
typedef unsigned int (*HashFunction)(const char*, int);

// Function to select hash function based on command-line argument
inline HashFunction select_hash_function(string hash_name)
{
    transform(hash_name.begin(), hash_name.end(), hash_name.begin(), ::tolower); // Convert to lowercase
    if (hash_name == "djb2")
    {
        return djb2_hash;
    }
    else if (hash_name == "fnv1a")
    {
        return fnv1a_hash;
    }
    else
    {
        return sdbm_hash; // Default to SDBM
    }
}

#endif // HASH_HPP
