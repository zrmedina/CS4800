package hibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Order;
import hibernate.entity.Product;

public class MainDeleteProduct {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
		
		
		Product product = products.get(0);
	
		session.delete(product);
		session.getTransaction().commit();

	}

}
