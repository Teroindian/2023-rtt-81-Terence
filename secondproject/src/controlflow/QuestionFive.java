package controlflow;

import java.util.Scanner;

public class QuestionFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter a score: ");
	        int score = scanner.nextInt();

	        if (score < 0 || score > 100) {
	            System.out.println("Score out of range");
	        } else if (score >= 90) {
	            System.out.println("A");
	        } else if (score >= 80) {
	            System.out.println("B");
	        } else if (score >= 70) {
	            System.out.println("C");
	        } else if (score >= 60) {
	            System.out.println("D");
	        } else {
	            System.out.println("F");
	        }

	        scanner.close();

	}

}
