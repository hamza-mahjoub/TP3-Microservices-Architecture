package com.example.forecast.controllers;

import com.example.forecast.CSVReader;
import com.example.forecast.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class ForecastController {

    @Autowired
    private CSVReader reader ;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/forecast")
    //@ResponseBody
    public Object getAllData(Model model) throws Exception {
        model.addAttribute("instances", reader.readCSV());
        return "DataList";
    }

    @RequestMapping("/forecastDataRaw")
    public Object getAllDataLine(Model model) throws Exception {
        User user = restTemplate.getForObject("http://AUTH-SERVICE/isLogged", User.class);
        if(user == null)
            return new RedirectView("http://localhost:8082/login");
        model.addAttribute("instances", reader.readCSVLineRaw());
        return "DataList";
    }

    @RequestMapping("/forecastDataTable")
    public Object getAllDataObj(Model model) throws Exception {
        User user = restTemplate.getForObject("http://AUTH-SERVICE/isLogged", User.class);
        if(user == null)
            return new RedirectView("http://localhost:8082/login");
        model.addAttribute("products", reader.readCSVLineObj());
        return "dataTable";
    }

    @GetMapping("/logout")
    public Object logout(Model model) {
        User user = restTemplate.getForObject("http://AUTH-SERVICE/isLogged", User.class);
        if(user != null){
            user = restTemplate.getForObject("http://AUTH-SERVICE/logout", User.class);
        }
        return new RedirectView("/welcome");
    }

    @GetMapping({"/", "/welcome","**"})
    public Object welcome(Model model) {
        User user = restTemplate.getForObject("http://AUTH-SERVICE/isLogged", User.class);
        if(user == null)
            return new RedirectView("http://localhost:8082/login");
        model.addAttribute("user",user);
        return "welcome";
        /*if(service.isLoggedIn())
        {
            model.addAttribute("user",service.getUser());
            return "welcome";
        }
        else
            return new RedirectView("/login");*/
    }

}
