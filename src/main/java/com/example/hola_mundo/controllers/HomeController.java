package com.example.hola_mundo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/base")
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());

    @GetMapping("hola-mundo")
    public ResponseEntity<?> holaMundo() {
        Map<String, Object> response = new HashMap<>();

        LOG.info("Hola mundo desde Spring Boot");
        response.put("respuesta", "Hola mundo desde Spring Boot - 202Accepted");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}

