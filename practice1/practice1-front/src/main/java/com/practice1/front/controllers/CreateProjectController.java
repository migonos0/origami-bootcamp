/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.controllers;

import com.practice1.front.constants.AppRoutes;
import com.practice1.front.managedBeans.ProyectoMB;
import com.practice1.front.models.Proyecto;
import com.practice1.front.services.ProyectoService;
import com.practice1.front.utilities.JSFMessages;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author miguel
 */
@SessionScoped
@Named("createProjectController")
public class CreateProjectController implements Serializable {

    @Inject
    private ProyectoService proyectoService;
    @Inject
    private ProyectoMB proyectoMB;
    private Proyecto createableProject;

    private void initializeCreateableProject() {
        this.createableProject = new Proyecto();
    }

    public String loadPage() {
        initializeCreateableProject();
        return AppRoutes.CREATE_PROJECT + "?faces-redirect=true";
    }

    public String loadPage(Proyecto proyecto) {
        this.createableProject = proyecto;
        return AppRoutes.CREATE_PROJECT + "?faces-redirect=true";
    }

    public String createProjectActionListener() {
        if (createableProject.getArea() == null) {
            JSFMessages.WARN("Por favor, seleccione una area.");
            return null;
        }
        if (createableProject.getProceso() == null) {
            JSFMessages.WARN("Por favor, seleccione un proceso.");
            return null;
        }
        if (createableProject.getResponsable() == null) {
            JSFMessages.WARN("Por favor, seleccione un responsable.");
            return null;
        }
        createableProject.setFechaCreacion(new Date());
        createableProject.setFechaModificacion(new Date());
        createableProject.setEstado("A");
        createableProject.setCreadoPor(createableProject.getResponsable().getNombre() + " " + createableProject.getResponsable().getApellido());
        createableProject.setModificadoPor(createableProject.getResponsable().getNombre() + " " + createableProject.getResponsable().getApellido());
        Proyecto createdProject = proyectoService.createProyecto(createableProject);
        if (createdProject == null) {
            JSFMessages.ERROR("Ha ocurrido un error en la creación del proyecto.");
            return null;
        }
        List<Proyecto> proyectos = new ArrayList<>(this.proyectoMB.getProyectos());
        proyectos.add(createdProject);
        this.proyectoMB.setProyectos(proyectos);
        JSFMessages.INFO("Proyecto creado de forma exitosa.");
        return "index?faces-redirect=true";
    }

    public String updateProjectActionListener() {
        if (createableProject.getArea() == null) {
            JSFMessages.WARN("Por favor, seleccione una area.");
            return null;
        }
        if (createableProject.getProceso() == null) {
            JSFMessages.WARN("Por favor, seleccione un proceso.");
            return null;
        }
        if (createableProject.getResponsable() == null) {
            JSFMessages.WARN("Por favor, seleccione un responsable.");
            return null;
        }
        createableProject.setFechaModificacion(new Date());
        createableProject.setModificadoPor(createableProject.getResponsable().getNombre() + " " + createableProject.getResponsable().getApellido());
        Proyecto updatedProject = proyectoService.updateProyecto(createableProject.getId(), createableProject);
        if (updatedProject == null) {
            JSFMessages.ERROR("Ha ocurrido un error en la creación del proyecto.");
            return null;
        }
        List<Proyecto> freshProyectos = this.proyectoMB.getProyectos().stream().filter(p -> p.getId().intValue() != updatedProject.getId().intValue()).collect(Collectors.toList());
        freshProyectos.add(updatedProject);
        this.proyectoMB.setProyectos(freshProyectos);
        JSFMessages.INFO("Proyecto actualizado de forma exitosa.");
        return "index?faces-redirect=true";
    }

    public Proyecto getCreateableProject() {
        return createableProject;
    }

    public void setCreateableProject(Proyecto createableProject) {
        this.createableProject = createableProject;
    }

}
