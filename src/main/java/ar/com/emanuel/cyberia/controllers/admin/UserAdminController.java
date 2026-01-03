package ar.com.emanuel.cyberia.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.dto.UsuarioDTO;
import ar.com.emanuel.cyberia.forms.UserForm;
import ar.com.emanuel.cyberia.forms.validators.UserFormValidator;
import ar.com.emanuel.cyberia.servicios.UserService;


@Controller
public class UserAdminController {
	private static final String LIST_ATTRIBUTE = "listado";
	private static final String FORM_ATTRIBUTE = "form";
	private static final String PATH_PAGES_URL = "admin/users";
	private static final String PATH_CONTEXT_URL = "/adm/users";
	@Autowired
	private UserService servicio;
	@Autowired
	private UserFormValidator validator;

	
	
	@InitBinder(value = FORM_ATTRIBUTE)
	void initFormValidator(WebDataBinder binder) {
		binder.addValidators(this.validator);
	}
	
	@GetMapping(value = PATH_CONTEXT_URL)
	public String init(Model model) {
		List<UsuarioDTO> usuarios = this.servicio.listAll();
		model.addAttribute(LIST_ATTRIBUTE, usuarios);
		return  PATH_PAGES_URL + "/list";
	}
	
	@GetMapping(value = PATH_CONTEXT_URL + "/edit")
	public String edit(Model model, @RequestParam(name = "id", defaultValue = "-1") Long id) {
		UserForm formulario = new UserForm();
		
		if(id != null && id > 0) {
			Usuario usuario = this.servicio.obtener(id);
			
			formulario.setId(usuario.getId());
			formulario.setEmail(usuario.getEmail());
		}
	
		model.addAttribute(FORM_ATTRIBUTE, formulario);
		return PATH_PAGES_URL + "/form";
	}
	
	@PostMapping(value = PATH_CONTEXT_URL + "/save")
	public String save(@Validated @ModelAttribute(name = FORM_ATTRIBUTE) UserForm formulario, BindingResult resultados) {
		if(resultados.hasErrors()) return PATH_PAGES_URL + "/form";
		Usuario usuario;
		String email =  formulario.getEmail();
		
		if(formulario.esCreacion()) {
			usuario = new Usuario(email);
		} else {
			usuario = this.servicio.obtener(formulario.getId());
			usuario.setEmail(email);
		}
		this.servicio.guardarUsuario(usuario);
		return "redirect:" + PATH_CONTEXT_URL;
	}
	
	
	
	}
	