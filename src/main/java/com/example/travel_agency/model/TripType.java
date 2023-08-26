package com.example.travel_agency.model;

import jakarta.validation.constraints.NotEmpty;

public enum TripType {

    HB(""), AI("AI"), FB("FB"), BB("BB");
    @NotEmpty
    private final String tripType;

    TripType(String tripType) {
        this.tripType = tripType;
    }
}
