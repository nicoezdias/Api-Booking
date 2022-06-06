package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface ICategoryService extends IService<CategoryDto>, ICheckId<Category> {


}
