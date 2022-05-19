package com.PI.apiBooking.Services;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IServices<T>{

    Set<T> findAll();
    T findById(Long id) throws ResourceNotFoundException;
    T save(T t);
    void delete(Long id) throws ResourceNotFoundException;
}
