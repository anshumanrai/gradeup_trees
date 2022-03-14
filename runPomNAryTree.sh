#!/bin/bash

mvn compile -f pomNAryTree.xml

mvn exec:java -f pomNAryTree.xml -Dexec.args="data/inputNAryTree.txt"
