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
    private String name;
    private String description;
    private Integer stars;
    private Set<Feature> features;
    private String categoryName;
    private Optional<Integer> avgRanting;
    private Double distance;
    private ImageProductDto imageProfile;

    //Default
    public Product_CardDto() {}
}
