#Language Subset Documentation

This document defines Ruby subset for Java interpreter

 ## 1. Variable Assignment
-Variables are assigned values using the = operator.

-syntax : variable_name = expression;

example: x = 5 

y = 10 

## 2. Arithmetic Operations
 -Interpreter Supports '+', '-' , '*', '/', '%' basic arithmetic operations
 
example: sum = 5 + 10;

multiply = a*2;

division = a/2;

difference = a-b;

## 3. Conditionals (if , else statements)
-Interpreter supports if, else conditional statements

-Conditions are evaluate boolean values (true or false)

example:  Conditionals
           
          if x > y
           puts "x is greater"
          else
           puts "y is greater"
          end

## 4. Loops (while loop)
-Iterative Control Flow 

-While loop executes statement inside the block repeatedly as long as the condition is 'true'.

-Syntax : while

example:

     i = 0
     while i < 5
       puts i           
       i = i+1
      end

## 5. Input/Output, Print statements
-Syntax: PRINT(EXPRESSION), gets, puts

-The gets function is used for  input

-The puts function is used for output to the console

-Print does same as puts, just prints the value of the expression but difference is just like in java print and println

example input/output

(chomp is a method to remove the blank line after the users input)
     
             name = gets.chomp 
             puts "Hello, Mandalorian!"

example print 
          print "Hello, Mandalorian"

## Syntax of the subset

as you see parser will support following expressions
 
- Variables
- Arithmetic Operations
- Conditionals (if, else) 
- Loops (While)
- Input/Output gets and puts
- Print

P.S comments are with #comment, also =begin (here will go as many comments as u want so u dont have to put # in front of evertyhing ) =end
 
## Example Ruby Program Using the Subset

 I will show you simple ruby program using the given subset

        #calculating factorial
        
        puts "Enter number"
        input = gets.chomp
        
        number = input.to_i  #converting the input to an integer
        
        if number < 0
          puts "enter only positive numbers"
        else
           factorial = 1

        while number > 0 
        factorial *= number
        number -= 1
       end 

      The factorial is #{factorial}
     end
 
side node #{variable} this tool is for replacing variable with the value. simple stuff you know

## ERROR HANDLING (basic syntax error detection)
   The Interpreter will detect basic syntax errors like
    
-  Invalid syntax in expressions: if a statement doesn't follow the correct syntax, the interpreter should display an error message
-  Undefined variable: if variable is used before assigned a value 
-  Division by zero: should display error message like error: division by zero

## Some examples about what we expect from interpreter

example a (while loop)
 
         x = 0
        while x < 5
         puts x
          x += 1
        end  # expected output 1,2,3,4,5

  
example b (error handling)
          
            a = 10
            b = 10 
            result = a/b 
             #expected output :  error: division by zero


     
          
           
        
 
