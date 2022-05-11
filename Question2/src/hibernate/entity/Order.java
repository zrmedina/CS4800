package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int order_id;
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	@JoinTable(
		name = "order_products",
		joinColumns = {@JoinColumn(name="order_id")},
		inverseJoinColumns = {@JoinColumn(name="product_id")})
	List<Product> products;

	public Order() {
		super();
		this.products = new ArrayList<Product>();
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
