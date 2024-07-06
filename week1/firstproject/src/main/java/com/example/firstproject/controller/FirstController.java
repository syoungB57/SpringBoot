package com.example.firstproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String greetUser(Model model){
        model.addAttribute("username", "Lee");
        return "greeting";
    }

    @GetMapping("/bye")
    public String sendingUser(Model model) {
        model.addAttribute("username", "Lee");
        return "goodbye";
    }
}
