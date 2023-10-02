package forlooprevision;

public class ForLoopTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
		  sum += i % 2;
		}

		System.out.println("The sum of the remainders is: " + sum);
	}

}
