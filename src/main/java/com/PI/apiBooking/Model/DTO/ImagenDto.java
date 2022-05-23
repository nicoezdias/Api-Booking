package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Producto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ImagenDto {

    private Long id;
    private String title;
    private String url;
    private String text_alt;
    private Producto product;


    //Constructor para los test
    public ImagenDto(String title, String url, String text_alt, Producto product) {
        this.title = title;
        this.url = url;
        this.text_alt = text_alt;
        this.product = product;
    }
}
