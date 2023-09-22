package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CoffeeShop {

	
	List<Product> products = new ArrayList<>();
	
	List<Product> order = new ArrayList<>();
	Scanner input = new Scanner ( System.in);


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
		
		
		Product sandwich = new Product();
		sandwich.setName("Egg && Cheese Muffin");
		sandwich.setPrice(19.99);
		products.add(sandwich);
		
		//printProduct(coffee);
		//printProduct(tea);
	//	printProduct(cookie);
		
		
	//	printAllProducts();
	}
	
	
	//print product name + tab + price ASSIGNMENT
		public void printProduct(Product product) {
			System.out.println( product.getName() +
					"\t"+
		product.getPrice());
		}
		
		public void printAllProducts() {
			for ( Product product : products) {
				printProduct(product);
			}
		}

	//	System.out.println("Price : " + coffee.getPrice());

	public void example () { 
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
	
	public int displayMainUserMenu () {
		System.out.println( "1 Print Menu Items and prices");
		System.out.println( "2 Add item to your order");
		System.out.println( "3 Print Items in your order");
		System.out.println( "4 Checkout");
		
		System.out.println("What do you want to do ?");
		int select = input.nextInt();
		input.nextLine();
		return select;
	}
	
	public void userSelectProduct() { 
		System.out.println("Enter product name to order ");
		String orderSelection = input.nextLine();
		
		
		for ( Product product : products) {
		       if ( product.getName().equalsIgnoreCase(orderSelection)) {
		    	   order.add(product);
		    	   System.out.println("Added" + product.getName()  +    "to your order");
		    	   
		}
		
		}
		
	}
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();
		cf.printAllProducts();

		int userSelection = cf.displayMainUserMenu();
		if ( userSelection == 1) { 
			cf.printAllProducts();
		} else if  (userSelection == 2) {
			cf.userSelectProduct();
		}else if  (userSelection == 3) {
			//TO DO HOMEWORK DISPLAY PRODUCTS IN THE ORDER LIST HERE
			System.out.println("Products in your order :");
			for(Product product : cf.order) {
				cf.printProduct(product);
			}
		}else if  (userSelection == 5) {
			System.exit(0);
		} else {
			System.out.println("User input "+ userSelection + 
			" is unknown.   Try again");
		}
		
	}

}

