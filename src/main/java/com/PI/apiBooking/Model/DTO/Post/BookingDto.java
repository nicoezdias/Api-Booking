package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Model.User.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class BookingDto {
    private Long id;
    private String reservationTime;
    private LocalDate arrival;
    private LocalDate departure;
    private Product product;
    //private User usuario;
}
