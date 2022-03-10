package br.com.geradorprova.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.Questao;
import br.com.geradorprova.model.Resposta;
import br.com.geradorprova.service.QuestaoService;

@Controller
@RequestMapping("/questao")
public class QuestaoController{
	
	@Autowired
	QuestaoService questaoService;

	@GetMapping("/novo")
	public String formNew(Model model) {
		Questao questao = new Questao();
//		questao.setRespostas(new ArrayList<>(Collections.nCopies(5, new Resposta())));
//		questao.setRespostas(Stream.generate(Resposta::new).limit(5).collect(Collectors.toList()));
		model.addAttribute(questao);
		model.addAttribute("tagList", questaoService.findAllTags());
		
		return "questao/form.html";
	}
	
	@PostMapping("/salvar")
	public String save(@Valid Questao questao, Model model) {
		
		questaoService.save(questao);
		
		return "redirect:/questao/listar";
	}

	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Long id) {
		
		questaoService.delete(id);
		
		return "redirect:/questao/listar";
	}

	@GetMapping("/editar/{id}")
	public String formEdit(@PathVariable Long id, Model model) {
		Questao questao = questaoService.findById(id);
		
		model.addAttribute("questao", questao);
		model.addAttribute("tagList", questaoService.findAllTags());
		
		return "questao/form.html";
	}

	@GetMapping("/listar")
	public String list(Model model) {
		
		List<Questao> questoes = questaoService.listAll();
		
		model.addAttribute("questaoList", questoes);
		
		return "questao/listar";
	}
	
}
