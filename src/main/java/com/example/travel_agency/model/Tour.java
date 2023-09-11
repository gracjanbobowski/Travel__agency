package com.example.travel_agency.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor // Dodano konstruktor bezargumentowy za pomocą Lombo
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourId;
    private String tourName;
    private String tourDescription;
    private double tourPrice;
    private int tourDuration;
    private String tourType;

    public Tour(String tourName, String tourDescription, double tourPrice, int tourDuration, String tourType) {
        this.tourName = tourName;
        this.tourDescription = tourDescription;
        this.tourPrice = tourPrice;
        this.tourDuration = tourDuration;
        this.tourType = tourType;
    }

    // Pozostałe gettery i settery
}
