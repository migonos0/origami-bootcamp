package com.migonos.practice1projects.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.migonos.practice1projects.dto.ProyectoDto;
import com.migonos.practice1projects.entity.Proyecto;

@Mapper
public interface ProyectoMapper {
    ProyectoMapper INSTANCE = Mappers.getMapper(ProyectoMapper.class);

    ProyectoDto proyectoToProyectoDto(Proyecto proyecto);
}
