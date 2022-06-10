package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Feature;
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
    private String categoryName;
    private Integer stars;
    private String name;
    private Optional<Integer> avgRanting;
    private Double distance;
    private String description;
    private Set<String> featuresIcons;
    private ImageProductDto imageProfile;

    //Default
    public Product_CardDto() {}
}
