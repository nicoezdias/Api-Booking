package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Model.DTO.UserRatingDto;
import com.PI.apiBooking.Model.Entity.*;
import com.PI.apiBooking.Service.Impl.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatingServiceTest {

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
    private RatingService ratingService;

    static RatingDto r1, r2, r3, r4;
    static Category category = new Category();
    static Feature feature = new Feature();
    static Country country = new Country();
    static Province province = new Province();
    static City city = new City();
    static Policy policy = new Policy();
    static Product  product = new Product();
    static UserRatingDto user = new UserRatingDto();


    @BeforeAll
    static void doBefore(@Autowired CityService cityService,
                         @Autowired ProvinceService provinceService,
                         @Autowired CountryService countryService,
                         @Autowired CategoryService categoryService,
                         @Autowired FeatureService featureService,
                         @Autowired PolicyService policyService,
                         @Autowired ProductService productService,
                         @Autowired RatingService ratingService){
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
        user.setId(1L);

        r1 = ratingService.save(new RatingDto(8, product, user));
        r2 = ratingService.save(new RatingDto(9, product, user));
        r3 = ratingService.save(new RatingDto(7, product, user));
        r4 = ratingService.save(new RatingDto(6, product, user));
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
    public void saveAndFindRatings() throws ResourceNotFoundException {
        assertNotNull(ratingService.findById(r1.getId()));
        assertNotNull(ratingService.findById(r2.getId()));
        assertNotNull(ratingService.findById(r3.getId()));
    }

    @Test
    public void findAllRatings() {
        Set<RatingDto> ratingsDto = ratingService.findAll();
        assertFalse(ratingsDto.isEmpty());
        System.out.println(ratingsDto);
    }

    @Test
    public void updateRating() throws ResourceNotFoundException {
        RatingDto r5 = ratingService.findById(r4.getId());
        r5.setScore(5);
        ratingService.save(r5);
        assertEquals(r5.getScore(), ratingService.findById(r5.getId()).getScore());
    }

    @Test
    public void deleteRating(){
        boolean ex = false;
        RatingDto r6 =  ratingService.save(new RatingDto(10, product, user));
        try{
            ratingService.delete(r6.getId());
            ratingService.findById(r6.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}