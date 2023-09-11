package com.example.travel_agency.service;

import com.example.travel_agency.model.Tour;
import com.example.travel_agency.respositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Tour updateTour(Long tourId, String tourName, String tourDescription, double tourPrice, int tourDuration, String tourType) {
        Optional<Tour> tourOptional = tourRepository.findById(tourId);
        if (tourOptional.isPresent()) {
            Tour tour = tourOptional.get();
            tour.setTourName(tourName);
            tour.setTourDescription(tourDescription);
            tour.setTourPrice(tourPrice);
            tour.setTourDuration(tourDuration);
            tour.setTourType(tourType);
            return tourRepository.save(tour);
        } else {
            throw new RuntimeException("Wycieczka o podanym ID nie istnieje.");
        }
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Optional<Tour> getTourById(Long tourId) {
        return tourRepository.findById(tourId);
    }

    public void saveTour(Tour tour) {
        tourRepository.save(tour);
    }

    public void deleteTour(Long tourId) {
        tourRepository.deleteById(tourId);
    }
}
