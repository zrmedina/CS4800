package hibernate.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Order;
import hibernate.entity.Product;

public class MainDeleteOrder {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		List<Order> orders = session.createQuery("FROM Order", Order.class).getResultList();
		
		
		Order order = orders.get(0);
	
		session.delete(order);
		session.getTransaction().commit();

	}

}
