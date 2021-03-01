package com.gabriel.desafiozup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.desafiozup.domain.User;
import com.gabriel.desafiozup.dto.UserDTO;
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
		
		
		User userEmail = repo.findByEmail(obj.getEmail());
		User userCPF = repo.findByCpf(obj.getCpf());
		
		String msg = "";
		
		try {
			obj.setId(null);
			return repo.save(obj);
		}catch(DataIntegrityViolationException e) {
			//DataIntegrityViolationException do meu Pacote
			
			if (userEmail != null) {
				msg = msg + " Email";
			}
			
			if (userCPF != null) {
				msg = msg + " CPF";
			}
			
			throw new DataIntegrityViolationException("Campo" + msg + " já consta nos registros do sistema.");
		}
		

		
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
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User fromDTO(UserDTO objDTO) {
		
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), objDTO.getCpf(), objDTO.getBday());
	}


}
