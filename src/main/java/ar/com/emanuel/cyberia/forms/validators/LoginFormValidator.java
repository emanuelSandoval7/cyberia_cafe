package ar.com.emanuel.cyberia.forms.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ar.com.emanuel.cyberia.forms.LoginForm;
import ar.com.emanuel.cyberia.servicios.UserService;

@Component
public class LoginFormValidator implements Validator {
	@Autowired
	private UserService servicio;

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginForm.class.equals(clazz);
	}
	

	@Override
	public void validate(Object target, Errors errors) {
		LoginForm f = (LoginForm) target;
		
		if(f.getEmail() == null || f.getEmail().isBlank()) {
			errors.rejectValue("email", "empty.email");
		} else {
			boolean exists = this.servicio.userExists(f.getEmail());
			if(exists) errors.rejectValue("email", "email.already.exists");
		}
	}

}