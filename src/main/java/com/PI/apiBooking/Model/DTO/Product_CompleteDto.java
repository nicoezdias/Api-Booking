package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Entity.Feature;
import com.PI.apiBooking.Model.Entity.Policy;
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
    private String titleDescription;
    private String description;
    private Integer stars;
    private String categoryName;
    private Set<Image_ProductDto> imagesProduct;
    private Set<Feature> features;
    private Set<Policy> policies;
    private String cityName;
    private Double distance;
    private Optional<Integer> avgRanting;
    private Set<Date_DisabledDto> disabled;
    private Boolean like = false;

    //Default
    public Product_CompleteDto() {
    }
}
