package br.com.geradorprova.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gerador/prova")
public class ProvaController {

	@PostMapping("/cadastrar")
	public String cadastrarProva(Model model) {
		
		return null;
	}
	
	@GetMapping("/listar/provas")
	public String listarProvas(Model model) {
		
		return null;
	}
	
	@GetMapping("/listar/provas/concluidas")
	public String listarProvasConcluidas(Model model) {
		
		return null;
	}

	@GetMapping("/listar/provas/corrigidas")
	public String listarProvasCorrigidas(Model model) {
		
		return null;
	}
	
	@PutMapping("/{id}")
	public String editarProva(@PathVariable Long id, Model model) {
		
		return null;
	}
	
	@DeleteMapping("/{id}")
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
