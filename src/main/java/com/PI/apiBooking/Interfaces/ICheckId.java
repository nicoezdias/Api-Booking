package com.PI.apiBooking.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;

public interface ICheckId<T>{

    String msjError = "La búsqueda no arrojó resultados con id: ";

    T checkId(Long c) throws ResourceNotFoundException;


}
