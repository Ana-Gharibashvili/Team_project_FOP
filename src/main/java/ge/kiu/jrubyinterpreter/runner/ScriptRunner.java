package ge.kiu.jrubyinterpreter.runner;

import ge.kiu.jrubyinterpreter.interpreter.Interpreter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;

public class ScriptRunner {
    private static final Logger logger = LogManager.getLogger(ScriptRunner.class);
    private final Interpreter interpreter;

    public ScriptRunner() {
        this.interpreter = new Interpreter();
    }

    public void runFile(String filePath) {
        try {
            String content = Files.readString(Path.of(filePath));
            interpreter.interpret(content);
        } catch (Exception e) {
            logger.error("Error running script: {}", filePath, e);
            System.err.println("Error running script: " + e.getMessage());
        }
    }
} 