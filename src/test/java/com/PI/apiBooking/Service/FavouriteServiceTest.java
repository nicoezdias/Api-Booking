package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Model.DTO.ProductCardDto;
import com.PI.apiBooking.Model.Entity.*;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.Impl.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FavouriteServiceTest {

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
    private FavouriteService favouriteService;

    static FavouriteDto f1, f2, f3;
    static Category category = new Category();
    static Feature feature = new Feature();
    static Country country = new Country();
    static Province province = new Province();
    static City city = new City();
    static Policy policy = new Policy();
    static Product  product = new Product();
    static User user1 = new User();
    static User user2 = new User();
    static User user3 = new User();
    static User user4 = new User();


    @BeforeAll
    static void doBefore(@Autowired CityService cityService,
                         @Autowired ProvinceService provinceService,
                         @Autowired CountryService countryService,
                         @Autowired CategoryService categoryService,
                         @Autowired FeatureService featureService,
                         @Autowired PolicyService policyService,
                         @Autowired ProductService productService,
                         @Autowired FavouriteService favouriteService){
        category.setId(categoryService.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1")).getId());
        feature.setId(featureService.save(new FeatureDto("Gym","Url1")).getId());
        Set<Feature> features = new HashSet<>();
        features.add(feature);
        country.setId(countryService.save(new CountryDto("Colombia")).getId());
        province.setId(provinceService.save(new ProvinceDto("Bogotá",country)).getId());
        city.setId(cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531)).getId());
        policy.setId(policyService.save(new PolicyDto("Normas de la casa","Check-out: 10:00")).getId());
        Set<Policy> policies = new HashSet<>();
        policies.add(policy);
        product.setId(productService.save(new ProductDto("Fonte Arcada","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies)).getId());
        user1.setId(1L);
        user2.setId(2L);
        user3.setId(3L);
        user4.setId(4L);
        f1 = favouriteService.save(new FavouriteDto(product, user1));
        f2 = favouriteService.save(new FavouriteDto(product, user2));
        f3 = favouriteService.save(new FavouriteDto(product, user3));
        System.out.println(favouriteService.findByUserIdAndProductId(user1.getId(), product.getId()).isEmpty());
    }

    @AfterAll
    static void doAfter(@Autowired CityService cityService,
                        @Autowired ProvinceService provinceService,
                        @Autowired CountryService countryService,
                        @Autowired CategoryService categoryService,
                        @Autowired FeatureService featureService,
                        @Autowired PolicyService policyService,
                        @Autowired ProductService productService) throws ResourceNotFoundException {
        productService.delete(product.getId());
        featureService.delete(feature.getId());
        policyService.delete(policy.getId());
        categoryService.delete(category.getId());
        cityService.delete(city.getId());
        provinceService.delete(province.getId());
        countryService.delete(country.getId());
    }

    @Test
    public void saveAndFindFavoutites(){
        System.out.println(favouriteService.findByUserIdAndProductId(user1.getId(), product.getId()).isPresent());
        assertTrue(favouriteService.findByUserIdAndProductId(user1.getId(), product.getId()).isPresent());
        assertTrue(favouriteService.findByUserIdAndProductId(user2.getId(), product.getId()).isPresent());
        assertTrue(favouriteService.findByUserIdAndProductId(user3.getId(), product.getId()).isPresent());
    }

    @Test
    public void findAllFavoutites() {
        Set<ProductCardDto> ratingsDto = favouriteService.findProductsByUserId(user2.getId());
        assertFalse(ratingsDto.isEmpty());
        System.out.println(ratingsDto);
    }


    @Test
    public void deleteFavoutites() throws ResourceNotFoundException {
        user4.setId(4L);
        FavouriteDto f6 =  favouriteService.save(new FavouriteDto(product, user4));
        favouriteService.delete(f6.getId());
        assertTrue(favouriteService.findByUserIdAndProductId(user4.getId(), product.getId()).isEmpty());
    }

}