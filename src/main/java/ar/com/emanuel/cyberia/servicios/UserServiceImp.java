package ar.com.emanuel.cyberia.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.repositorios.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository repository;

	public void guardarUsuario(Usuario u) {
		this.repository.save(u);
	}

}
