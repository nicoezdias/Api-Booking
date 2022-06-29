package com.PI.apiBooking.Model.DTO.Post;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AuthenticationRequest {

    private String email;
    private String password;

    //Default
    public AuthenticationRequest() {
    }
}
