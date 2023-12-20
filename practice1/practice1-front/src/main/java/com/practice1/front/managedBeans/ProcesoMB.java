/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.managedBeans;

import com.practice1.front.models.Proceso;
import com.practice1.front.services.ProcesoService;
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
@Named("procesoMB")
public class ProcesoMB implements Serializable {

    @Inject
    private ProcesoService procesoService;
    private List<Proceso> procesos;

    @PostConstruct
    public void onLoad() {
        this.procesos = procesoService.findAllProcesos();
    }

    public List<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(List<Proceso> procesos) {
        this.procesos = procesos;
    }

}
