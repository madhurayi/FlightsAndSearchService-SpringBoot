package com.example.flightsandsearchservice.services;

import com.example.flightsandsearchservice.dtos.FlightFilterDto;
import com.example.flightsandsearchservice.models.Airplane;
import com.example.flightsandsearchservice.models.Airport;
import com.example.flightsandsearchservice.models.Flight;
import com.example.flightsandsearchservice.repositories.AirplaneRepository;
import com.example.flightsandsearchservice.repositories.AirportRepository;
import com.example.flightsandsearchservice.repositories.FlightRepository;
import com.example.flightsandsearchservice.utils.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;
    private final Helper helper=new Helper();

    public FlightService(FlightRepository flightRepository, AirplaneRepository airplaneRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airplaneRepository = airplaneRepository;
        this.airportRepository = airportRepository;
    }

    public Flight createFlight(Flight flight) {
       Boolean val= helper.compareDate(flight.getDepartureTime(),flight.getArrivalTime());
        if(!val){
            return null;
        }
        Optional<Airplane> airplane=airplaneRepository.findById(flight.getAirplane().getId());
        flight.setAirplane(airplane.get());
        Airport arrivalairport=airportRepository.findById(flight.getArrivalAirport().getId()).get();
        flight.setArrivalAirport(arrivalairport);

        Airport departureairport=airportRepository.findById(flight.getDepartureAirport().getId()).get();
        flight.setDepartureAirport(departureairport);

        if(airplane.isPresent()){
            flight.setTotalSeats(airplane.get().getCapacity());
            System.out.println("airplane is present");
        }
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights(long departureAirportId,long arrivalAirportId,int maxPrice,int minPrice ) {
        if(departureAirportId!=0 || arrivalAirportId!=0 || maxPrice!=0 || minPrice!=0){
            System.out.println(arrivalAirportId);
            return flightRepository.findFlightByFilters(departureAirportId,arrivalAirportId,minPrice,maxPrice);
        }
        return flightRepository.findAll();
    }

    public Flight getFlightById(long id) {
        try{
            Optional<Flight> flight=flightRepository.findById(id);
            return flight.orElse(null);

        }catch(Exception e){
            throw e;
        }
    }

}
