package com.example.travel_agency.service;


import com.example.travel_agency.model.Airport;
import com.example.travel_agency.model.Continent;
import com.example.travel_agency.model.Hotel;
import com.example.travel_agency.respositories.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    AirportRepository airportRepository;


    @Transactional
    public void addAirport(Airport airport) {
        airportRepository.save(airport);
    }

    public  void removeAirport(Airport airport) { airportRepository.delete(airport);}

    public Airport getAirportById(long id) {
        return airportRepository.findById(id).get();
    }

    public List<Airport> getAll() {
        return airportRepository.findAll();
    }


}
