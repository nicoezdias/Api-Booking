package com.PI.apiBooking.Model.User;

import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Model.Entity.City;
import com.PI.apiBooking.Model.Entity.Like;
import com.PI.apiBooking.Model.Entity.Rating;
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
@JsonIgnoreProperties({"ratings","likes","bookings"})
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
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol" )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rol;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Like> likes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<Booking> bookings;
}
