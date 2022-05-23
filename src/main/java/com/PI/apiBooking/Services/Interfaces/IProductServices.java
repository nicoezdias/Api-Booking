package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Services.ICheckId;
import com.PI.apiBooking.Services.IServices;
import java.util.Set;

public interface IProductServices extends IServices<ProductDto>, ICheckId<Product> {

    Long countByCategory(String c);
    Set<ProductDto> findByCategory(Long categoryId);

    //Set<ProductDto> findByCategory(String c);
}
