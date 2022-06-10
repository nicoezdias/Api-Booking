package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Feature;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> back-dami
import java.util.Set;

@ToString
@Getter
@Setter
public class Product_CardDto {

    private Long id;
<<<<<<< HEAD
    private String name;
    private String description;
    private Integer stars;
    private Set<Feature> features;
    private String categoryName;
    private Integer avgRanting;
=======
    private String categoryName;
    private Integer stars;
    private String name;
    private Optional<Integer> avgRanting;
    private Double distance;
    private String description;
    private Set<String> featuresIcons;
>>>>>>> back-dami
    private ImageProductDto imageProfile;

    //Default
    public Product_CardDto() {}
}
