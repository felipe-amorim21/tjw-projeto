package com.tjw.projeto.service;

import com.tjw.projeto.entity.Aluno;
import com.tjw.projeto.entity.Turma;

import java.util.List;
import java.util.Optional;

public interface AlunoTurmaService {

    void associarAlunoATurma(Long alunoId, Long turmaId);

    List<Aluno> buscarAlunosComTurmas();

    public List<Turma> obterTodasTurmasComAlunos();

    public List<Aluno> buscarPorNomeComTurmas(String nome);
}
