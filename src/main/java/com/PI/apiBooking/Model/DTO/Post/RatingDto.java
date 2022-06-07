package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class RatingDto {

    private Long id;
    private Integer score;
    private Product product;

    //Constructor for test
    public RatingDto(Integer score, Product product) {
        this.score = score;
        this.product = product;
    }

    //Default
    public RatingDto() {}
}
