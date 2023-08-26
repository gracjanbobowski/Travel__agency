package com.example.travel_agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    private int tripDays;
    @NotEmpty
    private int kidPrice;
    @NotEmpty
    private int adultPrice;
    @NotEmpty
    private boolean tripPromote;
    @NotEmpty
    private int kidsPlaces;
    @NotEmpty
    private int AdultPlaces;



}
