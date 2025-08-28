package com.senac.games.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.games.entity.Jogo;
import jakarta.persistence.*;

import java.util.List;

public class CategoriaDTORequest {

    private int id;

    private String nome;

    private int status;

    private List<Jogo> jogos;

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

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}
