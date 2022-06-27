package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User_BookingDto {

    private Long id;
    private String name;
    private String surname;
    private String cityName;
    private String email;
}
