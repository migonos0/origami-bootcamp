/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.controllers;

import com.practice1.front.constants.AppRoutes;
import com.practice1.front.managedBeans.HitoMB;
import com.practice1.front.models.Hito;
import com.practice1.front.models.Proyecto;
import com.practice1.front.utilities.JSFMessages;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author miguel
 */
@SessionScoped
@Named("manageHitosController")
public class ManageHitosController implements Serializable {

    private List<Hito> hitos;
    @Inject
    private HitoMB hitoMB;
    private Proyecto selectedProject;
    private Hito hito;
    private int deletableHitoId;

    public String loadPage(Proyecto proyecto) {
        this.selectedProject = proyecto;
        this.hitos = hitoMB.getHitos().stream().filter(i -> i.getProyectoId().intValue() == proyecto.getId().intValue()).collect(Collectors.toList());
        return AppRoutes.MANAGE_HITOS + "?faces-redirect=true";
    }

    public void initializeHito() {
        this.hito = new Hito();
        this.hito.setProyectoId(this.selectedProject.getId().longValue());
    }

    public void createHitoActionListener() {
        Hito createdHito = hitoMB.createHito(this.hito);
        List<Hito> freshHitos = new ArrayList<>(this.hitos);
        freshHitos.add(createdHito);
        this.setHitos(freshHitos);
        JSFMessages.INFO("Hito creado de forma exitosa.");
    }

    public void updateHitoActionListener() {
        Hito updatedHito = hitoMB.updateHito(this.hito.getId(), this.hito);
        List<Hito> freshHitos = this.hitos.stream().filter(i -> i.getId().intValue() != updatedHito.getId().intValue()).collect(Collectors.toList());
        freshHitos.add(updatedHito);
        this.setHitos(freshHitos);
        JSFMessages.INFO("Hito modificado de forma exitosa.");
    }

    public void deleteHitoActionListener() {
        Hito deletedHito = hitoMB.deleteHito(this.deletableHitoId);
        List<Hito> freshHitos = this.hitos.stream().filter(i -> i.getId().intValue() != deletedHito.getId().intValue()).collect(Collectors.toList());
        this.setHitos(freshHitos);
        JSFMessages.INFO("Hito eliminado de forma exitosa.");
    }

    public List<Hito> getHitos() {
        return hitos;
    }

    public void setHitos(List<Hito> hitos) {
        this.hitos = hitos;
    }

    public Proyecto getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Proyecto selectedProject) {
        this.selectedProject = selectedProject;
    }

    public Hito getHito() {
        return hito;
    }

    public void setHito(Hito hito) {
        this.hito = hito;
    }

    public int getDeletableHitoId() {
        return deletableHitoId;
    }

    public void setDeletableHitoId(int deletableHitoId) {
        System.out.println("com.practice1.front.controllers.ManageHitosController.setDeletableHitoId()" + deletableHitoId);
        this.deletableHitoId = deletableHitoId;
    }
    
    public void test() {
        System.out.println("com.practice1.front.controllers.ManageHitosController.test()");
    }
}
