package com.PI.apiBooking.Services;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CaracteristicaDto;
import com.PI.apiBooking.Services.Impl.CaracteristicaServices;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class CaracteristicaServicesTest {

    @Autowired
    private CaracteristicaServices caracteristicaServices;

    public void cargarInfo(){
        caracteristicaServices.save(new CaracteristicaDto("Gym","Url1"));
        caracteristicaServices.save(new CaracteristicaDto("Wifi","Url2"));
        caracteristicaServices.save(new CaracteristicaDto("Mercado","Url3"));
    }

    @Test
    public void registrarYTraerCaracteristica() throws ResourceNotFoundException {
        CaracteristicaDto c1 = caracteristicaServices.save(new CaracteristicaDto("Gym","Url1"));
        CaracteristicaDto c2 = caracteristicaServices.save(new CaracteristicaDto("Wifi","Url2"));
        CaracteristicaDto c3 = caracteristicaServices.save(new CaracteristicaDto("Mercado","Url3"));
        assertNotNull(caracteristicaServices.findById(c1.getId()));
        assertNotNull(caracteristicaServices.findById(c2.getId()));
        assertNotNull(caracteristicaServices.findById(c3.getId()));
    }

    @Test
    public void traerTodasCaracteristica() {
        cargarInfo();
        Set<CaracteristicaDto> caracteristicas = caracteristicaServices.findAll();
        assertFalse(caracteristicas.isEmpty());
        System.out.println(caracteristicas);
    }

    @Test
    public void eliminarCaracteristica() throws ResourceNotFoundException {
        boolean ex = false;
        CaracteristicaDto c4 = caracteristicaServices.save(new CaracteristicaDto("CoWorking","Url4"));
        caracteristicaServices.delete(c4.getId());
        try{
            caracteristicaServices.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void actualizarCaracteristica() throws ResourceNotFoundException {
        CaracteristicaDto c5 = caracteristicaServices.save(new CaracteristicaDto("Servicio de limpieza","Url5"));
        CaracteristicaDto c6 = new CaracteristicaDto("Servicio de limpieza","UrlCambiada");
        c6.setId(c5.getId());

        caracteristicaServices.save(c6);
        assertEquals(c6.toString(), caracteristicaServices.findById(c6.getId()).toString());
    }
}