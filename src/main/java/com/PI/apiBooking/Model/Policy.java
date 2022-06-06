package com.PI.apiBooking.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Policy {

    @Id
    @SequenceGenerator(name = "policySequence",sequenceName = "policySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policySequence")
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
    @Lob
    private String cancellationPolicy;

    //Default
    public Policy() {
    }
}
