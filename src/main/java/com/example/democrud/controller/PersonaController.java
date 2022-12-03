package com.example.democrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceAPI;

@Controller
public class PersonaController {
	
	private PersonaServiceAPI personaServiceAPI;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("List", personaServiceAPI.getAll());
		return "index";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		
		if(id != null) {
			model.addAttribute("persona", personaServiceAPI.get(id));
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		personaServiceAPI.save(persona);
		return "redirect:/";
	}
	
	public String delete(@PathVariable Long id, Model model) {
		personaServiceAPI.delete(id);
		return "redirect:/";
	}
}





