package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Province;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class City_ListDto {

    private Long id;
    private String name;
    private String nameCountry;
}
