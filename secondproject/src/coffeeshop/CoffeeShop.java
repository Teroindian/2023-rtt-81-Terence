package coffeeshop;

import java.text.DecimalFormat;

public class CoffeeShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double coffee = 5.43d;
		double tea = 4.33d;
		double cookie = 6.76d;
		
		double subTotal = 0;
		
		//3 items of first product
		subTotal = coffee * 3;
		
		//4 items of 2nd product
		subTotal = subTotal + (tea * 4 );
		
		//2 items of 3rd product
		subTotal = subTotal + (cookie * 2 );
		
		
		System.out.println("SubTotal : " + subTotal);
		
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println("SubTotal : " + df.format(subTotal));

	}

}
