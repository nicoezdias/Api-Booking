package com.PI.apiBooking.Model.DTO;

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

    public RatingDto(Integer score, Product product) {
        this.score = score;
        this.product = product;
    }

    public RatingDto() {
    }
}
