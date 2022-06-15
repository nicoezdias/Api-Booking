package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Image_ProductDto {

    private Long id;
    private String title;
    private String url;
    private String text_alt;

    //Default
    public Image_ProductDto() {
    }
}
