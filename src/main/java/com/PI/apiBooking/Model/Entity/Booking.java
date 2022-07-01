package com.PI.apiBooking.Model.Entity;

import com.PI.apiBooking.Model.User.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Booking {

    @Id
    @SequenceGenerator(name = "bookingSequence",sequenceName = "bookingSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingSequence")
    private Long id;
    @Column(nullable = false)
    private String reservationTime;
    @Column(nullable = false)
    private LocalDate arrival;
    @Column(nullable = false)
    private LocalDate departure;
    private Boolean covidVaccine;
    @Lob
    private String additionalInformation;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

    //Default
    public Booking() {
    }
}
