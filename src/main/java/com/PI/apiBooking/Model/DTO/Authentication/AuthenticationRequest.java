package com.PI.apiBooking.Model.DTO.Authentication;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class AuthenticationRequest {

    private String email;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String password) {
        this.email = username;
        this.password = password;
    }
}
