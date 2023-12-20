/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SingletonEjbClass.java to edit this template
 */
package com.practice1.front.services;

import jakarta.ejb.Singleton;
import java.util.List;
import com.practice1.front.models.Proceso;
import com.practice1.front.constants.ResourceURLs;
import com.practice1.front.interfaces.AppServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 *
 * @author miguel
 */
@Singleton
@ApplicationScoped
public class ProcesoService {

    @Inject
    private AppServices appServices;

    public List<Proceso> findAllProcesos() {
        return appServices.methodListGET(ResourceURLs.APP_URL + ResourceURLs.PROCESO, Proceso[].class);
    }
}
