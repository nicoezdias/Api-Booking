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

    //Constructor for test1
    public ImageDto(String title, String url, String text_alt, Boolean profile) {
        this.title = title;
        this.url = url;
        this.textAlt = text_alt;
        this.profile = profile;
    }
    //Constructor for test2
    public ImageDto(String title, String url, String textAlt, Boolean profile, Product product) {
        this.title = title;
        this.url = url;
        this.textAlt = textAlt;
        this.profile = profile;
        this.product = product;
    }

    //Default
    public ImageDto() {
    }
}
