#!/bin/bash
if [ "$#" -eq "1" ]
then
    echo "running $1.java"
    java --module-path $PATH_TO_FX --add-modules javafx.controls --enable-native-access=javafx.graphics -cp out $1
else
    echo "enter the target java class as an argument. only takes one argument"
    exit 1
fi

