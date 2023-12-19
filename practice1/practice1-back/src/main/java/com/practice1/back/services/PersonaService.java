package com.practice1.back.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice1.back.dtos.PersonaDto;
import com.practice1.back.entities.Persona;
import com.practice1.back.mappers.PersonaMapper;
import com.practice1.back.repositories.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PersonaMapper personaMapper;

    public List<PersonaDto> findAllPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        personaRepository.findAll().forEach(personas::add);
        return personaMapper.toDto(personas);
    }
}
