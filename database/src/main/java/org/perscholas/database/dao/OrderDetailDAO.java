package org.perscholas.database.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class OrderDetailDAO {

	public OrderDetail findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM orderdetails od WHERE od.id = ?1"; // Example of HQL to get all records of user class

		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter(1, id);

		OrderDetail result = query.getSingleResult();
		return result;
	}
	
}
