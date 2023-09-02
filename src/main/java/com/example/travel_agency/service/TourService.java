package com.example.travel_agency.service;

import com.example.travel_agency.model.Tour;
import com.example.travel_agency.respositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    private final TourRepository tourRepository;

    @Autowired
    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public void saveTour(String tourName, String tourDescription, double tourPrice, int tourDuration, String tourType) {
        Tour tour = new Tour(tourName, tourDescription, tourPrice, tourDuration, tourType);
        tourRepository.save(tour);
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }
}

