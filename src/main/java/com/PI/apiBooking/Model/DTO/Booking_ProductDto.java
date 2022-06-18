package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class Booking_ProductDto {

    private Long id;
    private String reservationTime;
    private LocalDate arrival;
    private LocalDate departure;

    private String userNameComplete;

}
