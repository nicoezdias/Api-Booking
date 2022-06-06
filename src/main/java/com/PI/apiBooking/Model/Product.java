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
@JsonIgnoreProperties({"images", "products_features", "ratings"})
public class Product {
    @Id
    @SequenceGenerator(name = "productSequence",sequenceName = "productSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
    private Long id;
    private String name;
    @Lob
    private String description;
    private Boolean availability;
    private Integer stars;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    @JoinColumn(name = "policy_id" , referencedColumnName= "id")
    private Policy policy;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Image> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Product_Feature> products_features;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Rating> ratings;

    //Default
    public Product() {
    }
}
