package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;

import javax.mail.MessagingException;

public interface IService<T>{

    T save(T t);
    void delete(Long id) throws ResourceNotFoundException;
}
