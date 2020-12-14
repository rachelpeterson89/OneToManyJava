package com.rpete.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpete.dojosninjas.models.Dojo;
import com.rpete.dojosninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
//	@RequestMapping("")
//	public String index() {
//		return "newDojo.jsp";
//	}
	
	// returns jsp template to add a new dojo
	@RequestMapping("/dojos/new")
	public String addDojo(Model model, @ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newDojo.jsp";
	}
	
	// creates new dojo upon form submission
	@RequestMapping("/dojo/create")
	public String processAddDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	// returns jsp template with all the dojo locations and their corresponding ninjas
	@RequestMapping("/dojo/{id}")
	public String showOneDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showOneDojo.jsp";
	}
	
	
}
