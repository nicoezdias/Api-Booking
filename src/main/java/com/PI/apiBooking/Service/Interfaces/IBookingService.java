package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;


public interface IBookingService extends IService<BookingDto>, ICheckId<Booking> {

    Set<BookingDto> findBookingByProductId(Long productId);
    Set<BookingDto> findBookingByUserId(Long userId);
}
