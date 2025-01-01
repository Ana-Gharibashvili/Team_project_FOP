package ge.kiu.jrubyinterpreter.repl;

import ge.kiu.jrubyinterpreter.interpreter.Interpreter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RubyREPL {
    private static final Logger logger = LogManager.getLogger(RubyREPL.class);
    private final Interpreter interpreter;
    private final BufferedReader reader;
    private boolean isRunning;

    public RubyREPL() {
        this.interpreter = new Interpreter();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.isRunning = true;
    }

    public void run() {
        printWelcomeMessage();

        while (isRunning) {
            try {
                String input = readInput();
                if (input == null || input.equalsIgnoreCase("exit")) {
                    isRunning = false;
                    continue;
                }

                if (!input.trim().isEmpty()) {
                    Object result = interpreter.interpret(input);
                    if (result != null) {
                        System.out.println("=> " + result);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                logger.error("REPL error", e);
            }
        }

        System.out.println("\nGoodbye!");
    }

    private String readInput() {
        List<String> lines = new ArrayList<>();
        int indentLevel = 0;
        
        try {
            while (true) {
                System.out.print(indentLevel > 0 ? "... " : ">>> ");
                String line = reader.readLine();
                
                if (line == null) {
                    return null;
                }

                lines.add(line);

                // Check for block start/end
                if (line.trim().endsWith("end")) {
                    indentLevel--;
                    if (indentLevel == 0) {
                        break;
                    }
                } else if (isBlockStart(line)) {
                    indentLevel++;
                } else if (indentLevel == 0) {
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("Error reading input", e);
            return null;
        }

        return String.join("\n", lines);
    }

    private boolean isBlockStart(String line) {
        line = line.trim();
        return line.startsWith("if ") || 
               line.startsWith("while ") || 
               line.startsWith("def ");
    }

    private void printWelcomeMessage() {
        System.out.println("Ruby-like Interpreter v1.0");
        System.out.println("Type 'exit' to quit");
        System.out.println("Enter your code:");
    }
} 