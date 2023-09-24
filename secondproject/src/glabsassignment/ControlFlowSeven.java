package glabsassignment;

import java.util.Scanner;

public class ControlFlowSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your filing status (S, MFJ, MFS, or H): ");
        String filingStatus = scanner.nextLine();

        System.out.println("Enter your taxable income: ");
        double income = scanner.nextDouble();

        double tax = calculateTax(filingStatus, income);

        System.out.println("Your tax is: $" + tax);

        scanner.close();
    }

    private static double calculateTax(String filingStatus, double income) {
        double taxRate = 0.0;

        switch (filingStatus) {
            case "S":
                taxRate = 0.10;
                break;
            case "MFJ":
                taxRate = 0.15;
                break;
            case "MFS":
                taxRate = 0.20;
                break;
            case "H":
                taxRate = 0.25;
                break;
            default:
                System.out.println("Invalid filing status");
                return 0.0;
        }

        return income * taxRate;

	}


	}


