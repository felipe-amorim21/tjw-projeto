package com.tjw.projeto.service;

import com.tjw.projeto.entity.Aluno;
import java.util.List;

public interface AlunoTurmaService {

    void associarAlunoATurma(Long alunoId, Long turmaId);

    List<Aluno> buscarAlunosComTurmas();
}
