package com.PI.apiBooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
@JsonIgnoreProperties({"products"})
public class City {
    @Id
    @SequenceGenerator(name = "citySequence",sequenceName = "citySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySequence")
    private Long id;
    private String name;
    private String name_country;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Product> products;

    //Default
    public City() {
    }
}
