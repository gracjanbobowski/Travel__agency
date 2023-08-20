package com.example.travel_agency.respositories;

import com.example.travel_agency.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
