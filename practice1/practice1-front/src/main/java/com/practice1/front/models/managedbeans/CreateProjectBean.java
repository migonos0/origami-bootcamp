/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.practice1.front.models.managedbeans;

import com.practice1.front.models.Area;
import com.practice1.front.models.Persona;
import com.practice1.front.services.ProcesoService;
import com.practice1.front.models.Proceso;
import com.practice1.front.models.Proyecto;
import com.practice1.front.services.AreaService;
import com.practice1.front.services.PersonaService;
import com.practice1.front.services.ProyectoService;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author miguel
 */
@Named(value = "createProjectBean")
@SessionScoped
public class CreateProjectBean implements Serializable {

    @Inject
    private ProcesoService procesoService;
    @Inject
    private AreaService areaService;
    @Inject
    private PersonaService personaService;
    @Inject ProyectoService proyectoService;
    private List<Proceso> procesos;
    private List<Area> areas;
    private Proyecto proyecto;
    private List<Persona> personas;
    private List<Proyecto> proyectos;

    /**
     * Creates a new instance of CreateProjectBean
     */
    public CreateProjectBean() {
    }

    @PostConstruct
    public void onLoad() {
        this.procesos = procesoService.findAllProcesos();
        this.areas = areaService.findAllAreas();
        this.personas = personaService.findAllPersonas();
        this.proyectos = proyectoService.findAllProyectos();
        this.proyecto = new Proyecto();
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void createProjectActionListener() {
        Proyecto createdProject = proyectoService.createProyecto(this.proyecto);
        if (createdProject == null) {
            return;
        }
        this.proyectos.add(createdProject);
    }
}
