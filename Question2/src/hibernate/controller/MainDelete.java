package hibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Customer;
import hibernate.entity.Professor;


public class MainDelete {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Professor.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Customer> customers = session.createQuery("FROM Customer", Customer.class).getResultList();
	
		
		Customer customer = customers.get(0);
		
		session.delete(customer);
		session.getTransaction().commit();

	}

}

