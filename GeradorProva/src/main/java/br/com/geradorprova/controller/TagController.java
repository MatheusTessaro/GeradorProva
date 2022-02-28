package br.com.geradorprova.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.Tag;
import br.com.geradorprova.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	@GetMapping("/novo")
	public String tagFormNew(Model model) {
		Tag tag = new Tag();
		model.addAttribute("tag", tag);
		
		return "tag/form.html";
	}
	
	@PostMapping("/salvar")
	public String saveTag(@Valid Tag tag, Model model) {
		
		tagService.saveTag(tag);
		
		return "redirect:/tag/listar";
	}
	
	@PostMapping("/deletar/{id}")
	public String deleteTag(@PathVariable Long id, Model model) {
		
		tagService.deleteTag(id);
		
		return "redirect:/tag/listar";
	}
	
	@PostMapping("/editar/{id}")
	public String tagFormEdit(@PathVariable Long id, Model model) {
		
		Tag tag = tagService.findById(id);
		model.addAttribute("tag", tag);
		
		return "tag/form.html";
	}
	
	@GetMapping("/listar")
	public String ListTags(Model model) {
		model.addAttribute("taglist", tagService.listTag());
		
		return "tag/listar.html";
	}

}
