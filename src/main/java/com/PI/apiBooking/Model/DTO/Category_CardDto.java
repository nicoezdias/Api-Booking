package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Category_CardDto {
    private Long id;
    private String title;
    private String urlImage;
    private String text_alt;
    private Integer productQuantity = 0;

    //Default
    public Category_CardDto() {
    }
}
