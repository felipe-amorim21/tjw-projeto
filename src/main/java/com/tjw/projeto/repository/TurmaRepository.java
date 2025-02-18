package com.tjw.projeto.repository;

import com.tjw.projeto.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

    @Query("SELECT t FROM Turma t JOIN FETCH t.alunos WHERE t.id = :turmaId")
    Optional<Turma> findTurmaWithAlunos(@Param("turmaId") Long turmaId);

    @Query("SELECT DISTINCT t FROM Turma t LEFT JOIN FETCH t.alunos")
    List<Turma> findAllWithAlunos();
}
