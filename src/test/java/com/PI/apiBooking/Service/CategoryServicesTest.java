package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Category_CardDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
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
    private CategoryService categoryServices;

    public void logInfo(){
        categoryServices.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1"));
        categoryServices.save(new CategoryDto("Casa","Descripcion2","Url2", "txt2"));
        categoryServices.save(new CategoryDto("Dpto","Descripcion3", "url3","txt3"));
    }

    @Test
    public void saveAndFindCategories() throws ResourceNotFoundException {
        CategoryDto c1 = categoryServices.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1"));
        CategoryDto c2 = categoryServices.save(new CategoryDto("Casa","Descripcion2","Url2", "txt2"));
        CategoryDto c3 = categoryServices.save(new CategoryDto("Dpto","Descripcion3","Url3", "txt3"));
        assertNotNull(categoryServices.findById(c1.getId()));
        assertNotNull(categoryServices.findById(c2.getId()));
        assertNotNull(categoryServices.findById(c3.getId()));
    }

    @Test
    public void findAllCategories() {
        logInfo();
        Set<Category_CardDto> categories = categoryServices.findAll();
        assertFalse(categories.isEmpty());
        System.out.println(categories);
    }

    @Test
    public void deleteCategory() throws ResourceNotFoundException {
        boolean ex = false;
        CategoryDto c4 = categoryServices.save(new CategoryDto("Hostel","Descripcion4","Url4", "txt4"));
        categoryServices.delete(c4.getId());
        try{
            categoryServices.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateCategory() throws ResourceNotFoundException {
        CategoryDto c5 = categoryServices.save(new CategoryDto("Residencia","Descripcion5","Url5", "txt5"));
        CategoryDto c6 = new CategoryDto("Residencia","DescripcionCambiada","UrlCambiada", "txt5");
        c6.setId(c5.getId());

        categoryServices.save(c6);
        assertEquals(c6.toString(), categoryServices.findById(c6.getId()).toString());
    }
}