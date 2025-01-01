package ge.kiu.jrubyinterpreter;

import ge.kiu.jrubyinterpreter.interpreter.Interpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpreterTest {
    private Interpreter interpreter;

    @BeforeEach
    void setUp() {
        interpreter = new Interpreter();
    }

    @Test
    void testArithmeticOperations() {
        assertEquals(15.0, interpreter.interpret("5 + 2 * 5"));
        assertEquals(35.0, interpreter.interpret("(5 + 2) * 5"));
        assertEquals(2.0, interpreter.interpret("10 % 4"));
    }

    @Test
    void testVariableAssignment() {
        interpreter.interpret("x = 5");
        assertEquals(5.0, interpreter.getContext().getVariable("x"));
        
        interpreter.interpret("y = x + 3");
        assertEquals(8.0, interpreter.getContext().getVariable("y"));
    }

    @Test
    void testIfStatement() {
        String program = """
            x = 10
            if x > 5
                y = 1
            else
                y = 2
            end
            """;
        interpreter.interpret(program);
        assertEquals(1.0, interpreter.getContext().getVariable("y"));
    }

    @Test
    void testWhileLoop() {
        String program = """
            sum = 0
            i = 1
            while i <= 5
                sum = sum + i
                i = i + 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(15.0, interpreter.getContext().getVariable("sum"));
    }

    @Test
    void testFactorial() {
        String program = """
            n = 5
            result = 1
            while n > 0
                result = result * n
                n = n - 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(120.0, interpreter.getContext().getVariable("result"));
    }

    @Test
    void testGCD() {
        String program = """
            a = 48
            b = 18
            while b != 0
                temp = b
                b = a % b
                a = temp
            end
            """;
        interpreter.interpret(program);
        assertEquals(6.0, interpreter.getContext().getVariable("a"));
    }
} 