package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CityDto {

    private Long id;
    private String name;
    private String name_country;

    //Constructor for test
    public CityDto(String name, String name_country) {
        this.name = name;
        this.name_country = name_country;
    }

    //Default
    public CityDto() {
    }
}
