package com.example.flightsandsearchservice.repositories;

import com.example.flightsandsearchservice.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

//    @Query(value = "Select c from City c where c.name ilike %?1%  or ?1 is Null")
     public List<City> findCitiesByNameContainingIgnoreCase(String name);
}
