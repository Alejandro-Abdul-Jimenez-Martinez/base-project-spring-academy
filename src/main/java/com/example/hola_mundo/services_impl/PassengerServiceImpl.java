package com.example.hola_mundo.services_impl;

import com.example.hola_mundo.models.Passenger;
import com.example.hola_mundo.repository.PassengerRepository;
import com.example.hola_mundo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository passengerRepository;

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public List<Passenger> getPassengers() {
        return (List<Passenger>) this.passengerRepository.findAll();
    }
}
