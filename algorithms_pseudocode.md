1.Sum of first N numbers

Start.
initialize sum to 0.
for each number i from 1 to N.
add i to sum.
end for.
return sum.
End

2.Factorial of N

Start.
initialize result to 1.
for each i from 1 to N.
multiply result by i .
end for.
return result.
End 

3.GCD of two numbers

Start.
a and b are two integers.
while b is not 0
set a to b.
set b to a%b.
return a(fc).
End

4.Reverse number

Start.
Initialize a variable reversed to 0.
While number is greater than 0:
   a(fc2).Set digit to number % 10.
   b. Multiply reversed by 10 and add digit to reversed.
   c. Set number to number // 10 (integer division).
   Return reversed.
End

5.Check if Number is prime

Start.
If n <= 1, return False (not prime).
For each number i from 2 to sqrt(n):
   a(fc3). If n % i == 0, return False (not prime).
Return True (prime).
End.


6.Check if number is palindrome

Start.
Convert the number to a string.
Reverse the string.
If the reversed string is equal to the original string, return True (palindrome).
Otherwise, return False (not palindrome).
End.

7.Find the Largest digit in Number

Start.
 Convert the number to a string.
Initialize a variable largest_digit to 0.
For each character c in the string:
   a(fc4). Convert c to an integer.
   b. If the integer is greater than largest_digit, update largest_digit.
return largest_digit.
End

8.Sum of Digits

Start.
Initialize a variable sum to 0.
While number is greater than 0:
    Add number % 10 to sum.
   b. Set number to number // 10 (integer division).
Return sum.
End

9.Multiplication table

Start.
For each number  from 1 to 10:
   . For each number j from 1 to 10:
   i. Print i * j.
End

10.Nth fibonacci number

Start
If n == 0, return 0.
If n == 1, return 1.
Initialize variables a = 0 and b = 1.
For each number i from 2 to N:
   a(fcw). Set next_fib to a + b.
   b. Set a to b and b to next_fib.
Return b (this is the Nth Fibonacci number).
End



