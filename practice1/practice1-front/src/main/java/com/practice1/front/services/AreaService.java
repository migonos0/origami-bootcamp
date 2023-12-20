/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.services;

import com.practice1.front.interfaces.AppServices;
import com.practice1.front.models.Area;
import com.practice1.front.constants.ResourceURLs;
import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author miguel
 */
@Singleton
@ApplicationScoped
public class AreaService {

    @Inject
    private AppServices appServices;

    public List<Area> findAllAreas() {
        System.out.println(ResourceURLs.APP_URL + ResourceURLs.AREA);
        return appServices.methodListGET(ResourceURLs.APP_URL + ResourceURLs.AREA, Area[].class);
    }
}
