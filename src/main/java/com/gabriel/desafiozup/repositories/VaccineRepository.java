package com.gabriel.desafiozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.desafiozup.domain.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>{

}
