package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserRatingDto {
    private Long id;
    private String name;
    private String surname;

    //Default
    public UserRatingDto() {
    }
}
