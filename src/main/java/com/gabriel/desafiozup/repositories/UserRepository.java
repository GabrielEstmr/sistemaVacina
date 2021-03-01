package com.gabriel.desafiozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.desafiozup.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//Transactional faz transação ficar mais rápida e diminui loking do BD
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	User findByEmail(String email);
	
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	User findByCpf(String cpf);
	
}
