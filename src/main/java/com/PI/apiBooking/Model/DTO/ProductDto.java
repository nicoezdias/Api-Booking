package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.*;
//import com.PI.apiBooking.Model.Policy;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Boolean availability;
    private Integer stars;
    private Category category;
    private City city;
    private Policy policy;

    //Constructor for test
    public ProductDto(String name, String description, Boolean availability, Integer stars, Category category, City city, Policy policy) {
        this.name = name;
        this.description = description;
        this.availability = availability;
        this.stars = stars;
        this.category = category;
        this.city = city;
        this.policy = policy;
    }

    //Default
    public ProductDto() {}
}
