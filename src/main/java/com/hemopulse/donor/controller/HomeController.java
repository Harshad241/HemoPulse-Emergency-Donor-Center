package com.hemopulse.donor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Void> home() {
        // Automatically redirect root URL to /api/donors so clicking the Render service link immediately shows the data
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/api/donors"))
                .build();
    }
}
