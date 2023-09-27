package stringmethods;

public class StringJoiner {

	public static void main(String[] args) {

		String [] arr = { "a", "b", "c", "d", "e" };
		//in the box was a tire, a saw, a pig
		
		for ( int pos=0 ;pos < arr.length; pos++) { 
			 System.out.println(arr[pos] );
			 if ( pos < arr.length - 1) { 
				 System.out.println(",");
			 }
		}
		
		
	}

}
