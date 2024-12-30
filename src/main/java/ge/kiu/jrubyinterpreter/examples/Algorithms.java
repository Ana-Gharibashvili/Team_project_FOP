package ge.kiu.jrubyinterpreter.examples;

import ge.kiu.jrubyinterpreter.ast.ReadNode;
import ge.kiu.jrubyinterpreter.interpreter.Interpreter;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithms {
    private final Interpreter interpreter;
    private final Queue<String> testInputs;

    public Algorithms() {
        this.interpreter = new Interpreter();
        this.testInputs = new LinkedList<>();
        setupTestInputs();
        ReadNode.setInputSupplier(() -> {
            String input = testInputs.poll();
            if (input == null) {
                throw new RuntimeException("No more test inputs available");
            }
            System.out.println(input); // Echo the input
            return input;
        });
    }

    private void setupTestInputs() {
        // Add test inputs for each algorithm
        testInputs.add("5");  // Sum of First N Numbers
        testInputs.add("5");  // Factorial
        testInputs.add("48"); // GCD - first number
        testInputs.add("18"); // GCD - second number
        testInputs.add("12345"); // Reverse Number
        testInputs.add("17");    // Prime Number Check
        testInputs.add("12321"); // Palindrome Check
        testInputs.add("12345"); // Largest Digit
        testInputs.add("12345"); // Sum of Digits
        testInputs.add("5");     // Multiplication Table
        testInputs.add("6");     // Fibonacci
    }

    public void sumOfFirstNNumbers() {
        String program = """
            print 'Enter N: '
            n = read
            sum = 0
            i = 1
            while i <= n
                sum = sum + i
                i = i + 1
            end
            print 'Sum of first N numbers is: '
            print sum
            """;
        interpreter.interpret(program);
    }

    public void factorial() {
        String program = """
            print 'Enter N: '
            n = read
            result = 1
            while n > 0
                result = result * n
                n = n - 1
            end
            print 'Factorial is: '
            print result
            """;
        interpreter.interpret(program);
    }

    public void gcd() {
        String program = """
            print 'Enter first number: '
            a = read
            print 'Enter second number: '
            b = read
            while b != 0
                temp = b
                b = a % b
                a = temp
            end
            print 'GCD is: '
            print a
            """;
        interpreter.interpret(program);
    }

    public void reverseNumber() {
        String program = """
            print 'Enter a number: '
            n = read
            reversed = 0
            while n > 0
                digit = n % 10
                reversed = reversed * 10 + digit
                n = n / 10
            end
            print 'Reversed number is: '
            print reversed
            """;
        interpreter.interpret(program);
    }

    public void isPrime() {
        String program = """
            print 'Enter a number: '
            n = read
            isPrime = 1
            i = 2
            while i < n
                if n % i == 0
                    isPrime = 0
                end
                i = i + 1
            end
            print 'Is prime (1=yes, 0=no): '
            print isPrime
            """;
        interpreter.interpret(program);
    }

    public void isPalindrome() {
        String program = """
            print 'Enter a number: '
            n = read
            original = n
            reversed = 0
            while n > 0
                digit = n % 10
                reversed = reversed * 10 + digit
                n = n / 10
            end
            if original == reversed
                print 'Number is palindrome'
            else
                print 'Number is not palindrome'
            end
            """;
        interpreter.interpret(program);
    }

    public void largestDigit() {
        String program = """
            print 'Enter a number: '
            n = read
            largest = 0
            while n > 0
                digit = n % 10
                if digit > largest
                    largest = digit
                end
                n = n / 10
            end
            print 'Largest digit is: '
            print largest
            """;
        interpreter.interpret(program);
    }

    public void sumOfDigits() {
        String program = """
            print 'Enter a number: '
            n = read
            sum = 0
            while n > 0
                digit = n % 10
                sum = sum + digit
                n = n / 10
            end
            print 'Sum of digits is: '
            print sum
            """;
        interpreter.interpret(program);
    }

    public void multiplicationTable() {
        String program = """
            print 'Enter a number: '
            n = read
            i = 1
            while i <= 10
                result = n * i
                print result
                i = i + 1
            end
            """;
        interpreter.interpret(program);
    }

    public void fibonacci() {
        String program = """
            print 'Enter N: '
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
            print 'Nth Fibonacci number is: '
            print result
            """;
        interpreter.interpret(program);
    }

    public void cleanup() {
        ReadNode.resetInputSupplier();
    }
} 