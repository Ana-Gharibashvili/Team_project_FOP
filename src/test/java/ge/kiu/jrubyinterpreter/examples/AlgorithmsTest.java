package ge.kiu.jrubyinterpreter.examples;

import ge.kiu.jrubyinterpreter.ast.ReadNode;
import ge.kiu.jrubyinterpreter.interpreter.Interpreter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlgorithmsTest {
    private Interpreter interpreter;
    private Queue<String> testInputs;

    @BeforeEach
    void setUp() {
        interpreter = new Interpreter();
        testInputs = new LinkedList<>();
        ReadNode.setInputSupplier(() -> {
            String input = testInputs.poll();
            if (input == null) {
                throw new RuntimeException("No more test inputs available");
            }
            return input;
        });
    }

    @AfterEach
    void cleanup() {
        ReadNode.resetInputSupplier();
    }

    @Test
    void testSumOfFirstNNumbers() {
        testInputs.add("5");
        String program = """
            n = read
            sum = 0
            i = 1
            while i <= n
                sum = sum + i
                i = i + 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(15.0, interpreter.getContext().getVariable("sum")); // 1+2+3+4+5 = 15
    }

    @Test
    void testFactorial() {
        testInputs.add("5");
        String program = """
            n = read
            result = 1
            while n > 0
                result = result * n
                n = n - 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(120.0, interpreter.getContext().getVariable("result")); // 5! = 120
    }

    @Test
    void testGCD() {
        testInputs.add("48");
        testInputs.add("18");
        String program = """
            a = read
            b = read
            while b != 0
                temp = b
                b = a % b
                a = temp
            end
            """;
        interpreter.interpret(program);
        assertEquals(6.0, interpreter.getContext().getVariable("a")); // GCD(48,18) = 6
    }

    @Test
    void testReverseNumber() {
        testInputs.add("12345");
        String program = """
            n = read
            reversed = 0
            while n > 0
                digit = n % 10
                reversed = reversed * 10 + digit
                n = n / 10
            end
            """;
        interpreter.interpret(program);
        assertEquals(54321.0, interpreter.getContext().getVariable("reversed"));
    }

    @Test
    void testIsPrime() {
        testInputs.add("17"); // Prime number
        String program = """
            n = read
            isPrime = 1
            i = 2
            while i < n
                if n % i == 0
                    isPrime = 0
                end
                i = i + 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(1.0, interpreter.getContext().getVariable("isPrime"));

        // Test non-prime number
        interpreter = new Interpreter();
        testInputs.add("15"); // Non-prime number
        interpreter.interpret(program);
        assertEquals(0.0, interpreter.getContext().getVariable("isPrime"));
    }

    @Test
    void testIsPalindrome() {
        testInputs.add("12321"); // Palindrome
        String program = """
            n = read
            original = n
            reversed = 0
            while n > 0
                digit = n % 10
                reversed = reversed * 10 + digit
                n = n / 10
            end
            isPalindrome = 0
            if original == reversed
                isPalindrome = 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(1.0, interpreter.getContext().getVariable("isPalindrome"));

        // Test non-palindrome
        interpreter = new Interpreter();
        testInputs.add("12345"); // Non-palindrome
        interpreter.interpret(program);
        assertEquals(0.0, interpreter.getContext().getVariable("isPalindrome"));
    }

    @Test
    void testLargestDigit() {
        testInputs.add("12945");
        String program = """
            n = read
            largest = 0
            while n > 0
                digit = n % 10
                if digit > largest
                    largest = digit
                end
                n = n / 10
            end
            """;
        interpreter.interpret(program);
        assertEquals(9.0, interpreter.getContext().getVariable("largest"));
    }

    @Test
    void testSumOfDigits() {
        testInputs.add("12345");
        String program = """
            n = read
            sum = 0
            while n > 0
                digit = n % 10
                sum = sum + digit
                n = n / 10
            end
            """;
        interpreter.interpret(program);
        assertEquals(15.0, interpreter.getContext().getVariable("sum")); // 1+2+3+4+5 = 15
    }

    @Test
    void testMultiplicationTable() {
        testInputs.add("5");
        String program = """
            n = read
            i = 1
            results = 0
            while i <= 3
                results = n * i
                i = i + 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(15.0, interpreter.getContext().getVariable("results")); // 5 * 3 = 15
    }

    @Test
    void testFibonacci() {
        testInputs.add("6"); // 6th Fibonacci number
        String program = """
            n = read
            a = 0
            b = 1
            i = 1
            while i <= n
                if i <= 2
                    result = i - 1
                else
                    result = a + b
                    a = b
                    b = result
                end
                i = i + 1
            end
            """;
        interpreter.interpret(program);
        assertEquals(5.0, interpreter.getContext().getVariable("result")); // 6th Fibonacci = 5
    }

    @Test
    void testInvalidInput() {
        testInputs.add("abc"); // Invalid numeric input
        String program = "n = read";
        assertThrows(RuntimeException.class, () -> interpreter.interpret(program));
    }

    @Test
    void testNoMoreInputs() {
        String program = "n = read";
        assertThrows(RuntimeException.class, () -> interpreter.interpret(program));
    }
} 