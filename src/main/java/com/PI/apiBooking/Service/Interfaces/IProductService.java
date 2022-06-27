package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Date_DisabledDto;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.DTO.Product_BookingDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.DTO.Product_CompleteDto;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IProductService extends IService<ProductDto>, ICheckId<Product> {

    Set<Product_CardDto> findAll(Long UserId);
    Product_CompleteDto findById(Long id, Long userId) throws ResourceNotFoundException;
    Set<Product_CardDto> findByCategoryId(Long categoryId, Long userId);
    Set<Product_CardDto> findByCityId(Long cityId, Long userId);
    Set<Product_CardDto> findByDateAndCityId(Long cityId, Long userId, String arrival, String departure);
    ProductDto findForEdit(Long id) throws ResourceNotFoundException;
    Product_BookingDto findForBooking(Long productId, Long userId) throws ResourceNotFoundException;
    Set<Date_DisabledDto>findBookings(Long id) throws ResourceNotFoundException;;
}
