package ar.com.emanuel.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.dto.UsuarioDTO;
import ar.com.emanuel.cyberia.forms.UserForm;
import ar.com.emanuel.cyberia.servicios.UserService;

@RestController
public class UserAPIRestService {
	@Autowired
	private UserService service;
	
	
	@GetMapping(value = "/api/users", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsuarioDTO>> list() {
		List<UsuarioDTO> usuarios = this.service.listAll();
		
		return ResponseEntity.ok(usuarios);
	}

	@PostMapping(value = "/api/users/save", 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody UserForm formulario) {
		List<UsuarioDTO> usuarios = this.service.listAll();
		
		formulario.getEmail();
		
		return ResponseEntity.ok("Todo OK");
	}
}
