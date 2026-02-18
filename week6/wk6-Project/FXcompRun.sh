#!/bin/bash
if [ "$#" -eq "1" ]
then
    echo "Compiling $1.java"
    javac --module-path $PATH_TO_FX --add-modules javafx.controls -cp out -d out src/$1.java
    echo "Compilation done. Running $1"
    java --module-path $PATH_TO_FX --add-modules javafx.controls --enable-native-access=javafx.graphics -cp out $1
else
    echo "enter the target java class as an argument. only takes one argument"
    exit 1
fi

