package org.perscholas.database;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;

public class CreateAndUpdateExample {

	private CustomerDAO customerDao = new CustomerDAO();
	
	private OrderDAO orderDao = new OrderDAO();
	
	public void insertCustomerExample ()  { 
		Customer c = new Customer ();
		
		c.setCustomerName("Series Reminder LLC");
		c.setContactFirstname( "Eric");
		c.setContactLastname( "Heilig");
		c.setAddressLine1( " Address Line 1");
		c.setAddressLine2( " Address Line 2");
		c.setCity("Denver");
		c.setState(" Colorado");
		c.setPostalCode("80203");
		c.setCountry("USA");
		c.setCreditLimit(10000.00);
		c.setPhone("555-555-1212");
		
		
		customerDao.save(c);
		
	} 
	
	public void updateCustomerExample() {
		Customer c = customerDao.findById(103);
		
		if ( c!= null) {
		System.out.println(" Customer Name : " + c.getCustomerName());
		
		c.setContactFirstname(" Updated Firstname" );
		c.setContactLastname(  " Updated Lastname");
		//c.setCreditLimit(44444.44);
	//	c.setSalesRepEmployeeId(1002);
		
		customerDao.save(c);;
		
		} else { 
			System.out.println("Customer does not exist");
		}
	}
	
	
	public void listQuery() {
      List<Customer> customers = customerDao.findByFirstName("Eric");
        System.out.println(" We found " + customers.size() + "records in the database  ");
	}
	
	
	// --- CUSTOMER DAO CODE COMMENTED BELOW
	
	//	public static void main(String[] args) {
	//		CreateAndUpdateExample caue = new CreateAndUpdateExample();
		//	caue.insertCustomerExample();
	//		caue.updateCustomerExample();
	//	}
	
	
	public static void main(String[] args) {
		  CreateAndUpdateExample caue = new CreateAndUpdateExample();

		  // Create a Scanner object to read user input
		  Scanner scanner = new Scanner(System.in);

		  // Ask the user for a customer ID
		  System.out.println("Enter customer ID: ");
		  int customerId = scanner.nextInt();

		  // Query the customer from the database
		  Customer customer = caue.customerDao.findById(customerId);

		  // If the customer ID exists in the database, create a new order
		  if (customer != null) {
		    Order order = new Order();
		    order.setCustomerId(customerId);
		    order.setRequiredDate(new Date());
		    order.setStatus("NEW");

		    // Set the order details, such as the items ordered and the shipping address

		    // Set the order date to the current date
		    order.setOrderDate(new Date());

		    // Create the order in the database
		    caue.orderDao.save(order);

		    System.out.println("Order created successfully!");
		  } else {
		    System.out.println("Customer ID does not exist.");
		  }
		}

	
}
