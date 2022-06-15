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
@JsonIgnoreProperties({"products"})
public class City {
    @Id
    @SequenceGenerator(name = "citySequence",sequenceName = "citySequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySequence")
    private Long id;
    @Column(length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Province province;

    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "city")
    private Set<Product> products;

    //Default
    public City() {
    }
}
