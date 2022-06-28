package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.Entity.*;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.Impl.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    private UserService userService;
    @Autowired
    private RolService rolService;
    @Autowired
    private FavouriteService favouriteService;

    FavouriteDto f1, f2, f3, f4;
    Category category = new Category();
    Feature feature = new Feature();
    Country country = new Country();
    Province province = new Province();
    City city = new City();
    Policy policy = new Policy();
    Product  product = new Product();
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();
    User user4 = new User();


    @BeforeEach
    public void doBefore(){
        category.setId(categoryService.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1")).getId());
        feature.setId(featureService.save(new FeatureDto("Gym","Url1")).getId());
        Set<Feature> features = new HashSet<>();
        features.add(feature);
        country.setId(countryService.save(new CountryDto("Argentina")).getId());
        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
        city.setId(cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531)).getId());
        policy.setId(policyService.save(new PolicyDto("Normas de la casa","Check-out: 10:00")).getId());
        Set<Policy> policies = new HashSet<>();
        policies.add(policy);
        product.setId(productService.save(new ProductDto("Fonte Arcada","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies)).getId());
        user1.setId(1l);
        user2.setId(2l);
        user3.setId(3l);
        user4.setId(4l);
        f1 = favouriteService.save(new FavouriteDto(product, user1));
        f2 = favouriteService.save(new FavouriteDto(product, user2));
        f3 = favouriteService.save(new FavouriteDto(product, user3));
        System.out.println(favouriteService.findByUserIdAndProductId(user1.getId(), product.getId()).isEmpty());
    }

    @AfterEach
    public void doAfter() throws ResourceNotFoundException {
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
        Set<Product_CardDto> ratingsDto = favouriteService.findProductsByUserId(user2.getId());
        assertFalse(ratingsDto.isEmpty());
        System.out.println(ratingsDto);
    }


    @Test
    public void deleteFavoutites() throws ResourceNotFoundException {
        user4.setId(4l);
        FavouriteDto r6 =  favouriteService.save(new FavouriteDto(product, user4));
        favouriteService.delete(r6.getId());
        assertTrue(favouriteService.findByUserIdAndProductId(user4.getId(), product.getId()).isEmpty());
    }

}