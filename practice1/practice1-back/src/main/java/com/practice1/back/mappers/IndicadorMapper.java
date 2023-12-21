package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.practice1.back.dtos.IndicadorDto;
import com.practice1.back.entities.Indicador;

@Mapper(componentModel = "spring")
public interface IndicadorMapper {
    @Mapping(source = "indicador.proyecto.id", target = "proyectoId")
    IndicadorDto toDto(Indicador indicador);

    @Mapping(source = "indicadorDto.proyectoId", target = "proyecto.id")
    Indicador toEntity(IndicadorDto indicadorDto);

    List<IndicadorDto> toDto(List<Indicador> indicadors);

    List<Indicador> toEntity(List<IndicadorDto> dtos);
}
