package com.example.travel_agency.controller;

import com.example.travel_agency.model.Continent;
import com.example.travel_agency.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    AirportService airportService;
    CityService cityService;
    ContinentService continentService;
    CountryService countryService;
    HotelService hotelService;
    PurchaseOfTripService purchaseOfTripService;
    TripService tripService;

    public RestApiController(AirportService airportService, CityService cityService, ContinentService continentService, CountryService countryService, HotelService hotelService, PurchaseOfTripService purchaseOfTripService, TripService tripService) {
        this.airportService = airportService;
        this.cityService = cityService;
        this.continentService = continentService;
        this.countryService = countryService;
        this.hotelService = hotelService;
        this.purchaseOfTripService = purchaseOfTripService;
        this.tripService = tripService;
    }

//    @PostMapping("/continents")
//    public ResponseEntity<Continent> createContinent(@Valid @RequestBody Continent continent) {
//        ContinentService.addContinent(continent)
//        return new ResponseEntity<>(continent, HttpStatus.CREATED);
//    }



}
