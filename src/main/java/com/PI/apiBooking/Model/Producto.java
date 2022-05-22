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
public class Producto {
    @Id
    @SequenceGenerator(name = "productoSequence",sequenceName = "productoSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productoSequence")
    private Long id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria category;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "productos_caracteristicas",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="feature_id", nullable = false)
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Caracteristica> features;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ciudad city;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Imagen> images;

    //Constructor default
    public Producto() {
    }
}
