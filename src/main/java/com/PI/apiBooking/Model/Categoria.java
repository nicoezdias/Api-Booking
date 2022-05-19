package com.PI.apiBooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table
public class Categoria {
    @Id
    @SequenceGenerator(name = "categoriaSequence",sequenceName = "categoriaSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoriaSequence")
    private Long id;
    private String title;
    private String description;
    private String urlImage;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Producto> products = new HashSet<>();

    //Constructor default
    public Categoria() {}
}
