#!/bin/bash

./my-run.sh "$1"

g++ myoptimizer.cpp -o myoptimizer

./myoptimizer