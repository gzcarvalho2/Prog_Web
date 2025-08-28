package com.senac.games.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PatrocinadorDTORequest {

    private int id;

    private String nome;

    private String representateNome;

    private int status;

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

    public String getRepresentateNome() {
        return representateNome;
    }

    public void setRepresentateNome(String representateNome) {
        this.representateNome = representateNome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
