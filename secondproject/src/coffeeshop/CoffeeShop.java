package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class CoffeeShop {

	
	List<Product> products = new ArrayList<>();
	


	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("coffee");
		coffee.setPrice(5.44);
		products.add(coffee);
		
		
		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);
		
		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.77);
		products.add(cookie);
		
		printProduct(coffee);
		printProduct(tea);
		printProduct(cookie);
		
		
		printAllProducts();
	}
		public void printProduct(Product product) {
			System.out.println("Product name : " + product.getName() +
					"Price :" +
		product.getPrice());
		}
		
		public void printAllProducts() {
			for ( Product product : products) {
				printProduct(product);
			}
		}

	//	System.out.println("Price : " + coffee.getPrice());

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();

		double coffee = 5.43d;
		double tea = 4.33d;
		double cookie = 6.76d;

		double subTotal = 0;

		// 3 items of first product
		subTotal = coffee * 3;

		// 4 items of 2nd product
		subTotal = subTotal + (tea * 4);

		// 2 items of 3rd product
		subTotal = subTotal + (cookie * 2);

		System.out.println("SubTotal :\t " + subTotal);

		DecimalFormat df = new DecimalFormat("#,###.00");
		System.out.println("SubTotal :\t " + df.format(subTotal));

		double salesTax = subTotal * 0.10;
		System.out.println("Sales Tax : \t" + df.format(salesTax));

		double totalSale = subTotal + salesTax;
		System.out.println("Total :\t\t " + df.format(totalSale));

	}

}
