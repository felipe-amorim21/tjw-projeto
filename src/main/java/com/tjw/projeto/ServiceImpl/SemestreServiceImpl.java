package com.tjw.projeto.ServiceImpl;

import com.tjw.projeto.Entity.Semestre;
import com.tjw.projeto.Repository.SemestreRepository;
import com.tjw.projeto.Service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SemestreServiceImpl implements SemestreService {

    @Autowired
    SemestreRepository semestreRepository;

    @Override
    public Semestre cadastrar(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    @Override
    public Semestre editar(Semestre semestre) {
        Semestre novoSemestre = this.buscarPorId(semestre.getId());
        novoSemestre.setAno(semestre.getAno());
        novoSemestre.setNumeroSemestre(semestre.getNumeroSemestre());
        novoSemestre.setDataFim(semestre.getDataFim());
        novoSemestre.setDataInicio(semestre.getDataInicio());
        return semestreRepository.save(novoSemestre);
    }

    @Override
    public Semestre buscarPorId(Long id) {
        return semestreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Semestre de id: " + id + " não encontrado"));
    }

    @Override
    public void excluirPorId(Long id) {
        semestreRepository.deleteById(id);
    }

    @Override
    public List<Semestre> buscarTodos() {
        return List.of();
    }
}
