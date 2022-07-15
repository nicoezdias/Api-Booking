package com.PI.apiBooking.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Feature {
    @Id
    @SequenceGenerator(name = "featureSequence",sequenceName = "featureSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "featureSequence")
    private Long id;
    private String name;
    private String icon;
    @ManyToMany(mappedBy = "features")
    private Set<Product> products;

    //Default
    public Feature() {
    }
}
