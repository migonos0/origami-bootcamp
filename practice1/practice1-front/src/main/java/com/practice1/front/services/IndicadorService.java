/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.services;

import com.practice1.front.constants.ResourceURLs;
import com.practice1.front.interfaces.AppServices;
import com.practice1.front.models.Indicador;
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
public class IndicadorService {

    @Inject
    private AppServices appServices;

    public List<Indicador> findAllIndicadores() {
        return appServices.methodListGET(ResourceURLs.APP_URL + ResourceURLs.INDICADOR, Indicador[].class);
    }

    public Indicador createIndicator(Indicador indicator) {

        return (Indicador) appServices.methodPOST(indicator, ResourceURLs.APP_URL + ResourceURLs.INDICADOR, Indicador.class);
    }
    
    public Indicador deteleIndicador(int indicadorId) {
        return (Indicador) appServices.methodDELETE(ResourceURLs.APP_URL + ResourceURLs.INDICADOR + "/" + indicadorId, Indicador.class);
    }
    
    public Indicador updateIndicador(int indicadorId, Indicador indicador) {
        return (Indicador) appServices.methodPUT(indicador, ResourceURLs.APP_URL + ResourceURLs.INDICADOR + "/" + indicadorId, Indicador.class);
    }
}
