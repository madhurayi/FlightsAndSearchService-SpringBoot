package com.example.flightsandsearchservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Flight extends BaseModel{

    @Column(nullable = false,unique = true)
    private String flightNumber;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(nullable = false,name="airplane_id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(nullable = false,name="departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(nullable = false,name="arrival_airport_id")
    private Airport arrivalAirport;

    @Column(nullable = false)
    private Date departureTime;

    @Column(nullable = false)
    private Date arrivalTime;

    private String boardingGate;

    @Column(nullable = false)
    private int totalSeats;

}
