package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.BadRequestException;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.AuthenticationRequest;
import com.PI.apiBooking.Model.DTO.Post.UserDto;
import com.PI.apiBooking.Model.DTO.User_BookingDto;
import com.PI.apiBooking.Model.DTO.User_CardDto;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IUserService extends IService<UserDto>, ICheckId<User> {
    User findByEmail(String email);
    User_BookingDto findById(Long id) throws ResourceNotFoundException;
    User_CardDto authenticate(AuthenticationRequest authenticationRequest) throws BadRequestException;
}
