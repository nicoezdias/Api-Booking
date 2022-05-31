package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;
import java.util.Set;

@ToString
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Boolean availability;
    private Policy policy;
    private Category category;
    private Set<Feature> features;
    private City city;
    //private Set<Image> images;

    //Constructor for test
    public ProductDto(String name, String description, Category category, City city) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.city = city;
    }

    //Default
    public ProductDto() {
    }
}
