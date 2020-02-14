package com.example.hola_mundo.controllers;

import com.example.hola_mundo.models.Passenger;
import com.example.hola_mundo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private static final Logger LOG = Logger.getLogger(HomeController.class.getName());
    private PassengerService passengerService;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("getPassengers")
    public ResponseEntity<?> getPassengers() {

        Map<String, Object> response = new HashMap<>();
        List<Passenger> passengers = this.passengerService.getPassengers();

        if(passengers.isEmpty()) {
            response.put("Passengers", "No passengers");
        } else {
            response.put("Passengers", this.passengerService.getPassengers());
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.ACCEPTED);
    }
}
