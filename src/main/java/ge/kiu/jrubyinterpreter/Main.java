package ge.kiu.jrubyinterpreter;

import ge.kiu.jrubyinterpreter.examples.Algorithms;
import ge.kiu.jrubyinterpreter.repl.RubyREPL;
import ge.kiu.jrubyinterpreter.runner.ScriptRunner;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            // Interactive REPL mode
            RubyREPL repl = new RubyREPL();
            repl.run();
        } else if (args[0].equals("--examples")) {
            // Run example algorithms
            runExamples();
        } else {
            // Run script file
            ScriptRunner runner = new ScriptRunner();
            runner.runFile(args[0]);
        }
    }

    private static void runExamples() {
        Algorithms algorithms = new Algorithms();

        System.out.println("Testing all algorithms:");

        System.out.println("\n1. Sum of First N Numbers:");
        algorithms.sumOfFirstNNumbers();

        System.out.println("\n2. Factorial:");
        algorithms.factorial();

        System.out.println("\n3. GCD:");
        algorithms.gcd();

        System.out.println("\n4. Reverse Number:");
        algorithms.reverseNumber();

        System.out.println("\n5. Prime Number Check:");
        algorithms.isPrime();

        System.out.println("\n6. Palindrome Check:");
        algorithms.isPalindrome();

        System.out.println("\n7. Largest Digit:");
        algorithms.largestDigit();

        System.out.println("\n8. Sum of Digits:");
        algorithms.sumOfDigits();

        System.out.println("\n9. Multiplication Table:");
        algorithms.multiplicationTable();

        System.out.println("\n10. Fibonacci Number:");
        algorithms.fibonacci();
    }
    
}
