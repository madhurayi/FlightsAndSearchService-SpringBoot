package com.example.flightsandsearchservice.controllers;

import com.example.flightsandsearchservice.models.Airplane;
import com.example.flightsandsearchservice.models.Airport;
import com.example.flightsandsearchservice.services.AirplaneService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAirplanes() {
        return ResponseEntity.status(HttpStatus.OK).body(airplaneService.getAllAirplanes()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAirplaneById(@PathVariable long id) {
        Optional<Airplane> val=airplaneService.getAirplaneById(id);
        if(val.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Airplane not found");
        }
        return ResponseEntity.ok(val);
    }

    @PostMapping
    public ResponseEntity<?> addAirplane(@RequestBody Airplane airplane) {
       return ResponseEntity.status(HttpStatus.CREATED).body(airplaneService.addAirplane(airplane));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAirplane(@PathVariable long id , @RequestBody Airplane airplane) {
        return ResponseEntity.status(HttpStatus.OK).body(airplaneService.updateAirplaneById(id, airplane));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAirplane(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(airplaneService.DeleteAirplaneById(id));
    }
}
