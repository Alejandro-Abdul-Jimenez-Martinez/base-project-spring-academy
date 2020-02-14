package com.example.hola_mundo.controllers;

import com.example.hola_mundo.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
public class HomeController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());
    private HomeService homeService;

    // Services
    @Autowired
    public void setHomeService(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("hola-mundo")
    public ResponseEntity<?> holaMundo() {

        Map<String, Object> response = new HashMap<>();

        LOG.info("Hola mundo desde Spring Boot");
        response.put("respuesta", "Hola mundo desde Spring Boot - 202Accepted");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("getHolaMundo")
    public ResponseEntity<?> getHolaMundo() {

        return homeService.getHolaMundo();
    }
}

