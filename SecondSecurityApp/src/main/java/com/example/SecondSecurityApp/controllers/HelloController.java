package com.example.SecondSecurityApp.controllers;

import com.example.SecondSecurityApp.security.PersonDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;



@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }
}
