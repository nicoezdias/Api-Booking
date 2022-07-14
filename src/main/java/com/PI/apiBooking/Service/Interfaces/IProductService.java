package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.DTO.ProductBookingDto;
import com.PI.apiBooking.Model.DTO.ProductCardDto;
import com.PI.apiBooking.Model.DTO.ProductCompleteDto;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.time.LocalDate;
import java.util.Set;

public interface IProductService extends IService<ProductDto>, ICheckId<Product> {

    Set<ProductCardDto> findAll(Long UserId);
    ProductCompleteDto findById(Long id, Long userId) throws ResourceNotFoundException;
    Set<ProductCardDto> findByCategoryId(Long categoryId, Long userId);
    Set<ProductCardDto> findByCityId(Long cityId, Long userId);
    Set<ProductCardDto> findByDateAndCityId(Long cityId, Long userId, String arrival, String departure);
    ProductDto findForEdit(Long id) throws ResourceNotFoundException;
    ProductBookingDto findForBooking(Long productId, Long userId) throws ResourceNotFoundException;
}
