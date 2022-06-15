package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Province;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CityDto {

    private Long id;
    private String name;
    private Province province;
    private Double latitude;
    private Double longitude;

    //Constructor for test
    public CityDto(String name, String name_country) {
        this.name = name;
    }

    //Default
    public CityDto() {
    }
}
