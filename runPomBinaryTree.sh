#!/bin/bash

mvn compile -f pomBinaryTree.xml

mvn exec:java -f pomBinaryTree.xml -Dexec.args="data/inputBinaryTree.txt"
