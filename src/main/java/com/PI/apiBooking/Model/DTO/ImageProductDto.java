package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ImageProductDto {

    private Long id;
    private String title;
    private String url;
    private String text_alt;

    //Constructor for test
    public ImageProductDto(String title, String url, String text_alt) {
        this.title = title;
        this.url = url;
        this.text_alt = text_alt;
    }

    //Default
    public ImageProductDto() {
    }
}
