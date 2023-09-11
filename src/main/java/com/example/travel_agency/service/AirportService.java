package com.example.travel_agency.service;

import com.example.travel_agency.model.Airport;
import com.example.travel_agency.model.City;
import com.example.travel_agency.model.Country;
import com.example.travel_agency.respositories.AirportRepository;
import com.example.travel_agency.respositories.CityRepository;
import com.example.travel_agency.respositories.CountryRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Autowired
    public AirportService(
            AirportRepository airportRepository,
            CountryRepository countryRepository,
            CityRepository cityRepository
    ) {
        this.airportRepository = airportRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Transactional
    public void addAirport(@NotNull Airport airport, Long countryId, Long cityId) {
        Country country = countryRepository.findById(countryId).orElse(null);
        City city = cityRepository.findById(cityId).orElse(null);

        if (country == null || city == null) {
            throw new IllegalArgumentException("Kraj lub miasto nie istnieje.");
        }

        airport.setCountry(country);
        airport.setCity(city);

        airportRepository.save(airport);
    }

    @Transactional
    public void editAirport(@NotNull Airport airport) {
        String countryName = airport.getCountryName();
        String cityName = airport.getCityName();

        Country country = countryRepository.findByCountryName(countryName);
        City city = cityRepository.findByCityName(cityName);

        if (country == null) {
            country = new Country();
            country.setCountryName(countryName);
            countryRepository.save(country);
        }

        if (city == null) {
            city = new City();
            city.setCityName(cityName);
            city.setCountry(country);
            cityRepository.save(city);
        }

        airport.setCountry(country);
        airport.setCity(city);

        airportRepository.save(airport);
    }

    public void removeAirport(Long id) {
        airportRepository.deleteById(id);
    }

    public Airport getAirportById(Long id) {
        Optional<Airport> optionalAirport = airportRepository.findById(id);
        return optionalAirport.orElse(null);
    }

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportByName(String airportName) {
        return airportRepository.findByAirportName(airportName);
    }
}