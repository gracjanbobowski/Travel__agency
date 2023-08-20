package com.example.travel_agency.service;


import com.example.travel_agency.model.Country;
import com.example.travel_agency.respositories.CountryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    CountryRepository countryRepository;

    Country country;

    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public  void removeCountry(Country country) { countryRepository.delete(country);}

    public Country getOwnerById(long id) {
        return countryRepository.findById(id).get();
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }



}
