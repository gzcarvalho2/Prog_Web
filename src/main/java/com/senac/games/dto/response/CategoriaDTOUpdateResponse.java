package com.senac.games.dto.response;

import com.senac.games.entity.Jogo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CategoriaDTOUpdateResponse {
    @NotEmpty
    private int id;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Min(0)
    @Max(2)
    private int status;

    @NotEmpty

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
