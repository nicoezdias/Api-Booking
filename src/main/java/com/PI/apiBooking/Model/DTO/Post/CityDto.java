package com.PI.apiBooking.Model.DTO.Post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CityDto {

    private Long id;
    private String name;
    private String name_province;
    private String name_country;
    private Double latitude;
    private Double longitude;

    //Constructor for test
    public CityDto(String name, String name_country) {
        this.name = name;
        this.name_country = name_country;
    }

    //Default
    public CityDto() {
    }
}