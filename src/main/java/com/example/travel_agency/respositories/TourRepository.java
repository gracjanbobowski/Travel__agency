package com.example.travel_agency.respositories;

import com.example.travel_agency.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
    // Tutaj możesz zdefiniować niestandardowe metody dostępu do bazy danych, jeśli są potrzebne
}
