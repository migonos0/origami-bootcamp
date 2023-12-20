/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.converters;

import com.practice1.front.managedBeans.PersonaMB;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import com.practice1.front.models.Persona;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;

/**
 *
 * @author miguel
 */
@Named("personaConverter")
@FacesConverter(forClass = Persona.class)
@RequestScoped
public class PersonaConverter implements Converter<Persona> {

    @Inject
    private PersonaMB personaMB;

    @Override
    public Persona getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0 && personaMB.getPersonas() != null) {
            try {
                Persona foundPersona = personaMB.getPersonas().stream().filter(persona -> value.equals(persona.getId().toString())).findAny().orElse(null);
                return foundPersona;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Persona value) {
        try {
            if (value != null) {
                return String.valueOf(value.getId());
            } else {
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }
}
