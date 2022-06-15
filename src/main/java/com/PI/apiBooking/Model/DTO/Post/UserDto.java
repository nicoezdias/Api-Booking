package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.City;
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

    //Constructor for test
    public UserDto(String name, String surname, String email, String password, City city, Rol rol) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.city = city;
        this.rol = rol;
    }

    //Default
    public UserDto() {}
}