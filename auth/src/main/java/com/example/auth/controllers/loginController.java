package com.example.auth.controllers;

import com.example.auth.Services.authService;
import com.example.auth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class loginController {

    @Autowired
    private authService service ;

    @GetMapping("/login")
    public Object loginForm(Model model) {
        if(service.isLoggedIn()){
            return new RedirectView("http://localhost:8081/welcome");
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public Object login(@ModelAttribute User user, Model model) {
        if(service.checkUser(user.getEmail(),user.getPassword())){
            model.addAttribute("user",service.getUser());
            return new RedirectView("http://localhost:8081/welcome");
        }else
            return "login";
    }

    @GetMapping("**")
    public Object redirect(Model model) {
        return new RedirectView("http://localhost:8081/welcome");
    }
}
