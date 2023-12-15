package com.migonos.practice1projects.mapper;

import org.mapstruct.factory.Mappers;

import com.migonos.practice1projects.entity.Area;

public interface AreaMapper {
    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

    Area areaToAreaDto(Area area);
}
