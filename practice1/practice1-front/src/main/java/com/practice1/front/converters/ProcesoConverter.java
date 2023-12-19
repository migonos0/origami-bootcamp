/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.converters;

import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import com.practice1.front.models.Proceso;
import com.practice1.front.models.managedbeans.CreateProjectBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;

/**
 *
 * @author miguel
 */
@Named("procesoConverter")
@FacesConverter(forClass = Proceso.class)
@RequestScoped
public class ProcesoConverter implements Converter<Proceso> {

    @Inject
    private CreateProjectBean createProjectBean;

    @Override
    public Proceso getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0 && createProjectBean.getProcesos() != null) {
            try {
                Proceso foundProceso = createProjectBean.getProcesos().stream().filter(proceso -> value.equals(proceso.getId().toString())).findAny().orElse(null);
                return foundProceso;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Proceso value) {
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
