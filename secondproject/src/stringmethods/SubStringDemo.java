package stringmethods;

public class SubStringDemo {

	public static void main(String[] args) {
		
		

		String string = "This is a string";
		//---------------0123456789012345
		
		//substring with a start and an end
		String sub  = string.substring(5,7);
		System.out.println(sub);
		
		//substring with just a start
		String sub1 = string.substring(5);
		System.out.println(sub1);
		
		//-----------------0123456789012
		String filename = "someimage.jpg";
		int lastDot = filename.lastIndexOf(".");
		
		String ext = filename.substring(filename.lastIndexOf(".") + 1);
		System.out.println(ext);
		
		
		//-------------0123456789012345
		String name = "TERENCE AGAROMBA";
		
		int spacePosition = name.indexOf(" ");
		String firstname = name.substring(0, spacePosition);
		System.out.println( firstname);
		
		String lastname = name.substring(name.indexOf(" ") + 1);
		System.out.println( lastname);
		
		
		// FIND THE POSITION OF THE FIRST SPACE IN THE STRING
		
		
		
		//FIND THE POSITION OF LAST SPACE IN THE STRING
		
		//SUBSTRING OF THE CHARACTERS BETWEEN THE FIRST AND LAST SPACE OF STRING
		
		// DO THE SAME THING TO FIND THE SUBSTRING OF THE FIRST AND LAST VOWEL OF THE STRING
		//EDABIT.COM CHALLENGES
		//CHANGE TO JAVA / VERY EASY OR EASY / Strings and try to do some of them
		
		
		
		
		// use sting.charAt function and use a for loop over the entire string
		//and print out each character with a new line after it
		//you need to use string.length() function also
		
		
		
		//using only indexOf("") print the substring  that contains word 'is' and try to do some of them
		
		
		
		// find the position of the first space in the string
				String example = "This is an example";
				
				// find the position of the last space in the string
		int LastSpace = example.lastIndexOf(" ");
		int firstSpace = example.indexOf("");
		
				// substring of the characters between the first and last space of the string
				String chrBetween = example.substring( firstSpace + 1,LastSpace);
				System.out.println("---->" + chrBetween);
		
		
				//this is pretty hard
				// do the same thing to find the substring of the first and last vowel of the string
			
				
				// use the string.charAt function and use a for loop to loop over the entire string
				// and print out each character with a new line after it.
				// you need to use the string.length() function also
		
		  String myString = "Hello, world!";

	        for (int i = 0; i < myString.length(); i++) {
	        	//using an array is different in that it uses a [] to reference position
	            System.out.println(myString.charAt(i));
	        }
				
				// using only indexOf(" ") print the substring that contains the word "is"
				// use 2 substrings to do this.
				
	        
				
				// https://edabit.com/challenges
				// Change to Java / Very Easy or Easy / Strings and try to do some of them
	}
	
	

}
