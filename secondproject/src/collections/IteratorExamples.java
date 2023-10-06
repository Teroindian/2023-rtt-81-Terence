 package collections;

import java.util.ArrayList;
import java.util.Iterator; // Import Iterator class

public class IteratorExamples {
    public static void main(String[] args) {
    	
    	// pos 012345
    	// val abcdef
        
        ArrayList<String> strings = new ArrayList<>();
        
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        
        for (String string : strings) {
            System.out.println(string);
        }

        strings.remove(0);
        
        System.out.println("============");
        
        
        Iterator<String> itr = strings.iterator(); // Specify the type for Iterator
        while (itr.hasNext()) { // Fix the hasNext method
            System.out.println(itr.next()); // Fix the next method
        }
    }
}