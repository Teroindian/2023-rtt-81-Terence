package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class OrderDetailDAO {

	public  OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM orderdetails od WHERE od.order.id = : orderId "
				+ "and od.product.id = :od.product_id ";
		
				
	  TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
	  
	  query.setParameter("orderId",orderId);
	  query.setParameter("productId",productId);
	  
	  
	  OrderDetail result = query.getSingleResult();
		return result;
		
		//List<OrderDetail> result = query.getResultList();
		//return result;
	  
	}
	
	
	
	
	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM orderdetails od WHERE od.id = ?1"; // Example of HQL to get all records of user class

		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter(1, id);

		OrderDetail result = query.getSingleResult();
		return result;
	}
	
	public void save ( OrderDetail save) { 
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		session.saveOrUpdate(save);
		t.commit();
	}
	
}
