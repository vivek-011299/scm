package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("home")
    public String home(Model model)
    {
        System.out.println("In home comtroller");
        model.addAttribute("name", "Vivek");
        model.addAttribute("company", "Statestreet");
        return "home";
    }
}
