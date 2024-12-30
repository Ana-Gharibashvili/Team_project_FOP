package ge.kiu.jrubyinterpreter.lexer;

public enum TokenType {
    // Keywords
    IF, ELSE, WHILE, END, PRINT, READ,
    
    // Operators
    PLUS, MINUS, MULTIPLY, DIVIDE, MODULO,
    ASSIGN, EQUALS, NOT_EQUALS,
    GREATER_THAN, LESS_THAN,
    GREATER_THAN_EQUALS, LESS_THAN_EQUALS,
    
    // Other tokens
    IDENTIFIER, NUMBER, STRING,
    LEFT_PAREN, RIGHT_PAREN,
    NEWLINE,
    
    // Special tokens
    EOF
} 