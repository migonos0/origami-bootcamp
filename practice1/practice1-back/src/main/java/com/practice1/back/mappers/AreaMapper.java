package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.practice1.back.dtos.AreaDto;
import com.practice1.back.entities.Area;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    AreaDto toDto(Area area);

    Area toEntity(AreaDto dto);

    List<AreaDto> toDto(List<Area> areas);

    List<Area> toEntity(List<AreaDto> areas);
}
