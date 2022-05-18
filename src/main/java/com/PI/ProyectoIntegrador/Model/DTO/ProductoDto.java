package com.PI.ProyectoIntegrador.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductoDto {
    private Long id;
    private String name;
    private String description;

    //Constructor para los test
    public ProductoDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Constructor default
    public ProductoDto() {
    }
}
