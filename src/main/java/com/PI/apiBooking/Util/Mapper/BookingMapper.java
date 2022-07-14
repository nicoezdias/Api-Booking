package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.BookingUserDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Service.Impl.ImageService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class BookingMapper {
    @Autowired
    protected ImageService imageService;

    public abstract Booking toBooking(BookingDto bookingDto);

    @Mappings({
            @Mapping(target = "categoryName", expression="java(booking.getProduct().getCategory().getTitle())"),
            @Mapping(target = "productName", expression="java(booking.getProduct().getName())"),
            @Mapping(target = "productStars", expression="java(booking.getProduct().getStars())"),
            @Mapping(target = "productCityName", expression="java(booking.getProduct().getCity().getName() + \", \" + booking.getProduct().getCity().getProvince().getName() + \", \" + booking.getProduct().getCity().getProvince().getCountry().getName())"),
            @Mapping(target = "productDirection", expression="java(booking.getProduct().getDirection())"),
            @Mapping(target = "imageProfile", expression="java(imageService.findProfileImageByProductId(booking.getProduct().getId()))")
    })
    public abstract BookingUserDto toBookingUserDto(Booking booking);

    public abstract List<BookingUserDto> toBookingUserDtoSet(List<Booking> products);
}
