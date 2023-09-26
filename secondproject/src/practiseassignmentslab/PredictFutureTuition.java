package practiseassignmentslab;

public class PredictFutureTuition {
	public static void main(String[] args) {
		// The current tuition.
		double tuition = 10000;

		// The annual increase rate.
		double annualIncreaseRate = 0.07;

		// The number of years it will take for the tuition to be doubled.
		int yearsToDoubleTuition = 0;

		// While the tuition is less than doubled, keep increasing it by the annual
		// increase rate and incrementing the number of years.
		while (tuition < 2 * tuition) {
			tuition *= (1 + annualIncreaseRate);
			yearsToDoubleTuition++;
		}

		// Print the number of years it will take for the tuition to be doubled.
		System.out.println("The tuition will be doubled in " + yearsToDoubleTuition + " years.");
	}
}
