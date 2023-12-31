package com.practice1.back.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice1.back.dtos.IndicadorDto;
import com.practice1.back.services.IndicadorService;

@RestController
@RequestMapping(path = "indicador")
public class IndicadorResource {
    @Autowired
    private IndicadorService indicadorService;

    @GetMapping
    public List<IndicadorDto> findAllIndicadores(
            @RequestParam(name = "projectId", required = false) Integer projectId) {
        if (projectId != null) {
            return indicadorService.findIndicatorsByProjectId(projectId);
        }
        return indicadorService.findAllIndicadores();
    }

    @PostMapping
    public IndicadorDto createIndicador(@RequestBody IndicadorDto dto) {
        return indicadorService.createIndicador(dto);
    }

    @PutMapping(path = "/{indicadorId}")
    public IndicadorDto updateIndicador(@PathVariable int indicadorId, @RequestBody IndicadorDto indicadorDto) {
        try {
            return indicadorService.updateIndicador(indicadorId, indicadorDto);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @DeleteMapping(path = "/{indicadorId}")
    public IndicadorDto deleteIndicador(@PathVariable int indicadorId) {
        try {
            return indicadorService.deleteIndicadorById(indicadorId);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
}
