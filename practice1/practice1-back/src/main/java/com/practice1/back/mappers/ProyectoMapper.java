package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.practice1.back.dtos.ProyectoDto;
import com.practice1.back.entities.Proyecto;

@Mapper(componentModel = "spring", uses = { AreaMapper.class, PersonaMapper.class, ProcesoMapper.class })
public interface ProyectoMapper {
    ProyectoDto toDto(Proyecto proyecto);

    Proyecto toEntity(ProyectoDto dto);

    List<ProyectoDto> toDto(List<Proyecto> proyectos);

    List<Proyecto> toEntity(List<ProyectoDto> proyectos);
}
