# Ruby-like Interpreter

A simple interpreter implementation that supports a subset of Ruby-like syntax. This interpreter includes basic programming constructs and can execute simple algorithms.

## Features

- Basic arithmetic operations (+, -, *, /, %)
- Variable assignments
- Control flow structures (if/else, while)
- Input/Output operations (print, read)
- Interactive REPL (Read-Eval-Print Loop)
- Script file execution
- String support
- Error handling

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Building and Running

### Building the Project

```bash
mvn clean package
```

### Running the Interpreter

1. Interactive REPL mode:
```bash
java -jar target/ruby-interpreter-1.0-SNAPSHOT-jar-with-dependencies.jar
```

2. Run example algorithms:
```bash
java -jar target/ruby-interpreter-1.0-SNAPSHOT-jar-with-dependencies.jar --examples
```

3. Execute a script file:
```bash
java -jar target/ruby-interpreter-1.0-SNAPSHOT-jar-with-dependencies.jar script.rb
```

## Language Syntax

### Variables and Arithmetic
```ruby
x = 5
y = x * 2 + 1
z = (x + y) * 3
```

### Control Structures
```ruby
if x > 3
    print "x is greater than 3"
else
    print "x is less than or equal to 3"
end

while x > 0
    print x
    x = x - 1
end
```

### Input/Output
```ruby
print "Enter a number: "
n = read
print "You entered: "
print n
```

## Implemented Algorithms

1. Sum of First N Numbers
```ruby
print "Enter N: "
n = read
sum = 0
i = 1
while i <= n
    sum = sum + i
    i = i + 1
end
print sum
```

2. Factorial
```ruby
print "Enter N: "
n = read
result = 1
while n > 0
    result = result * n
    n = n - 1
end
print result
```

3. GCD (Greatest Common Divisor)
```ruby
print "Enter first number: "
a = read
print "Enter second number: "
b = read
while b != 0
    temp = b
    b = a % b
    a = temp
end
print a
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── interpreter/
│   │           ├── ast/           # Abstract Syntax Tree nodes
│   │           ├── lexer/         # Lexical analysis
│   │           ├── parser/        # Syntax parsing
│   │           ├── interpreter/   # Core interpreter
│   │           ├── repl/          # Interactive REPL
│   │           ├── runner/        # Script file runner
│   │           └── examples/      # Example algorithms
│   └── resources/
│       └── log4j2.xml            # Logging configuration
└── test/
    ├── java/
    │   └── com/
    │       └── interpreter/
    │           └── tests/         # Unit tests
    └── resources/
        └── log4j2-test.xml       # Test logging configuration
```

## Error Handling

The interpreter provides meaningful error messages for:

1. Syntax Errors
```
Error: Unexpected character: @ at line 1, column 5
Error: Unterminated string at line 1, column 1
```

2. Runtime Errors
```
Error: Division by zero
Error: Variable not found: undefined_var
```

3. Input/Output Errors
```
Error: Invalid input: expected a number
Error: No more test inputs available
```

## Testing

Run the test suite:
```bash
mvn test
```

The project includes comprehensive tests for:
- Lexer (tokenization)
- Parser (syntax analysis)
- Interpreter (execution)
- Example algorithms
- Error handling
