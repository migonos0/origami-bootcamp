package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.practice1.back.dtos.HitoDto;
import com.practice1.back.entities.Hito;

@Mapper(componentModel = "spring")
public interface HitoMapper {
    @Mapping(source = "hito.proyecto.id", target = "proyectoId")
    HitoDto toDto(Hito hito);

    @Mapping(target = "proyecto.id", source = "hitoDto.proyectoId")
    Hito toEntity(HitoDto hitoDto);

    List<HitoDto> toDto(List<Hito> hitos);

    List<Hito> toEntity(List<HitoDto> hitoDtos);
}
