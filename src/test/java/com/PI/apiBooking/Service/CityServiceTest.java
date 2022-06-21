package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Country;
import com.PI.apiBooking.Model.DTO.City_ListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Model.DTO.Post.CountryDto;
import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
import com.PI.apiBooking.Model.Province;
import com.PI.apiBooking.Service.Impl.CityService;
import com.PI.apiBooking.Service.Impl.CountryService;
import com.PI.apiBooking.Service.Impl.ProvinceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceTest {

    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CountryService countryService;

    CityDto c1, c2, c3, c4, c5;
    @BeforeEach
    public void doBefore(){
        Country country = new Country();
        country.setId(countryService.save(new CountryDto("Argentina")).getId());
        Province province = new Province();
        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
        c1 = cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531));
        c2 = cityService.save(new CityDto("Caballito",province,-34.6061369839531,-34.6061369839531));
        c3 = cityService.save(new CityDto("Flores",province,-34.6061369839531,-34.6061369839531));
        c4 = cityService.save(new CityDto("Ramos",province,-34.6061369839531,-34.6061369839531));
        c5 = cityService.save(new CityDto("Moreno",province,-34.6061369839531,-34.6061369839531));
    }

    @Test
    public void saveAndFindCities() throws ResourceNotFoundException {
        assertNotNull(cityService.findById(c1.getId()));
        assertNotNull(cityService.findById(c2.getId()));
        assertNotNull(cityService.findById(c3.getId()));
    }

    @Test
    public void findAllCities() {
        Set<City_ListDto> citiesDtos = cityService.findAll();
        assertFalse(citiesDtos.isEmpty());
        System.out.println(citiesDtos);
    }
    @Test
    public void deleteCity() throws ResourceNotFoundException {
        boolean ex = false;
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
        CityDto c6 = cityService.findById(c5.getId());
        c6.setName("Caballito");
        cityService.save(c6);
        assertEquals(c6.toString(), cityService.findById(c6.getId()).toString());
    }
}
