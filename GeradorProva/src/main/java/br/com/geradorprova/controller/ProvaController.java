package br.com.geradorprova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.Prova;
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
		
//		return "prova/form.html";
		return "index.html";
	}
	
	@PostMapping("/salvar")
	public String save(@Valid Prova prova) {
		
		
//		return "redirect:/prova/listar";
		return "index.html";
	}

	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Long id) {
		
		provaService.delete(id);
		
//		return "redirect:/prova/listar";
		return "index.html";
	}

	@GetMapping("/realizar/{id}")
	public String formExecProva(@PathVariable Long id, Model model) {
		Prova prova = provaService.findById(id);
		
		model.addAttribute("prova", prova);
		
//		return "prova/formExecProva.html";
		return "index.html";
	}

	@GetMapping("/listar")
	public String list(Model model) {
		List<Prova> provas = provaService.listAll();
		model.addAttribute("provaList", provas);
		
		return "prova/listar";
//		return "index.html";
	}
	
	@GetMapping("/corrigir/{id}")
	public String rectify(@PathVariable Long id, Model model) {
		Prova prova = new Prova();
		prova = provaService.autoRectify(id);
		model.addAttribute("prova", prova);
		
//		return "prova/rectify.html";
		return "index.html";
	}
	
}
