package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class OrderProductsExample {

	// 1) Create a connection to the database classic_models
		// 2) Use the scanner to take input of an order number
		// 3) Write a query using a prepared statement to print out the product_id, product name, 
		//    quantity ordered, msrp, buy_price, margin (msrp-buy_price), and total margin (margin * quantity ordered)
		// try to make the output look nice
		
		// DOUBLE BONUS
		// 4) use a  java variable to calculate the total margin for the entire order (all products)
	
	/*
	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost/classic_models";
		String user = "root";
		String password = "root123*";
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scanner = new Scanner (System.in);
			System.out.println("Enter an order number : ");
			String ordernumber = scanner.nextLine();
			
			
			
			String sql = "Select * FROM orders where id = '" + ordernumber + "'";
			//System.out.println(sql);
			
			Statement stmt = connection.createStatement();
			
			
			ResultSet result = stmt.executeQuery(sql);
			
			
			while (result.next()) {
				Integer id = result.getInt("id");
			//	String name = result.getString("firstname");
			//	String email = result.getString("email");
				System.out.println(id ); // + " | " + name + " | " + email 
			}
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		   
		}
	*/
	
	
	


	    public static void main(String[] args) throws SQLException {
	        String dburl = "jdbc:mysql://localhost/classic_models";
	        String user = "root";
	        String password = "root123*";
	        Connection connection = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); // optional
	            connection = DriverManager.getConnection(dburl, user, password);

	            Scanner scanner = new Scanner(System.in);
	            System.out.println("Enter an order number: ");
	            String ordernumber = scanner.nextLine();

	            // Prepare a SQL query to retrieve product information for the given order number
	            String sql = "select o.id as order_id, p.product_code, p.product_name, od.quantity_ordered, p.buy_price, p.msrp, " +
	                    "(p.msrp - p.buy_price) as profit, " +
	                    "((p.msrp - p.buy_price) * od.quantity_ordered) as total_profit " +
	                    "from orders o, orderdetails od, products p " +
	                    "where o.id = ? " +
	                    "and od.order_id = o.id " +
	                    "and od.product_id = p.id";

	            // Create a prepared statement
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, ordernumber);
	            
	            // Execute the prepared statement and get the result set
	            ResultSet result = stmt.executeQuery();

	            // Print the header for the output
	            System.out.printf("%-15s %-15s %-40s %-15s %-10s %-10s %-10s %-15s%n",
	                    "Order ID", "Product Code", "Product Name", "Quantity", "Buy Price", "MSRP", "Profit", "Total Profit");

	            // Initialize a variable to calculate the total profit for the entire order
	            double totalOrderProfit = 0.0;

	            while (result.next()) {
	                String orderId = result.getString("order_id");
	                String productCode = result.getString("product_code");
	                String productName = result.getString("product_name");
	                int quantityOrdered = result.getInt("quantity_ordered");
	                double buyPrice = result.getDouble("buy_price");
	                double msrp = result.getDouble("msrp");
	                double profit = result.getDouble("profit");
	                double totalProfit = result.getDouble("total_profit");

	                // Update the total profit for the entire order
	                totalOrderProfit += totalProfit;

	                // Print product details for this order
	                System.out.printf("%-15s %-15s %-40s %-15s $%-10.2f $%-10.2f $%-10.2f $%-15.2f%n",
	                        orderId, productCode, productName, quantityOrdered, buyPrice, msrp, profit, totalProfit);
	            }

	            // Print the total profit for the entire order
	            System.out.println("Total Profit for the Entire Order: $" + totalOrderProfit);

	            result.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (connection != null) {
	                connection.close();
	            }
	        }
	    }
	
	
	
}
