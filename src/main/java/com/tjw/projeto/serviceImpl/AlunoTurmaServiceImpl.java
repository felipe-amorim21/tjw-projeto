package com.tjw.projeto.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.tjw.projeto.entity.Aluno;
import com.tjw.projeto.entity.Turma;
import com.tjw.projeto.repository.AlunoRepository;
import com.tjw.projeto.repository.TurmaRepository;
import com.tjw.projeto.service.AlunoTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoTurmaServiceImpl implements AlunoTurmaService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    TurmaRepository turmaRepository;


    @Override
    public void associarAlunoATurma(Long alunoId, Long turmaId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(() -> new RuntimeException("Turma não encontrada"));

        aluno.getTurmas().add(turma);
        alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAlunosComTurmas() {
        return alunoRepository.findAlunoComTurmas();
    }

    @Override
    public List<Turma> obterTodasTurmasComAlunos() {
        return turmaRepository.findAllWithAlunos();
    }


    public List<Aluno> buscarPorNomeComTurmas(String nome){
        return alunoRepository.findByNomeContainingIgnoreCaseComTurmas(nome);
    }


}
