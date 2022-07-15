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
public class Policy {

    @Id
    @SequenceGenerator(name = "policySequence",sequenceName = "policySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "policySequence")
    private Long id;
    private String type;
    @Lob
    private String description;
    @ManyToMany(mappedBy = "policies")
    private Set<Product> products;

    //Default
    public Policy() {
    }
}
