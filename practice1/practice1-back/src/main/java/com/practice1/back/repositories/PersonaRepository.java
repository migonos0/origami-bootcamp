package com.practice1.back.repositories;

import org.springframework.data.repository.CrudRepository;

import com.practice1.back.entities.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
