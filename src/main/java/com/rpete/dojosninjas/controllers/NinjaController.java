package com.rpete.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpete.dojosninjas.models.Dojo;
import com.rpete.dojosninjas.models.Ninja;
import com.rpete.dojosninjas.services.DojoService;
import com.rpete.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	// returns jsp template to add a new dojo
	@RequestMapping("/ninjas/new")
	public String addNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Ninja> ninjas = ninjaService.allNinjas();
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("ninjas", ninjas);
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@RequestMapping("/ninja/create")
	public String processAddNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
