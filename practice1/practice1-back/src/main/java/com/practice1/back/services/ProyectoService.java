package com.practice1.back.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice1.back.dtos.ProyectoDto;
import com.practice1.back.entities.Proyecto;
import com.practice1.back.mappers.ProyectoMapper;
import com.practice1.back.repositories.ProyectoRepository;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;
    @Autowired
    private ProyectoMapper proyectoMapper;

    public List<ProyectoDto> findAll() {
        List<Proyecto> proyectos = new ArrayList<>();
        proyectoRepository.findAll().forEach(proyectos::add);
        return proyectoMapper.toDto(proyectos);
    }

    public ProyectoDto createProyecto(ProyectoDto proyectoDto) {
        Proyecto proyecto = proyectoMapper.toEntity(proyectoDto);

        proyecto = proyectoRepository.save(proyecto);
        return proyectoMapper.toDto(proyecto);
    }

    public ProyectoDto updateProyecto(int proyectoId, ProyectoDto proyectoDto) throws Exception {
        if (!proyectoRepository.existsById(proyectoId)) {
            throw new Exception("El proyecto especificado no exite.");
        }
        proyectoDto.setId(proyectoId);
        Proyecto updatedProyecto = proyectoRepository.save(proyectoMapper.toEntity(proyectoDto));
        return proyectoMapper.toDto(updatedProyecto);
    }

}
