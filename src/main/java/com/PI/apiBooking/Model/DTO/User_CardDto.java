package com.PI.apiBooking.Model.DTO;

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
    private String rol_Name;
    private String jwt;

    //Default
    public User_CardDto() {}
}
