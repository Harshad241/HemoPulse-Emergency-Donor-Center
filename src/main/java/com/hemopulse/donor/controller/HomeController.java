package com.hemopulse.donor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "HemoPulse Emergency Donor Center - Spring Boot Application Deployed Successfully";
    }
}