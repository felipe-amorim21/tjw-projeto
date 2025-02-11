package com.tjw.projeto.Controller;

import com.tjw.projeto.entity.Disciplina;
import com.tjw.projeto.serviceImpl.DisciplinaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    DisciplinaServiceImpl disciplinaService;

    @GetMapping("/listar")
    String listarDisciplinas(ModelMap model){
        model.addAttribute("disciplinas", disciplinaService.buscarTodos());
        return "disciplina/lista";
    }

    @GetMapping("/cadastrar")
    String cadastrarDisciplina(ModelMap model){
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/cadastro";
    }

    @PostMapping("/salvar")
    String salvar(Disciplina disciplina){
        disciplinaService.cadastrar(disciplina);
        return "redirect:/disciplinas/listar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("disciplina", disciplinaService.buscarPorId(id));
        return "disciplina/cadastro";
    }

    @PostMapping("/editar")
    String editar(Disciplina disciplina){
        disciplinaService.editar(disciplina);
        return "redirect:/disciplinas/listar";
    }

    @GetMapping("/excluir/{id}")
    String excluir(@PathVariable("id") Long id){
        disciplinaService.excluirPorId(id);
        return "redirect:/disciplinas/listar";
    }
}
