package br.com.geradorprova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.UserSingleton;
import br.com.geradorprova.model.enumeration.TipoUsuario;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping("index")
	public String index() {
		return "index.html";
	}

	@GetMapping("login/{tipo}")
	public String login(@PathVariable String tipo) {
		
		UserSingleton.getInstance().setTipo(TipoUsuario.valueOf(tipo));
		
		return "home.html";
	}
	
	@GetMapping("home")
	public String home() {
		
		return "home.html";
	}
	
	@GetMapping("logout")
	public String logout() {
		
		UserSingleton.destroyInstance();
		
		return "index.html";
	}
	
}
