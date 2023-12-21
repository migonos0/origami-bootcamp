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

import com.practice1.back.dtos.HitoDto;
import com.practice1.back.services.HitoService;

@RestController
@RequestMapping(path = "hito")
public class HitoResource {
    @Autowired
    private HitoService hitoService;

    @GetMapping
    public List<HitoDto> findAllHitos(@RequestParam(name = "projectId", required = false) Integer projectId) {
        if (projectId != null) {
            return hitoService.findHitosByProjectId(projectId);
        }
        return hitoService.findAllHitos();
    }

    @PostMapping
    public HitoDto createHito(@RequestBody HitoDto hitoDto) {
        return hitoService.createHito(hitoDto);
    }

    @PutMapping(path = "/{hitoId}")
    public HitoDto updateHito(@PathVariable int hitoId, @RequestBody HitoDto hitoDto) {
        try {
            return hitoService.updateHito(hitoId, hitoDto);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    @DeleteMapping(path = { "/hitoId" })
    public HitoDto deleteHito(@PathVariable int hitoId) {
        try {
            return hitoService.deleteHito(hitoId);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

}
