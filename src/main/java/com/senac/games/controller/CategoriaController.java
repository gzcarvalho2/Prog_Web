package com.senac.games.controller;


import com.senac.games.dto.request.CategoriaDTORequest;
import com.senac.games.dto.request.CategoriaDTOUpdateRequest;
import com.senac.games.dto.request.CategoriaDTORequest;
import com.senac.games.dto.request.CategoriaDTOUpdateRequest;
import com.senac.games.dto.response.CategoriaDTOResponse;
import com.senac.games.dto.response.CategoriaDTOUpdateResponse;
import com.senac.games.dto.response.CategoriaDTOResponse;
import com.senac.games.dto.response.CategoriaDTOUpdateResponse;
import com.senac.games.entity.Categoria;
import com.senac.games.entity.Categoria;
import com.senac.games.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
@Tag(name="Categoria", description = "API para gerenciamento de categorias")

public class CategoriaController {

    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping("/listar")
    @Operation(summary = "Listar categorias", description = "Endpoint para listar todos as categorias")

    public ResponseEntity<List<Categoria>> listarCategorias(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/ListarPorcategoriaId/{categoriaId}")
    @Operation(summary = "Listar categorias pelo ID", description = "Endpoint para obter categoria pelo id de categoria")
    public ResponseEntity<Categoria> listarPorCategoriaId(@PathVariable("categoriaId") Integer categoriaId){
        Categoria categoria = categoriaService.listarPorCategoriaId(categoriaId);
        if (categoria == null){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(categoria);

        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar novo categoria", description = "Endpoint para criar um novo registro de categoria")
    public ResponseEntity<CategoriaDTOResponse> criarcategoria(@Valid @RequestBody CategoriaDTORequest categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.criarCategoria(categoria));
    }

    @PutMapping("/atualizar/{categoriaId}")
    @Operation(summary = "Atualizar todos so dados do categoria", description = "Endpoint para atualizar todo o registro do categoria")
    public ResponseEntity<CategoriaDTOResponse> atualizarCategoria(@PathVariable("categoriaId") Integer categoriaId, @RequestBody CategoriaDTORequest categoriaDTORequest){
        return ResponseEntity.ok(categoriaService.atualizarCategoria(categoriaId, categoriaDTORequest));
    }

    @PatchMapping ("/atualizarStatus/{categoriaId}")
    @Operation(summary = "Atualiza o campo status do categoria",description = "Endpoint para atualizar o status do partiicpante")
    public ResponseEntity<CategoriaDTOUpdateResponse> atualizarStatusCategoria(
            @Valid
            @PathVariable("categoriaId") Integer categoriaId,
            @RequestBody CategoriaDTOUpdateRequest categoriaDTOUpdateRequest){
        return  ResponseEntity.ok(categoriaService.atualizarStatusCategoria(categoriaId,categoriaDTOUpdateRequest));
    }

    @DeleteMapping("/apagar/{categoriaId}")
    @Operation(summary = "Apagar registro de categoria", description = "Endpoint responsavel de apagar o usuario com base no id")
    public ResponseEntity apagarcategoria(@PathVariable("categoriaId") Integer categoriaId){
        categoriaService.apagarCategoria(categoriaId);
        return ResponseEntity.noContent().build();
    }
}
