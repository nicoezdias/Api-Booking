package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Model.User.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class FavouriteDto {

    private Long id;
    private Product product;
    private User user;

    //Constructor for test
    public FavouriteDto(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    //Default
    public FavouriteDto() {
    }
}
