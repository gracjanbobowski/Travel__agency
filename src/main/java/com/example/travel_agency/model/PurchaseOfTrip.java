package com.example.travel_agency.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@ToString
public class PurchaseOfTrip {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long purchaseOfTripId;
    @NotEmpty
    private int price;






}
