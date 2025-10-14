package ar.com.emanuel.cyberia.domain;

import java.util.List;

import ar.com.emanuel.cyberia.enums.Privilegio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")

public class Usuario {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	private List<Privilegio> privilegios;
	
	

public Usuario(String nombre, String email, String password, List<Privilegio> privilegios) {
	this.nombre = nombre;
	this.email = email;
	this.password = password;
	this.privilegios = privilegios;
}

public String getNombre() {
	return nombre;
}
public String getEmail() {
	return email;
}
public List<Privilegio> getPrivilegios() {
	return privilegios;
}


}


