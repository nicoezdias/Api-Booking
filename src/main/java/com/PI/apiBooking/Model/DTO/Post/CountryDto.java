package com.PI.apiBooking.Model.DTO.Post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CountryDto {

    private Long id;
    private String name;

    //Constructor for test
    public CountryDto(String name) {
        this.name = name;
    }

    //Default
    public CountryDto() {
    }
}
