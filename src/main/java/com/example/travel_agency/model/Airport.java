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
public class Airport {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long airportId;

    private String airportName;

    public Airport(Long airportId, String airportName) {
        this.airportId = airportId;
        this.airportName = airportName;
    }

    public Airport() {
    }
}
