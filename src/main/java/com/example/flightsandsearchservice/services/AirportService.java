package com.example.flightsandsearchservice.services;

import com.example.flightsandsearchservice.models.Airport;
import com.example.flightsandsearchservice.models.City;
import com.example.flightsandsearchservice.repositories.AirportRepository;
import com.example.flightsandsearchservice.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    private AirportRepository airportRepository;
    private CityRepository cityRepository;
    public AirportService(AirportRepository airportRepository, CityRepository cityRepository) {
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirportById(long id) {
        Optional<Airport> res=airportRepository.findById(id);
        return res;
    }

    public Airport addAirport(Airport airport) {
        City c=cityRepository.findById(airport.getCity().getId()).get();
        airport.setCity(c);
        return airportRepository.save(airport);
    }

    public Boolean DeleteAirportById(long id) {
       Airport res=airportRepository.findById(id).get();
       if(res!=null) {
           airportRepository.delete(res);
           return true;
       }
        return false;
    }

    public Airport updateAirportById(long id, Airport airport) {
        Airport res=airportRepository.findById(id).get();
        if(res!=null) {
            if(airport.getName()!=null){
                res.setName(airport.getName());
            }
            if(airport.getAddress()!=null){
                res.setAddress(airport.getAddress());
            }
            if(airport.getCity()!=null){
                airport.setCity(airport.getCity());
            }
            Airport ar=airportRepository.save(airport);
            return ar;
        }
       return null;
    }
}
