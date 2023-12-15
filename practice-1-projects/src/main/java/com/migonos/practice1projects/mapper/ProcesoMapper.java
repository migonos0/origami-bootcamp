package com.migonos.practice1projects.mapper;

import org.mapstruct.factory.Mappers;

import com.migonos.practice1projects.dto.ProcesoDto;
import com.migonos.practice1projects.entity.Proceso;

public interface ProcesoMapper {
    ProcesoMapper INSTANCE = Mappers.getMapper(ProcesoMapper.class);

    ProcesoDto procesoToProcesoDto(Proceso proceso);
}
