package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Category_CardDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Service.Impl.CategoryService;
import com.PI.apiBooking.Service.Interfaces.ICategoryService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServicesTest {

    @Autowired
    private CategoryService categoryServices;

    CategoryDto c1, c2, c3, c4, c5;

    @BeforeEach
    void doBefore(){
        c1 = categoryServices.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1"));
        c2 = categoryServices.save(new CategoryDto("Casa","Descripcion2","Url2", "txt2"));
        c3 = categoryServices.save(new CategoryDto("Dpto","Descripcion3","Url3", "txt3"));
        c4 = categoryServices.save(new CategoryDto("Hostel","Descripcion4","Url4", "txt4"));
        c5 = categoryServices.save(new CategoryDto("Residencia","Descripcion5","Url5", "txt5"));
    }

    @Test
    public void saveAndFindCategories() throws ResourceNotFoundException {
        assertNotNull(categoryServices.findById(c1.getId()));
        assertNotNull(categoryServices.findById(c2.getId()));
        assertNotNull(categoryServices.findById(c3.getId()));
    }

    @Test
    public void findAllCategories() {
        Set<Category_CardDto> categories = categoryServices.findAll();
        assertFalse(categories.isEmpty());
        System.out.println(categories);
    }

    @Test
    public void deleteCategory() throws ResourceNotFoundException {
        boolean ex = false;
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
        CategoryDto c6 = new CategoryDto("Residencia","DescripcionCambiada","UrlCambiada", "txt5");
        c6.setId(c5.getId());

        categoryServices.save(c6);
        assertEquals("Category_CompleteDto(id="+c6.getId() +", title=Residencia, description=DescripcionCambiada, urlImage=UrlCambiada, text_alt=txt5, productQuantity=0)", categoryServices.findById(c6.getId()).toString());
    }
}