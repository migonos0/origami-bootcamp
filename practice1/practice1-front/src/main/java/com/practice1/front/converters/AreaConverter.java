/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.converters;

import com.practice1.front.managedBeans.AreaMB;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Named;
import com.practice1.front.models.Area;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;

/**
 *
 * @author miguel
 */
@Named("areaConverter")
@FacesConverter(forClass = Area.class)
@RequestScoped
public class AreaConverter implements Converter<Area> {

    @Inject
    private AreaMB AreaMB;

    @Override
    public Area getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0 && AreaMB.getAreas() != null) {
            try {
                Area foundArea = AreaMB.getAreas().stream().filter(area -> value.equals(area.getId().toString())).findAny().orElse(null);
                return foundArea;
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Area value) {
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
