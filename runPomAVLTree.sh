#!/bin/bash

mvn compile -f pomAVLTree.xml

mvn exec:java -f pomAVLTree.xml -Dexec.args="data/inputAVLTree.txt"
