package ar.com.emanuel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.com.emanuel.cyberia.domain.Registrador;
import ar.com.emanuel.cyberia.domain.Usuario;
import ar.com.emanuel.cyberia.interfaces.Registro;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    	
    	Registro registro = new Registrador();
    	Usuario u = registro.nuevoUsuario("Ema", "ema@mail.com", "secreto123");
    	
    	System.out.printf("Usuario creado: %s \n Mail: %s \n", u.getNombre(), u.getEmail());
    	System.out.println("los privilegios que tengo son: " +u.getPrivilegios());
    }
    }


