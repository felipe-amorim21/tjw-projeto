package com.tjw.projeto.service;

import com.tjw.projeto.entity.Disciplina;

import java.util.List;

public interface DisciplinaService {

    Disciplina cadastrar(Disciplina disciplina);

    Disciplina editar(Disciplina disciplina);

    Disciplina buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Disciplina> buscarTodos();
}
