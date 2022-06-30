package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.DTO.UserRatingDto;
import com.PI.apiBooking.Model.Entity.Product;
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
    private UserRatingDto user;

    //Constructor for test
    public RatingDto(Integer score, Product product, UserRatingDto user) {
        this.score = score;
        this.product = product;
        this.user = user;
    }

    //Default
    public RatingDto() {}
}
