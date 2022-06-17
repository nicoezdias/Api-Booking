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
    public CityDto(String name, Province province, Double latitude, Double longitude) {
        this.name = name;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Default
    public CityDto() {
    }
}
