package practiceassignmentarray;

import java.util.Arrays;

public class TaskThree {

	public static void main(String[] args) {
	
		  // Create an array of String type.
        String[] myArray = {"red", "green", "blue", "yellow"};

        // Print out the array length.
        System.out.println(myArray.length);

        // Make a copy using the clone() method.
        String[] newArray = myArray.clone();

        // Use the Arrays.toString() method on the new array to verify that the original array was copied.
        System.out.println(Arrays.toString(newArray));

	}

}
