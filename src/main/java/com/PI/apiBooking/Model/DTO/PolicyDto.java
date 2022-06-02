package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PolicyDto {

    private Long id;
    private Integer checkOut;
    private Boolean parties;
    private Boolean smoke;
    private Boolean pets;
    private Boolean parking;
    private Boolean coronaVirus;
    private Boolean smokeDetector;
    private Boolean safetyBox;
    private Boolean securityDeposit;
    private String cancellationPolicy;
}
