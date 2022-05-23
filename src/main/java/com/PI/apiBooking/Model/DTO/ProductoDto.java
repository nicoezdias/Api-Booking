package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Caracteristica;
import com.PI.apiBooking.Model.Categoria;
import com.PI.apiBooking.Model.Ciudad;
import com.PI.apiBooking.Model.Imagen;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
public class ProductoDto {
    private Long id;
    private String name;
    private String description;
    private Categoria category;
    private Set<Caracteristica> features;
    private Ciudad city;
    private Set<Imagen> images;

    //Constructor para los test
    public ProductoDto(String name, String description, Categoria category, Ciudad city) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.city = city;
    }

    //Constructor default
    public ProductoDto() {
    }
}
