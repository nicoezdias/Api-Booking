package com.PI.apiBooking.Model.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
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
    @Enumerated(EnumType.STRING)
    private UserRoles name;
    @OneToMany(mappedBy = "rol")
    @ToString.Exclude
    private Set<User> users;
}
