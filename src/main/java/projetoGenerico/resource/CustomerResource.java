package projetoGenerico.resource;

import java.util.Date;

public class CustomerResource {

	private long id;
	private String name;
	private String email;
	private String motherName;
	private Date birthDate;
	private String cpf;
	private String rg;
	private String password;
	private String phone;
	private Boolean active;

	public CustomerResource() {
		
	}

	public CustomerResource(long id, String name, String email, String motherName, Date birthDate, String cpf,
			String rg, String password, String phone, Boolean active) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.motherName = motherName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.password = password;
		this.phone = phone;
		this.active = active;
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
