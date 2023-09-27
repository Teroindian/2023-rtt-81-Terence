package calc;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.menu();
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);

        // Get the user's input
        double num1 = input(scanner);
        double num2 = input(scanner);

        // Print a menu of operations
        System.out.println("Choose an operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        // Get the user's choice of operation
        int choice = scanner.nextInt();

        // Perform the selected operation and print the result
        double result = 0;
        switch (choice) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.println("The result is: " + result);
    }

    private double input(Scanner scanner) {
        System.out.println("Enter a number: ");
        return scanner.nextDouble();
    }

    private double add(double num1, double num2) {
        return num1 + num2;
    }

    private double subtract(double num1, double num2) {
        return num1 - num2;
    }

    private double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        } else {
            return num1 / num2;
        }
    }
}
