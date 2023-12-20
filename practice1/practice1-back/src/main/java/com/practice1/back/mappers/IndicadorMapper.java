package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.practice1.back.dtos.IndicadorDto;
import com.practice1.back.entities.Indicador;

@Mapper(componentModel = "spring", uses = { ProyectoMapper.class })
public interface IndicadorMapper {
    IndicadorDto toDto(Indicador indicador);

    Indicador toEntity(IndicadorDto indicadorDto);

    List<IndicadorDto> toDto(List<Indicador> indicadors);

    List<Indicador> toEntity(List<IndicadorDto> dtos);
}
