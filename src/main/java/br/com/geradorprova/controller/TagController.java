package br.com.geradorprova.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.geradorprova.model.Tag;
import br.com.geradorprova.model.enumeration.TipoUsuario;
import br.com.geradorprova.pattern.singleton.UserSingleton;
import br.com.geradorprova.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	@GetMapping("/novo")
	public String tagFormNew(Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo())) {
			return "redirect:/logout";
		}else if(TipoUsuario.ALUNO.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/home";
		}
		
		Tag tag = new Tag();
		model.addAttribute("tag", tag);
		
		return "tag/form.html";
	}
	
	@PostMapping("/salvar")
	public String save(Tag tag, Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo())) {
			return "redirect:/logout";
		}else if(TipoUsuario.ALUNO.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/home";
		}
		
		tagService.save(tag);
		
		return "redirect:/tag/listar";
	}
	
	@GetMapping("/deletar/{id}")
	public String delete(@PathVariable Long id) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo())) {
			return "redirect:/logout";
		}else if(TipoUsuario.ALUNO.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/home";
		}
		
		tagService.delete(id);
		
		return "redirect:/tag/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String formEdit(@PathVariable Long id, Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo())) {
			return "redirect:/logout";
		}else if(TipoUsuario.ALUNO.equals(UserSingleton.getInstance().getTipo())) {
			return "redirect:/home";
		}
		
		Tag tag = tagService.findById(id);
		model.addAttribute("tag", tag);
		
		return "tag/form.html";
	}
	
	@GetMapping("/listar")
	public String list(Model model) {
		
		if(Objects.isNull(UserSingleton.getInstance().getTipo())) {
			return "redirect:/logout";
		}
		
		model.addAttribute("tagList", tagService.list());
		model.addAttribute("usuario" ,UserSingleton.getInstance());
		
		return "tag/listar.html";
	}

}
