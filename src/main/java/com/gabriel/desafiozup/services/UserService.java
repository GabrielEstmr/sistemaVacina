package com.gabriel.desafiozup.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.desafiozup.domain.User;
import com.gabriel.desafiozup.repositories.UserRepository;
import com.gabriel.desafiozup.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User find(Integer id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public User insert(User obj) {
		//Para garantir que o obj tenha id nulo > para o proprio JPA criar o id de acordo com a estratégia definida
		//Pois o metodo save do JPA se nao tiver id nulo ele considera que é uma atualização e nao uma inserção
		obj.setId(null);
		return repo.save(obj);
		
	}

}
