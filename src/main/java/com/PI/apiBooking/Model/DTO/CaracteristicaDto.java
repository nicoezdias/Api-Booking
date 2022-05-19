package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CaracteristicaDto {
    private Long id;
    private String name;
    private String icon;

    //Constructor para los test
    public CaracteristicaDto(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    //Constructor default
    public CaracteristicaDto() {
    }
}
