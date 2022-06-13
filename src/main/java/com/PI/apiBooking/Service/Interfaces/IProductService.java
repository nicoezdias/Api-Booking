package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.DTO.Product_CompleteDto;
import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IProductService extends IService<ProductDto>, ICheckId<Product> {

    Set<Product_CardDto> findAll();
    Product_CompleteDto findById(Long id) throws ResourceNotFoundException;
    Set<Product_CardDto> findByCategoryId(Long categoryId);
    Set<Product_CardDto> findByCityId(Long cityId);
    Set<Product_CardDto> findByDateAndCityId(String arrival, String departure, int id);
}
