package glabsassignment;


import java.util.Scanner;


public class ControlFlowSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter an integer between 1 and 7: ");
	        int dayNumber = scanner.nextInt();

	        String dayName;

	        switch (dayNumber) {
	            case 1:
	                dayName = "Sunday";
	                break;
	            case 2:
	                dayName = "Monday";
	                break;
	            case 3:
	                dayName = "Tuesday";
	                break;
	            case 4:
	                dayName = "Wednesday";
	                break;
	            case 5:
	                dayName = "Thursday";
	                break;
	            case 6:
	                dayName = "Friday";
	                break;
	            case 7:
	                dayName = "Saturday";
	                break;
	            default:
	                dayName = "Out of range";
	                break;
	        }

	        System.out.println("Weekday: " + dayName);

	        scanner.close();

	}

}
