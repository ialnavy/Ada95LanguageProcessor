cls
java -jar "antlr\antlr-4.7.2-complete.jar" -no-listener -package parser src\parser\Ada95Lexer.g4
java -jar "antlr\antlr-4.7.2-complete.jar" -no-listener -package parser src\parser\Ada95Parser.g4

@echo off
del src\parser\*.tokens
del src\parser\*.interp
