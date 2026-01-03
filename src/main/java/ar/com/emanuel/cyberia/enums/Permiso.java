package ar.com.emanuel.cyberia.enums;

public enum Permiso {
	ADMINISTRADOR,
	USUARIO;
	
	public String securityName() {
		return "ROLE_" + name();
	}
}
