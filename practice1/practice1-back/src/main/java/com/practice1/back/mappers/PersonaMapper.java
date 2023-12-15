package com.practice1.back.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.practice1.back.dtos.PersonaDto;
import com.practice1.back.entities.Persona;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaDto toDto(Persona persona);

    Persona toEntity(PersonaDto dto);

    List<PersonaDto> toDto(List<Persona> personas);

    List<Persona> toEntity(List<PersonaDto> personas);
}
