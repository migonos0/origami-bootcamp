/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.managedBeans;

import com.practice1.front.models.Area;
import com.practice1.front.services.AreaService;
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
@Named("areaMB")
public class AreaMB implements Serializable {

    private List<Area> areas;
    @Inject
    private AreaService areaService;

    @PostConstruct
    public void onLoad() {
        this.areas = areaService.findAllAreas();
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}
