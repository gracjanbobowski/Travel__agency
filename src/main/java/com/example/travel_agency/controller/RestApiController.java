package com.example.travel_agency.controller;

import com.example.travel_agency.service.*;
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
}
