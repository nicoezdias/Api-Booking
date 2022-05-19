package com.PI.apiBooking.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

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
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria category;

    //Constructor default
    public Producto() {
    }
}
