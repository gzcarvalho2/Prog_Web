package com.senac.games.controller;

import com.senac.games.entity.Jogo;
import com.senac.games.service.JogoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogos")
@Tag(name="Jogo", description = "API para gerenciamento de jogos")

public class JogoController {

    private final JogoService jogoService;

    @Autowired
    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    /**
     * Endpoint para listar todos os jogos.
     * Acessível via GET http://localhost:8080/jogos
     */
    @GetMapping
    @Operation(summary = "Listar jogos", description = "Endpoint para listar todos os jogos")

    public ResponseEntity<List<Jogo>> listarTodos() {
        List<Jogo> jogos = jogoService.listarJogos();
        return ResponseEntity.ok(jogos);
    }
}