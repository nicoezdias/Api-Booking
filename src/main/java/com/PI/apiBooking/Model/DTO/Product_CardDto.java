package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Optional;
import java.util.Set;

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
    private Double distance;
    private Image_ProductDto imageProfile;
    private Set<String> FeaturesIcons;


    //Default
    public Product_CardDto() {}
}
