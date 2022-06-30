package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class BookingUserDto {

    private Long id;
    private String reservationTime;
    private LocalDate arrival;
    private LocalDate departure;

    private String categoryName;
    private String productName;
    private Integer productStars;
    private String productCityName;
    private String productDirection;

    //Default
    public BookingUserDto() {
    }
}
