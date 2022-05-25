package com.PI.apiBooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Feature {
    @Id
    @SequenceGenerator(name = "featureSequence",sequenceName = "featureSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "featureSequence")
    private Long id;
    private String name;
    private String icon;
    @ManyToMany(mappedBy = "features")
    @JsonIgnore
    private Set<Product> products;

    //Default
    public Feature() {
    }
}
