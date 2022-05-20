package com.PI.apiBooking.Services;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CategoriaDto;
import com.PI.apiBooking.Services.Impl.CategoriaServices;
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
class CategoriaServicesTest {

    @Autowired
    private CategoriaServices categoriaServices;

    public void cargarInfo(){
        categoriaServices.save(new CategoriaDto("Hotel","Descripcion1","Url1"));
        categoriaServices.save(new CategoriaDto("Casa","Descripcion2","Url2"));
        categoriaServices.save(new CategoriaDto("Dpto","Descripcion3","Url3"));
    }

    @Test
    public void registrarYTraerCategoria() throws ResourceNotFoundException {
        CategoriaDto c1 = categoriaServices.save(new CategoriaDto("Hotel","Descripcion1","Url1"));
        CategoriaDto c2 = categoriaServices.save(new CategoriaDto("Casa","Descripcion2","Url2"));
        CategoriaDto c3 = categoriaServices.save(new CategoriaDto("Dpto","Descripcion3","Url3"));
        assertNotNull(categoriaServices.findById(c1.getId()));
        assertNotNull(categoriaServices.findById(c2.getId()));
        assertNotNull(categoriaServices.findById(c3.getId()));
    }

    @Test
    public void traerTodasCategorias() {
        cargarInfo();
        Set<CategoriaDto> categorias = categoriaServices.findAll();
        assertFalse(categorias.isEmpty());
        System.out.println(categorias);
    }

    @Test
    public void eliminarCategoria() throws ResourceNotFoundException {
        boolean ex = false;
        CategoriaDto c4 = categoriaServices.save(new CategoriaDto("Hostel","Descripcion4","Url4"));
        categoriaServices.delete(c4.getId());
        try{
            categoriaServices.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void actualizarCategoria() throws ResourceNotFoundException {
        CategoriaDto c5 = categoriaServices.save(new CategoriaDto("Residencia","Descripcion5","Url5"));
        CategoriaDto c6 = new CategoriaDto("Residencia","DescripcionCambiada","UrlCambiada");
        c6.setId(c5.getId());

        categoriaServices.save(c6);
        assertEquals(c6.toString(), categoriaServices.findById(c6.getId()).toString());
    }
}