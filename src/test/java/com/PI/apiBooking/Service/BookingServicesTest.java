package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Model.Entity.*;
import com.PI.apiBooking.Model.User.User;
import com.PI.apiBooking.Service.Impl.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BookingServicesTest {

    @Autowired
    private BookingService bookingService;
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
    private ImageService imageService;
    @Autowired
    private UserService userService;

    BookingDto b1, b2, b3, b4;
    Set<BookingDto> bookingDtos = new HashSet<>();
    Category category = new Category();
    Feature feature = new Feature();
    Country country = new Country();
    Province province = new Province();
    City city = new City();
    Policy policy = new Policy();
    Product productOne = new Product();
    Product productTwo = new Product();
    Image imageOne = new Image();
    Image imageTwo = new Image();
    User user = new User();

    @BeforeEach
    void doBefore(){
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
    @AfterEach
    void doAfter() throws ResourceNotFoundException {

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
        assertEquals(bookingDtos.size(), (bookingService.findBookingByUserId(user.getId())).size());
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