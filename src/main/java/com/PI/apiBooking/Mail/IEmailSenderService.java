package com.PI.apiBooking.Mail;

import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.DTO.Post.UserDto;

import javax.mail.MessagingException;

public interface IEmailSenderService {
    void sendMailUser(UserDto user) throws MessagingException;
    void sendMailBooking(BookingDto bookingDto) throws MessagingException;
}
