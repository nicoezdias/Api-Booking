package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PolicyDto {

    private Long id;
    private String policy;

    //Constructor for test
    public PolicyDto(String policy) {
        this.policy = policy;
    }

    //Default
    public PolicyDto() {
    }
}
