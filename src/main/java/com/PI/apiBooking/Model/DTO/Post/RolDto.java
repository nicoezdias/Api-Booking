package com.PI.apiBooking.Model.DTO.Post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RolDto {
    private Long id;
    private String name;


    //Default
    public RolDto() {}
}
