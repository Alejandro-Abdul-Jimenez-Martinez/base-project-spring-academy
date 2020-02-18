package com.example.hola_mundo.repository;

import com.example.hola_mundo.models.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {

    Passenger findByFirstName(String firstName);

    @Query("SELECT p FROM Passenger p WHERE p.firstName = ?1")
    Passenger getPassengerByFirstName(String firsName);
}