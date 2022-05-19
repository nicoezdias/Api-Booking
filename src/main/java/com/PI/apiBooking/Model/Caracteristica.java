package com.PI.apiBooking.Model;

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
public class Caracteristica {
    @Id
    @SequenceGenerator(name = "caracteristicaSequence",sequenceName = "caracteristicaSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracteristicaSequence")
    private Long id;
    private String name;
    private String icon;
    @ManyToMany(mappedBy = "features")
    @JsonIgnore
    private Set<Producto> products;

    //Constructor default
    public Caracteristica() {
    }
}
