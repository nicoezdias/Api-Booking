package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Entity.Feature;
import com.PI.apiBooking.Model.Entity.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@ToString
@Getter
@Setter
public class ProductCompleteDto {

    private Long id;
    private String name;
    private String titleDescription;
    private String description;
    private Integer stars;
    private String categoryName;
    private Set<ImageProductDto> imagesProduct;
    private Set<Feature> features;
    private Set<Policy> policies;
    private String cityName;
    private Double distance;
    private Optional<Integer> avgRanting;
    private Double longitude;
    private Double latitude;
    private Set<LocalDate> disabled;
    private Boolean like = false;

    //Default
    public ProductCompleteDto() {
    }
}
