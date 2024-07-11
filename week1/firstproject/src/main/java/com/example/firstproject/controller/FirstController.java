package com.example.firstproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String greetUser(Model model){
        // "username"이라는 변수에 "Lee"값 전달 후 greeting.mustache 뷰 호출
        model.addAttribute("username", "Lee");
        return "greeting";
    }

    @GetMapping("/bye")
    public String byeUser(Model model) {
        model.addAttribute("username", "Lee");
        return "goodbye";
    }
}
