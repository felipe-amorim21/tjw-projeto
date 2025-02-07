package com.tjw.projeto.Service;

import com.tjw.projeto.Entity.Aluno;

import java.util.List;

public interface AlunoService {

    Aluno cadastrar(Aluno aluno);

    Aluno editar(Aluno aluno);

    Aluno buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Aluno> buscarTodos();

}
