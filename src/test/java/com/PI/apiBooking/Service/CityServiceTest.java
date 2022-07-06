package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CityListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Model.DTO.Post.CountryDto;
import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
import com.PI.apiBooking.Model.Entity.Country;
import com.PI.apiBooking.Model.Entity.Province;
import com.PI.apiBooking.Service.Impl.CityService;
import com.PI.apiBooking.Service.Impl.CountryService;
import com.PI.apiBooking.Service.Impl.ProvinceService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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

    static CityDto c1, c2, c3, c4;
    static Country country = new Country();
    static Province province = new Province();

    @BeforeAll
    static void doBefore(@Autowired CityService cityService,
                         @Autowired ProvinceService provinceService,
                         @Autowired CountryService countryService){
        country.setId(countryService.save(new CountryDto("Colombia")).getId());
        province.setId(provinceService.save(new ProvinceDto("Bogotá",country)).getId());
        c1 = cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531));
        c2 = cityService.save(new CityDto("Caballito",province,-34.6061369839531,-34.6061369839531));
        c3 = cityService.save(new CityDto("Flores",province,-34.6061369839531,-34.6061369839531));
        c4 = cityService.save(new CityDto("Moreno",province,-34.6061369839531,-34.6061369839531));
    }

    @AfterAll
    static void doAfter(@Autowired CityService cityService,
                        @Autowired ProvinceService provinceService,
                        @Autowired CountryService countryService) throws ResourceNotFoundException {
        cityService.delete(c1.getId());
        cityService.delete(c2.getId());
        cityService.delete(c3.getId());
        cityService.delete(c4.getId());
        provinceService.delete(province.getId());
        countryService.delete(country.getId());
    }

    @Test
    public void saveAndFindCities() throws ResourceNotFoundException {
        assertNotNull(cityService.findById(c1.getId()));
        assertNotNull(cityService.findById(c2.getId()));
        assertNotNull(cityService.findById(c3.getId()));
    }

    @Test
    public void findAllCities() {
        Set<CityListDto> citiesDtos = cityService.findAll();
        assertFalse(citiesDtos.isEmpty());
        System.out.println(citiesDtos);
    }

    @Test
    public void updateCity() throws ResourceNotFoundException {
        CityDto c5 = cityService.findById(c4.getId());
        c5.setName("Caballito");
        cityService.save(c5);
        assertEquals(c5.toString(), cityService.findById(c5.getId()).toString());
    }

    @Test
    public void deleteCity(){
        boolean ex = false;
        CityDto c6 = cityService.save(new CityDto("Ramos",province,-34.6061369839531,-34.6061369839531));
        try{
            cityService.delete(c6.getId());
            cityService.findById(c6.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}
