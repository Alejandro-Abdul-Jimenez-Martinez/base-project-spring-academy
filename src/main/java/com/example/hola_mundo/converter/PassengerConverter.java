package com.example.hola_mundo.converter;

import com.example.hola_mundo.dto.DTOPassenger;
import com.example.hola_mundo.models.Passenger;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("PassengerConverter")
public class PassengerConverter {

    public DTOPassenger passengerToDTOPassenger(Passenger passenger) {

        DTOPassenger dtoPassenger = new DTOPassenger();

        dtoPassenger.setId(passenger.getId());
        dtoPassenger.setRole(passenger.getRole());
        dtoPassenger.setFirstName(passenger.getFirstName());
        dtoPassenger.setLastName(passenger.getLastName());
        dtoPassenger.setAge(passenger.getAge());
        dtoPassenger.setEmail(passenger.getEmail());
        dtoPassenger.setPhone(passenger.getPhone());
        dtoPassenger.setRegistrationDate(passenger.getRegistrationDate());

        return dtoPassenger;
    }

    public List<DTOPassenger> passengerToDTOPassenger(List<Passenger> passengers) {

        List<DTOPassenger> dtoPassengers = new ArrayList<>();

        for(Passenger passenger: passengers) {

            DTOPassenger dtoPassenger = passengerToDTOPassenger(passenger);
            dtoPassengers.add(dtoPassenger);
        }

        return dtoPassengers;
    }

    public Passenger dtoPassengerToPassenger(DTOPassenger dtoPassenger) {

        Passenger passenger = new Passenger();

        passenger.setId(dtoPassenger.getId());
        passenger.setRole(dtoPassenger.getRole());
        passenger.setFirstName(dtoPassenger.getFirstName());
        passenger.setLastName(dtoPassenger.getLastName());
        passenger.setAge(dtoPassenger.getAge());
        passenger.setEmail(dtoPassenger.getEmail());
        passenger.setPhone(dtoPassenger.getPhone());
        passenger.setRegistrationDate(dtoPassenger.getRegistrationDate());

        return passenger;
    }

    public List<Passenger> dtoPassengerToPassenger(List<DTOPassenger> dtoPassengers) {

        List<Passenger> passengers = new ArrayList<>();

        for(DTOPassenger dtoPassenger: dtoPassengers) {

            Passenger passenger = dtoPassengerToPassenger(dtoPassenger);
            passengers.add(passenger);
        }

        return passengers;
    }
}
