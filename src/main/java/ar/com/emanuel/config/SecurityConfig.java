package ar.com.emanuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import ar.com.emanuel.cyberia.enums.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.formLogin(page -> page.loginPage(("/login")));
		
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/sec/**").hasAnyRole(Permiso.ADMINISTRADOR.name(), Permiso.USUARIO.name())
												  	  .requestMatchers("/sec/admin/**").hasRole(Permiso.ADMINISTRADOR.name())
												  	  .requestMatchers("/adm/**").hasAnyRole(Permiso.ADMINISTRADOR.name())
												  	  .anyRequest().permitAll());
		return http.build();
	}

}
