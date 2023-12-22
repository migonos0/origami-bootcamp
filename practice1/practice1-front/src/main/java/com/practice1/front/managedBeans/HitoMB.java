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
import java.util.List;

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

}
