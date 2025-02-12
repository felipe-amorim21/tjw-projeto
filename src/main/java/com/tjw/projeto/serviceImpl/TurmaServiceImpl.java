package com.tjw.projeto.serviceImpl;

import com.tjw.projeto.entity.Turma;
import com.tjw.projeto.repository.TurmaRepository;
import com.tjw.projeto.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    @Override
    public Turma cadastrar(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma editar(Turma turma) {
        Turma novoTurma = this.buscarPorId(turma.getId());
        novoTurma.setDisciplina(turma.getDisciplina());
        novoTurma.setProfessor(turma.getProfessor());
        novoTurma.setSemestre(turma.getSemestre());
        return turmaRepository.save(novoTurma);
    }

    @Override
    public Turma buscarPorId(Long id) {
        return turmaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Turma de id: " + id + " não encontrada"));
    }

    @Override
    public void excluirPorId(Long id) {
        turmaRepository.deleteById(id);
    }

    @Override
    public List<Turma> buscarTodos() {
        return turmaRepository.findAll();
    }
}
