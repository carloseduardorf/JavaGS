package com.globalsolution.upskilling.service;

import com.globalsolution.upskilling.dto.UsuarioDTO;
import com.globalsolution.upskilling.exception.ResourceNotFoundException;
import com.globalsolution.upskilling.model.Usuario;
import com.globalsolution.upskilling.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDTO> findAll(){
        return usuarioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id){
        Usuario u = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado com id " + id));
        return toDTO(u);
    }

    public UsuarioDTO create(UsuarioDTO dto){
        Usuario u = new Usuario(dto.getNome(), dto.getEmail(), dto.getAreaAtuacao(), dto.getNivelCarreira());
        Usuario saved = usuarioRepository.save(u);
        return toDTO(saved);
    }

    public UsuarioDTO update(Long id, UsuarioDTO dto){
        Usuario u = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado com id " + id));
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setAreaAtuacao(dto.getAreaAtuacao());
        u.setNivelCarreira(dto.getNivelCarreira());
        Usuario updated = usuarioRepository.save(u);
        return toDTO(updated);
    }

    public void delete(Long id){
        Usuario u = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado com id " + id));
        usuarioRepository.delete(u);
    }

    private UsuarioDTO toDTO(Usuario u){
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        dto.setAreaAtuacao(u.getAreaAtuacao());
        dto.setNivelCarreira(u.getNivelCarreira());
        return dto;
    }
}
