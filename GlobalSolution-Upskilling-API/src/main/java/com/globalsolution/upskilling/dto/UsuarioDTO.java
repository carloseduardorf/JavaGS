package com.globalsolution.upskilling.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    @Size(max=100)
    private String nome;

    @NotBlank(message = "email é obrigatório")
    @Email(message = "formato de email inválido")
    private String email;

    private String areaAtuacao;

    private String nivelCarreira;

    public UsuarioDTO() {}

    // getters and setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getNome(){ return nome; }
    public void setNome(String nome){ this.nome = nome; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }

    public String getAreaAtuacao(){ return areaAtuacao; }
    public void setAreaAtuacao(String areaAtuacao){ this.areaAtuacao = areaAtuacao; }

    public String getNivelCarreira(){ return nivelCarreira; }
    public void setNivelCarreira(String nivelCarreira){ this.nivelCarreira = nivelCarreira; }
}
