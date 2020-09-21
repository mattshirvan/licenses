package com.relationships.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.services.DolService;

@RestController
public class RelationshipApi {
	private final DolService service;
	
	public RelationshipApi(DolService service) {
		this.service = service;
	}
	
	@GetMapping("/api/people")
	public List<Person> index() {
		return service.getPeople();
	}
	
	@PostMapping("/api/people")
	public Person createPerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		Person person = new Person(firstName, lastName);
		return service.createPerson(person);
	}
	
	@GetMapping("/api/people/{id}")
	public Person getPerson(@PathVariable("id") Long id) {
		Person person = service.getPerson(id);
		return person;
	}
	
	@PutMapping("/api/people/{id}")
	public Person updatePerson(@PathVariable("id") Long id, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		Person person = service.getPerson(id);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		return service.updatePerson(person);
	}
	
	@DeleteMapping("/api/people/{id}")
	public void deletePerson(@PathVariable("id") Long id) {
		service.deletePerson(id);
	}
	
	@PostMapping("/api/licenses")
	public License createLicense(@RequestParam("expires") Date expires, @RequestParam("state") String state, @RequestParam("id") Long id) {
		License license = new License();
		Person person = service.getPerson(id);
		license.setState(state);
		license.setExpires(expires);
		license.setPerson(person);
		return service.createLicense(license);
	}
}
