package ar.com.emanuel.cyberia.forms;
/*FORM es un POJO, osea, un DTO*/

public class UserForm {
	private Long id;
	private String email;
	
	
	public boolean esCreacion() {
		return this.id == null || this.id < 1;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
