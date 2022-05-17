package com.PI.ProyectoIntegrador.Services;

import com.PI.ProyectoIntegrador.Exceptions.ResourceNotFoundException;
import com.PI.ProyectoIntegrador.Model.DTO.CategoriaDto;
import com.PI.ProyectoIntegrador.Services.Impl.CategoriaServices;
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
        categoriaServices.guardar(new CategoriaDto("Hotel1","Descripcion1","Url1"));
        categoriaServices.guardar(new CategoriaDto("Hotel2","Descripcion2","Url2"));
        categoriaServices.guardar(new CategoriaDto("Hotel3","Descripcion3","Url3"));
    }

    @Test
    public void registrarOdontologoYTraerOdontologo() throws ResourceNotFoundException {
        CategoriaDto c1 = categoriaServices.guardar(new CategoriaDto("Hotel1","Descripcion1","Url1"));
        CategoriaDto c2 = categoriaServices.guardar(new CategoriaDto("Hotel2","Descripcion2","Url2"));
        CategoriaDto c3 = categoriaServices.guardar(new CategoriaDto("Hotel3","Descripcion3","Url3"));
        assertNotNull(categoriaServices.buscar(c1.getId()));
        assertNotNull(categoriaServices.buscar(c2.getId()));
        assertNotNull(categoriaServices.buscar(c3.getId()));
    }

    @Test
    public void traerTodos() {
        cargarInfo();
        Set<CategoriaDto> categorias = categoriaServices.buscarTodas();
        assertFalse(categorias.isEmpty());
        System.out.println(categorias);
    }

    @Test
    public void eliminarOdontologo() throws ResourceNotFoundException {
        boolean ex = false;
        CategoriaDto c4 = categoriaServices.guardar(new CategoriaDto("Hotel4","Descripcion4","Url4"));
        categoriaServices.eliminar(c4.getId());
        try{
            categoriaServices.buscar(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void actualizarOdontologo() throws ResourceNotFoundException {
        CategoriaDto c5 = categoriaServices.guardar(new CategoriaDto("Hotel5","Descripcion5","Url5"));
        CategoriaDto c6 = new CategoriaDto("Hotel4","Descripcion4","UrlCambiada");
        c6.setId(c5.getId());

        categoriaServices.actualizar(c6);
        assertEquals(c6.toString(), categoriaServices.buscar(c6.getId()).toString());
    }
}