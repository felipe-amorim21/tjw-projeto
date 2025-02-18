package com.tjw.projeto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    String index(){
        return "home";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
