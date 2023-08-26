package com.example.travel_agency.controller;

import com.example.travel_agency.model.*;
import com.example.travel_agency.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/continents")
    public ResponseEntity<Continent> createContinent(@Valid @RequestBody Continent continent) {
        continentService.addContinent(continent);
        return new ResponseEntity<>(continent, HttpStatus.CREATED);
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> createCountry(@Valid @RequestBody Country country) {
        countryService.addCountry(country);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }

    @PostMapping("/cities")
    public ResponseEntity<City> createCity(@Valid @RequestBody City city) {
        cityService.addCity();
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @PostMapping("/airport")
    public ResponseEntity<Airport>  createAirport(@Valid @RequestBody Airport airport) {
        airportService.addAirport(airport);
        return new ResponseEntity<>(airport, HttpStatus.CREATED);
    }

    @GetMapping("/continent/{id}")
    public ResponseEntity<Continent> getContinent(@PathVariable Long id ) {
        return new ResponseEntity<>(continentService.getContinent(id), HttpStatus.OK);
    }

//    @GetMapping("/country/{id}")
//    public ResponseEntity<Country> getContinent(@PathVariable Long id ) {
//        return new ResponseEntity<>(CountryService.getCountry(id), HttpStatus.OK);
//    }




}
