package com.example.travel_agency.service;


import com.example.travel_agency.model.Country;
import com.example.travel_agency.respositories.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void removeCountry(Long id) {
        countryRepository.deleteById(id);
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }
}
