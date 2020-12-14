package com.rpete.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpete.dojosninjas.models.Dojo;
import com.rpete.dojosninjas.repositories.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	// returns all dojos
	public List<Dojo> allDojos() {
		return (List<Dojo>) dojoRepo.findAll();
	}
	
	// creates a new dojo
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// retrieves a dojo by id
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	// method for updating dojo from jsp form
	public Dojo updateDojo1(Dojo d) {
		return dojoRepo.save(d);
	}
	
	// updates a dojo
	public Dojo updateDojo(Long id, String name) {
		Dojo optionalDojo = this.findDojo(id);
		optionalDojo.setName(name);
		return dojoRepo.save(optionalDojo);
	}
	
	// deletes a dojo by id
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
		return;
	}
}
