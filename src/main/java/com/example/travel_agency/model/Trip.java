package com.example.travel_agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@Setter
public class Trip {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long tripId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    private int tripDays;

    private int kidPrice;

    private int adultPrice;

    private boolean tripPromote;

    private int kidsPlaces;

    private int AdultPlaces;



}
