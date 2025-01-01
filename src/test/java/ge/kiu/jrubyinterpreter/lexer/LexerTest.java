package ge.kiu.jrubyinterpreter.lexer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LexerTest {

    @Test
    void testArithmeticOperators() {
        Lexer lexer = new Lexer("2 + 3 - 4 * 5 / 6 % 7");
        List<Token> tokens = lexer.tokenize();
        
        TokenType[] expectedTypes = {
            TokenType.NUMBER, TokenType.PLUS, TokenType.NUMBER,
            TokenType.MINUS, TokenType.NUMBER, TokenType.MULTIPLY,
            TokenType.NUMBER, TokenType.DIVIDE, TokenType.NUMBER,
            TokenType.MODULO, TokenType.NUMBER, TokenType.EOF
        };
        
        String[] expectedValues = {
            "2", "+", "3", "-", "4", "*", "5", "/", "6", "%", "7", ""
        };
        
        assertTokens(tokens, expectedTypes, expectedValues);
    }

    @Test
    void testComparisonOperators() {
        Lexer lexer = new Lexer("x == y != z > w < v >= u <= t");
        List<Token> tokens = lexer.tokenize();
        
        TokenType[] expectedTypes = {
            TokenType.IDENTIFIER, TokenType.EQUALS, TokenType.IDENTIFIER,
            TokenType.NOT_EQUALS, TokenType.IDENTIFIER, TokenType.GREATER_THAN,
            TokenType.IDENTIFIER, TokenType.LESS_THAN, TokenType.IDENTIFIER,
            TokenType.GREATER_THAN_EQUALS, TokenType.IDENTIFIER,
            TokenType.LESS_THAN_EQUALS, TokenType.IDENTIFIER, TokenType.EOF
        };
        
        assertTokenTypes(tokens, expectedTypes);
    }

    @Test
    void testKeywords() {
        Lexer lexer = new Lexer("if else while end print read");
        List<Token> tokens = lexer.tokenize();
        
        TokenType[] expectedTypes = {
            TokenType.IF, TokenType.ELSE, TokenType.WHILE,
            TokenType.END, TokenType.PRINT, TokenType.READ, TokenType.EOF
        };
        
        assertTokenTypes(tokens, expectedTypes);
    }

    @Test
    void testStrings() {
        Lexer lexer = new Lexer("'hello' \"world\"");
        List<Token> tokens = lexer.tokenize();
        
        TokenType[] expectedTypes = {
            TokenType.STRING, TokenType.STRING, TokenType.EOF
        };
        
        String[] expectedValues = {"hello", "world", ""};
        
        assertTokens(tokens, expectedTypes, expectedValues);
    }

    @Test
    void testUnterminatedString() {
        Lexer lexer = new Lexer("'unterminated");
        assertThrows(RuntimeException.class, lexer::tokenize);
    }

    @Test
    void testNewlines() {
        Lexer lexer = new Lexer("x = 1\ny = 2\n");
        List<Token> tokens = lexer.tokenize();
        
        TokenType[] expectedTypes = {
            TokenType.IDENTIFIER, TokenType.ASSIGN, TokenType.NUMBER, TokenType.NEWLINE,
            TokenType.IDENTIFIER, TokenType.ASSIGN, TokenType.NUMBER, TokenType.NEWLINE,
            TokenType.EOF
        };
        
        assertTokenTypes(tokens, expectedTypes);
    }

    @Test
    void testInvalidCharacter() {
        Lexer lexer = new Lexer("x @ y");
        assertThrows(RuntimeException.class, lexer::tokenize);
    }

    private void assertTokenTypes(List<Token> tokens, TokenType[] expectedTypes) {
        assertEquals(expectedTypes.length, tokens.size(), "Wrong number of tokens");
        for (int i = 0; i < expectedTypes.length; i++) {
            assertEquals(expectedTypes[i], tokens.get(i).getType(),
                "Token at position " + i + " has wrong type");
        }
    }

    private void assertTokens(List<Token> tokens, TokenType[] expectedTypes, String[] expectedValues) {
        assertEquals(expectedTypes.length, tokens.size(), "Wrong number of tokens");
        for (int i = 0; i < expectedTypes.length; i++) {
            Token token = tokens.get(i);
            assertEquals(expectedTypes[i], token.getType(),
                "Token at position " + i + " has wrong type");
            assertEquals(expectedValues[i], token.getValue(),
                "Token at position " + i + " has wrong value");
        }
    }
} 