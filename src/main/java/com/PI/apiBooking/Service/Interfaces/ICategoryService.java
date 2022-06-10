package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.DTO.Category_CardDto;
import com.PI.apiBooking.Model.DTO.Category_CompleteDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface ICategoryService extends IService<CategoryDto>, ICheckId<Category> {

    Set<Category_CardDto> findAll();
    Category_CompleteDto findById(Long id) throws ResourceNotFoundException;
}
