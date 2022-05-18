package com.PI.apiBooking.Services;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IServices<T>{

    Set<T> buscarTodas();
    T buscar(Long id) throws ResourceNotFoundException;
    T guardar(T t);
    void eliminar(Long id) throws ResourceNotFoundException;
}
