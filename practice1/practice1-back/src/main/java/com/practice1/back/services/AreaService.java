package com.practice1.back.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice1.back.dtos.AreaDto;
import com.practice1.back.entities.Area;
import com.practice1.back.mappers.AreaMapper;
import com.practice1.back.repositories.AreaRepository;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private AreaMapper areaMapper;

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    public List<AreaDto> findAllAreas() {
        ArrayList<Area> areas = new ArrayList<>();
        areaRepository.findAll().forEach(areas::add);
        return areaMapper.toDto(areas);
    }

    public Area findAreaById(int areaId) {
        return areaRepository.findById(areaId).orElse(null);
    }

}
