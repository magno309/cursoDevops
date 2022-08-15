package com.service.springcloud.flightservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.springcloud.flightservice.entities.Flight;
import com.service.springcloud.flightservice.repo.FlightRepository;

@RestController
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @GetMapping(value = "/flights")
    public List<Flight> findFlights(){
        return flightRepository.findAll();
    }

}
