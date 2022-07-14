package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.CategoryCardDto;
import com.PI.apiBooking.Model.DTO.CategoryCompleteDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Model.Entity.Category;
import com.PI.apiBooking.Repository.ICategoryRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {
    @Autowired
    protected ICategoryRepository categoryRepository;

    public abstract Category toCategory(CategoryDto categoryDto);

    @Mapping(target = "productQuantity", expression="java(categoryRepository.countByCategory(category.getId()))")
    public abstract CategoryCompleteDto totoCategoryCompleteDto(Category category);

    @Mapping(target = "productQuantity", expression="java(categoryRepository.countByCategory(category.getId()))")
    public abstract CategoryCardDto toCategoryCardDto(Category category);

    public abstract Set<CategoryCardDto> toCategoryCardDtoSet(List<Category> categories);
}
