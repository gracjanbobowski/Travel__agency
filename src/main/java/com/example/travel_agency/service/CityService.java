package com.example.travel_agency.service;

import com.example.travel_agency.model.City;
import com.example.travel_agency.model.Country;
import com.example.travel_agency.respositories.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    City city;

    CityRepository cityRepository;

    public CityService(City city) {
        this.city = city;
    }

    @Transactional
    public void addCity(City city) { cityRepository.save(city);
    }

    public void removeCity(City city) {cityRepository.delete(city);}

    public City getCityById(long id) {
        return cityRepository.findById(id).get();
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }





}
