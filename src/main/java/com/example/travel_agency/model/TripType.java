package com.example.travel_agency.model;

public enum TripType {

    HB(""), AI("AI"), FB("FB"), BB("BB");

    private final String tripType;

    TripType(String tripType) {
        this.tripType = tripType;
    }
}
