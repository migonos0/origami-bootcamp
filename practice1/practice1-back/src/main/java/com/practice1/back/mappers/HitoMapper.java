package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.practice1.back.dtos.HitoDto;
import com.practice1.back.entities.Hito;

@Mapper(componentModel = "spring", uses = { ProyectoMapper.class })
public interface HitoMapper {
    HitoDto toDto(Hito hito);

    Hito toEntity(HitoDto hitoDto);

    List<HitoDto> toDto(List<Hito> hitos);

    List<Hito> toEntity(List<HitoDto> hitoDtos);
}
