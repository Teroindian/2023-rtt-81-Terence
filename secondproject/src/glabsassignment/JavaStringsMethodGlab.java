package glabsassignment;

import java.util.Arrays;

public class JavaStringsMethodGlab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// length() method
//The length() method returns the length of the string, or it returns the count of the total number of characters present in the string.
		String str1 = "Java";
        String str2 = "";

        System.out.println(str1.length());  // 4
        System.out.println(str2.length());  // 0
        System.out.println("Java".length());  // 4
        System.out.println("Java\n".length()); // 5
        System.out.println("Learn Java".length()); // 10
        
        


	}

	  
    // IsEmpty() method:
    // 	This method checks whether the String contains anything or not. If the Java String is empty, it returns true or false.
          
		public static void main2(String args[]){
		String s1="";
		String s2="hello";
		System.out.println(s1.isEmpty());      // true
		System.out.println(s2.isEmpty());      // false
		}


//Trim() method:
	//	The Java string trim() method removes the leading and trailing spaces. 
		//It checks the Unicode value of the space character (‘\u0020’) before and after the string. 
		public static void main3(String args[]){ 
			String s1="  hello   "; 
			System.out.println(s1+"how are you");        // without trim() 
			System.out.println(s1.trim()+"how are you"); // with trim() 
			 }
			
		
		//toLowerCase() method:
		public static void main4(String args[]){
		    String s1="HELLO HOW Are You?";
		    String s1lower=s1.toLowerCase();
		    System.out.println(s1lower);}
		
		//toUpper() method:
		public static void main5(String args[]){ 
		    String s1="hello how are you"; 
		    String s1upper=s1.toUpperCase(); 
		    System.out.println(s1upper); 
		}

       //concat() method
		 public static void main6(String[] args) {
		      //------By using concat method----
		       String str1 = "Learn ";
		       String str2 = "Java";
		       // concatenate str1 and str2
		       System.out.println(str1.concat(str2)); // "Learn Java"

		       // concatenate str2 and str11
		       System.out.println(str2.concat(str1)); // "JavaLearn "
		     //--- By using + operator---
		       String s3 =  "hello";
		       String s4 = "Learners";
		     //  String s5 = s3.concat(s4); or
		          String s5 = s3 + s4;
		     //both of the above statement will give you the same result

		      // Three strings are concatenated
		       String message = "Welcome " + "to " + "Java";

		     // String Chapter is concatenated with number 2
		       String s = "Chapter" + 2; // s becomes Chapter2

		   // String Supplement is concatenated with character B
		       String s1 = "Supplement" + 'B'; // s1 becomes SupplementB
		   }

		 
		 //split() method

		 //The split() method divides the string at the specified regex and returns an array of substrings. The syntax of the string split() method is:
		// string.split(String regex, int limit)
		// regex - the string is divided at this regex (can be strings)
		// limit (optional) - controls the number of resulting substrings

		// If the limit parameter is not passed, split() returns all possible substrings.

		 //import java.util.Arrays;

		 public static void main7(String[] args) {
			    String vowels = "a::b::c::d:e";

			    // splitting the string at "::"
			    // storing the result in an array of strings
			    String[] result = vowels.split("::");

			    // converting array to string and printing it
			    System.out.println("result = " + Arrays.toString(result));
			  }

		 
		 //result = [a, b, c, d:e]
		// Here, we split the string at ::  Since the limit parameter is not passed, the returned array contains all the substrings.

	
}

