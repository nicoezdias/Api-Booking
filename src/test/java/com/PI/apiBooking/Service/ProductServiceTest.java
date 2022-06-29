package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Model.DTO.ProductCardDto;
import com.PI.apiBooking.Model.DTO.ProductCompleteDto;
import com.PI.apiBooking.Model.Entity.*;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.Impl.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private CityService cityService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FeatureService featureService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private ObjectMapper mapper;

    ProductDto p1, p2, p3, p4;
    Category category1 = new Category();
    Category category2 = new Category();
    Feature feature = new Feature();
    Country country = new Country();
    Province province = new Province();
    City city1 = new City();
    City city2 = new City();
    Policy policy = new Policy();
    User user = new User();
    Product productOne = new Product();


    @BeforeEach
    public void doBefore(){
        category1.setId(categoryService.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1")).getId());
        category2.setId(categoryService.save(new CategoryDto("Departamento","Descripcion2","Url2", "txt2")).getId());
        feature.setId(featureService.save(new FeatureDto("Gym","Url1")).getId());
        Set<Feature> features = new HashSet<>();
        features.add(feature);
        country.setId(countryService.save(new CountryDto("Argentina")).getId());
        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
        city1.setId(cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531)).getId());
        city2.setId(cityService.save(new CityDto("Caballito",province,-34.6061369839531,-34.6061369839531)).getId());
        policy.setId(policyService.save(new PolicyDto("Normas de la casa","Check-out: 10:00")).getId());
        Set<Policy> policies = new HashSet<>();
        policies.add(policy);
        user.setId(1l);

        p1 = productService.save(new ProductDto("Producto1","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category1,features,city1,policies));
        p2 = productService.save(new ProductDto("Producto2","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category2,features,city1,policies));
        p3 = productService.save(new ProductDto("Producto3","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category1,features,city2,policies));
        p4 = productService.save(new ProductDto("Producto4","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category2,features,city2,policies));

        productOne.setId(p1.getId());
        BookingDto b1 = bookingService.save(new BookingDto("10:00", LocalDate.of(2022, 6, 12), LocalDate.of(2022, 6, 14), productOne, user));
        productOne.setId(p3.getId());
        BookingDto b2 = bookingService.save(new BookingDto("10:00", LocalDate.of(2022, 6, 12), LocalDate.of(2022, 6, 14), productOne, user));
    }

    @AfterEach
    public void doAfter() throws ResourceNotFoundException {
        productService.delete(p1.getId());
        productService.delete(p2.getId());
        productService.delete(p3.getId());
        productService.delete(p4.getId());
        featureService.delete(feature.getId());
        policyService.delete(policy.getId());
        categoryService.delete(category1.getId());
        categoryService.delete(category2.getId());
        cityService.delete(city1.getId());
        cityService.delete(city2.getId());
        provinceService.delete(province.getId());
        countryService.delete(country.getId());
    }

    @Test
    public void saveAndFindProducts() throws ResourceNotFoundException {
        assertNotNull(productService.findById(p1.getId(),null));
        assertNotNull(productService.findById(p2.getId(),null));
        assertNotNull(productService.findById(p3.getId(),null));
    }

    @Test
    public void findAllProducts() {
        Set<ProductCardDto> products = productService.findAll(null);
        assertFalse(products.isEmpty());
        System.out.println(products);
    }

    @Test
    public void findByCategoryId(){
        Set<ProductCardDto> productsHotel = productService.findByCategoryId(category1.getId(),null);
        assertFalse(productsHotel.isEmpty());
        System.out.println(productsHotel);
        assertEquals(2, productsHotel.size());

        Set<ProductCardDto> productsDepartamento = productService.findByCategoryId(category2.getId(),null);
        assertFalse(productsDepartamento.isEmpty());
        assertEquals(2, productsDepartamento.size());
        System.out.println(productsDepartamento);
    }

    @Test
    public void findForEdit() throws ResourceNotFoundException {
        assertNotNull(productService.findForEdit(p1.getId()));
        assertNotNull(productService.findForEdit(p2.getId()));
        assertNotNull(productService.findForEdit(p2.getId()));
    }

    @Test
    public void findByDateAndCityId(){
//        Sin Arrival And Departure
        Set<ProductCardDto> productsOnce = productService.findByDateAndCityId(city1.getId(),null,null,null);
        assertFalse(productsOnce.isEmpty());
        System.out.println(productsOnce);
        assertEquals(2, productsOnce.size());

        Set<ProductCardDto> productsCaballito = productService.findByDateAndCityId(city2.getId(),null,null,null);
        assertFalse(productsCaballito.isEmpty());
        assertEquals(2, productsCaballito.size());
        System.out.println(productsCaballito);

//        Sin Arrival And Departure
        Set<ProductCardDto> productsOnceEnfecha = productService.findByDateAndCityId(city1.getId(),null,"2022-06-13","2022-06-16");
        assertFalse(productsOnceEnfecha.isEmpty());
        System.out.println(productsOnceEnfecha);
        assertEquals(1, productsOnceEnfecha.size());

        Set<ProductCardDto> productsCaballitoEnfecha = productService.findByDateAndCityId(city2.getId(),null,"2022-06-09","2022-06-13");
        assertFalse(productsCaballitoEnfecha.isEmpty());
        assertEquals(1, productsCaballitoEnfecha.size());
        System.out.println(productsCaballitoEnfecha);

    }


    @Test
    public void findForBooking() throws ResourceNotFoundException {
        assertNotNull(productService.findForBooking(p1.getId(),user.getId()));
        assertNotNull(productService.findForBooking(p3.getId(),user.getId()));
    }

    @Test
    public void updateProduct() throws ResourceNotFoundException {
        ProductDto p5 = productService.findForEdit(p4.getId());
        p5.setDescription("Cambiada");
        p5.setTitleDescription("titleCambiado");
        productService.save(p5);
        assertEquals("Cambiada", productService.findById(p5.getId(),null).getDescription());
        assertEquals("titleCambiado", productService.findById(p5.getId(),null).getTitleDescription());
    }

    @Test
    public void deleteProduct() throws ResourceNotFoundException {
        boolean ex = false;
        Set<Policy> policies = new HashSet<>();
        policies.add(policy);
        Set<Feature> features = new HashSet<>();
        features.add(feature);
        ProductDto p6 = productService.save(new ProductDto("Producto4","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category2,features,city2,policies));
        try{
            productService.delete(p6.getId());
            productService.findById(p6.getId(),null);
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}