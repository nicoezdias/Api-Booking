package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.City;
import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Model.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@ToString
@Getter
@Setter
public class Product_CardDto {
    private Long id;
    private String name;
    private String description;
    private Integer stars;
    private String categoryName;
    private Optional<Integer> avgRanting;
    private ImageProductDto imageProfile;

    //Constructor for test
    public Product_CardDto(String name, String description, Integer stars, String categoryName, Optional<Integer> avgRanting, ImageProductDto imageProfile) {
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.categoryName = categoryName;
        this.avgRanting = avgRanting;
        this.imageProfile = imageProfile;
    }

    //Default
    public Product_CardDto() {}
}
