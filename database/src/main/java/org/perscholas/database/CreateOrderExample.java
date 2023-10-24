package org.perscholas.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.entity.Order;

public class CreateOrderExample {

	private OrderDAO orderDao = new OrderDAO();
	
	
	public void createOrder() throws ParseException{  
		
		Order order = new Order();
		
		//makes a new date object that represents right now
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd  HH:mm");
		Date requiredDate = sdf.parse("2023-10-31  12:30");
		
		//this is the # of millisecond since the epoch
		System.out.println(orderDate.getTime());
		
		
		order.setRequiredDate(requiredDate);
		//  below is set to null cause the order is not yet shipped
		order.setShippedDate(null);
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
