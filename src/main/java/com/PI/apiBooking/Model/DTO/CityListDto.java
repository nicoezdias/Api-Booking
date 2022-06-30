package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CityListDto {

    private Long id;
    private String name;
    private String nameCountry;

    //Default
    public CityListDto() {
    }
}
