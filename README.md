# Team_project_FOP

  For our project, we are working with Ruby, a high-level programming language designed to be simple, readable and enjoyable to use. Ruby supports different ways of writing code, such as
  object-oriented, procedural and functional programming. It's particularly well-known in web development, mainly due to the Ruby on Rails framework, which allows developers to build web 
  applications quickly and efficiently. In this project, we will design and implement a simple interpreter for a programming language. The project will focus on creating and supporting a minimal
  subset of the language with an emphasis on basic constructs like variables, arithmetic, conditionals and iterative control flow. The interpreter will be capable of executing simple algorithms,
  serving as a proof of its functionality. 
   
# Algorithms
   
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

  For the fourth algorithm, it reverses the digits of a given number. It takes user input as a string, converts it into an integer and checks if the number is valid. The program checks a validation. 
  If the number is negative, it tells the user to enter a positive number. But if it's valid number, then it proceeds to reverse the digits. By using a while loop, the last digit is extracted with
  the modulo operator '%' and added to the reversed number. The current digits in reversed are shifted left by multiplying by 10 and the number is reduced by dividing it by 10. Finally, the reversed 
  number is displayed. The program uses the = operator for variable assignment, arithmetic operations, like % and /, and an if statement to handle negative inputs. The while loop reverses the digits
  and for I/O, gets.chomp captures input and puts displays the result.

  As our fifth algorithm, we determine if a given number N is prime. We start with error handling, which checks if the number is less than or equal to 1, in which case it 
 returns false because prime numbers must be greater than 1. We also use for loop to iterate through numbers from 2 to the square root of n, which checks if n is divisible 
 by any of them. If this happens, it returns false. If no divisors are found, it returns true, which means that n is prime. The algorithm also involves arithmetic operations 
 with the modulo operator (%) to check divisibility and uses I/O to print the result.

  For the sixth algorithm, it checks if a number is a palindrome, which means it reads the same forwards and backwards. It starts by converting the number into a string, which makes it easier
 to compare the digits. Then it creates a reversed version of the string. It compares the original string to the reversed one and if they are identical, it returns true, indicating that the 
  number is a palindrome. Otherwise it returns false. So the program uses 'to_s' method for converting the number to a string. It employs the reverse method to reverse the string and uses a 
 comparison == to check if the original and reversed strings match. For I/O, the program handles input and output separately, though the main function does not directly handle them.

 As our seventh algorithm, we have a method that identifies the largest digit in a given integer. First, the number is converted to a string using variable assignment. We 
 initialize the largest_digit variable to 0 and then set it as the starting point. We use a for loop to iterate through each character in the string, which converts each 
 digit back to an integer. Conditional checks are used to compare each digit with the current largest digit. If a larger digit is found, it updates the largest_digit 
 variable. After the loop finishes, the method returns the largest digit. I/O is handled by returning the result of the comparison. 

 For the eighth algorithm, it calculates the sum of digits of a given number. It starts by taking the user's input and converting it to an integer. It checks a validation, so if the number 
 is negative, an error message is displayed. Otherwise the algorithm uses a while loop to repeatedly extract the last digit of the number and add it to the sum. This is done using the modulo 
  operator '%'. After each digit is added, the number is reduced by performing integer division '/ 10' to remove the last digit. The loop continues until all digits have been processed. Finally,
  the sum is displayed. So we see that the program uses the += operator for adding the last digit to the sum. It handles error checking with an if statement. The while loop processes the number digit
 by digit and the puts function is used to display the result.


 As our ninth algorithm, we have a method that generates and prints the multiplication table for a given number up to 10. We accept user input, which is then 
 converted to an integer using I/O and variable assignment. A while loop is used to iterate from 1 to 10. During each iteration, the product of the input number 
 and the current value of i is printed by using puts. The loop continues until i becomes greater than 10, with arithmetic operations to calculate the 
 multiplication and increment i by 1 after each iteration. Finally, the result is printed by using puts.

   Now for the final algorithm, it calculates the Nth Fibonacci number. The Fibonacci sequence begins with 0 and 1, where each subsequent number is the sum of the two preceding ones. 
   The program starts by taking user input for n and converts it into an integer. If N is 0 or 1, it directly returns the corresponding Fibonacci numbers (0 or 1). For values greater than 1, 
   the algorithm initializes the first two Fibonacci numbers (0 and 1) and uses a while loop to calculate the Fibonacci number at position n by summing the previous two numbers. This continues
   until the Nth Fibonacci number is reached and the result is displayed. So finally we see that the program uses the = operator for variable assignments and arithmetic operations like + to sum
   the previous two Fibonacci numbers. The while loop iterates from 2 to N to calculate the Fibonacci sequence.

 We designed these ten algorithms to highlight essential programming features: variable assignment with =, arithmetic operations (+, -, *, /, %), conditional 
 statements (if-else), loops (while), and input/output using puts. Advanced constructs like recursion, function calls, arrays, or lists were intentionally avoided 
 to maintain clarity and simplicity. Additionally, these algorithms have also been implemented in Java for broader applicability.

 With our language subset clearly defined, we now move on to building a simple interpreter capable of processing and executing code written in this subset. The 
 interpreter will focus on parsing and execution while ensuring syntax error detection for better reliability. Our priority remains simplicity and correctness over 
 raw performance, ensuring the interpreter is both functional and easy to understand.
