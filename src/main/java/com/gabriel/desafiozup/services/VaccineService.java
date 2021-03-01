package com.gabriel.desafiozup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gabriel.desafiozup.domain.User;
import com.gabriel.desafiozup.domain.Vaccine;
import com.gabriel.desafiozup.dto.VaccineDTO;
import com.gabriel.desafiozup.repositories.UserRepository;
import com.gabriel.desafiozup.repositories.VaccineRepository;
import com.gabriel.desafiozup.services.exceptions.ObjectNotFoundException;


@Service
public class VaccineService {
	
	@Autowired
	private VaccineRepository repo;
	
	@Autowired
	private UserRepository repoUser;
	
	private void updateData(Vaccine newObj,Vaccine obj) {
		newObj.setName(obj.getName());
		newObj.setAdmDate(obj.getAdmDate());
		
	}
	
	public Vaccine find(Integer id) {
		Optional<Vaccine> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Vaccine.class.getName()));
	}
	
	public Vaccine insert(Vaccine obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}
	
	public Vaccine update(Vaccine obj) {
		Vaccine newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir um Usuário que contem Registros de Vacinação");
		}
	}
	
	public List<Vaccine> findAll(){
		return repo.findAll();
	}
	
	
	
	public Vaccine fromDTO(VaccineDTO objDTO) {
		
		String userEmail = objDTO.getUserEmail();
		User userVaccine = repoUser.findByEmail(userEmail);
		
		if (userVaccine == null) {
			throw new DataIntegrityViolationException("Não é possivel criar um registro de Vacinação para um usuário ainda não cadastrado");
		} else {
			
			
			Vaccine vacineFromDTO =  new Vaccine(objDTO.getId(), objDTO.getName(), objDTO.getAdmDate(), userVaccine);
			
			return vacineFromDTO;
		}
		
		
	}


}




