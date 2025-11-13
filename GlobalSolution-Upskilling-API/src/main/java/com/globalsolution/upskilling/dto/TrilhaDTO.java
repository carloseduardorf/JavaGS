package com.globalsolution.upskilling.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TrilhaDTO {
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    @Size(max=150)
    private String nome;

    private String descricao;

    @NotBlank(message = "nivel é obrigatório")
    private String nivel;

    @NotNull(message = "cargaHoraria é obrigatória")
    @Min(value = 1, message = "cargaHoraria deve ser positiva")
    private Integer cargaHoraria;

    private String focoPrincipal;

    public TrilhaDTO() {}

    // getters and setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome = nome; }

    public String getDescricao(){ return descricao; }
    public void setDescricao(String descricao){ this.descricao = descricao; }

    public String getNivel(){ return nivel; }
    public void setNivel(String nivel){ this.nivel = nivel; }

    public Integer getCargaHoraria(){ return cargaHoraria; }
    public void setCargaHoraria(Integer cargaHoraria){ this.cargaHoraria = cargaHoraria; }

    public String getFocoPrincipal(){ return focoPrincipal; }
    public void setFocoPrincipal(String focoPrincipal){ this.focoPrincipal = focoPrincipal; }
}
