package com.example.hola_mundo.services;

import com.example.hola_mundo.dto.DTOPassenger;
import com.example.hola_mundo.models.Passenger;

import java.util.List;

public interface PassengerService {

    List<DTOPassenger> getPassengers();
    DTOPassenger findPassengerByFirstName(String firstName);
    DTOPassenger getPassengerByFirstName(String firstName);
    void setPassenger(Passenger passenger);
}
