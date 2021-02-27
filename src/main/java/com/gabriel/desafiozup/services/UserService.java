package com.gabriel.desafiozup.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.desafiozup.domain.User;
import com.gabriel.desafiozup.repositories.UserRepository;
import com.gabriel.desafiozup.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	
	private void updateData(User newObj,User obj) {
		//Aqui atualização de newObj
		newObj.setName(obj.getName());
		newObj.setCpf(obj.getCpf());
		newObj.setEmail(obj.getEmail());
		newObj.setBday(obj.getBday());
	}
	
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
	
	public User update(User obj) {
		//Verificação dse há o obj no banco, caso não haja > já lança um erro
		User newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		//Verificação dse há o obj no banco, caso não haja > já lança um erro
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			//DataIntegrityViolationException do meu Pacote
			throw new DataIntegrityViolationException("Não é possivel excluir um Usuário que contem Registros de Vacinação");
		}
	}


}
