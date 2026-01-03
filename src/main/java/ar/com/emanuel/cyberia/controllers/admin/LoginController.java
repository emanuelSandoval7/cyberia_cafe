package ar.com.emanuel.cyberia.controllers.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.forms.LoginForm;
import ar.com.emanuel.cyberia.forms.validators.LoginFormValidator;
import ar.com.emanuel.cyberia.servicios.UserService;

@Controller
public class LoginController {
	private static final String LOGIN_CONTEXT_URL = "/login";
	private static final String LOGIN_PAGE_URL = "unsecured/login";
	private static final String FORM_ATTRIBUTE = "loginform";
	
	@Autowired
	private UserService servicio;
	@Autowired
	private LoginFormValidator validator;
	
	@InitBinder(value = FORM_ATTRIBUTE)
	void initLoginFormValidator(WebDataBinder binder) {
		binder.addValidators(this.validator);
	}

	@GetMapping(value = LOGIN_CONTEXT_URL)
	public String LoginForm(Model model) {
		model.addAttribute("loginform", new LoginForm());
		return LOGIN_PAGE_URL;
	}
	
	@PostMapping("/signIn")
	public String signIn(@Validated @ModelAttribute(name = FORM_ATTRIBUTE) LoginForm formulario, BindingResult result) {
		Usuario usuario = this.servicio.obtener(formulario.getEmail());
		
		SecurityContext contexto = SecurityContextHolder.getContext();
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(formulario.getEmail(), null, usuario.collectAuthorities());
	
		contexto.setAuthentication(authentication);
		
		return "/home";
	}
}
