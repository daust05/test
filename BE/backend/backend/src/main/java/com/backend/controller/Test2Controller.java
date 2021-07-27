package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {
    @GetMapping("/")
    public ResponseEntity home(){
        return ResponseEntity.status(200).body("Success");
    }
}
