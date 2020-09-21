package com.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.relationships.models.License;
import com.relationships.models.Person;
import com.relationships.repositories.LicenseRepository;
import com.relationships.repositories.PersonRepository;

@Service
public class DolService {
	private final PersonRepository personRepository;
	private final LicenseRepository licenseRepository;
	
	public DolService(PersonRepository personRepository, LicenseRepository licenseRepository) {
		this.personRepository = personRepository;
		this.licenseRepository = licenseRepository;
	}
	
	public List<Person> getPeople() {
		return personRepository.findAll();
	}
	
	public Person getPerson(Long id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public List<Person> getUnlicensed() {
		return personRepository.findByLicenseIdIsNull();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	
	public License createLicense(License license) {
		int number = this.generateLicenseNumber();
		license.setNumber(number);
		return licenseRepository.save(license);
	}
	
	public int generateLicenseNumber() {
		License license = licenseRepository.findTopByOrderByNumberDesc();
		
		if (license == null) {
			return 1;			
		}
		int number = license.getNumber();
		number++;
		return number;
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
}
