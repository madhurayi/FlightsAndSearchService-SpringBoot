package com.example.flightsandsearchservice.repositories;

import com.example.flightsandsearchservice.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "select f from Flight f " +
            "where (f.arrivalAirport.id=:arrivalAirportId or :arrivalAirportId is null ) " +
            "and (f.departureAirport.id=:departureAirportId or :departureAirportId is null) and " +
            "(f.price>=:minPrice or :minPrice is null) and (f.price<=:maxPrice or :maxPrice is null)"
    )
    public List<Flight> findFlightByFilters(long departureAirportId,long arrivalAirportId,int minPrice,int maxPrice);
}
