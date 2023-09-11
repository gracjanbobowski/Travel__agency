package com.example.travel_agency.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airportId;

    @NotEmpty
    private String airportName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Airport() {
    }

    public Airport(String airportName, Country country, City city) {
        this.airportName = airportName;
        this.country = country;
        this.city = city;
    }

    public String getCountryName() {
        if (country != null) {
            return country.getCountryName();
        } else {
            return null; // lub zwróć odpowiednią wartość, gdy country jest null
        }
    }

    public String getCityName() {
        if (city != null) {
            return city.getCityName();
        } else {
            return null; // lub zwróć odpowiednią wartość, gdy city jest null
        }
    }
}
