/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.managedBeans;

import com.practice1.front.models.Indicador;
import com.practice1.front.services.IndicadorService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jdk.jfr.Name;

/**
 *
 * @author miguel
 */
@SessionScoped
@Name("indicadorMB")
public class IndicadorMB implements Serializable {

    @Inject
    private IndicadorService indicadorService;
    private List<Indicador> indicadores;

    @PostConstruct
    public void onLoad() {
        this.indicadores = indicadorService.findAllIndicadores();
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }

    public Indicador createIndicator(Indicador indicator) {
        Indicador createdIndicador = indicadorService.createIndicator(indicator);
        ArrayList<Indicador> freshIndicadores = new ArrayList<>(this.indicadores);
        freshIndicadores.add(createdIndicador);
        this.setIndicadores(freshIndicadores);
        return createdIndicador;
    }

    public Indicador deleteIndicador(int indicadorId) {
        Indicador deletedIndicador = indicadorService.deteleIndicador(indicadorId);
        List<Indicador> filteredIndicadores = this.indicadores.stream().filter(i -> i.getId().intValue() != deletedIndicador.getId().intValue()).collect(Collectors.toList());
        this.setIndicadores(filteredIndicadores);
        return deletedIndicador;
    }
    
    public Indicador updateIndicador(int indicadorId, Indicador indicador) {
        Indicador updatedIndicador = indicadorService.updateIndicador(indicadorId, indicador);
        List<Indicador> filteredIndicadores = this.indicadores.stream().filter(i -> i.getId().intValue() != updatedIndicador.getId().intValue()).collect(Collectors.toList());
        filteredIndicadores.add(updatedIndicador);
        this.setIndicadores(filteredIndicadores);
        return updatedIndicador;
    }
}
