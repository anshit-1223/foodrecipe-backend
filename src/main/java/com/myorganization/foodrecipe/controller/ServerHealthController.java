package com.myorganization.foodrecipe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerHealthController {

    @GetMapping
    public ResponseEntity<?> checkServerHealth() {
        return new ResponseEntity<>("Server is live!", HttpStatus.valueOf(200));
    }
}
