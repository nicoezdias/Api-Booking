package com.PI.apiBooking.Model.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Rol {

    @Id
    @SequenceGenerator(name = "rolSequence",sequenceName = "rolSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolSequence")
    private Long id;
    private String name;
}
