package com.example.travel_agency.model;

import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Airport(Long airportId, String airportName, Country country, City city) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.country = country;
        this.city = city;
    }

    public Airport() {
    }
}
