package com.example.flightsandsearchservice.services;

import com.example.flightsandsearchservice.models.Airplane;
import com.example.flightsandsearchservice.models.Airport;
import com.example.flightsandsearchservice.models.City;
import com.example.flightsandsearchservice.repositories.AirplaneRepository;
import com.example.flightsandsearchservice.repositories.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {
    private final AirportRepository airportRepository;
    private AirplaneRepository airplaneRepository;
    public AirplaneService(AirplaneRepository airplaneRepository, AirportRepository airportRepository) {
        this.airplaneRepository = airplaneRepository;
        this.airportRepository = airportRepository;
    }

    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    public Optional<Airplane> getAirplaneById(long id) {
        Optional<Airplane> res=airplaneRepository.findById(id);
        return res;
    }

    public Airplane addAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    public Boolean DeleteAirplaneById(long id) {
        Airplane res=airplaneRepository.findById(id).get();
        if(res!=null) {
            airplaneRepository.delete(res);
            return true;
        }
        return false;
    }

    public Airplane updateAirplaneById(long id, Airplane airplane) {
        Airplane res=airplaneRepository.findById(id).get();
        if(res!=null) {
            if(airplane.getModelNumber()!=null){
                res.setModelNumber(airplane.getModelNumber());
            }
            if(airplane.getCapacity()>=0){
                res.setCapacity(airplane.getCapacity());
            }

            Airplane ar=airplaneRepository.save(airplane);
            return ar;
        }
        return null;
    }
}
