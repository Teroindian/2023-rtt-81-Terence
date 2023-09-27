package practiceassignmentarray;

public class TaskNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        // Create an int array of 6 elements.
        int[] myArray = {4, 2, 9, 13, 1, 0};

        // Sort the array in ascending order.
        for (int i = 0; i < myArray.length; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[i] > myArray[j]) {
                    int temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }

        // Print out the array in ascending order.
        System.out.println("Array in ascending order:");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();

        // Print the smallest and the largest element of the array.
        System.out.println("The smallest number is " + myArray[0]);
        System.out.println("The biggest number is " + myArray[myArray.length - 1]);
    }

	

}
