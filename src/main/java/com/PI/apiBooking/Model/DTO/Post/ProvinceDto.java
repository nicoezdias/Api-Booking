package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Country;
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
}
