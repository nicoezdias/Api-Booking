package com.PI.apiBooking.Model.DTO;

import com.PI.apiBooking.Model.Policy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.util.Set;

@ToString
@Getter
@Setter
public class Booking_ProductDto {

    private String categoryName;
    private String productName;
    private String productStars;
    private String productCityName;
    private Set<Policy> productPolicies;
    private String productCheckInMin;
    private String productCheckInMax;

    private String userName;
    private String userSurname;
    private String userEmail;
    private String userCityName;




}
