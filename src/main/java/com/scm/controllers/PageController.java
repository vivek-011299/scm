package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("home")
    public String home(Model model)
    {
        //adding attribute to model object which is visible to thymeleaf.
        //thymeleaf is responsible for sending the data to frontend page.
        System.out.println("In home comtroller");
        model.addAttribute("name", "Vivek");
        model.addAttribute("company", "Statestreet");
        return "home";
    }
}
