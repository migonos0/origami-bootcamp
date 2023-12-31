package com.practice1.back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.back.dtos.ProyectoDto;
import com.practice1.back.services.ProyectoService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoResource {
    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<ProyectoDto> findAll() {
        return proyectoService.findAll();
    }

    @PostMapping
    public ProyectoDto createProyecto(@RequestBody ProyectoDto proyectoDto) {
        return proyectoService.createProyecto(proyectoDto);
    }

    @PutMapping(path = "/{proyectoId}")
    public ProyectoDto updateProyecto(@PathVariable int proyectoId, @RequestBody ProyectoDto proyectoDto) {
        try {
            return proyectoService.updateProyecto(proyectoId, proyectoDto);
        } catch (Exception e) {
            return null;
            // TODO: handle exception
        }
    }
}
