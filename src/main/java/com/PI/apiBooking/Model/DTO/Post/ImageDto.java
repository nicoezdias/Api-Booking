package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Entity.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ImageDto {

    private Long id;
    private String title;
    private String url;
    private String textAlt;
    private Boolean profile;
    private Product product;

    //Constructor for test
    public ImageDto(String title, String url, String text_alt, Boolean profile, Product product) {
        this.title = title;
        this.url = url;
        this.textAlt = text_alt;
        this.profile = profile;
        this.product = product;
    }

    //Default
    public ImageDto() {
    }
}
