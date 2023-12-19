package com.practice1.back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.back.dtos.PersonaDto;
import com.practice1.back.services.PersonaService;

@RestController
@RequestMapping(path = "/persona")
public class PersonaResource {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<PersonaDto> findAllPersonas() {
        return personaService.findAllPersonas();
    }
}
