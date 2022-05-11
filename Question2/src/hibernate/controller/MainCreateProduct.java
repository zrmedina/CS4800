package hibernate.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Order;
import hibernate.entity.Product;

public class MainCreateProduct {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		Product product1 = new Product(11);
		Product product2 = new Product(12);
		
		session.beginTransaction();
		session.save(product1);
		session.save(product2);
		session.getTransaction().commit();


	}

}
