package com.zmk.controller;

import com.zmk.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam(name = "user") UserRegistrationDto user, Model model) {
        System.out.println(user);
        model.addAttribute("user", user);
        return "registration";
    }
}