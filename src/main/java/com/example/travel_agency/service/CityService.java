package com.example.travel_agency.service;

import com.example.travel_agency.model.City;
import com.example.travel_agency.respositories.CityRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    public void addCity(@Valid City city) {
        cityRepository.save(city);
    }

    public void removeCity(Long id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityByName(String cityName) {
        return cityRepository.findByCityName(cityName);
    }
}
