package com.tjw.projeto.service;

import com.tjw.projeto.entity.Semestre;

import java.util.List;

public interface SemestreService {

    Semestre cadastrar(Semestre semestre);

    Semestre editar(Semestre semestre);

    Semestre buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Semestre> buscarTodos();

}
