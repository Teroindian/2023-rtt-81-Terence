package practiceassignmentarray;

public class TaskSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  // Create an array of 5 elements.
        int[] myArray = {1, 2, 3, 4, 5};

        // Loop through the array and print the value of each element, except for the middle (index 2) element.
        for (int i = 0; i < myArray.length; i++) {
            if (i != 2) {
                System.out.println(myArray[i]);
            }
        }
	}

}
