package com.migonos.practice1projects.repository;

import org.springframework.data.repository.CrudRepository;

import com.migonos.practice1projects.entity.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
