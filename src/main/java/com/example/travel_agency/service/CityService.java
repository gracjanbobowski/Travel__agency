package com.example.travel_agency.service;

import com.example.travel_agency.model.City;
import com.example.travel_agency.respositories.CityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {

    City city;

    public CityService(City city) {
        this.city = city;
    }


}
