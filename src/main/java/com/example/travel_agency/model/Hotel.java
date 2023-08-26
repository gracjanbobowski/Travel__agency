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
public class Hotel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long hotelId;
    @NotEmpty
    private String hotelName;
    @NotEmpty
    private int hotelStars;
    @NotEmpty
    private String hotelDescription;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    public Hotel(Long hotelId, String hotelName, int hotelStars, String hotelDescription) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelStars = hotelStars;
        this.hotelDescription = hotelDescription;
    }

    public Hotel() {
    }
}
