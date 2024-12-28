/*In the following algorithms, we have to write the code in minimal subsets,
*which means that our codes only include variables,loops, conditions.
*At first, we have implemented sum of first N numbers written in java
*/1.for N=10, it should give 55
import java.util.Scanner;

public class Sum {
      public static void main(String[] args) {
   //Handle all given inputs
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();//Initialize N
//At first, we check if number is less than or equal to zero, if it is than it should say that there will be an error.So we can handle errors.
        if (N <= 0) {
            System.out.println("Please enter positive N.");
        } else {
    //And if the given number is greater than zero, then:
            int sum = 0; //Initialize sum to 0, during each iteration it gets bigger and bigger
            int i = 1;   //Start i from 1, because first natural number is 1
//While i is less than or equal to N, it should add numbers to the sum and then increment i by 1
            while (i <= N) {
                sum += i; //Adding i to the sum, this is the same as sum = sum+i
                i++; //Incrementing i by 1 for every iteration
            }//end of while loop
// When while loop ends, and we have the final result of sum, we print it on the console
            System.out.println(sum);
        }
    }
}

//2.In the following algorithm, our mission is to compute the factorial of N.
//for N=5, it should give 120.
import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
  //Handle all given inputs
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();//Initialize N
//At first, handle errors to negative integers or zero.
        if (N <= 0) {
            System.out.println("Please enter number which is greater than zero.");
        //This means that for n<=0, the program will ask again to input N which is positive
        } else {
            long result = 1; //The starting value of factorial, we use 1, because we can handle bigger numbers
//for 5 the factorial is 1*2*3*4*5 which is 120, so now we write for loop which multiplies numbers from 1 to N
            int i = 1;//initialize i=1, because the starting value of factorial is 1,
            while (i <= N) {
                result *= i; //multiplying result by i on every iteration
                i++; //incrementing i by 1
            }//end of while loop
//When while loop ends, and we have the final result, we print it on the console.
            System.out.println(result); 
        }
    }
}

//3.In the following algorithm, our mission is to 
//find the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
import java.util.Scanner;

public class Gcd {
   public static void main(String[] args) {
//Handle all given inputs and enter numbers
   Scanner scanner = new Scanner(System.in);
   System.out.println("Enter first number: ");
   int a = scanner.nextInt();
   System.out.println("Enter second number: ");
   int b = scanner.nextInt();
//Handle all errors at first
        if (a == 0 || b == 0) {
            System.out.println("Cannot calculate the gcd for zeros");
        } else if (a < 0 || b < 0) {
            System.out.println("Cannot calculate gcd for negative numbers");
        } else {
            //if a and b are both greater than zero and doesnt equal to each other,then write the while loop.
            while (b != 0) {
                int temp = b;//Store the current value of b in temp.
                b = a % b;//Update b with the remainder of a divided by b.
                a = temp;//store the value of temp in a
            }
//When while loop ends, and we have the final result, we print it on the console.
      System.out.println(a);
        }
    }
}

//4.In the following algorithm, we want to reverse a number, for example, if n=123, the reversed should be 321
import java.util.Scanner;

public class Reverse {
   public static void main(String[] args) {
//Handle all given inputs and enter numbers
   Scanner scanner = new Scanner(System.in);
   System.out.println("Input a number");
   int n = scanner.nextInt();//initialize value of n
//handle errors for negative numbers
        if (n<0) {
            System.out.println("cannot reverse negative numbers.");
        }else{
            int reversed = 0; //initializing the reversed number, which, at the beginning is zero
//write the while loop for reversing numbers
            while (n>0) {
                int b = n%10; //get the last digit by the modulo operator
                reversed = reversed * 10 + b;//adding the digit to reversed in the correct place
                n /= 10;//divide n by 10 and update the value of n
            }
//When while loop ends, print the result
            System.out.println(reversed);
        }
    }
}

  
//5.In this algorithm, we check the given number is prime or not.In other words, if a number is divisible for its own self and 1.
import java.util.Scanner;

public class Prime {
  public static void main(String[] args) {
//Handle inputs
   Scanner scanner = new Scanner(System.in);
//enter the nnumber for n
   int n = scanner.nextInt();
//define the boolean isprime, which checks the following number is prime or not.
   boolean isprime = true;//lets say it's true at the beginning

//Handle errors by checking the number is less than or equal to 1, because these numbers are neither prime nor not prime.
        if (n <= 1) {
            isprime = false;//we equal isprime to false, because it doesnt satisfy the condition
        }
//now we write the while loop for numbers which are greater than or equal to 2
        int i = 2;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                isprime = false;//if n can divide the other number from 1 and its own self, it is not prime
                break;//exit from a program earlier
            }
            i++;//incrementing i by 1 on every iteration
        }
//print the received result to the console
        System.out.println(isprime);
    }
}

//6.In the following algorithm we check if the number is palindrome.for example 121 is palindrome, but 123 is not.
import java.util.Scanner;

public class Palindrome {
   public static void main(String[] args) {
//Handle inputs and enter number
   Scanner scanner = new Scanner(System.in);
   int n = scanner.nextInt();
//handle errors for negative numbers
        if (n < 0) {
            System.out.println("negative numbers cannot be palindrome");
            return;
        }
   int original = n;//store the value of n into original
   int reversed = 0;//initialize the reveresed which at the beginning is zero

//write the while loop for positive values
        while (n > 0) {
            int d = n % 10;//get the last digit
            reversed = reversed * 10 + d; multiply reversed by 10 and add last digit
            n /= 10;//divide n by 10 and update n, if n is 121, then will be 12 and so on.
        }

//once we get reversed number, compare to the original 
        if (original == reversed) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

//7.In the following algortihm, we write the code which finds the largest digit in a number
.import java.util.Scanner;

public class LargestDigit {
  public static void main(String[] args) {
//handling inputs, enter the number
  Scanner scanner = new Scanner(System.in);
  int n = scanner.nextInt();

//Handle errors for negative numbers
        if (n < 0) {
            System.out.println("cannot find the largest");
            return;//end the code earlier
        }
  int largest = 0;//initialize the largest digit which is at first zero
  //we write the while loop to find the largest digit, when n>0
        while (n > 0) {
            int d = n % 10;//by modulo operator, we get the last digit and then compare to the current value of largest
            if (d > largest) {
                largest = d;
            }
            n /= 10;//divide n by 10 and update the value of n
        }
//when loop ends, print the result to the console
        System.out.println(largest);
    }
}

//8..import java.util.Scanner;

public class SumOfDigits {
   public static void main(String[] args) {
   //handle inputs, enter number
   Scanner scanner = new Scanner(System.in);
   int n = scanner.nextInt();
//handle errors for negative values of n and also zero
    if (n <= 0) {
      System.out.println("cannot compute sum of digits");
      return;//exit the program earlier
    }
//in is positive, then initialize sum which is at first equal to zero
   int sum = 0;
//wwrite the while loop to calculate the sum of digits
    while (n > 0) {
      sum += n % 10; //we add the last digit to the sum
      n /= 10; //divide n by 10, which removes last digit
    }
//when the while loop ends, print the result to the console
    System.out.println(sum);
  }
}

//9.for this algorithm, we generate and print the multiplication table for a given number up to 10
import java.util.Scanner;

public class MultiplicationTabl {
  public static void main(String[] args) {
//handle inputs
  Scanner scanner = new Scanner(System.in);
//enter the value of n
  int n = scanner.nextInt();
//handle errors by checking n
    if (n <= 0) {
      System.out.println("we should have positive integer");
      return;//exit the program earlier
    }
//write nested while loops to generate multiplication table
    int i = 1;//initialize i to 1
    while (i <= 10) {
      int j = 1;//start inner loop from 1 too
      while (j <= 10) {
        System.out.println(i + "x" + j + "=" + (i * j));
        j++;//increment j on every iteration by 1
      }
      i++;//increment i by 1
    }
 }
}

//10.In the following algortihm,we want to compute the Nth Fibonacci number by using iteration
.import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
// Input handling
  Scanner scanner = new Scanner(System.in);
  System.out.print("Enter a number: ");
  int N = scanner.nextInt();//read the input

//handle errors by checking if n is negative or not
    if (N < 0) {
      System.out.println("N should be positive");//write error message for this case
      return;//exit the program earlier
    }

  int x = 0;//first fibonacci number
  int y = 1;//second fibonacci number

  if (N == 0) {
      System.out.println(x);
    } else if (N == 1) {
      System.out.println(y);
    } else {
//calculate fibonacci for numbers which are greater than 1.
      int i = 2;//initialize i to 2, because it is the first number greater than 1, so we start loop from here
      while (i <= N) {
        int next = x + y;//the third number is the sum of the previous two
        x = y;//update x to the previous y
        y = next;//update y to new number
        i++;//increment i by 1 on every iteration
      }
//When the while loop ends, print the result
      System.out.println("fibonacci of "+N+ ":"+ y);
    }
} 

/*
*we have made sure that these 10 algorithms are designed to cover the following essential features:
*variable assignment, where values are assigned to variables using the = operator.
*basic arithmetic operations such as addition, subtraction, multiplication, division, and modulo.
*conditional statements (if, else) for decision-making.
*iterative control flow using loops (like while) to repeat actions.
*basic input and output operations, which are optional but can be used for user interaction.
*no advanced constructs such as recursion, function calls, arrays, or lists are used.
*/


 