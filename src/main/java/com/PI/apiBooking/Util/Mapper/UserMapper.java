package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.UserBookingDto;
import com.PI.apiBooking.Model.DTO.UserCardDto;
import com.PI.apiBooking.Model.DTO.UserRatingDto;
import com.PI.apiBooking.Model.User.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public abstract UserDto toUserDto(User user);

    public abstract User toUser(UserDto userDto);

    @Mapping(target = "rolName", expression="java(user.getRol().getName().name())")
    public abstract UserCardDto toUserCardDto(User user);

    public abstract UserBookingDto toUserBookingDto(User user);

    public abstract UserRatingDto toUserRatingDto(User user);

    public abstract User toRating(UserRatingDto user);
}
