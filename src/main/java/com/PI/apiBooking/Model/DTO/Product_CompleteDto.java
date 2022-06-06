package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;
import java.util.Set;

@ToString
@Getter
@Setter
public class Product_CompleteDto {

    private Long id;
    private String name;
    private String description;
    private Integer stars;
    private String categoryName;
    private Optional<Integer> avgRanting;
    private Set<ImageProductDto> imagesProduct;
    private Set<FeatureDto> featuresProduct;
    private Set<PolicyDto> policiesProduct;

    //Constructor for test
    public Product_CompleteDto(String name, String description, Integer stars, String categoryName, Optional<Integer> avgRanting, Set<ImageProductDto> imagesProduct, Set<FeatureDto> featuresProduct, Set<PolicyDto> policiesProduct) {
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.categoryName = categoryName;
        this.avgRanting = avgRanting;
        this.imagesProduct = imagesProduct;
        this.featuresProduct = featuresProduct;
        this.policiesProduct = policiesProduct;
    }

    //Default
    public Product_CompleteDto() {
    }
}
