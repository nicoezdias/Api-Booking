package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CategoryCompleteDto {

    private Long id;
    private String title;
    private String description;
    private String urlImage;
    private String textAlt;
    private Integer productQuantity = 0;

    //Default
    public CategoryCompleteDto() {
    }

}
