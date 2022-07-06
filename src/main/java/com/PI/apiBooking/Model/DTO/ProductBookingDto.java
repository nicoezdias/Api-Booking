package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Entity.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@ToString
@Getter
@Setter
public class ProductBookingDto {

    private String categoryName;
    private String productName;
    private Integer productStars;
    private String productCityName;
    private Set<Policy> productPolicies;
    private String productCheckInMin;
    private String productCheckInMax;

    private String userName;
    private String userSurname;
    private String userEmail;
    private Long userCityId;

    private ImageProductDto productImage;

    private Set<LocalDate> disabled;

    //Default
    public ProductBookingDto() {
    }
}
