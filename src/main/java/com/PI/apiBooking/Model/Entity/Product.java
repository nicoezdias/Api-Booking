package com.PI.apiBooking.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table
@JsonIgnoreProperties({"images", "ratings", "likes", "bookings"})
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
    private String direction;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_features",
            joinColumns = @JoinColumn(name = "product_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="feature_id", nullable = false)
    )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Feature> features;

    @ManyToMany(fetch = FetchType.EAGER)
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private Set<Rating> ratings;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private Set<Favourite> likes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private Set<Image> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private Set<Booking> bookings;

    //Default
    public Product() {
    }
}
