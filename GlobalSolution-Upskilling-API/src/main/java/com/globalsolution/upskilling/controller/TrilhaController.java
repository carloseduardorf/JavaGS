package com.globalsolution.upskilling.controller;

import com.globalsolution.upskilling.dto.TrilhaDTO;
import com.globalsolution.upskilling.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {
    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService){
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public List<TrilhaDTO> getAll(){
        return trilhaService.findAll();
    }

    @GetMapping("/{id}")
    public TrilhaDTO getById(@PathVariable Long id){
        return trilhaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrilhaDTO create(@Valid @RequestBody TrilhaDTO dto){
        return trilhaService.create(dto);
    }

    @PutMapping("/{id}")
    public TrilhaDTO update(@PathVariable Long id, @Valid @RequestBody TrilhaDTO dto){
        return trilhaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        trilhaService.delete(id);
    }
}
