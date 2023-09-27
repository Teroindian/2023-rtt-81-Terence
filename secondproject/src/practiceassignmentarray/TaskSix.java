package practiceassignmentarray;

public class TaskSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  // Create an integer array of 5 numbers.
        int[] myArray = {1, 2, 3, 4, 5};

        // Loop through the array and assign the value of the loop control variable multiplied by 2 to the corresponding index in the array.
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] *= 2;
        }

        // Print out the array.
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }
    
	}

}
