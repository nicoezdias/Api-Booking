package com.PI.apiBooking.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Country {

    @Id
    @SequenceGenerator(name = "countrySequence",sequenceName = "countrySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countrySequence")
    private Long id;
    private String name;

    //Default
    public Country() {
    }
}
