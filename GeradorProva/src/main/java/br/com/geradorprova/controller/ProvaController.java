package br.com.geradorprova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.service.ProvaService;

@Controller
@RequestMapping("/gerador/prova")
public class ProvaController {
	
	@Autowired
	ProvaService provaService;

	@PostMapping("/cadastrar")
	public String cadastrarProva(Model model) {
		
		return null;
	}
	
	@GetMapping("/listar")
	public String listarProvas(Model model) {
		
		return null;
	}
	
	@GetMapping("/listar/concluidas")
	public String listarProvasConcluidas(Model model) {
		
		return null;
	}

	@GetMapping("/listar/corrigidas")
	public String listarProvasCorrigidas(Model model) {
		
		return null;
	}
	
	@PostMapping("/editar/{id}")
	public String editarProva(@PathVariable Long id, Model model) {
		
		return null;
	}
	
	@PostMapping("/deletar/{id}")
	public String deletarProva(@PathVariable Long id, Model model) {
		
		return null;
	}
	
	@PostMapping("/corrigir/{id}")
	public String corrigirProva(@PathVariable Long id, Model model) {
		
		return null;
	}
	
	@PostMapping("/realizar/{id}")
	public String realizarProva(Model model) {
		
		return null;
	}
	
}
