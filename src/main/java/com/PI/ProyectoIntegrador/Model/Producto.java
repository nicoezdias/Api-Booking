package com.PI.ProyectoIntegrador.Model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @SequenceGenerator(name = "productoSequence",sequenceName = "productoSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productoSequence")
    private Long id;
    private String name;
    private String description;

    //Constructor default
    public Producto() {
    }
}
