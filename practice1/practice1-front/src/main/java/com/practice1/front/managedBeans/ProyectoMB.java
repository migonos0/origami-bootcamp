/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.managedBeans;

import com.practice1.front.models.Proyecto;
import com.practice1.front.services.ProyectoService;
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
@Named("proyectoMB")
public class ProyectoMB implements Serializable {

    @Inject
    private ProyectoService proyectoService;
    private List<Proyecto> proyectos;

    @PostConstruct
    public void onLoad() {
        this.proyectos = proyectoService.findAllProyectos();
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
