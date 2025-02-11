package com.tjw.projeto.Controller;

import com.tjw.projeto.entity.Semestre;
import com.tjw.projeto.serviceImpl.SemestreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/semestres")
public class SemestreController {

    @Autowired
    SemestreServiceImpl semestreService;

    @GetMapping("/listar")
    String listarSemestres(ModelMap model){
        model.addAttribute("semestres", semestreService.buscarTodos());
        return "semestre/lista";
    }

    @GetMapping("/cadastrar")
    String cadastrarSemestre(ModelMap model){
        model.addAttribute("semestre", new Semestre());
        return "semestre/cadastro";
    }

    @PostMapping("/salvar")
    String salvar(Semestre semestre){
        semestreService.cadastrar(semestre);
        return "redirect:/semestres/listar";
    }

    @GetMapping("/editar/{id}")
    String preEditar(@PathVariable("id") Long id, ModelMap modelMap){
        modelMap.addAttribute("semestre", semestreService.buscarPorId(id));
        return "semestre/cadastro";
    }

    @PostMapping("/editar")
    String editar(Semestre semestre){
        semestreService.editar(semestre);
        return "redirect:/semestres/listar";
    }

    @GetMapping("/excluir/{id}")
    String excluir(@PathVariable("id") Long id){
        semestreService.excluirPorId(id);
        return "redirect:/semestres/listar";
    }
}
