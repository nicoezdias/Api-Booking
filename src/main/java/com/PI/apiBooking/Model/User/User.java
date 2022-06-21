package com.PI.apiBooking.Model.User;

import com.PI.apiBooking.Model.Booking;
import com.PI.apiBooking.Model.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
@JsonIgnoreProperties({"bookings"})
public class User{

    @Id
    @SequenceGenerator(name = "userSequence",sequenceName = "userSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;

    @ManyToOne
    @JoinColumn(name = "id_rol" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rol;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Booking> bookings;
}
