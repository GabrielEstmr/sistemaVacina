package com.gabriel.desafiozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.desafiozup.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
