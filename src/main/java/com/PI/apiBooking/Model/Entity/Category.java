package com.PI.apiBooking.Model.Entity;

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
public class Category {
    @Id
    @SequenceGenerator(name = "categorySequence",sequenceName = "categorySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
    private Long id;
    @Column(nullable = false, length = 20)
    private String title;
    @Lob
    private String description;
    @Lob
    private String urlImage;
    private String textAlt;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    //Default
    public Category() {}
}
