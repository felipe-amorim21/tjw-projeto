package com.tjw.projeto.repository;

import com.tjw.projeto.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :nome, '%')) AND a.turmas IS NOT EMPTY")
    List<Aluno> findByNomeContainingIgnoreCaseComTurmas(String nome);

    @Query("SELECT a FROM Aluno a WHERE a.turmas IS NOT EMPTY")
    List<Aluno> findAlunoComTurmas();
}
