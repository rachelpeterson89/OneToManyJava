package com.rpete.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rpete.dojosninjas.models.Ninja;
import com.rpete.dojosninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	// returns all ninjas
	public List<Ninja> allNinjas() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
	
	// creates a new ninja
	public Ninja createNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	// retrieves a ninja by id
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	// method for updating ninja from jsp form
	public Ninja updateNinja1(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	// updates a ninja
	public Ninja updateNinja(Long id, String firstName, String lastName, int age) {
		Ninja optionalNinja = this.findNinja(id);
		optionalNinja.setFirstName(firstName);
		optionalNinja.setLastName(lastName);
		optionalNinja.setAge(age);
		return ninjaRepo.save(optionalNinja);
	}
	
	// deletes a ninja by id
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
		return;
	}
}
