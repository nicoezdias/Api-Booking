package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Entity.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProvinceDto {

    private Long id;
    private String name;
    private Country country;

    //Constructor for test
    public ProvinceDto(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    //Default
    public ProvinceDto() {
    }
}
