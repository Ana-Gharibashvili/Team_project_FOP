package ge.kiu.jrubyinterpreter.interpreter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InterpreterTest {
    private Interpreter interpreter;

    @BeforeEach
    void setUp() {
        interpreter = new Interpreter();
    }

    @Test
    void testArithmeticOperations() {
        assertEquals(7.0, interpreter.interpret("3 + 4"));
        assertEquals(12.0, interpreter.interpret("3 * 4"));
        assertEquals(-1.0, interpreter.interpret("3 - 4"));
        assertEquals(2.0, interpreter.interpret("8 / 4"));
        assertEquals(2.0, interpreter.interpret("8 % 3"));
    }

    @Test
    void testVariableOperations() {
        interpreter.interpret("x = 5");
        assertEquals(5.0, interpreter.getContext().getVariable("x"));
        
        interpreter.interpret("y = x + 3");
        assertEquals(8.0, interpreter.getContext().getVariable("y"));
    }

    @Test
    void testComplexExpression() {
        Object result = interpreter.interpret("""
            x = 5
            y = 3
            z = (x + y) * 2
            """);
        assertEquals(16.0, interpreter.getContext().getVariable("z"));
    }

    @Test
    void testControlFlow() {
        interpreter.interpret("""
            x = 5
            if x > 3
                y = 1
            else
                y = 2
            end
            """);
        assertEquals(1.0, interpreter.getContext().getVariable("y"));
    }

    @Test
    void testLoopExecution() {
        interpreter.interpret("""
            sum = 0
            i = 1
            while i <= 5
                sum = sum + i
                i = i + 1
            end
            """);
        assertEquals(15.0, interpreter.getContext().getVariable("sum"));
    }

    @Test
    void testUndefinedVariable() {
        assertThrows(RuntimeException.class, () -> 
            interpreter.interpret("x = y + 1")
        );
    }

    @Test
    void testSyntaxError() {
        assertThrows(RuntimeException.class, () -> 
            interpreter.interpret("if x > 3 y = 1 end")
        );
    }

    @Test
    void testDivisionByZero() {
        assertThrows(RuntimeException.class, () -> 
            interpreter.interpret("x = 5 / 0")
        );
    }
} 