package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
public class Product_CompleteDto {

    private Long id;
    private String name;
    private String titleDescription;
    private String description;
    private Integer stars;
    private String categoryName;
<<<<<<< HEAD
    private Integer avgRanting;
    private Set<ImageProductDto> imagesProduct;
    private Set<Feature> features;
    private Set<Policy> policies;
=======
    private String cityName;
    private Double distance;
    private Optional<Integer> avgRanting;
    private Set<ImageProductDto> imagesProduct;
    private Set<Feature> features;
    private Set<Policy> policies;

>>>>>>> back-dami

    //Default
    public Product_CompleteDto() {
    }
}
