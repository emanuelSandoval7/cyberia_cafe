package ar.com.emanuel.cyberia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {
	@JsonProperty(value = "user")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
