package com.example.travel_agency.service;


import com.example.travel_agency.model.Country;
import com.example.travel_agency.model.Hotel;
import com.example.travel_agency.respositories.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    Hotel hotel;

    HotelRepository hotelRepository;

    @Transactional
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public  void removeHotel(Hotel hotel) { hotelRepository.delete(hotel);}

    public Hotel getHotelById(long id) {
        return hotelRepository.findById(id).get();
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }


}
