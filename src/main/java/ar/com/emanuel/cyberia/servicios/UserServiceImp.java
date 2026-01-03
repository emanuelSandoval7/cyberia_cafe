package ar.com.emanuel.cyberia.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.dto.UsuarioDTO;
import ar.com.emanuel.cyberia.repositorios.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserRepository repository;
	
	private ModelMapper mapper = new ModelMapper();
	

	public void guardarUsuario(Usuario u) {
		this.repository.save(u);
	}

	public Usuario obtener(Long id) {
		Optional<Usuario> user = this.repository.findById(id);
		return user.get();
	}
	
	@Override
	public Usuario obtener(String email) {
		List<Usuario> usuarios = this.repository.findByEmail(email);
		
		return usuarios.get(0);
	}

	@Override
	public List<UsuarioDTO> listAll() {
		List<Usuario> usuario = this.repository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		
		for (Usuario user : usuario) {
			usuariosDTO.add(mapper.map(user,  UsuarioDTO.class));
		}
		
		return usuariosDTO;
	
	}

	@Override
	public boolean userExists(String email) {
		boolean exists = false;
		
		if(email != null) {
			List<Usuario> result = this.repository.findByEmail(email);
			exists = !result.isEmpty();
		}
		return exists;
	}
	}


