package practiceassignmentarray;

public class TaskEight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  // Create a String array of 5 elements.
        String[] myArray = {"first", "second", "third", "fourth", "fifth"};

        // Swap the first element with the middle element without creating a new array.
        String temp = myArray[0];
        myArray[0] = myArray[2];
        myArray[2] = temp;

        // Print out the array.
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
	}

}
