package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.practice1.back.dtos.ProcesoDto;
import com.practice1.back.entities.Proceso;

@Mapper(componentModel = "spring")
public interface ProcesoMapper {
    ProcesoDto toDto(Proceso proceso);

    Proceso toEntity(ProcesoDto dto);

    List<ProcesoDto> toDto(List<Proceso> procesos);

    List<Proceso> toEntity(List<ProcesoDto> procesos);
}
