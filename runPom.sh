#!/bin/bash


mvn compile -f pom.xml

mvn exec:java -f pom.xml -Dexec.args="data/input0.txt"
