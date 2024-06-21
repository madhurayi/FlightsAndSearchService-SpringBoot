package com.example.flightsandsearchservice.controllers;

import com.example.flightsandsearchservice.models.City;
import com.example.flightsandsearchservice.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping
    public ResponseEntity<?> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCityById(@PathVariable long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @PostMapping
    public ResponseEntity<?> addCity(@RequestBody City city) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.CreateCity(city));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cityService.DeleteCityById(id));
    }
}
