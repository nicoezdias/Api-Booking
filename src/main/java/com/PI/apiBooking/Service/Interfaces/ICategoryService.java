package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoryCardDto;
import com.PI.apiBooking.Model.DTO.CategoryCompleteDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Model.Entity.Category;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface ICategoryService extends IService<CategoryDto>, ICheckId<Category> {

    Set<CategoryCardDto> findAll();
    CategoryCompleteDto findById(Long id) throws ResourceNotFoundException;
}
