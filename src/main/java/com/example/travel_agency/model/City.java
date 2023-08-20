package com.example.travel_agency.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class City {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long CityId;

    private String cityName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    public City(long cityId, String cityName) {
        CityId = cityId;
        this.cityName = cityName;
    }

    public City() {
    }
}
