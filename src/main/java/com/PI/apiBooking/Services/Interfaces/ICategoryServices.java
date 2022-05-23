package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Services.ICheckId;
import com.PI.apiBooking.Services.IServices;

public interface ICategoryServices extends IServices<CategoryDto>, ICheckId<Category> {}
