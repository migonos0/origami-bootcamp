package com.practice1.back.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice1.back.dtos.HitoDto;
import com.practice1.back.entities.Hito;
import com.practice1.back.mappers.HitoMapper;
import com.practice1.back.repositories.HitoRepository;

@Service
public class HitoService {
    @Autowired
    private HitoRepository hitoRepository;
    @Autowired
    private HitoMapper hitoMapper;

    public HitoDto createHito(HitoDto hitoDto) {
        Hito hito = hitoMapper.toEntity(hitoDto);
        return hitoMapper.toDto(hitoRepository.save(hito));
    }

    public List<HitoDto> findAllHitos() {
        List<Hito> hitos = new ArrayList<>();
        hitoRepository.findAll().forEach(hitos::add);
        return hitoMapper.toDto(hitos);
    }

    public HitoDto updateHito(int hitoId, HitoDto hitoDto) throws Exception {
        if (!hitoRepository.existsById(hitoId)) {
            throw new Exception("El hito indicado no existe");
        }
        hitoDto.setId(hitoId);
        return hitoMapper.toDto(hitoRepository.save(hitoMapper.toEntity(hitoDto)));
    }

    public HitoDto deleteHito(int hitoId) throws Exception {
        Hito foundHito = hitoRepository.findById(hitoId).orElse(null);
        if (foundHito == null) {
            throw new Exception("El hito indicado no existe");
        }
        hitoRepository.deleteById(hitoId);
        return hitoMapper.toDto(foundHito);
    }
}
