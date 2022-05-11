package hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import hibernate.entity.Customer;
import hibernate.entity.Professor;


public class MainCreate {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Professor.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Customer customer = new Customer("Zoe Medina", "Chino Hills");
		Professor professor = new Professor("Bdg 3", "CS", customer);
		
		session.beginTransaction();
		session.save(professor);
		session.getTransaction().commit();

	}

}
