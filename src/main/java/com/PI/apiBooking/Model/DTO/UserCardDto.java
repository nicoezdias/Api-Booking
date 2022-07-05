package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserCardDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String rolName;
    private String jwt;

    //Default
    public UserCardDto() {}
}
