package com.example.auth.controllers;

import com.example.auth.Services.authService;
import com.example.auth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class authController {

    @Autowired
    private authService service ;

    @GetMapping("/logout")
    public Object logout(Model model) {
        if(service.isLoggedIn()){
            service.logout();
        }
        return  null;
    }

    @GetMapping("/isLogged")
    public User rawForecastData(Model model) {
        if (service.isLoggedIn()){
            return service.getUser();
        }
        return null;
    }


}
