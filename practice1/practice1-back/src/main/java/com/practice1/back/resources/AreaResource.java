package com.practice1.back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.back.dtos.AreaDto;
import com.practice1.back.services.AreaService;

@RestController
@RequestMapping(path = "area")
public class AreaResource {
    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<AreaDto> findAllAreas() {
        return areaService.findAllAreas();
    }
}
