package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Entity.City;
import com.PI.apiBooking.Model.User.Rol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private City city;
    private Rol rol;


    //Default
    public UserDto() {}
}