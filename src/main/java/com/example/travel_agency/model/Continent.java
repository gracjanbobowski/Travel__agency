package com.example.travel_agency.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int continentId;

    private String continentName;


    public Continent(int continentId, String continentName) {
        this.continentId = continentId;
        this.continentName = continentName;
    }

    public Continent() {
    }
}
