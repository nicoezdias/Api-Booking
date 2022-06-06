package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.DTO.Product_CompleteDto;
import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IProductService extends IService<ProductDto>, ICheckId<Product> {

    Set<ProductDto> findByCategoryId(Long categoryId);
    Set<ProductDto> findByCityId(Long cityId);
    Set<Product_CardDto> findAllCard();
    Product_CompleteDto findByIdComplete(Long id) throws ResourceNotFoundException;
}
