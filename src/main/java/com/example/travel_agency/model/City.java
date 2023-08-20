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
public class City {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long CityId;

    private String cityName;

    public City(long cityId, String cityName) {
        CityId = cityId;
        this.cityName = cityName;
    }

    public City() {
    }
}
