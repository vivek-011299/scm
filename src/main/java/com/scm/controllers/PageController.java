package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



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

    //about
    @RequestMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("isLoggedIn", false);
        System.out.println("In about route");
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String services(Model model)
    {
        System.out.println("Services page");
        return "services";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/contact")
    public String contacts() {
        return new String("contact");
    }
    
    @GetMapping("/register")
    public String register() {
        return new String("register");
    }
    
    
}
