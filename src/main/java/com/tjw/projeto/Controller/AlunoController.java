package com.tjw.projeto.Controller;

import com.tjw.projeto.entity.Aluno;
import com.tjw.projeto.serviceImpl.AlunoServiceImpl;
import com.tjw.projeto.serviceImpl.AlunoTurmaServiceImpl;
import com.tjw.projeto.serviceImpl.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl alunoService;

    @Autowired
    private TurmaServiceImpl turmaService;

    @Autowired
    private AlunoTurmaServiceImpl alunoTurmaService;


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

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "/aluno/cadastro";
    }

    @PostMapping("/editar")
    String editar(Aluno aluno){
        alunoService.editar(aluno);
        return "redirect:/alunos/listar";
    }

    @GetMapping("/excluir/{id}")
    String excluir(@PathVariable("id") Long id){
        alunoService.excluirPorId(id);
        return "redirect:/alunos/listar";
    }


}
