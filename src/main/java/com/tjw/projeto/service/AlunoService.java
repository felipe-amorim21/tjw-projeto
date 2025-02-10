package com.tjw.projeto.service;

import com.tjw.projeto.entity.Aluno;

import java.util.List;

public interface AlunoService {

    Aluno cadastrar(Aluno aluno);

    Aluno editar(Aluno aluno);

    Aluno buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Aluno> buscarTodos();

}
