package com.PI.apiBooking.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
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
