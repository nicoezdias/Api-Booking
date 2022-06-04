package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Product_FeatureDto {

    private Long id;
    private Product product;
    private Feature feature;

    //Constructor for test
    public Product_FeatureDto(Product product, Feature feature) {
        this.product = product;
        this.feature = feature;
    }

    //Default
    public Product_FeatureDto() {}
}
