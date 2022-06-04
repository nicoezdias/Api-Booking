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

    //Constructor for test
    public PolicyDto(Integer checkOut, Boolean parties, Boolean smoke, Boolean pets, Boolean parking, Boolean coronaVirus, Boolean smokeDetector, Boolean safetyBox, Boolean securityDeposit, String cancellationPolicy) {
        this.checkOut = checkOut;
        this.parties = parties;
        this.smoke = smoke;
        this.pets = pets;
        this.parking = parking;
        this.coronaVirus = coronaVirus;
        this.smokeDetector = smokeDetector;
        this.safetyBox = safetyBox;
        this.securityDeposit = securityDeposit;
        this.cancellationPolicy = cancellationPolicy;
    }

    //Default
    public PolicyDto() {
    }
}
