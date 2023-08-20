package com.example.travel_agency.respositories;

import com.example.travel_agency.model.TripType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripTypeRepository extends JpaRepository<TripType, Long> {
}
