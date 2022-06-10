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
@JsonIgnoreProperties({"images", "products_features", "ratings", "bookings"})
public class Product {
    @Id
    @SequenceGenerator(name = "productSequence",sequenceName = "productSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSequence")
    private Long id;
    @Column(nullable = false)
    private String name;
    private String titleDescription;
    @Lob
    private String description;
    private Integer stars;
    @Column(nullable = false)
    private Double latitude;
    @Column(nullable = false)
    private Double longitude;
    @Column(nullable = false)
    private String checkInMin;
    @Column(nullable = false)
    private String checkInMax;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "product_features",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="feature_id", nullable = false)
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Feature> features;

    @ManyToMany
    @JoinTable(
            name = "product_policies",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="policy_id", nullable = false)
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Policy> policies;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private City city;

<<<<<<< HEAD
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Image> images;
=======
    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Image> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    private Set<Booking> bookings;
>>>>>>> back-dami

    //Default
    public Product() {
    }
}
