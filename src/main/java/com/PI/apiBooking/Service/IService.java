package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IService<T>{

    T save(T t);
    void delete(Long id) throws ResourceNotFoundException;
}
