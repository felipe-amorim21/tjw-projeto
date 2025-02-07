package com.tjw.projeto.Service;

import com.tjw.projeto.Entity.Semestre;

import java.util.List;

public interface SemestreService {

    Semestre cadastrar(Semestre semestre);

    Semestre editar(Semestre semestre);

    Semestre buscarPorId(Long id);

    void excluirPorId(Long id);

    List<Semestre> buscarTodos();

}
