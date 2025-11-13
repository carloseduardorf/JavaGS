package com.globalsolution.upskilling.service;

import com.globalsolution.upskilling.dto.TrilhaDTO;
import com.globalsolution.upskilling.exception.ResourceNotFoundException;
import com.globalsolution.upskilling.model.Trilha;
import com.globalsolution.upskilling.repository.TrilhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrilhaService {
    private final TrilhaRepository trilhaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository){
        this.trilhaRepository = trilhaRepository;
    }

    public List<TrilhaDTO> findAll(){
        return trilhaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public TrilhaDTO findById(Long id){
        Trilha t = trilhaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada com id " + id));
        return toDTO(t);
    }

    public TrilhaDTO create(TrilhaDTO dto){
        Trilha t = new Trilha(dto.getNome(), dto.getDescricao(), dto.getNivel(), dto.getCargaHoraria(), dto.getFocoPrincipal());
        Trilha saved = trilhaRepository.save(t);
        return toDTO(saved);
    }

    public TrilhaDTO update(Long id, TrilhaDTO dto){
        Trilha t = trilhaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada com id " + id));
        t.setNome(dto.getNome());
        t.setDescricao(dto.getDescricao());
        t.setNivel(dto.getNivel());
        t.setCargaHoraria(dto.getCargaHoraria());
        t.setFocoPrincipal(dto.getFocoPrincipal());
        Trilha updated = trilhaRepository.save(t);
        return toDTO(updated);
    }

    public void delete(Long id){
        Trilha t = trilhaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada com id " + id));
        trilhaRepository.delete(t);
    }

    private TrilhaDTO toDTO(Trilha t){
        TrilhaDTO dto = new TrilhaDTO();
        dto.setId(t.getId());
        dto.setNome(t.getNome());
        dto.setDescricao(t.getDescricao());
        dto.setNivel(t.getNivel());
        dto.setCargaHoraria(t.getCargaHoraria());
        dto.setFocoPrincipal(t.getFocoPrincipal());
        return dto;
    }
}
