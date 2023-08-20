package com.example.travel_agency.respositories;

import com.example.travel_agency.model.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepository extends JpaRepository<Continent, Long> {
}
