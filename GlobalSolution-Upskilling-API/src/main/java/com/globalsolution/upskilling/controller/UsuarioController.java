package com.globalsolution.upskilling.controller;

import com.globalsolution.upskilling.dto.UsuarioDTO;
import com.globalsolution.upskilling.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> getAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@Valid @RequestBody UsuarioDTO dto){
        return usuarioService.create(dto);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto){
        return usuarioService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        usuarioService.delete(id);
    }
}
