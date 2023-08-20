package com.example.travel_agency.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    private String countryName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_id")
    private Continent continent;

    public Country(Long countryId, String countryName, Continent continent) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.continent = continent;
    }

    public Country() {
    }
}
