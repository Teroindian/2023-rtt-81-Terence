package variables;

public class ConditionalOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean conditionOne = true;
		boolean conditionTwo = false;

		// && is and
		if (conditionOne && conditionTwo) {
			// do something if all variables are true
			System.out.println("Both variables are true");
		}

		// neither is true
		if (!conditionOne && !conditionTwo) {

			System.out.println(" neither is true");
		}

		// || is or
		if (conditionOne || conditionTwo) {
			// do something if one or the other or both variables are true
			System.out.println("Either or Both of  variables is true");

			// this is using mathematical operators
			int x = 10;
			if ((x > 3) && (x < 20)) {
				System.out.println("x is between 3 and 20");
			}

			// odd vs even
			// this is using modulus

			int y = 4;
			if ((y % 2) == 1) {
				System.out.println("This is an odd number");
			} else {
				System.out.println("This is an even number");
			}

		}
	}

}
