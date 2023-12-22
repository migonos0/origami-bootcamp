/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.managedBeans;

import com.practice1.front.models.Hito;
import com.practice1.front.services.HitoService;
import jakarta.annotation.PostConstruct;
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
@Named("hitoMB")
public class HitoMB implements Serializable {

    private List<Hito> hitos;
    @Inject
    private HitoService hitoService;

    @PostConstruct
    public void onLoad() {
        hitos = hitoService.findAllHitos();
    }

    public List<Hito> getHitos() {
        return hitos;
    }

    public void setHitos(List<Hito> hitos) {
        this.hitos = hitos;
    }
    
    public Hito createHito(Hito hito) {
        Hito createdHito = hitoService.createHito(hito);
        List<Hito> freshHitos = new ArrayList<>(this.hitos);
        freshHitos.add(createdHito);
        this.setHitos(freshHitos);
        return createdHito;
    }

    public Hito updateHito(int hitoId, Hito hito) {
        Hito updatedHito = hitoService.updateHito(hitoId, hito);
        List<Hito> freshHitos = this.hitos.stream().filter(i -> i.getId().intValue() != updatedHito.getId().intValue()).collect(Collectors.toList());
        freshHitos.add(updatedHito);
        this.setHitos(freshHitos);
        return updatedHito;
    }
    
     public Hito deleteHito(int hitoId) {
        Hito deletedHito = hitoService.deleteHito(hitoId);
        List<Hito> freshHitos = this.hitos.stream().filter(i -> i.getId().intValue() != deletedHito.getId().intValue()).collect(Collectors.toList());
        this.setHitos(freshHitos);
        return deletedHito;
    }
}
