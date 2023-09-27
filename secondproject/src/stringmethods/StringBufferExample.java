package stringmethods;

public class StringBufferExample {

	public static void main(String[] args) {

		//change x to be abc123xyz
		String x = "abcxyz";
		//Stringx1 = x.substring(0,3) + "123"+ x.substring(3);
		
		String y = x.toUpperCase();
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(" abc");
		buffer.append("xyz");
		
		//StringBuffer substring does the same as String substring
		String sub = buffer.substring(0,3);
		
		//you can insert into the string buffer anywhere
		buffer.insert(4, "123");
		
		
		System.out.println(buffer.toString());
	}

}
