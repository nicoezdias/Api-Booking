package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoryCardDto;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
import com.PI.apiBooking.Service.Impl.CategoryService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServicesTest {

    @Autowired
    private CategoryService categoryServices;

    static CategoryDto c1, c2, c3, c4;

    @BeforeAll
    static void beforeAll(@Autowired CategoryService categoryServices){
        c1 = categoryServices.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1"));
        c2 = categoryServices.save(new CategoryDto("Casa","Descripcion2","Url2", "txt2"));
        c3 = categoryServices.save(new CategoryDto("Dpto","Descripcion3","Url3", "txt3"));
        c4 = categoryServices.save(new CategoryDto("Residencia","Descripcion5","Url5", "txt5"));
    }

    @AfterAll
    static void doAfter(@Autowired CategoryService categoryServices) throws ResourceNotFoundException {
        categoryServices.delete(c1.getId());
        categoryServices.delete(c2.getId());
        categoryServices.delete(c3.getId());
        categoryServices.delete(c4.getId());
    }

    @Test
    public void saveAndFindCategories() throws ResourceNotFoundException {
        assertNotNull(categoryServices.findById(c1.getId()));
        assertNotNull(categoryServices.findById(c2.getId()));
        assertNotNull(categoryServices.findById(c3.getId()));
    }

    @Test
    public void findAllCategories() {
        Set<CategoryCardDto> categories = categoryServices.findAll();
        assertFalse(categories.isEmpty());
        System.out.println(categories);
    }

    @Test
    public void updateCategory() throws ResourceNotFoundException {
        CategoryDto c5 = new CategoryDto("Residencia","DescripcionCambiada","UrlCambiada", "txt5");
        c5.setId(c4.getId());

        categoryServices.save(c5);
        assertEquals("CategoryCompleteDto(id="+c5.getId() +", title=Residencia, description=DescripcionCambiada, urlImage=UrlCambiada, textAlt=txt5, productQuantity=0)", categoryServices.findById(c5.getId()).toString());
    }

    @Test
    public void deleteCategory(){
        boolean ex = false;
        CategoryDto c6 = categoryServices.save(new CategoryDto("Hostel","Descripcion4","Url4", "txt4"));
        try{
            categoryServices.delete(c6.getId());
            categoryServices.findById(c6.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}