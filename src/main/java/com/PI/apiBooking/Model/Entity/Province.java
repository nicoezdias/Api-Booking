package com.PI.apiBooking.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table
public class Province {

    @Id
    @SequenceGenerator(name = "provinceSequence",sequenceName = "provinceSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provinceSequence")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Country country;

    //Default
    public Province() {
    }
}
