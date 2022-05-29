package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Lob;

@ToString
@Getter
@Setter
public class ImageDto {

    private Long id;
    private String title;
    private String url;
    private String text_alt;
    private Product product;

    //Constructor for test
    public ImageDto(String title, String url, String text_alt, Product product) {
        this.title = title;
        this.url = url;
        this.text_alt = text_alt;
        this.product = product;
    }

    //Default
    public ImageDto() {
    }
}