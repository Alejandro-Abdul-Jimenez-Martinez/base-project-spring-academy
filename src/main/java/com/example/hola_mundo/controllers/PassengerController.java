package com.example.hola_mundo.controllers;

import com.example.hola_mundo.dto.DTOPassenger;
import com.example.hola_mundo.models.Passenger;
import com.example.hola_mundo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private static final Logger LOG = Logger.getLogger(PassengerController.class.getName());
    private PassengerService passengerService;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping("getPassengers")
    public ResponseEntity<?> getPassengers() {

        Map<String, Object> response = new HashMap<>();
        List<DTOPassenger> passengers = this.passengerService.getPassengers();

        if(passengers.isEmpty()) {
            response.put("Passengers", "No passengers");
        } else {
            response.put("Passengers", this.passengerService.getPassengers());
        }

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("findPassengerByFirstName/{firstName}")
    public ResponseEntity<?> findPassengerByFirstName(@PathVariable String firstName) {

        Map<String, Object> response = new HashMap<>();

        try {
            DTOPassenger passenger = this.passengerService.findPassengerByFirstName(firstName);
            response.put("Passenger by first name", passenger);

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (NullPointerException e) {
            response.put("Error", "No passenger with the given first name");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getPassengerByFirstName/{firstName}")
    public ResponseEntity<?> getPassengerByFirstName(@PathVariable String firstName) {

        Map<String, Object> response = new HashMap<>();

        try {
            DTOPassenger passenger = this.passengerService.getPassengerByFirstName(firstName);
            response.put("Passenger by first name using a raw query", passenger);

            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (NullPointerException e) {
            response.put("Error", "No passenger with the given first name");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> createPassenger(@RequestBody Passenger passenger) {

        Map<String, Object> response = new HashMap<>();

        try {
            this.passengerService.setPassenger(passenger);
            response.put("Success", "User added correctly");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            response.put("Error", e.getStackTrace());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
