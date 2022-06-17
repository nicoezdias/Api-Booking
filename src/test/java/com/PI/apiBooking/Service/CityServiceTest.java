//package com.PI.apiBooking.Service;
//
//import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
//import com.PI.apiBooking.Model.Country;
//import com.PI.apiBooking.Model.DTO.Post.CityDto;
//import com.PI.apiBooking.Model.DTO.Post.CountryDto;
//import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
//import com.PI.apiBooking.Model.Province;
//import com.PI.apiBooking.Service.Impl.CityService;
//import com.PI.apiBooking.Service.Impl.CountryService;
//import com.PI.apiBooking.Service.Impl.ProvinceService;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//class CityServiceTest {
//
//    @Autowired
//    private CityService cityService;
//    @Autowired
//    private ProvinceService provinceService;
//    @Autowired
//    private CountryService countryService;
//
//    public void logInfo(){
//        Country country = new Country();
//        country.setId(countryService.save(new CountryDto("Argentina")).getId());
//        Province province = new Province();
//        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
//        cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531));
//        cityService.save(new CityDto("Caballito",province,-34.6061369839531,-34.6061369839531));
//        cityService.save(new CityDto("Flores",province,-34.6061369839531,-34.6061369839531));
//    }
//
//    @Test
//    public void saveAndFindCities() throws ResourceNotFoundException {
//        Country country = new Country();
//        country.setId(countryService.save(new CountryDto("Argentina")).getId());
//        Province province = new Province();
//        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
//        CityDto c1 = cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531));
//        CityDto c2 = cityService.save(new CityDto("Caballito",province,-34.6061369839531,-34.6061369839531));
//        CityDto c3 = cityService.save(new CityDto("Flores",province,-34.6061369839531,-34.6061369839531));
//        assertNotNull(cityService.findById(c1.getId()));
//        assertNotNull(cityService.findById(c2.getId()));
//        assertNotNull(cityService.findById(c3.getId()));
//    }
//
//    /*
//    @Test
//    public void findAllCities() {
//        logInfo();
//        Set<CityDto> citiesDtos = cityService.findAll();
//        assertFalse(citiesDtos.isEmpty());
//        System.out.println(citiesDtos);
//    }
//*/
//    @Test
//    public void deleteCity() throws ResourceNotFoundException {
//        Country country = new Country();
//        country.setId(countryService.save(new CountryDto("Argentina")).getId());
//        Province province = new Province();
//        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
//        CityDto c1 = cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531));
//        boolean ex = false;
//        CityDto c4 = cityService.save(new CityDto("Medellín","Colombia"));
//        cityService.delete(c4.getId());
//        try{
//            cityService.findById(c4.getId());
//        }catch (ResourceNotFoundException e){
//            ex = true;
//        }
//        assertTrue(ex);
//    }
//
//    @Test
//    public void updateCity() throws ResourceNotFoundException {
//        CityDto c5 = cityService.save(new CityDto("La Paz","Bolivi"));
//        CityDto c6 = (new CityDto("La Paz","Bolivia"));
//        c6.setId(c5.getId());
//        cityService.save(c6);
//        assertEquals(c6.toString(), cityService.findById(c6.getId()).toString());
//    }
//}
