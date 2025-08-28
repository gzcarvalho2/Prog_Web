package com.senac.games.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senac.games.entity.Jogo;
import com.senac.games.entity.Participante;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class InscricaoDTORequest {

    private int id;
    private LocalDateTime data;
    private int status;

    private Participante participante;

    private Jogo jogo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
