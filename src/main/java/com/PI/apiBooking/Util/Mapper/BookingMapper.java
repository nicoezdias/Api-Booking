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
            @Mapping(target = "categoryName", source="booking.product.category.title"),
            @Mapping(target = "productName", source="booking.product.name"),
            @Mapping(target = "productStars", source="booking.product.stars"),
            @Mapping(target = "productCityName", expression="java(booking.getProduct().getCity().getName() + \", \" + booking.getProduct().getCity().getProvince().getName() + \", \" + booking.getProduct().getCity().getProvince().getCountry().getName())"),
            @Mapping(target = "productDirection", source="booking.product.direction"),
            @Mapping(target = "imageProfile", expression="java(imageService.findProfileImageByProductId(booking.getProduct().getId()))")
    })
    public abstract BookingUserDto toBookingUserDto(Booking booking);

    public abstract List<BookingUserDto> toBookingUserDtoSet(List<Booking> products);
}
