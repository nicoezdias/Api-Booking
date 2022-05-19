package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Producto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
public class CategoriaDto {
    private Long id;
    private String title;
    private String description;
    private String urlImage;

    //Constructor para los test
    public CategoriaDto(String title, String description, String urlImage) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
    }

    //Constructor default
    public CategoriaDto() {
    }

}