package com.tjw.projeto.ServiceImpl;

import com.tjw.projeto.Entity.Disciplina;
import com.tjw.projeto.Repository.DisciplinaRepository;
import com.tjw.projeto.Service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DisciplinaServiceImpl implements DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Override
    public Disciplina cadastrar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina editar(Disciplina disciplina) {
        Disciplina novaDisciplina = this.buscarPorId(disciplina.getId());
        novaDisciplina.setCodigo(disciplina.getCodigo());
        novaDisciplina.setEmenta(disciplina.getEmenta());
        novaDisciplina.setHorario(disciplina.getHorario());
        novaDisciplina.setNome(disciplina.getNome());
        return disciplinaRepository.save(novaDisciplina);
    }

    @Override
    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Disciplina de id: " + id + " não encontrada"));
    }

    @Override
    public void excluirPorId(Long id) {
        disciplinaRepository.deleteById(id);
    }

    @Override
    public List<Disciplina> buscarTodos() {
        return disciplinaRepository.findAll();
    }
}
