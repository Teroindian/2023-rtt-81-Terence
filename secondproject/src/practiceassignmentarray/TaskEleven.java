package practiceassignmentarray;

import java.util.Scanner;

public class TaskEleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // Ask the user how many favorite things they have.
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many favorite things do you have?");
        int numberOfFavoriteThings = scanner.nextInt();

        // Create a String array of the correct size.
        String[] favoriteThings = new String[numberOfFavoriteThings];

        // Ask the user to enter the things and store them in the array.
        for (int i = 0; i < favoriteThings.length; i++) {
            System.out.println("Enter your thing:");
            favoriteThings[i] = scanner.nextLine();
        }

        // Print out the contents of the array.
        System.out.println("Your favorite things are:");
        for (int i = 0; i < favoriteThings.length; i++) {
            System.out.println(favoriteThings[i]);
        }
	}

}
