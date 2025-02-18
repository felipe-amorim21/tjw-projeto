package com.tjw.projeto.Controller;

import com.tjw.projeto.entity.Turma;
import com.tjw.projeto.serviceImpl.DisciplinaServiceImpl;
import com.tjw.projeto.serviceImpl.SemestreServiceImpl;
import com.tjw.projeto.serviceImpl.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    TurmaServiceImpl turmaService;

    @Autowired
    SemestreServiceImpl semestreService;

    @Autowired
    DisciplinaServiceImpl disciplinaService;

    @GetMapping("/listar")
    String listarTurmas(ModelMap model){
        model.addAttribute("turmas", turmaService.buscarTodos());
        return "turma/lista";
    }

    @GetMapping("/cadastrar")
    String cadastrarTurmas(ModelMap model){
        model.addAttribute("turma", new Turma());
        model.addAttribute("semestres", semestreService.buscarTodos());
        model.addAttribute("disciplinas", disciplinaService.buscarTodos());
        return "turma/cadastro";
    }

    @PostMapping("/salvar")
    String salvar(Turma turma){
        turmaService.cadastrar(turma);
        return "redirect:/turmas/listar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("turma", turmaService.buscarPorId(id));
        model.addAttribute("semestres", semestreService.buscarTodos());
        model.addAttribute("disciplinas", disciplinaService.buscarTodos());
        return "turma/cadastro";
    }

    @PostMapping("/editar")
    String editar(Turma turma){
        turmaService.editar(turma);
        return "redirect:/turmas/listar";
    }

    @GetMapping("/excluir/{id}")
    String excluir(@PathVariable("id") Long id){
        turmaService.excluirPorId(id);
        return "redirect:/turmas/listar";
    }

}
