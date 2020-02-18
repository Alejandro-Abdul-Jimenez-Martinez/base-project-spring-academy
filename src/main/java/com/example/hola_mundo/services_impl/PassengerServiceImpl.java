package com.example.hola_mundo.services_impl;

import com.example.hola_mundo.converter.PassengerConverter;
import com.example.hola_mundo.dto.DTOPassenger;
import com.example.hola_mundo.models.Passenger;
import com.example.hola_mundo.repository.PassengerRepository;
import com.example.hola_mundo.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository passengerRepository;
    private PassengerConverter passengerConverter;

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Autowired
    @Qualifier("PassengerConverter")
    public void setPassengerConverter(PassengerConverter passengerConverter) {
        this.passengerConverter = passengerConverter;
    }

    @Override
    public List<DTOPassenger> getPassengers() {

        return this.passengerConverter.passengerToDTOPassenger((List<Passenger>) this.passengerRepository.findAll());
    }

    @Override
    public DTOPassenger findPassengerByFirstName(String firstName) {
        return this.passengerConverter.passengerToDTOPassenger(this.passengerRepository.findByFirstName(firstName));
    }

    @Override
    public DTOPassenger getPassengerByFirstName(String firstName) {
        return this.passengerConverter.passengerToDTOPassenger(this.passengerRepository.getPassengerByFirstName(firstName));
    }

    @Override
    public void setPassenger(Passenger passenger) {
        this.passengerRepository.save(passenger);
    }
}
