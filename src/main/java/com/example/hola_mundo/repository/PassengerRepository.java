package com.example.hola_mundo.repository;

import com.example.hola_mundo.models.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface PassengerRepository extends CrudRepository<Passenger, Long> {
}
