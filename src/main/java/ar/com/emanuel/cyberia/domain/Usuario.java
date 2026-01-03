package ar.com.emanuel.cyberia.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import ar.com.emanuel.cyberia.enums.Permiso;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")

public class Usuario {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	
	@Enumerated(EnumType.ORDINAL)
	@ElementCollection(targetClass = Permiso.class)
	@CollectionTable(name = "permisos_usuarios", joinColumns = @JoinColumn(name = "usuario_id"))
	@Column(name = "permiso_id")
	private List<Permiso> permisos;
	
	/* Hibernate*/
	Usuario() {
		
	}
	
	public void convertirEnAdministrador() {
		this.permisos.add(Permiso.ADMINISTRADOR);
	}
	
	public List<GrantedAuthority> collectAuthorities(){
		List<GrantedAuthority> credentials = new ArrayList<GrantedAuthority>();
		
		for (Permiso permiso : this.permisos) {
			credentials.add(new SimpleGrantedAuthority(permiso.securityName()));
		}
		
		return credentials;
	}

	public Usuario(String email) {
	this.email = email;
	}
	
	public Long getId() {
	return id;
	}
	
	public String getEmail() {
	return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
		this.permisos = new ArrayList<Permiso>();
		this.permisos.add(Permiso.USUARIO);
	}


}


