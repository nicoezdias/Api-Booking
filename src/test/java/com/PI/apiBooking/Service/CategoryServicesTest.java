package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Service.Impl.CategoryService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CategoryServicesTest {

    @Autowired
    private CategoryService categoryService;

    public void logInfo(){
        categoryService.save(new CategoryDto("Hotel","Descripcion1","Url1"));
        categoryService.save(new CategoryDto("Casa","Descripcion2","Url2"));
        categoryService.save(new CategoryDto("Dpto","Descripcion3","Url3"));
    }

    @Test
    public void saveAndFindCategories() throws ResourceNotFoundException {
        CategoryDto c1 = categoryService.save(new CategoryDto("Hotel","Descripcion1","Url1"));
        CategoryDto c2 = categoryService.save(new CategoryDto("Casa","Descripcion2","Url2"));
        CategoryDto c3 = categoryService.save(new CategoryDto("Dpto","Descripcion3","Url3"));
        assertNotNull(categoryService.findById(c1.getId()));
        assertNotNull(categoryService.findById(c2.getId()));
        assertNotNull(categoryService.findById(c3.getId()));
    }

    @Test
    public void findAllCategories() {
        logInfo();
        Set<CategoryDto> categories = categoryService.findAll();
        assertFalse(categories.isEmpty());
        System.out.println(categories);
    }

    @Test
    public void deleteCategory() throws ResourceNotFoundException {
        boolean ex = false;
        CategoryDto c4 = categoryService.save(new CategoryDto("Hostel","Descripcion4","Url4"));
        categoryService.delete(c4.getId());
        try{
            categoryService.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateCategory() throws ResourceNotFoundException {
        CategoryDto c5 = categoryService.save(new CategoryDto("Residencia","Descripcion5","Url5"));
        CategoryDto c6 = new CategoryDto("Residencia","DescripcionCambiada","UrlCambiada");
        c6.setId(c5.getId());

        categoryService.save(c6);
        assertEquals(c6.toString(), categoryService.findById(c6.getId()).toString());
    }
}