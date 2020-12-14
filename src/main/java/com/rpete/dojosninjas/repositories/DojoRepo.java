package com.rpete.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rpete.dojosninjas.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}
