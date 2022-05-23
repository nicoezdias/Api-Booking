package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.DTO.CaracteristicaDto;
import com.PI.apiBooking.Model.DTO.ProductoDto;
import com.PI.apiBooking.Model.Producto;
import com.PI.apiBooking.Services.IServices;

import java.util.Set;

public interface ICaracteristicaServices extends IServices<CaracteristicaDto> {

    Set<ProductoDto> buscarPorCaracteristica(String c);
}
