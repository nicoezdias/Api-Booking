package com.PI.apiBooking.Service;

import com.PI.apiBooking.Model.DTO.CategoryDto;
import com.PI.apiBooking.Service.Impl.CategoryServices;
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
    private CategoryServices categoryServices;

    public void logInfo(){
        categoryServices.save(new CategoryDto("Hotel","Descripcion1","Url1"));
        categoryServices.save(new CategoryDto("Casa","Descripcion2","Url2"));
        categoryServices.save(new CategoryDto("Dpto","Descripcion3","Url3"));
    }

    @Test
    public void saveAndFindCategories() throws ResourceNotFoundException {
        CategoryDto c1 = categoryServices.save(new CategoryDto("Hotel","Descripcion1","Url1"));
        CategoryDto c2 = categoryServices.save(new CategoryDto("Casa","Descripcion2","Url2"));
        CategoryDto c3 = categoryServices.save(new CategoryDto("Dpto","Descripcion3","Url3"));
        assertNotNull(categoryServices.findById(c1.getId()));
        assertNotNull(categoryServices.findById(c2.getId()));
        assertNotNull(categoryServices.findById(c3.getId()));
    }

    @Test
    public void findAllCategories() {
        logInfo();
        Set<CategoryDto> categories = categoryServices.findAll();
        assertFalse(categories.isEmpty());
        System.out.println(categories);
    }

    @Test
    public void deleteCategory() throws ResourceNotFoundException {
        boolean ex = false;
        CategoryDto c4 = categoryServices.save(new CategoryDto("Hostel","Descripcion4","Url4"));
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
        CategoryDto c5 = categoryServices.save(new CategoryDto("Residencia","Descripcion5","Url5"));
        CategoryDto c6 = new CategoryDto("Residencia","DescripcionCambiada","UrlCambiada");
        c6.setId(c5.getId());

        categoryServices.save(c6);
        assertEquals(c6.toString(), categoryServices.findById(c6.getId()).toString());
    }
}