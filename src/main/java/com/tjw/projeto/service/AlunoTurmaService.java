package com.tjw.projeto.service;

import com.tjw.projeto.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AlunoTurmaService {

    public void associarAlunoATurma(Long alunoId, Long turmaId);

}
