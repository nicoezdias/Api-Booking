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
public class Category {
    @Id
    @SequenceGenerator(name = "categorySequence",sequenceName = "categorySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorySequence")
    private Long id;
    @Column(length = 20)
    private String title;
    private String description;
    @Lob
    private String urlImage;
    private String text_alt;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;

    //Default
    public Category() {}
}