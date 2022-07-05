package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.UserBookingDto;
import com.PI.apiBooking.Model.DTO.UserCardDto;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IUserService extends IService<UserDto>, ICheckId<User> {
    UserDto findByEmail(String email);
    UserBookingDto findById(Long id) throws ResourceNotFoundException;
    UserDto updateCity(UserDto userDto) throws ResourceNotFoundException;
    UserCardDto validate(AuthenticationRequest authenticationRequest, UserDto userdto) throws BadRequestException;
    UserCardDto authenticate(AuthenticationRequest authenticationRequest) throws BadRequestException;
}
