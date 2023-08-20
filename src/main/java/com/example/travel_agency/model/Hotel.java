package com.example.travel_agency.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Hotel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String hotelName;

    private int hotelStars;

    private String hotelDescription;

    public Hotel(Long hotelId, String hotelName, int hotelStars, String hotelDescription) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelDescription = hotelDescription;
    }

    public Hotel() {
    }
}
