package com.tjw.projeto.Controller;

import com.tjw.projeto.serviceImpl.AlunoServiceImpl;
import com.tjw.projeto.serviceImpl.AlunoTurmaServiceImpl;
import com.tjw.projeto.serviceImpl.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("alunoturmas")
public class AlunoTurmaController {

    @Autowired
    private AlunoTurmaServiceImpl alunoTurmaService;

    @Autowired
    private AlunoServiceImpl alunoService;

    @Autowired
    private TurmaServiceImpl turmaService;

    @GetMapping("/associar")
    public String exibirFormularioAssociacao(ModelMap model) {

        model.addAttribute("alunos", alunoService.buscarTodos());
        model.addAttribute("turmas", turmaService.buscarTodos());

        return "aluno_turma/associarAlunoTurma";
    }

    @PostMapping("/associar")
    public String associarAlunoATurma(@RequestParam Long alunoId, @RequestParam Long turmaId, ModelMap model) {
        alunoTurmaService.associarAlunoATurma(alunoId, turmaId);

        model.addAttribute("mensagem", "Aluno associado à turma com sucesso!");

        return "aluno_turma/associarAlunoTurma";
    }

    @GetMapping("/listar")
    public String listarAlunoTurma(@RequestParam(name = "search", required = false) String search, ModelMap model) {

        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("alunos", alunoTurmaService.buscarPorNomeComTurmas(search));
        } else {
            model.addAttribute("alunos", alunoTurmaService.buscarAlunosComTurmas());
        }
        //model.addAttribute("turmas", turmaService.buscarTodos());

        return "aluno_turma/lista";
    }

    String preEditar(@PathVariable("id") Long id, ModelMap model){

    }
}
