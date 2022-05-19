package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Caracteristica;
import com.PI.apiBooking.Model.Categoria;
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
