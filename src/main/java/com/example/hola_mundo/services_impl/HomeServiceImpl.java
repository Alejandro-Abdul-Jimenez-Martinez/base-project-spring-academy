package com.example.hola_mundo.services_impl;

import com.example.hola_mundo.controllers.HomeController;
import com.example.hola_mundo.services.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class HomeServiceImpl implements HomeService {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());

    @Override
    public ResponseEntity<?> getHolaMundo() {

        Map<String, Object> response = new HashMap<>();

        LOG.info("Hola mundo desde Spring Boot");
        response.put("respuesta", "Hola mundo desde Spring Boot - 202Accepted");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
