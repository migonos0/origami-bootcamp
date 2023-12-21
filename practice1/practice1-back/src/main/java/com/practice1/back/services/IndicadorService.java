package com.practice1.back.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice1.back.dtos.IndicadorDto;
import com.practice1.back.entities.Indicador;
import com.practice1.back.mappers.IndicadorMapper;
import com.practice1.back.repositories.IndicadorRepository;

@Service
public class IndicadorService {
    @Autowired
    private IndicadorRepository indicadorRepository;
    @Autowired
    private IndicadorMapper indicadorMapper;

    public IndicadorDto createIndicador(IndicadorDto indicadorDto) {
        Indicador indicador = indicadorMapper.toEntity(indicadorDto);
        return indicadorMapper.toDto(indicadorRepository.save(indicador));
    }

    public List<IndicadorDto> findAllIndicadores() {
        List<Indicador> indicadors = new ArrayList<>();
        indicadorRepository.findAll().forEach(indicadors::add);
        return indicadorMapper.toDto(indicadors);
    }

    public List<IndicadorDto> findIndicatorsByProjectId(int projectId) {
        List<Indicador> indicadors = new ArrayList<>();
        indicadorRepository.findAll().forEach(indicadors::add);
        indicadors = indicadors.stream().filter(indicator -> indicator.getId().equals(projectId))
                .collect(Collectors.toList());
        return indicadorMapper.toDto(indicadors);
    }

    public IndicadorDto updateIndicador(int indicadorId, IndicadorDto dto) throws Exception {
        if (!indicadorRepository.existsById(indicadorId)) {
            throw new Exception("En indicador especificado no existe.");
        }
        dto.setId(indicadorId);
        return indicadorMapper.toDto(indicadorRepository.save(indicadorMapper.toEntity(dto)));
    }

    public IndicadorDto deleteIndicadorById(int indicadorId) throws Exception {
        Indicador foundIndicador = indicadorRepository.findById(indicadorId).orElse(null);
        if (foundIndicador == null) {
            throw new Exception("El indicador especificado no existe.");
        }
        indicadorRepository.deleteById(indicadorId);
        return indicadorMapper.toDto(foundIndicador);
    }
}
