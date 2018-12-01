package com.zmk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/")
    public String redirectToProfile() {
        return "redirect:/profile";
    }

    @GetMapping("/profile")
    public String profile(Model model) {


        return "profile";
    }

}
