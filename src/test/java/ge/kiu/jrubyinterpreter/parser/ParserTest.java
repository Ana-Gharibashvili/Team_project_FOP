package ge.kiu.jrubyinterpreter.parser;

import ge.kiu.jrubyinterpreter.ast.*;
import ge.kiu.jrubyinterpreter.interpreter.Context;
import ge.kiu.jrubyinterpreter.lexer.Lexer;
import ge.kiu.jrubyinterpreter.lexer.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {
    private Context context;

    @BeforeEach
    void setUp() {
        context = new Context();
    }

    @Test
    void testArithmeticExpression() {
        List<Node> nodes = parse("2 + 3 * 4");
        assertEquals(1, nodes.size());
        
        Object result = nodes.get(0).evaluate();
        assertEquals(14.0, result); // 2 + (3 * 4) = 14
    }

    @Test
    void testParenthesizedExpression() {
        List<Node> nodes = parse("(2 + 3) * 4");
        assertEquals(1, nodes.size());
        
        Object result = nodes.get(0).evaluate();
        assertEquals(20.0, result); // (2 + 3) * 4 = 20
    }

    @Test
    void testAssignment() {
        List<Node> nodes = parse("x = 5");
        assertEquals(1, nodes.size());
        
        nodes.get(0).evaluate();
        assertEquals(5.0, context.getVariable("x"));
    }

    @Test
    void testIfStatement() {
        List<Node> nodes = parse("""
            if 5 > 3
                x = 1
            else
                x = 2
            end
            """);
        
        nodes.get(0).evaluate();
        assertEquals(1.0, context.getVariable("x"));
    }

    @Test
    void testWhileStatement() {
        List<Node> nodes = parse("""
            x = 0
            while x < 3
                x = x + 1
            end
            """);
        
        for (Node node : nodes) {
            node.evaluate();
        }
        assertEquals(3.0, context.getVariable("x"));
    }

    @Test
    void testMissingEnd() {
        assertThrows(RuntimeException.class, () -> parse("""
            while x < 3
                x = x + 1
            """));
    }

    @Test
    void testInvalidExpression() {
        assertThrows(RuntimeException.class, () -> parse("1 + + 2"));
    }

    private List<Node> parse(String input) {
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        Parser parser = new Parser(tokens, context);
        return parser.parseProgram();
    }
} 