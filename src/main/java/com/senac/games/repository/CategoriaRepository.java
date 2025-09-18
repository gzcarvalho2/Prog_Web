package com.senac.games.repository;

import com.senac.games.entity.Categoria;
import com.senac.games.entity.Participante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("SELECT p FROM Categoria p WHERE p.id = :id AND p.status >= 0")
    Categoria obterCategoriaPeloId(@Param("id") Integer categoriaId);

    @Modifying
    @Transactional
    @Query("UPDATE Categoria p SET p.status = -1 WHERE p.id = :id")
    void apagadoLogicoCategoria(@Param("id") Integer categoriaId);
}
