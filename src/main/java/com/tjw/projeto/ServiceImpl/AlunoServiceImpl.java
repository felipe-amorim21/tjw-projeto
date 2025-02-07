package com.tjw.projeto.ServiceImpl;

import com.tjw.projeto.Entity.Aluno;
import com.tjw.projeto.Repository.AlunoRepository;
import com.tjw.projeto.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlunoServiceImpl implements AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno editar(Aluno aluno) {
        Aluno novoAluno = this.buscarPorId(aluno.getId());
        novoAluno.setNome(aluno.getNome());
        novoAluno.setCpf(aluno.getCpf());
        novoAluno.setEmail(aluno.getEmail());
        novoAluno.setDataNascimento(aluno.getDataNascimento());
        return alunoRepository.save(novoAluno);
    }

    @Override
    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Aluno de id: " + id + " não encontrado."));
    }

    @Override
    public void excluirPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    @Override
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }
}
