package ar.com.emanuel.cyberia.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginForm {
	@NotBlank(message = "El email es obligatorio")
	@Email(message = "Ingresa un email valido")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
