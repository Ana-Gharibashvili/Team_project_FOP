package ge.kiu.jrubyinterpreter.ast;

import java.util.Scanner;
import java.util.function.Supplier;

public class ReadNode implements Node {
    private static Scanner scanner = new Scanner(System.in);
    private static Supplier<String> inputSupplier = () -> scanner.nextLine().trim();

    public static void setInputSupplier(Supplier<String> supplier) {
        inputSupplier = supplier;
    }

    public static void resetInputSupplier() {
        inputSupplier = () -> scanner.nextLine().trim();
    }

    @Override
    public Object evaluate() {
        try {
            String input = inputSupplier.get();
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input: expected a number");
        }
    }
} 