package com.example.travel_agency.controller;

import com.example.travel_agency.model.*;
import com.example.travel_agency.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Validated
public class RestApiController {

    private final AirportService airportService;
    private final CityService cityService;
    private final ContinentService continentService;
    private final CountryService countryService;
    private final HotelService hotelService;
    private final TripService tripService;

    @Autowired
    public RestApiController(
            AirportService airportService,
            CityService cityService,
            ContinentService continentService,
            CountryService countryService,
            HotelService hotelService,
            TripService tripService
    ) {
        this.airportService = airportService;
        this.cityService = cityService;
        this.continentService = continentService;
        this.countryService = countryService;
        this.hotelService = hotelService;
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
    public ResponseEntity<City> createCity(@Valid City city) {
        cityService.addCity(city);
        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }

    @PostMapping("/airports")
    public ResponseEntity<Airport> createAirport(
            @Valid @RequestBody Airport airport,
            @RequestParam("countryId") Long countryId,
            @RequestParam("cityId") Long cityId
    ) {
        try {
            airportService.addAirport(airport, countryId, cityId);
            return new ResponseEntity<>(airport, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<Airport> getAirport(@PathVariable Long id) {
        Airport airport = airportService.getAirportById(id);
        if (airport != null) {
            return new ResponseEntity<>(airport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/continent/{id}")
    public ResponseEntity<Continent> getContinent(@PathVariable Long id) {
        Continent continent = continentService.getContinent(id);
        if (continent != null) {
            return new ResponseEntity<>(continent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}