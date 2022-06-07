package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Feature;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private Integer avgRanting;
    private ImageProductDto imageProfile;

    //Default
    public Product_CardDto() {}
}
