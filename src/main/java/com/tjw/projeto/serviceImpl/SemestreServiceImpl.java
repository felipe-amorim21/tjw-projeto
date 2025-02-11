package com.tjw.projeto.serviceImpl;

import com.tjw.projeto.entity.Semestre;
import com.tjw.projeto.repository.SemestreRepository;
import com.tjw.projeto.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return semestreRepository.findAll();
    }
}
