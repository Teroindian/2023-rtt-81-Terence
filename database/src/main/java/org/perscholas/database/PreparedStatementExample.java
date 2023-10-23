package org.perscholas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementExample {

	
	
	
	
	/* public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost/classic_models";
		String user = "root";
		String password = "root123*";
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional
			connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner scanner = new Scanner (System.in);
			
			System.out.println("Enter an employee first name : ");
			String firstname = scanner.nextLine();
			
			System.out.println("Enter an employee last name : ");
			String lastname = scanner.nextLine();
			
			// String sql = "Select * FROM employees where firstname = '" + firstname + "'";
			String sql = "Select * FROM employees WHERE firstname =  ? AND lastname = ?";
			System.out.println(sql);
			
			// this is the secure way of creating a query
			PreparedStatement stmt = connection.prepareStatement(sql);
			//the first ? in the query is position 1
			stmt.setString(1, firstname);
			 stmt.setString(2, lastname);
			
			
		//	Statement stmt = connection.createStatement();
			
			
			
			// 
			// passed it into the prepared statement
			
			ResultSet result = stmt.executeQuery(sql);
			
			while (result.next()) {
				Integer id = result.getInt("id");
				firstname = result.getString("firstname");
				lastname = result.getString("lastname");
				String email = result.getString("email");
				System.out.println(id + " | " + firstname + " | " + " | "+ lastname + " | " + email);
			}
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
		   
		}*/
		
	
	



	    public static void main(String[] args) throws SQLException {
	        String dburl = "jdbc:mysql://localhost/classic_models";
	        String user = "root";
	        String password = "root123*";
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver"); // optional
	            connection = DriverManager.getConnection(dburl, user, password);

	            Scanner scanner = new Scanner(System.in);

	            System.out.println("Enter an employee first name : ");
	            String firstname = scanner.nextLine();

	            System.out.println("Enter an employee last name : ");
	            String lastname = scanner.nextLine();

	            String sql = "Select * FROM employees WHERE firstname = ? AND lastname = ?";
	          //  System.out.println(sql);

	            // This is the secure way of creating a query
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, firstname);
	            stmt.setString(2, lastname);

	            // Execute the prepared statement, not the SQL string
	            ResultSet result = stmt.executeQuery();

	            while (result.next()) {
	                Integer id = result.getInt("id");
	                String employeeFirstname = result.getString("firstname");
	                String employeeLastname = result.getString("lastname");
	                String email = result.getString("email");
	                System.out.println(id + " | " + employeeFirstname + " | " + employeeLastname + " | " + email);
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
	}

		
		
		

	



//expand the output inside the while loop to also print out the last name
	// use the scanner to also ask for 
	// the last name and modify the query to search for 1st name and lastname
	
