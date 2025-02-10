package com.tjw.projeto.Controller;

import com.tjw.projeto.entity.Aluno;
import com.tjw.projeto.serviceImpl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;


    @GetMapping("/listar")
    String listarAlunos(ModelMap model){
        model.addAttribute("alunos", alunoService.buscarTodos());
        return "aluno/lista";
    }

    @GetMapping("/cadastrar")
    String cadastrarAluno(ModelMap model){
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastro";
    }

    @PostMapping("/salvar")
    String salvar(Aluno aluno){
        alunoService.cadastrar(aluno);
        return "redirect:/alunos/listar";
    }
}
