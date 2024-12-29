# Team_project_FOP

   Ruby is a high-level programming language that is known for being simple and easy to use. It was created with the goal of making programming enjoyable and productive,
   so it's easy to read and understand. Ruby supports different ways of writing code, such as object-oriented, procedural and functional programming. It's especially popular in web
   development, largely because of the Ruby on Rails framework which helps developers build web apps quickly. 
   
   
   While Ruby is a powerful and versatile language, its core strengths can be better understood by examining minimal language subsets. A minimal subset focuses on a small but 
   essential portion of the language's features. This approach makes it easier to understand how the language executes basic instructions, manages control flow, and handles 
   variables. By working with a minimal subset, developers can build a solid foundation before diving into Ruby's more complex features.

   To effectively demonstrate the interpreter's capabilities, we defined a minimal subset of Ruby with essential features like variable assignment, arithmetic operations, 
   conditional statements, loops, and optional I/O operations. By excluding recursion, function calls, and arrays, the subset stays focused and clear, making it ideal for 
   demonstrating core programming principles. Using this subset, we implemented ten algorithms to showcase control flow, iteration, and arithmetic processing. 

   As our first algorithm, we have a method which calculates the sum of all natural numbers from 1 to n. At first, we handle errors by checking if n is negative; if so, it 
   displays an error message and returns 0. We also demonstrate variable assignment by initializing sum to 0 and i to 1. It then performs arithmetic operations 
   using sum += i to add i to sum and i += 1 to increment i by 1 on every iteration. With while loop, we iterate through the numbers from 1 to n, 
   then add each value of i to sum. Once we finish loop, we use puts for input/output and handle errors by returning 0 if the input is invalid.

   For the second algorithm, it calculates the factorial of a number by multiplying all integers from 1 to the given number. It starts by taking user input, ensuring it’s a valid,
   non-negative number. If the input is valid, it initializes the factorial as 1 and uses a while loop to multiply the factorial by each number down to 1. After the calculation,
   it outputs the result. For the variable assignment, the program uses the = operator to assign values like n = 'input.to_i' and 'factorial = 1'. Also we have to use arithmetic operations, 
   which this program definitely includes. It uses * for multiplication, which is 'factorial *= n' and - for subtraction, which is 'n -= 1'. This program also using conditionals, as we see, 
   an if statement checks that if the input is negative, show the error message. Otherwise, it proceeds to calculate the factorial. For the loops, we use while loop which runs the calculation 
   until n becomes 0. And finally we made the end and for the I/O, the program uses 'gets.chomp' to capture user input and 'puts' to display the result.

   As our third algorithm, we have gcd of two numbers, which calculates greatest common divisor of two numbers by using Euclidean algorithm. We start by error handling, 
  which checks if number is zero and displays an error message if it is true. We also use variable assignment by setting a and b to the user's input. 
  The method performs arithmetic operations by using the modulo operator to update a and b on every iteration. A while loop continues until b becomes zero, 
  at which point the result is stored in a. Finally, I/O is handled with puts to print the result.

  As our fifth algorithm, we determine if a given number N is prime. We start with error handling, which checks if the number is less than or equal to 1, in which case it 
 returns false because prime numbers must be greater than 1. We also use for loop to iterate through numbers from 2 to the square root of n, which checks if n is divisible 
 by any of them. If this happens, it returns false. If no divisors are found, it returns true, which means that n is prime. The algorithm also involves arithmetic operations 
 with the modulo operator (%) to check divisibility and uses I/O to print the result.

  
