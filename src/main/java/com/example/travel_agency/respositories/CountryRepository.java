package com.example.travel_agency.respositories;

import com.example.travel_agency.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
