package practiseassignmentslab;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter two positive integers: ");
		int n1 = scanner.nextInt();
		int n2 = scanner.nextInt();

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

}
