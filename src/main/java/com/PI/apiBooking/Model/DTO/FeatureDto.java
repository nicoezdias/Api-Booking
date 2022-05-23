package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class FeatureDto {
    private Long id;
    private String name;
    private String icon;

    //Constructor for test
    public FeatureDto(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    //Default
    public FeatureDto() {
    }
}
