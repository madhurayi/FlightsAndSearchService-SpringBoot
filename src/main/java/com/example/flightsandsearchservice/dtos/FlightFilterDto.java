package com.example.flightsandsearchservice.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightFilterDto {

        private long departureAirportId;
        private long arrivalAirportId;

        private int maxPrice;
        private int minPrice;
}
