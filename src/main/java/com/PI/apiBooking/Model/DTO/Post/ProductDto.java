package com.PI.apiBooking.Model.DTO.Post;

<<<<<<< HEAD:src/main/java/com/PI/apiBooking/Model/DTO/Post/ProductDto.java
import com.PI.apiBooking.Model.*;
import com.PI.apiBooking.Model.Feature;
=======
import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.City;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Policy;
>>>>>>> back-dami:src/main/java/com/PI/apiBooking/Model/DTO/ProductDto.java
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
    private Set<Feature> features;
    private City city;
    private Set<Policy> policies;
<<<<<<< HEAD:src/main/java/com/PI/apiBooking/Model/DTO/Post/ProductDto.java
=======

    private Double latitude;
    private Double longitude;
>>>>>>> back-dami:src/main/java/com/PI/apiBooking/Model/DTO/ProductDto.java

    //Constructor for test
    public ProductDto(String name, String description, Boolean availability, Integer stars, Category category, City city, Set<Policy> policies) {
        this.name = name;
        this.description = description;
        this.availability = availability;
        this.stars = stars;
        this.category = category;
        this.city = city;
        this.policies = policies;
    }

    //Default
    public ProductDto() {}
}
