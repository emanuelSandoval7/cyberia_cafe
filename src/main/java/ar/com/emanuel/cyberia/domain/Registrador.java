package ar.com.emanuel.cyberia.domain;

import java.util.ArrayList;

import ar.com.emanuel.cyberia.enums.Privilegio;
import ar.com.emanuel.cyberia.interfaces.Registro;

public class Registrador implements Registro{
	@Override
	public Usuario nuevoUsuario(String nombre, String email, String password) {
		return new Usuario(nombre, email, password, new ArrayList<Privilegio>());
	}

}
