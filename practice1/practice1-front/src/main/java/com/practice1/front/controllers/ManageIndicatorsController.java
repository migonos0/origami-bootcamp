/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.controllers;

import com.practice1.front.constants.AppRoutes;
import com.practice1.front.managedBeans.IndicadorMB;
import com.practice1.front.models.Indicador;
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
@Named("manageIndicatorsController")
public class ManageIndicatorsController implements Serializable {

    private List<Indicador> indicadores;
    @Inject
    private IndicadorMB indicadorMB;
    private Proyecto selectedProject;
    private Indicador indicador;
    private int deletableIndicatorId;

    public String loadPage(Proyecto proyecto) {
        this.selectedProject = proyecto;
        this.indicadores = this.indicadorMB.getIndicadores().stream().filter(i -> i.getProyectoId() == proyecto.getId().intValue()).collect(Collectors.toList());
        return AppRoutes.MANAGE_INDICADORES + "?faces-redirect=true";
    }

    public void initializeIndicador() {
        this.indicador = new Indicador();
        this.indicador.setProyectoId(this.selectedProject.getId().longValue());
    }
    
    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public Proyecto getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(Proyecto selectedProject) {
        this.selectedProject = selectedProject;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }
    
    public void createIndicadorActionListener() {
        Indicador createdIndicador = indicadorMB.createIndicator(this.indicador);
        ArrayList<Indicador> freshIndicadores = new ArrayList<>(this.indicadores);
        freshIndicadores.add(createdIndicador);
        this.setIndicadores(freshIndicadores);
        JSFMessages.INFO("Indicador registrado de forma exitosa.");
    }
    
    public void deleteIndicadorActionListener() {
        Indicador deletedIndicador = indicadorMB.deleteIndicador(this.deletableIndicatorId);
        List<Indicador> filteredIndicadores = this.indicadores.stream().filter(i -> i.getId().intValue() != deletedIndicador.getId().intValue()).collect(Collectors.toList());
        this.setIndicadores(filteredIndicadores);
        JSFMessages.INFO("Indicador borrado de forma exitosa.");
    }
    
    public void updateIndicadorActionListener() {
        Indicador updatedIndicador = indicadorMB.updateIndicador(this.indicador.getId(), this.indicador);
        List<Indicador> filteredIndicadores = this.indicadores.stream().filter(i -> i.getId().intValue() != updatedIndicador.getId().intValue()).collect(Collectors.toList());
        filteredIndicadores.add(updatedIndicador);
        this.setIndicadores(filteredIndicadores);
        JSFMessages.INFO("Indicador actualizado de forma exitosa.");
    }

    public int getDeletableIndicatorId() {
        return deletableIndicatorId;
    }

    public void setDeletableIndicatorId(int deletableIndicatorId) {
        this.deletableIndicatorId = deletableIndicatorId;
    }
    
    
}
