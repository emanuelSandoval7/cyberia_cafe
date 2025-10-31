package ar.com.emanuel.cyberia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.emanuel.cyberia.forms.UserForm;


/*@Controller
public class InicioController {
	private final String PATH = "/paginas";
	
	@GetMapping("/paginas/init")
	public String init(Model model) {
		model.addAttribute("iniciarFrm", new UserForm());
		return PATH + "/init";
	}
	
	@PostMapping("/paginas/iniciar")
	public String iniciar(UserForm formulario) {
		formulario.getUsername();
		return PATH + "/success";
	}
}
*/