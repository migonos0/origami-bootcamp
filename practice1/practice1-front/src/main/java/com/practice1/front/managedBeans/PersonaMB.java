/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.managedBeans;

import com.practice1.front.models.Persona;
import com.practice1.front.services.PersonaService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author miguel
 */
@SessionScoped
@Named("personaMB")
public class PersonaMB implements Serializable {

    private List<Persona> personas;
    @Inject
    private PersonaService personaService;

    @PostConstruct
    public void onLoad() {
        this.personas = personaService.findAllPersonas();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

}
