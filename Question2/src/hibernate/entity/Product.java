package hibernate.entity;

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
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int product_id;

	public Product() {
		super();
	}
	
	@ManyToMany(cascade = {CascadeType.DETACH})
	@JoinTable(
		name = "order_products",
		joinColumns = {@JoinColumn(name="product_id")},
		inverseJoinColumns = {@JoinColumn(name="order_id")})
	List<Order> orders;
	

	public Product(int product_id) {
		super();
		this.product_id = product_id;
	}



	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	
}
