package com.example.travel_agency.respositories;

import com.example.travel_agency.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
