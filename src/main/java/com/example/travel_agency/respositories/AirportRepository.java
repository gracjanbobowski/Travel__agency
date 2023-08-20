package com.example.travel_agency.respositories;
import com.example.travel_agency.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
