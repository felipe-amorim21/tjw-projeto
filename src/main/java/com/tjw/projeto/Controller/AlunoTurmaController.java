package com.tjw.projeto.Controller;

import com.tjw.projeto.entity.Aluno;
import com.tjw.projeto.entity.Turma;
import com.tjw.projeto.serviceImpl.AlunoServiceImpl;
import com.tjw.projeto.serviceImpl.AlunoTurmaServiceImpl;
import com.tjw.projeto.serviceImpl.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        //model.addAttribute("mensagem", "Aluno associado à turma com sucesso!");

        return "redirect:/alunoturmas/listar";
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

    @GetMapping("/editar/{alunoId}/{turmaId}")
    public String preEditar(@PathVariable Long alunoId, @PathVariable Long turmaId, ModelMap model) {
        model.addAttribute("aluno", alunoService.buscarPorId(alunoId));
        model.addAttribute("turma", turmaService.buscarPorId(turmaId));
        model.addAttribute("turmas", turmaService.buscarTodos());
        return "aluno_turma/editar";
    }

    @PostMapping("/editar")
    public String editarAssociacao(@RequestParam Long alunoId, @RequestParam Long turmaId, @RequestParam Long turmaNovaId, ModelMap model) {
        Aluno aluno = alunoService.buscarPorId(alunoId);
        Turma turmaAntiga = turmaService.buscarPorId(turmaId);
        Turma turmaNova = turmaService.buscarPorId(turmaNovaId);

        aluno.getTurmas().remove(turmaAntiga);
        turmaAntiga.getAlunos().remove(aluno);

        aluno.getTurmas().add(turmaNova);
        turmaNova.getAlunos().add(aluno);

        alunoService.editar(aluno);
        turmaService.editar(turmaAntiga);
        turmaService.editar(turmaNova);

        model.addAttribute("mensagem", "Associação alterada com sucesso!");
        return "redirect:/alunoturmas/listar";
    }

    @GetMapping("/excluir/{alunoId}/{turmaId}")
    public String deletarAssociacao(@PathVariable Long alunoId, @PathVariable Long turmaId, ModelMap model) {
        Aluno aluno = alunoService.buscarPorId(alunoId);
        Turma turma = turmaService.buscarPorId(turmaId);

        aluno.getTurmas().remove(turma);
        turma.getAlunos().remove(aluno);

        alunoService.editar(aluno);
        turmaService.editar(turma);

        model.addAttribute("mensagem", "Associação deletado com sucesso!");

        return "redirect:/alunoturmas/listar";
    }


    @GetMapping("/relatorio/turmas")
    public String gerarRelatorioTodasTurmas(ModelMap model) {
        List<Turma> turmas = alunoTurmaService.obterTodasTurmasComAlunos();
        model.addAttribute("turmas", turmas);
        return "aluno_turma/relatorio-turma";
    }
}
