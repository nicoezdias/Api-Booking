package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;

public interface IService<T>{

    T save(T t);
    void delete(Long id) throws ResourceNotFoundException;
}
