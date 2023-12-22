/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.services;

import com.practice1.front.constants.ResourceURLs;
import com.practice1.front.interfaces.AppServices;
import com.practice1.front.models.Hito;
import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

/**
 *
 * @author miguel
 */
@ApplicationScoped
@Singleton
public class HitoService {
    @Inject
    private AppServices appServices;
    
    public List<Hito> findAllHitos() {
        return appServices.methodListGET(ResourceURLs.APP_URL + ResourceURLs.HITO, Hito[].class);
    }
    
    public Hito createHito(Hito hito) {
        return (Hito) appServices.methodPOST(hito, ResourceURLs.APP_URL + ResourceURLs.HITO, Hito.class);
    }
    
    public Hito updateHito(int hitoId, Hito hito) {
        return (Hito) appServices.methodPUT(hito, ResourceURLs.APP_URL + ResourceURLs.HITO + "/" + hitoId, Hito.class);
    }
    
    public Hito deleteHito(int hitoId) {
        System.out.println("com.practice1.front.services.HitoService.deleteHito()" + hitoId);
        return (Hito) appServices.methodDELETE(ResourceURLs.APP_URL + ResourceURLs.HITO + "/" + hitoId, Hito.class);
    }
}
