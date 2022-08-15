package com.service.springcloud.flightservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.springcloud.flightservice.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
    
}
