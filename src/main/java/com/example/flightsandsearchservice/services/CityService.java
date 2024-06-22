package com.example.flightsandsearchservice.services;

import com.example.flightsandsearchservice.models.City;
import com.example.flightsandsearchservice.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private CityRepository cityRepository;
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities(String cityName) {
        if(cityName==null){
            return cityRepository.findAll();
        }
        return cityRepository.findCitiesByNameContainingIgnoreCase(cityName);
    }

    public Optional<City> getCityById(long id) {
        return cityRepository.findById(id);
    }

    public City CreateCity(City city) {
        return cityRepository.save(city);
    }

    public boolean DeleteCityById(Long id) {
        cityRepository.deleteById(id);
        return true;
    }
}
