package ge.kiu.jrubyinterpreter.lexer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lexer {
    private static final Logger logger = LogManager.getLogger(Lexer.class);
    private final String input;
    private int position;
    private int line;
    private int column;
    private static final Map<String, TokenType> KEYWORDS;

    static {
        KEYWORDS = new HashMap<>();
        KEYWORDS.put("if", TokenType.IF);
        KEYWORDS.put("else", TokenType.ELSE);
        KEYWORDS.put("while", TokenType.WHILE);
        KEYWORDS.put("end", TokenType.END);
        KEYWORDS.put("print", TokenType.PRINT);
        KEYWORDS.put("read", TokenType.READ);
    }

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
        this.line = 1;
        this.column = 1;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            
            if (Character.isWhitespace(currentChar)) {
                if (currentChar == '\n') {
                    tokens.add(new Token(TokenType.NEWLINE, "\n", line, column));
                    line++;
                    column = 1;
                } else {
                    column++;
                }
                position++;
                continue;
            }

            if (Character.isDigit(currentChar)) {
                tokens.add(tokenizeNumber());
                continue;
            }

            if (Character.isLetter(currentChar)) {
                tokens.add(tokenizeIdentifier());
                continue;
            }

            if (currentChar == '\'' || currentChar == '"') {
                tokens.add(tokenizeString());
                continue;
            }

            Token operatorToken = tokenizeOperator();
            if (operatorToken != null) {
                tokens.add(operatorToken);
                continue;
            }

            throw new RuntimeException(String.format("Unexpected character: %c at line %d, column %d", 
                currentChar, line, column));
        }

        tokens.add(new Token(TokenType.EOF, "", line, column));
        return tokens;
    }

    private Token tokenizeNumber() {
        StringBuilder number = new StringBuilder();
        int startColumn = column;
        
        while (position < input.length() && Character.isDigit(input.charAt(position))) {
            number.append(input.charAt(position));
            position++;
            column++;
        }
        
        return new Token(TokenType.NUMBER, number.toString(), line, startColumn);
    }

    private Token tokenizeIdentifier() {
        StringBuilder identifier = new StringBuilder();
        int startColumn = column;
        
        while (position < input.length() && 
               (Character.isLetterOrDigit(input.charAt(position)) || input.charAt(position) == '_')) {
            identifier.append(input.charAt(position));
            position++;
            column++;
        }
        
        String identifierStr = identifier.toString();
        TokenType type = KEYWORDS.getOrDefault(identifierStr, TokenType.IDENTIFIER);
        return new Token(type, identifierStr, line, startColumn);
    }

    private Token tokenizeOperator() {
        int startColumn = column;
        char currentChar = input.charAt(position);
        
        switch (currentChar) {
            case '+':
                position++;
                column++;
                return new Token(TokenType.PLUS, "+", line, startColumn);
            case '-':
                position++;
                column++;
                return new Token(TokenType.MINUS, "-", line, startColumn);
            case '*':
                position++;
                column++;
                return new Token(TokenType.MULTIPLY, "*", line, startColumn);
            case '/':
                position++;
                column++;
                return new Token(TokenType.DIVIDE, "/", line, startColumn);
            case '%':
                position++;
                column++;
                return new Token(TokenType.MODULO, "%", line, startColumn);
            case '=':
                position++;
                column++;
                if (position < input.length() && input.charAt(position) == '=') {
                    position++;
                    column++;
                    return new Token(TokenType.EQUALS, "==", line, startColumn);
                }
                return new Token(TokenType.ASSIGN, "=", line, startColumn);
            case '!':
                position++;
                column++;
                if (position < input.length() && input.charAt(position) == '=') {
                    position++;
                    column++;
                    return new Token(TokenType.NOT_EQUALS, "!=", line, startColumn);
                }
                throw new RuntimeException(String.format("Expected '=' after '!' at line %d, column %d", 
                    line, startColumn));
            case '<':
                position++;
                column++;
                if (position < input.length() && input.charAt(position) == '=') {
                    position++;
                    column++;
                    return new Token(TokenType.LESS_THAN_EQUALS, "<=", line, startColumn);
                }
                return new Token(TokenType.LESS_THAN, "<", line, startColumn);
            case '>':
                position++;
                column++;
                if (position < input.length() && input.charAt(position) == '=') {
                    position++;
                    column++;
                    return new Token(TokenType.GREATER_THAN_EQUALS, ">=", line, startColumn);
                }
                return new Token(TokenType.GREATER_THAN, ">", line, startColumn);
            case '(':
                position++;
                column++;
                return new Token(TokenType.LEFT_PAREN, "(", line, startColumn);
            case ')':
                position++;
                column++;
                return new Token(TokenType.RIGHT_PAREN, ")", line, startColumn);
            default:
                return null;
        }
    }

    private Token tokenizeString() {
        char quote = input.charAt(position);
        position++;
        column++;
        
        StringBuilder string = new StringBuilder();
        int startColumn = column;
        
        while (position < input.length() && input.charAt(position) != quote) {
            string.append(input.charAt(position));
            position++;
            column++;
        }
        
        if (position >= input.length()) {
            throw new RuntimeException(String.format("Unterminated string at line %d, column %d", 
                line, startColumn - 1));
        }
        
        // Skip closing quote
        position++;
        column++;
        
        return new Token(TokenType.STRING, string.toString(), line, startColumn);
    }
} 