package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.City;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class User_CardDto {
    private Long id;
    private String name;
    private String surname;
    private City city;
    private String jwt;

    //Default
    public User_CardDto() {}
}
