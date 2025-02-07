package com.tjw.projeto.Service;

import com.tjw.projeto.Entity.Disciplina;

import java.util.List;

public interface DisciplinaService {

    Disciplina cadastrar(Disciplina disciplina);

    Disciplina editar(Disciplina disciplina);

    Disciplina buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Disciplina> buscarTodos();
}
