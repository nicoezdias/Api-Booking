package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Category;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Repository.ICategoryRepository;
import com.PI.apiBooking.Service.Interfaces.ICategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryService implements ICategoryService {
    protected final static Logger logger = Logger.getLogger(CategoryService.class);

    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<CategoryDto> findAll() {
        Set<CategoryDto> categoriesDto = new HashSet<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories
        ) {
            categoriesDto.add(mapper.convertValue(category, CategoryDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ categoriesDto);
        return categoriesDto;
    }

    @Override
    public CategoryDto findById(Long id) throws ResourceNotFoundException {
        Category category = checkId(id);
        CategoryDto categoryDto = mapper.convertValue(category, CategoryDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return categoryDto;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = mapper.convertValue(categoryDto, Category.class);
        categoryRepository.save(category);
        if (categoryDto.getId() == null){
            categoryDto.setId(category.getId());
            logger.info("Categoria registrada correctamente: "+ categoryDto);
        }else{
            logger.info("Categoria actualizada correctamente: "+ categoryDto);
        }

        return categoryDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        categoryRepository.deleteById(id);
        logger.info("Se elimino la Categoria correctamente: id("+id+")");
    }

    @Override
    public Category checkId(Long id) throws ResourceNotFoundException{
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return category.get();
    }
}
