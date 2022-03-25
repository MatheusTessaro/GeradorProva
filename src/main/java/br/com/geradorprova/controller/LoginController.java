package br.com.geradorprova.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.Usuario;
import br.com.geradorprova.pattern.singleton.UserSingleton;
import br.com.geradorprova.service.UsuarioService;

@Controller
@RequestMapping
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "login.html";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("usuario" ,UserSingleton.getInstance());
		
		return "home.html";
	}
	
	@PostMapping("/login")
	public String login(Usuario usuario) {
		
		usuario = usuarioService.findUser(usuario.getLogin(), usuario.getSenha());
		
		if(Objects.isNull(usuario))
			return "login.html";
		
		UserSingleton.getInstance().setTipo(usuario.getTipo());
		
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		UserSingleton.destroyInstance();
		
		return "redirect:/";
	}
	
}
