package projetoGenerico.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3370720362753379174L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_CUSTOMER_GEN")
	@SequenceGenerator(name = "TB_CUSTOMER_GEN", sequenceName = "TB_CUSTOMER_GEN", allocationSize = 1)
	private long id;
	@Column(name = "NAME", nullable = false, length = 100)
	private String name;
	
	
	public Customer() {
	}

	public Customer(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
