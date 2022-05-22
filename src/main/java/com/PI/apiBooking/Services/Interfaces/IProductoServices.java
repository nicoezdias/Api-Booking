package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.DTO.ProductoDto;
import com.PI.apiBooking.Services.IServices;

import java.util.Set;

public interface IProductoServices extends IServices<ProductoDto> {

    Long countByCategory(String c);
    Set<ProductoDto> buscarPorCategoria(String c);
}
