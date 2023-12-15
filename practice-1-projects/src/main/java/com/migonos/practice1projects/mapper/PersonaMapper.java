package com.migonos.practice1projects.mapper;

import org.mapstruct.factory.Mappers;

import com.migonos.practice1projects.dto.PersonaDto;
import com.migonos.practice1projects.entity.Persona;

public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDto personaToPersonaDto(Persona persona);
}
