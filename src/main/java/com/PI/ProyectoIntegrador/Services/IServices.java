package com.PI.ProyectoIntegrador.Services;

import com.PI.ProyectoIntegrador.Exceptions.ResourceNotFoundException;
import com.PI.ProyectoIntegrador.Model.DTO.CategoriaDto;

import java.util.Set;

public interface IServices<T>{

    Set<T> buscarTodas();
    T buscar(Long id) throws ResourceNotFoundException;
    T guardar(T t);
    void eliminar(Long id) throws ResourceNotFoundException;;
    T actualizar(T t);
}
