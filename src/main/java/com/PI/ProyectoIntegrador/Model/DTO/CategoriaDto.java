package com.PI.ProyectoIntegrador.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    //Constructor de odontologo default
    public CategoriaDto() {
    }

}