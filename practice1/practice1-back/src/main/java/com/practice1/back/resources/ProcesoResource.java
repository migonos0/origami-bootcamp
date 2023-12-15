package com.practice1.back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.back.dtos.ProcesoDto;
import com.practice1.back.services.ProcesoService;

@RestController
@RequestMapping("/proceso")
public class ProcesoResource {
    @Autowired
    private ProcesoService procesoService;

    @GetMapping
    public List<ProcesoDto> findAllProcesos() {
        return procesoService.findAllProcesos();
    }
}
