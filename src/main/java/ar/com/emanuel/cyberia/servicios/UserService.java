package ar.com.emanuel.cyberia.servicios;

import java.util.List;

import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.dto.UsuarioDTO;

public interface UserService {
	
	public Usuario obtener(Long id);
	
	public void guardarUsuario(Usuario u);
	
	public List<UsuarioDTO> listAll();

	public boolean userExists(String email);

	public Usuario obtener(String email);
	

}
