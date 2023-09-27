package practiceassignmentarray;

public class TaskFour {

	public static void main(String[] args) {
		
		// Create an integer array with 5 elements.
        int[] myArray = {1, 2, 3, 4, 5};

        // Print out the value at the first index and the last index using length - 1 as the index.
        System.out.println(myArray[0]);
        System.out.println(myArray[myArray.length - 1]);

        // Try printing the value at index = length (e.g., myArray[myArray.length] ).
        try {
            System.out.println(myArray[myArray.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException!");
        }

        // Try to assign a value to the array index 5.
        try {
            myArray[5] = 6;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException!");
        }

	}

}
