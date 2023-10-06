package practiseassignmentslab;

import java.util.Scanner;




public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int n1 = readPositiveNumber(scanner);
		int n2 = readPositiveNumber(scanner);
		
		System.out.println("First number  : " + n1);
		System.out.println("Second number : " + n2);
		
		
		//Check whether k (for k = 2, 3, 4, and so on) is a common divisor 
		// for n1 and n2, until k is greater than n1 or n2.
		
		// we are looking for where both numbers are divisible with no remainder
		
		// 5 and 15
		// 5 / 1 = 5   , 15 / 1 = 15    = Good !!! 
		// 5 / 2 = 2.x , 15 / 2 = 7.x   = No good
		// 5 / 3 = 1.x , 15 / 3 = 5     = No good
		// 5 / 4 = 1.x , 15 / 4 = 3.x   = No good
		// 5 / 5 = 1   , 15 / 5 = 3     = Good !!!
		// 5 / 6 = 0.x ,
		// 5 / 7 = 0.x ,
		
		int gcd = 1;
		int min = Math.min(n1, n2);
	
		for ( int k = 1 ; k <= min  ; k++ ) {
			if ( (n1 % k == 0) && (n2 % k == 0) ) {
				gcd = k;
			}
		}
		
		System.out.println("The gcd of " + n1 + " and " + n2 + " is " + gcd);
	}
	
	private static int readPositiveNumber(Scanner scanner) /*throws InvalidInputException*/{
		int number = -1;
		while ( number <= 0 ) {
			System.out.print("Enter a positive integer greater than 0 : ");
			number = scanner.nextInt();
		/*	try {  
				number  = scanner.nextInt();
			} catch (InputMismatchException e) { 
				throw new InvalidInputException("Invalid input: Must be a numeric value");
			}*/
			
			
			if ( number <= 0 ) {
				System.out.println("Error : Must be a positive number");
			} 
		}
		
		return number;
	}
	
}	
	
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a positive integer: ");
		int n1 = scanner.nextInt();

		// Check if the user input is a positive number. If it is not, print an error message and prompt the user to enter a positive number again.
		while (n1 < 0) {
			System.out.println("Must be a positive number");
			System.out.println("Enter a positive integer: ");
			n1 = scanner.nextInt();
		}

		System.out.println("Enter another positive integers: ");
		int n2 = scanner.nextInt();

		// Check if the user input is a positive number. If it is not, print an error message and prompt the user to enter a positive number again.
		while (n2 < 0) {
			System.out.println("Must be a positive number");
			System.out.println("Enter another positive integers: ");
			n2 = scanner.nextInt();
		}

		
		//Check whether k (for k = 2, 3, 4, and so on) is a common divisor 
				// for n1 and n2, until k is greater than n1 or n2.
				
				// 5 and 15
				// 5 / 1 = 5   , 15 / 1 = 15    = Good !!! 
				// 5 / 2 = 2.x , 15 / 2 = 7.x   = No good
				// 5 / 3 = 1.x , 15 / 3 = 5     = No good
				// 5 / 4 = 1.x , 15 / 4 = 3.x   = No good
				// 5 / 5 = 1   , 15 / 5 = 3     = Good !!!
				// 5 / 6 = 0.x ,
				// 5 / 7 = 0.x ,
		
		// Find the greatest common divisor of n1 and n2.
		int gcd = 1;
		for (int i = 2; i <= Math.min(n1, n2); i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}

		// Print the greatest common divisor.
		System.out.println("The greatest common divisor of " + n1 + " and " + n2 + " is " + gcd);

	}
*/

