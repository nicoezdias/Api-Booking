package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.*;
import com.PI.apiBooking.Model.Policy;
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
    private String titleDescription;
    private String description;
    private Integer stars;
    private String direction;
    private Double latitude;
    private Double longitude;
    private String checkInMin;
    private String checkInMax;
    private Category category;
    private Set<Feature> features;
    private City city;
    private Set<Policy> policies;

    //Constructor for test
    public ProductDto(String name, String description, Boolean availability, Integer stars, Category category, City city, Set<Policy> policies) {
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.category = category;
        this.city = city;
        this.policies = policies;
    }

    //Default
    public ProductDto() {}
}
