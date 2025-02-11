package com.tjw.projeto.service;

import com.tjw.projeto.entity.Turma;

import java.util.List;

public interface TurmaService {

    Turma cadastrar(Turma turma);

    Turma editar(Turma turma);

    Turma buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Turma> buscarTodos();
}
