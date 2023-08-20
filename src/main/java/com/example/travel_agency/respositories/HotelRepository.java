package com.example.travel_agency.respositories;

import com.example.travel_agency.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
