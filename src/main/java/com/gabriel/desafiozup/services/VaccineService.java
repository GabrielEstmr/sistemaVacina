package com.gabriel.desafiozup.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.desafiozup.domain.Vaccine;
import com.gabriel.desafiozup.repositories.VaccineRepository;

@Service
public class VaccineService {
	
	@Autowired
	private VaccineRepository repo;
	
	public Vaccine find(Integer id) {
		Optional<Vaccine> obj = repo.findById(id);
		return obj.orElse(null); 
	}
}




