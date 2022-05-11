package hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")
	private int professor_id;
	
	@Column(name="office_number")
	private String office_number;
	
	@Column(name="research_area")
	private String research_area;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public Professor(String office_number, String research_area, Customer customer) {
		super();
		this.office_number = office_number;
		this.research_area = research_area;
		this.customer = customer;
	}
	
	

	public Professor() {
		super();
	}



	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public String getOffice_number() {
		return office_number;
	}

	public void setOffice_number(String office_number) {
		this.office_number = office_number;
	}

	public String getResearch_area() {
		return research_area;
	}

	public void setResearch_area(String research_area) {
		this.research_area = research_area;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	
	
	
	
}
