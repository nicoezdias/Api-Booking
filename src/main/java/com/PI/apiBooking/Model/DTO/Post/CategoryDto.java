package com.PI.apiBooking.Model.DTO.Post;

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
    private String textAlt;

    //Constructor for test
    public CategoryDto(String title, String description, String urlImage, String text_alt) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
        this.textAlt = text_alt;
    }

    //Default
    public CategoryDto() {
    }

}