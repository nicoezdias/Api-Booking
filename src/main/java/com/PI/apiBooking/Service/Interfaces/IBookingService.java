package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.BookingUserDto;
import com.PI.apiBooking.Model.DTO.DateDisabledDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;


public interface IBookingService extends IService<BookingDto>, ICheckId<Booking> {

    Set<DateDisabledDto> findBookingByProductId(Long productId);
    Set<BookingUserDto> findBookingByUserId(Long userId);
}
