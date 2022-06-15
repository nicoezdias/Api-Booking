package com.PI.apiBooking.Model.User;

import com.PI.apiBooking.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
@JsonIgnoreProperties({"users"})
public class Rol {

    @Id
    @SequenceGenerator(name = "rolSequence",sequenceName = "rolSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolSequence")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "city")
    private Set<User> users;
}
