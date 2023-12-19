/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package com.practice1.front.services;

import com.practice1.front.converters.config.Constants;
import jakarta.ejb.Singleton;
import jakarta.ejb.LocalBean;
import java.util.List;
import com.practice1.front.models.Proyecto;
import com.practice1.front.services.interfaces.AppServices;
import jakarta.inject.Inject;

/**
 *
 * @author miguel
 */
@Singleton
@LocalBean
public class ProyectoService {

    @Inject
    private AppServices appServices;

    public List<Proyecto> findAllProyectos() {
        return appServices.methodListGET(Constants.APP_URL + "proyecto", Proyecto[].class);
    }

    public Proyecto createProyecto(Proyecto proyecto) {
        return (Proyecto) appServices.methodPOST(proyecto, Constants.APP_URL + "proyecto", Proyecto.class);
    }
}
