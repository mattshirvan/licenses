package com.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.services.DolService;

@Controller
public class DolController {
	private final DolService dolService;
	
	public DolController(DolService dolService) {
		this.dolService = dolService;
	}
	
	@RequestMapping("/persons/new")
	public String Index(@ModelAttribute("person") Person person) {
		return "Index";
	}
	
	@RequestMapping(value="/persons/create", method=RequestMethod.POST) 
	public String New(@Valid @ModelAttribute("person") Person person, BindingResult result){
		
		if (result.hasErrors()) {
			return "/persons/new";
		}
		
		else {
			dolService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/licenses/new")
	public String NewLicense(@ModelAttribute("license") License license, @ModelAttribute("person") Person person, Model model) {
		List<Person> people = dolService.getUnlicensed();
		model.addAttribute("people", people);
		return "License";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String CreateLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		
		if (result.hasErrors()) {
			return "License";
		}
		
		else {
			dolService.createLicense(license);
			return "redirect:/persons/new";
		}
	}
}
