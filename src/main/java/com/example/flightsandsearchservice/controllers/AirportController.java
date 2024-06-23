package com.example.flightsandsearchservice.controllers;

import com.example.flightsandsearchservice.models.Airport;
import com.example.flightsandsearchservice.models.City;
import com.example.flightsandsearchservice.services.AirportService;
import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airports")
public class AirportController {
    private final AirportService airportService;
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAirports() {
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAirportById(@PathVariable  long id) {
        Optional<Airport> val=airportService.getAirportById(id);
        if(val.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airport not found");
        }
        return ResponseEntity.ok(val);
    }

    @PostMapping
    public ResponseEntity<?> addAirport(@RequestBody Airport airport) {
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.addAirport(airport));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.updateAirportById(id,airport));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(airportService.DeleteAirportById(id));
    }

}
