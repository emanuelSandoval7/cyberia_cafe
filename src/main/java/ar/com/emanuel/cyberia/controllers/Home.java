package ar.com.emanuel.cyberia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class Home {
	
	@GetMapping("/")
	public String home() {
		return "home";

}
}