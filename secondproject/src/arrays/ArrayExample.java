package arrays;

public class ArrayExample {

	public static void main(String[] args) {

		int arraySize = 20;

		// this creates a new array of type double with 20 elements 0.....19
		double[] doubleArray = new double[arraySize];

		String[] stringArray = new String[arraySize];
		stringArray[1] = " one";
		stringArray[2] = " two";
		stringArray[0] = " zero";
		stringArray[9] = " nine";

		// loop over the entire array and print the value in each location
		for (int pos = 0; pos < stringArray.length; pos++) {
			System.out.println("The value in position " + pos + " is " + stringArray[pos]);
		}

		System.out.println("=================================");

		// enhanced for loop
		for (String value : stringArray) {
			System.out.println("The value = " + value);
		}

		System.out.println("==========================");

		// write a for loop that counts the number of nulls in the array
		// after the loop completes print that number
		int nullCount = 0;
		for (String value : stringArray) {
			// Check if the element is null.
			if (value == null) {
				// Increment the count variable.
				// nullCount = nullCount + 1;
				nullCount++;
			}
		}
		System.out.println("number of null is " + nullCount);

		// write a for loop that tells me the location of the first null in the array
		// this is going to use the non-enhanced for loop
		int firstNull = -1;
		for (int pos = 0; pos < stringArray.length; pos++) {
			if (stringArray[pos] == null) {
				firstNull = pos;
				break;
			}
		}

		// write a for loop that tells me how many values are not null
		int nonNullCount = 0;
		for (String value : stringArray) {
			if (value != null) {
				nonNullCount++;
			}
		}
		System.out.println("number of non-null is " + nonNullCount);

		// for loop that tells me last position of null in array
		int lastNull = -1;
		for (int pos = stringArray.length - 1; pos >= 0; pos--) {
			if (stringArray[pos] == null) {
				lastNull = pos;
				break;
			}
		}
		System.out.println("last position of null is " + lastNull);

		// for loop that starts in final position n the array and counts down to first
		for (int pos = stringArray.length - 1; pos >= 0; pos--) {
			System.out.println("The value in position " + pos + " is " + stringArray[pos]);
		}

		String letters = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

		// use letters.split(",") to make any array of letters
		// loop over the array and count the number of letters that are not vowels

		String letterrss = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
		String[] letterArray = letterrss.split(",");

		int nonVowelCount = 0;
		for (String letter : letterArray) {
			if (!letter.equals("a") && !letter.equals("e") && !letter.equals("i") && !letter.equals("o")
					&& !letter.equals("u")) {
				nonVowelCount++;
			}
		}

		System.out.println("number of non-vowels is " + nonVowelCount);

		System.out.println("Positon of the first null is " + firstNull);
	}

}
