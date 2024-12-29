#In this following algorithm, we have to write the code in minimal subsets,
#which means that our codes only include variables, loops and conditions.
#here we have implemented simple algorithms written in Ruby, 
#using a minimal subset of the language, as specified for the project. 
#at first we will define a method which takes one argument 'n'
#this method calculates the sum of all natural numbers form 1 to n
def sum_of_numbers(n)
   if n < 0
      puts "there's an error. n must not be the negetive."
      return 0  #if input is invalid then it's gonna return 0
   end
   sum = 0 #this will initialize a variable 'sum' to 0 and store the cumulative total
#we will use a for loop to iterate through each number in the range 1 to n
#'i' represents the current number in the range
   i = 1  # Start from 1
   while i <= n
      sum += i #this will add the current number i to sum
      i += 1  # Increment i by 1
   end #this marks the conclusion of the for loop block
#so after the loop has completed, the final value of sum is returned
   return sum #this statement ends the method and returns the final computed result
end





#This program calculates the factorial of a given number, meaning it
#multiplies all the numbers from 1 up to that number
#For example, if the number is 5 then the factorial of 5 is 5*4*3*2*1=120
#so now we will define which calculates that
puts "Enter a number:" #according to this method, the user can enter a number. so this is the part where 
                       #the program starts it and when the user enter the number, it will calculate the factorial
input = gets.chomp  #method 'gets.chomp' captures input and removes the newline character and 
n = input.to_i       #with using 'input.to_i', we convert the input string to an int

if n < 0                               #this will check if the number is negative, it's an error and
   puts "Enter only positive numbers"  #will notify the user that should only enter the positive number
else       #and if the number that user input is positive than it will calculate its factorial
   factorial = 1  #this will initialize the factorial to 1
   while n > 0    #uses a while loop to multiply the factorial by each number down to 1
      factorial *= n  #multiply factorial by the current number
      n -= 1  #decrement number by 1
   end    #ends the loop
   puts "The factorial is #{factorial}" 
end   #and finally when the calculate is done, we can show the result




#In the following code, we have two inputs a and b
#and we should find the greatest common divisor of these two numbers,
#by writing Euclidean algorithm, which works in the following way:
#if we have gcd(a,b) and a and b are not equal to each other we can write something like this:
#gcd(a,b) is the same as gcd(a-b,b) in case a is greater than b, or vise versa.
#If b is greater than a, then gcd(a,b) is the same as gcd(a,b-a)
#and this continues until a and b are equal to each other
puts "Enter the first number:" #this part tells the user to input the first number
a = gets.chomp.to_i #this method convert the input to an integer, as we said in a previous task, and assign it to a
puts "Enter the second number:" #this part do the same but for the second number
b = gets.chomp.to_i
#now we will check with the help of if statement, if the second number is zero to 
#avoid division by zero that is error of course
if a == 0 || b == 0
   puts "it's an error. you can't divide by zero"
else #if the second number is not zero, it will calculate gcd
   while b != 0 #keeps reducing the problem until we get to the gcd
      temp = b
      b = a % b
      a = temp
   end  
   puts "The GCD is #{a}" #finally prints the result
end




#This program reverses the digits of a given number
def reverse_digits_of_number(num)
   reversed = 0 #firstly, we will start with 0, which means that we need an empty container for our reversed number
#of course we keep looping as long as digits still there. and in this process we gradually peeling off digits,
#one by one and placing them in the correct order
   while num > 0 
     digit = num % 10  #this will grab tha last digit 
     reversed = reversed * 10 + digit #then lets take last digit and add it to the reversed number
                                      #we shift everything in 'reversed' left by multiplying by 10
                                      #finally we add the new digit
     num = num / 10 #this will remove the last digit of num
   end
#method 'reversed' contains the number with its digits reversed 
   return reversed  #and with that we will see our number that is reversed
end
puts "Enter a number to reverse:" #as the previous task, we know that this method helps the user to enter the number
input = gets.chomp  #than when user input something, it means it is stored as a string
num = input.to_i  #this will convert the input string to an integer
#of course we are using if statement to check,if the number is negative and if it is, then 
#it will print a message
if num < 0
   puts "Please enter a positive number"
else #and if it is positive number, it's gonna call the method to reverse the digits 
     #and it will output the result
   result = reverse_digits_of_number(num)  
   puts result
end


#In the following algorithm, we have to check if a number is prime,
#in other words, if a number is only divisible for its own self and 1
def num_is_prime(n) 
   if n <= 1 #this checks if the number is less than or equal to 1 then it's not a prime
     return false #it is gonna return false because prime numbers should be greater than 1
   end
#for this part, this will iterate through numbers starting from 2 up to the square root of n
#and we only need to check divisors because if n can be divided by any number larger than square root
   for i in 2..Math.sqrt(n).to_i
      if n % i == 0 #this checks if n is prime or not. if n is dividible by i then it's not a prime
        return false #and it's gonna return false
      end
   end
   return true #anf if n is prime, it's gonna return true
end




#This program checks if a number is a palindrome
#A palindrome is a number that reads the same forwards and backwards
def is_palindrome(n) 
#so this method will change the number into a string and this gonna make it easier 
#to check the order of digits
   str_n = n.to_s
   reversed_str = str_n.reverse #it's create a reversed string and will help us to see
                              #if digits are the same when reversed
   return str_n == reversed_str #then it will compare the original string to reversed one
                              #and if they are identical, then it's palindrome and returns true
                              #if it's not then return false
end





#This following program finds the largest digit in a given number
#This function takes a number as input, converts it to a string
#and then finds the largest digit by comparing each digit one by one
def largest_digit(n): #firstly, we need to convert the number into a string
    str_n = n.to_s   #as we do the previous task, we need to compare them one by one
    largest_digit = 0  #we are starting with 0 to initialize a variable to store the largest digit
#now we need to iterate through each digit in the string
  str_n.each_char do |c| 
    digit = c.to_i #so since each digit is a string, we need to convert it to integer
#next we will use if statement, so if the current digit is greater than the largest, it's gonna update
    if digit > largest_digit
      largest_digit = digit
    end
  end
#and finally when program goes through the all digits, it will hold the largest value
  return largest_digit
end






#This following algorithm calculates the sum of digits of a given number
#it means it takes a number, breaks it into individual digits and adds them together.
sum = 0
puts "Enter a number:" #the user inputs here a number
number = gets.chomp.to_i #this convert input to an integer
if number < 0 #this part handles an error
   puts "it's an error. Please enter a positive number"
else
#now we are using the while loop and it will run as long as the number is positive and it will continue one by one
   while number > 0 
     sum += number % 10  #this method gives us the last digit and we add this digit to sum
     number = number / 10  #then it's gonna perform integer division to remove the last digit
   end
   puts sum #finally it prints result
end





#This following algorithm prints the multiplication table for a given number up to 10
puts "Enter a number:"  #of course, as we do in the previous tasks, user in this type of method always inputs something
                        #for this part, it's gonna input number
num = gets.chomp.to_i  #this converts the input to an integer
i = 1
while i <= 10  #with while loop, it will generate the multiplication table
               #it continues the loop as long as i is less than or equal to 10
   puts num * i  #this prints the result
   i += 1  #than after each iteration it's incrementing i by 1 
end  






#In this following program we will declare fibonacci numbers
#fibonacci numbers are a sequence where each number is the sum of the two preceding ones
#its starts like this: 0, 1, 1, 2, 3, 5, 8, 13, and so on
#the goal of this program is to find the Nth Fibonacci number
puts "Enter the value of N:" #input the number
n = gets.chomp.to_i #convert input to integer
if n == 0   #we know that fibonacci number's first number is 0 and second is 1
            #so this part is according to that, it checks those numbers
  puts "The Fibonacci number is 0"
elsif n == 1
  puts "The Fibonacci number is 1"
else
#from here we initialize the first two numbers
  a = 0  
  b = 1  
  i = 2
#Now we need to calculate Fibonacci numbers starting from 2 up to n
#and loop through the numbers from 2 to n and calculate the next number
  while i <= n
    next_fib = a + b #the next Fibonacci number is the sum of the previous two
    a = b    #updates the a to the previous number
    b = next_fib  # updates b to the newly calculated number
    i += 1
  end
  puts "The Fibonacci number is #{b}" # and finally we have a result
end


