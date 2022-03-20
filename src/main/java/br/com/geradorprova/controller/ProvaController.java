package br.com.geradorprova.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.Prova;
import br.com.geradorprova.model.UserSingleton;
import br.com.geradorprova.model.enumeration.TipoUsuario;
import br.com.geradorprova.service.ProvaService;

@Controller
@RequestMapping("/prova")
public class ProvaController {
	
	@Autowired
	ProvaService provaService;
	
	@GetMapping("/novo")
	public String formNew(Model model) {
		Prova prova = new Prova();
		model.addAttribute(prova);
		model.addAttribute("tagList", provaService.findAllTags());
		
		return "prova/form.html";
	}
	
	@PostMapping("/salvar")
	public String save(Prova prova) {
		
		if(Objects.isNull(UserSingleton.getInstance())) {
			return "redirect:/index";
		}
		
		provaService.save(prova);
		
		return "redirect:/prova/listar";
	}
	
//	@PostMapping("/gerar")
//	public String generate(@Valid Prova prova) {
//		
//		provaService.generate(prova);
//		
//		return "redirect:/prova/listar";
//	}

	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Long id) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo()) || TipoUsuario.ALUNO.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/index";
		}
		
		provaService.delete(id);
		
		return "redirect:/prova/listar";
	}

	@GetMapping("/realizar/{id}")
	public String formExecProva(@PathVariable Long id, Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo()) || TipoUsuario.PROFESSOR.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/index";
		}
		
		Prova prova = provaService.findById(id);
		
		model.addAttribute("prova", prova);
		
		return "prova/realizar.html";
	}

	@GetMapping("/listar")
	public String list(Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo())) {
			return "redirect:/index";
		}
		
		List<Prova> provas = provaService.listAll();
		model.addAttribute("provaList", provas);
		
		return "prova/listar";
	}
	
	@GetMapping("/corrigir/{id}")
	public String rectify(@PathVariable Long id, Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo()) || TipoUsuario.ALUNO.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/index";
		}
		
		Prova prova = provaService.rectify(id);
		model.addAttribute("prova", prova);
		
		return "prova/corrigir.html";
	}
	
}
