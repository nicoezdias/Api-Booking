package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String title;
    private String description;
    private String urlImage;
    private String text_alt;

    //Constructor for test
    public CategoryDto(String title, String description, String urlImage) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
    }

    //Default
    public CategoryDto() {
    }

}