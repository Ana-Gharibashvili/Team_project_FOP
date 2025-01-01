package ge.kiu.jrubyinterpreter.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private final Map<String, Object> variables;

    public Context() {
        this.variables = new HashMap<>();
    }

    public void setVariable(String name, Object value) {
        variables.put(name, value);
    }

    public Object getVariable(String name) {
        if (!variables.containsKey(name)) {
            throw new RuntimeException("Variable not found: " + name);
        }
        return variables.get(name);
    }
} 