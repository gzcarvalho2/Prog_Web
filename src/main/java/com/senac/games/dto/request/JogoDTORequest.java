package com.senac.games.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.games.entity.Categoria;
import com.senac.games.entity.Inscricao;
import jakarta.persistence.*;

import java.util.List;

public class JogoDTORequest {

    private int id;

    private String nome;

    private int status;


    private List<Inscricao> inscricoes;
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
