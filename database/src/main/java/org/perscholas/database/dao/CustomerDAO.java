package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;

public class CustomerDAO {

	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.id = ?1"; // Example of HQL to get all records of user class

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter(1, id);
		
 ///exception error reading
		try { 
			Customer result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) { 
			return null;
		}
		
	//Customer result = query.getSingleResult();
	//	return result;
	}
	
	
	

	
	public List<Customer> findByFirstName(String fname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.contactFirstname =  : firstname"; // Example of HQL to get all records of user class

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);
	//	query.setParameter("lastname", lname);

		
		List<Customer> result = query.getResultList();
		return result;
	}

	public void save ( Customer save) { 
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction t = session.beginTransaction();
		
		session.saveOrUpdate(save);
		t.commit();
	}
	
	
}
