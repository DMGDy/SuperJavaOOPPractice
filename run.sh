#!/usr/bin/env sh

PROJECT="CreateUserAccount"
SRC="src"
BIN="bin"

if [ ! -d ${BIN} ]; then
  echo "Creating directory ${BIN} for binary files"
  mkdir -p ${BIN}
fi

# compile project sources
echo "Compiling project ${PROJECT}..."
javac -d ${BIN} ${SRC}/*.java
printf "Compilation successful! now running...\n\n"

# run the build in jvm
java -cp ${BIN} ${PROJECT}
