#!/bin/bash
if [ "$#" -eq "1" ]
then
    echo "Compiling $1.java"
    javac -g -d out src/$1.java
else
    echo "enter the target java class as an argument. only takes one argument"
    exit 1
fi
