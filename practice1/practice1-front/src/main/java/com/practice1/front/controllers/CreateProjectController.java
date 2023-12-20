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
import java.util.Date;

/**
 *
 * @author miguel
 */
@SessionScoped
@Named("createProjectController")
public class CreateProjectController implements Serializable {

    @Inject
    private ProyectoMB proyectoMB;
    @Inject
    private ProyectoService proyectoService;
    private Proyecto createableProject;

    @PostConstruct
    public void onLoad() {
        initializeCreateableProject();
    }

    private void initializeCreateableProject() {
        this.createableProject = new Proyecto();
    }

    public String loadPage() {
        return AppRoutes.CREATE_PROJECT + "?faces-redirect=true";
    }

    public void createProjectActionListener() {
                System.out.println("0");

        if (createableProject.getArea() == null) {
            JSFMessages.WARN("Por favor, seleccione una area.");
            return;
        }
        if (createableProject.getProceso() == null) {
            JSFMessages.WARN("Por favor, seleccione un proceso.");
            return;
        }
        if (createableProject.getResponsable() == null) {
            JSFMessages.WARN("Por favor, seleccione un responsable.");
            return;
        }
        createableProject.setFechaCreacion(new Date());
        createableProject.setFechaModificacion(new Date());
        createableProject.setEstado("A");
        createableProject.setCreadoPor(createableProject.getResponsable().getNombre() + " " + createableProject.getResponsable().getApellido());
        createableProject.setModificadoPor(createableProject.getResponsable().getNombre() + " " + createableProject.getResponsable().getApellido());
        System.out.println("1");
        Proyecto createdProject = proyectoService.createProyecto(createableProject);
        if (createdProject == null) {
            JSFMessages.ERROR("Ha ocurrido un error en la creación del proyecto.");
            return;
        }
                System.out.println("2");

//        this.proyectoMB.getProyectos().add(createdProject);
                                System.out.println("3");

        initializeCreateableProject();
                        System.out.println("4");

        JSFMessages.INFO("Proyecto creado de forma exitosa.");
                                System.out.println("5");

    }

    public Proyecto getCreateableProject() {
        return createableProject;
    }

    public void setCreateableProject(Proyecto createableProject) {
        this.createableProject = createableProject;
    }

    public String test() {
        Proyecto createdProject = proyectoService.createProyecto(createableProject);
        return "";
    }
}
