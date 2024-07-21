package com.scm.controllers;

import com.scm.forms.UserForm;
import com.scm.model.User;
import com.scm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PageController {
    @Autowired
    private UserService userService;
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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return new String("register");
    }

    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm)
    {
        //save the user
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .about(userForm.getAbout())
                .password(userForm.getPassword())
                .phoneNumber(userForm.getPhoneNumber())
                .profilePic("https://drive.google.com/file/d/11eEPtGwNyxNpBv9Qic7Mw8K2cVpO0Rh2/view?usp=drive_link")
                .build();
        userService.saveUser(user);
        return "redirect:/register";
    }
    
    
}
