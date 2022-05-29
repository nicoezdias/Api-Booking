package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IServices;

public interface ICategoryServices extends IServices<CategoryDto>, ICheckId<Category> {}
