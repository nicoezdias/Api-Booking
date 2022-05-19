package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Categoria;
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
    private Categoria category;

    //Constructor para los test
    public ProductoDto(String name, String description, Categoria category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    //Constructor default
    public ProductoDto() {
    }
}
