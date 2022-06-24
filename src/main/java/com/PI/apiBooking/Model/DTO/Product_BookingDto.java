package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Model.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
public class Product_BookingDto {

    private String categoryName;
    private String productName;
    private Integer productStars;
    private String productCityName;
    private Set<Policy> productPolicies;
    private String productCheckInMin;
    private String productCheckInMax;
    private Image_ProductDto productImage;

    private String userName;
    private String userSurname;
    private String userEmail;
    private String userCity;

    private Set<Date_DisabledDto> disabled;

}
