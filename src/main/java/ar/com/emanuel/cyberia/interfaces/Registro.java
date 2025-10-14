package ar.com.emanuel.cyberia.interfaces;

import ar.com.emanuel.cyberia.domain.Usuario;

public interface Registro {
	Usuario nuevoUsuario(String nombre, String email, String password);
	
}