#!/bin/sh
find . -name "*.java" > sources.txt
javac @sources.txt
java com.simulator.Simulator scenario.txt