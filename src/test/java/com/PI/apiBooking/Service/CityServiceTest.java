package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CityDto;
import com.PI.apiBooking.Service.Impl.CityService;
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
class CityServiceTest {

    @Autowired
    private CityService cityService;

    public void logInfo(){
        cityService.save(new CityDto("Buenos Aires","Argentina"));
        cityService.save(new CityDto("Tucumán","Argentina"));
        cityService.save(new CityDto("Bogotá","Colombia"));
    }

    @Test
    public void saveAndFindCities() throws ResourceNotFoundException {
        CityDto c1 = cityService.save(new CityDto("Buenos Aires","Argentina"));
        CityDto c2 = cityService.save(new CityDto("Tucumán","Argentina"));
        CityDto c3 = cityService.save(new CityDto("Bogotá","Colombia"));
        assertNotNull(cityService.findById(c1.getId()));
        assertNotNull(cityService.findById(c2.getId()));
        assertNotNull(cityService.findById(c3.getId()));
    }

    @Test
    public void findAllCities() {
        logInfo();
        Set<CityDto> citiesDtos = cityService.findAll();
        assertFalse(citiesDtos.isEmpty());
        System.out.println(citiesDtos);
    }

    @Test
    public void deleteCity() throws ResourceNotFoundException {
        boolean ex = false;
        CityDto c4 = cityService.save(new CityDto("Medellín","Colombia"));
        cityService.delete(c4.getId());
        try{
            cityService.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateCity() throws ResourceNotFoundException {
        CityDto c5 = cityService.save(new CityDto("La Paz","Bolivi"));
        CityDto c6 = (new CityDto("La Paz","Bolivia"));
        c6.setId(c5.getId());
        cityService.save(c6);
        assertEquals(c6.toString(), cityService.findById(c6.getId()).toString());
    }
}
