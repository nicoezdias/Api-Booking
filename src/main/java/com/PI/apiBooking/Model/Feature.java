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
@JsonIgnoreProperties({"products_features"})
public class Feature {
    @Id
    @SequenceGenerator(name = "featureSequence",sequenceName = "featureSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "featureSequence")
    private Long id;
    @Column(unique = true, length = 50)
    private String name;
    private String icon;

    @OneToMany(mappedBy = "feature", cascade = CascadeType.REMOVE)
    private Set<Product_Feature> products_features;

    //Default
    public Feature() {
    }
}
