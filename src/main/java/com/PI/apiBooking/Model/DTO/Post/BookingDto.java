package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Entity.Product;
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
    private User user;

    //Constructor for test
    public BookingDto(String reservationTime, LocalDate arrival, LocalDate departure, Product product, User user) {
        this.reservationTime = reservationTime;
        this.arrival = arrival;
        this.departure = departure;
        this.product = product;
        this.user = user;
    }

    //Default
    public BookingDto() {
    }
}
