package hibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Order;
import hibernate.entity.Product;

public class MainCreateOrder {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Order order = new Order();
		
		List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
		
		Product product1 = products.get(0);
		Product product2 = products.get(1);
		order.getProducts().add(product1);
		order.getProducts().add(product2);
		
		session.save(order);
		session.getTransaction().commit();
	}

}
