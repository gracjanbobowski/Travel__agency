package com.example.travel_agency.service;


import com.example.travel_agency.model.Hotel;
import com.example.travel_agency.model.Trip;
import com.example.travel_agency.respositories.TripRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    Trip trip;

    TripRepository tripRepository;

    @Transactional
    public void addTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public  void removeTrip(Trip trip) { tripRepository.delete(trip);}

    public Trip getHotelById(long id) {
        return tripRepository.findById(id).get();
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }
}
