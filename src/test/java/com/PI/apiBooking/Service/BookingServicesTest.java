package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Model.Entity.*;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.Impl.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookingServicesTest {

    @Autowired
    BookingService bookingService;
    @Autowired
    CityService cityService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    CountryService countryService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    FeatureService featureService;
    @Autowired
    PolicyService policyService;
    @Autowired
    ProductService productService;
    @Autowired
    ImageService imageService;

    static BookingDto b1, b2, b3, b4;
    static Set<BookingDto> bookingDtos = new HashSet<>();
    static Category category = new Category();
    static Feature feature = new Feature();
    static Country country = new Country();
    static Province province = new Province();
    static City city = new City();
    static Policy policy = new Policy();
    static Product productOne = new Product();
    static Product productTwo = new Product();
    static Image imageOne = new Image();
    static Image imageTwo = new Image();
    static User user = new User();

    @BeforeAll
    static void doBefore(@Autowired BookingService bookingService,
                         @Autowired CityService cityService,
                         @Autowired ProvinceService provinceService,
                         @Autowired CountryService countryService,
                         @Autowired CategoryService categoryService,
                         @Autowired FeatureService featureService,
                         @Autowired PolicyService policyService,
                         @Autowired ProductService productService,
                         @Autowired ImageService imageService){
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
        productOne.setId(productService.save(new ProductDto("Fonte Arcada","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies)).getId());
        productTwo.setId(productService.save(new ProductDto("Nh Hotel","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies)).getId());
        imageOne.setId(imageService.save(new ImageDto("image", "url", "textAlt", true, productOne)).getId());
        imageTwo.setId(imageService.save(new ImageDto("image", "url", "textAlt", true, productTwo)).getId());
        user.setId(1L);

        b1 = bookingService.save(new BookingDto("10:00", LocalDate.of(2022, 6, 12), LocalDate.of(2022, 6, 14), productOne, user));
        b2 = bookingService.save(new BookingDto("11:00", LocalDate.of(2022, 7, 2), LocalDate.of(2022, 7, 9), productOne, user));
        b3 = bookingService.save(new BookingDto("12:00", LocalDate.of(2022, 9, 23), LocalDate.of(2022, 9, 26), productTwo, user));
        b4 = bookingService.save(new BookingDto("13:00", LocalDate.of(2023, 1, 10), LocalDate.of(2023, 2, 2), productOne, user));

        bookingDtos.add(b1);
        bookingDtos.add(b2);
        bookingDtos.add(b3);
        bookingDtos.add(b4);

    }

    @AfterAll
    static void doAfter(@Autowired CityService cityService,
                        @Autowired ProvinceService provinceService,
                        @Autowired CountryService countryService,
                        @Autowired CategoryService categoryService,
                        @Autowired FeatureService featureService,
                        @Autowired PolicyService policyService,
                        @Autowired ProductService productService,
                        @Autowired ImageService imageService) throws ResourceNotFoundException {

        imageService.delete(imageOne.getId());
        imageService.delete(imageTwo.getId());
        productService.delete(productOne.getId());
        productService.delete(productTwo.getId());
        featureService.delete(feature.getId());
        policyService.delete(policy.getId());
        categoryService.delete(category.getId());
        cityService.delete(city.getId());
        provinceService.delete(province.getId());
        countryService.delete(country.getId());

    }

    @Test
    public void findBookingByProductId(){
        int count_1 = 0;
        int count_2 = 0;

        for(BookingDto bookingDto : bookingDtos){
            if(bookingDto.getProduct().getId().equals(productOne.getId()))
                count_1++;
            if(bookingDto.getProduct().getId().equals(productTwo.getId()))
                count_2++;
        }

        assertNotNull(bookingService.findBookingByProductId(productOne.getId()));
        assertNotNull(bookingService.findBookingByProductId(productTwo.getId()));
        assertEquals(bookingService.findBookingByProductId(productOne.getId()).size(), count_1);
        assertEquals(bookingService.findBookingByProductId(productTwo.getId()).size(), count_2);
    }

    @Test
    public void findBookingByUserId(){
        assertNotNull(bookingService.findBookingByUserId(user.getId()));
    }

    @Test
    public void updateBooking(){
        String newTime = "07:00";
        b4.setReservationTime(newTime);
        bookingService.save(b4);
        assertEquals(b4.getReservationTime(), newTime);
    }

    @Test
    public void deleteBooking() throws ResourceNotFoundException {
        BookingDto b6 = bookingService.save(new BookingDto("10:00", LocalDate.of(2022, 6, 12), LocalDate.of(2022, 6, 14), productOne, user));
        int length = (bookingService.findBookingByProductId(productOne.getId())).size();
        bookingService.delete(b6.getId());
        assertEquals(length-1, (bookingService.findBookingByProductId(productOne.getId())).size());
    }
}