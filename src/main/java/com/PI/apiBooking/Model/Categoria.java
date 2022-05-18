package com.PI.apiBooking.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @SequenceGenerator(name = "categoriaSequence",sequenceName = "categoriaSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoriaSequence")
    private Long id;
    private String title;
    private String description;
    private String urlImage;

    //Constructor default
    public Categoria() {}
}
