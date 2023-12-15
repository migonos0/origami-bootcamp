package com.practice1.back.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice1.back.dtos.ProcesoDto;
import com.practice1.back.entities.Proceso;
import com.practice1.back.mappers.ProcesoMapper;
import com.practice1.back.repositories.ProcesoRepository;

@Service
public class ProcesoService {
    @Autowired
    private ProcesoRepository procesoRepository;
    @Autowired
    private ProcesoMapper procesoMapper;

    public List<ProcesoDto> findAllProcesos() {
        List<Proceso> procesos = new ArrayList<>();
        procesoRepository.findAll().forEach(procesos::add);
        return procesoMapper.toDto(procesos);
    }
}
