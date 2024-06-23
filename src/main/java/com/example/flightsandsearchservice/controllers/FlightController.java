package com.example.flightsandsearchservice.controllers;

import com.example.flightsandsearchservice.dtos.FlightFilterDto;
import com.example.flightsandsearchservice.models.Flight;
import com.example.flightsandsearchservice.services.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
        Flight res=flightService.createFlight(flight);
        if(res==null) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Check Departure or Arrival Dates");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllFlights(@RequestParam(required = false,name="departureAirportId") long departureAirportId,@RequestParam(required = false,name="arrivalAirportId") long arrivalAirportId,@RequestParam(required = false,name = "maxPrice") int maxPrice,@RequestParam(required = false,name="minPrice") int minPrice) {
//        FlightFilterDto flightFilterDto = FlightFilterDto.builder()
//                .arrivalAirportId(ArrivalAirportId)
//                .departureAirportId(DepartureAirportId)
//                .maxPrice(maxPrice)
//                .minPrice(minPrice)
//                .build();
        return ResponseEntity.ok(flightService.getAllFlights(departureAirportId,arrivalAirportId,maxPrice,minPrice));
    }
}
