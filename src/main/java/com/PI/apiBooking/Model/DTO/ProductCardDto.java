package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;
import java.util.Set;

@ToString
@Getter
@Setter
public class ProductCardDto {

    private Long id;
    private String name;
    private String description;
    private Integer stars;
    private String categoryName;
    private Optional<Integer> avgRanting;
    private String cityName;
    private Double distance;
    private ImageProductDto imageProfile;
    private Set<String> FeaturesIcons;
    private Double longitude;
    private Double latitude;
    private Boolean like = false;

    //Default
    public ProductCardDto() {}
}
