package projetoGenerico.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_CUSTOMER")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3370720362753379174L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TB_CUSTOMER")
	@SequenceGenerator(name = "SEQ_TB_CUSTOMER", sequenceName = "SEQ_TB_CUSTOMER", allocationSize = 1)
	private long id;
	@Column(name = "NAME", nullable = false, length = 255)
	private String name;

	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "MOTHER_NAME", length = 255)
	private String motherName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "CPF", length = 11, nullable = false)
	private String cpf;

	@Column(name = "RG", length = 11, nullable = true)
	private String rg;

	@Column(name = "PASSWORD", length = 255, nullable = false)
	private String password;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ACTIVE")
	private Boolean active;

	public Customer() {
	}

	public Customer(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Customer(String name, String email, String motherName, Date birthDate, String cpf, String rg,
			String password, String phone) {
		this.name = name;
		this.email = email;
		this.motherName = motherName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.password = password;
		this.phone = phone;
	}

	public Customer(long id, String name, String email, String motherName, Date birthDate, String cpf, String rg,
			String password, String phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.motherName = motherName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.password = password;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
