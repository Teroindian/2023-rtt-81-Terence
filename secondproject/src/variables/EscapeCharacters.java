package variables;

public class EscapeCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//The main ones to know are \t, \n and  \:
		//this is an example of tab escape character
		System.out.println("This is a tab character ->\t<-");
		
		//basic formatting with tabs
		System.out.println("1\tone\t\tCol3");
		System.out.println("10\tTen\t\tCol3");
		//this one is long so it need one tab character
		System.out.println("100\tOne Hundred\tCol3");
		
		//this an example of a new line character \n
		System.out.println("This is line 1 \nThis is line 2");
		System.out.println("This is line 3");
		
		//What happens if i want to print just a \
		System.out.println("To get a slash to print we need 2 of them \\");

	}

}
