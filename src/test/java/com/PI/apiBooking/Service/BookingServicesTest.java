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
import java.time.temporal.ChronoUnit;
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
    static ImageDto imageDto = new ImageDto();
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
        imageDto = new ImageDto("Habitación", "url1", "Habitación", true);
        Set<ImageDto> imageDtos = new HashSet<>();
        imageDtos.add(imageDto);
        productOne.setId(productService.save(new ProductDto("Sh Hotel","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies,imageDtos)).getId());
        productTwo.setId(productService.save(new ProductDto("Nh Hotel","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies,imageDtos)).getId());
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
        int countOne = 0;
        int countTwo = 0;

        for(BookingDto bookingDto : bookingDtos){
            if(bookingDto.getProduct().getId().equals(productOne.getId())) {
                long daysOne = ChronoUnit.DAYS.between(bookingDto.getArrival(), bookingDto.getDeparture());
                for (int i = 0; i < daysOne; i++) {
                    countOne++;
                }
            }

            if(bookingDto.getProduct().getId().equals(productTwo.getId())) {
                long daysTwo = ChronoUnit.DAYS.between(bookingDto.getArrival(), bookingDto.getDeparture());
                for (int i = 0; i < daysTwo; i++) {
                    countTwo++;
                }
            }
        }

        assertNotNull(bookingService.findBookingByProductId(productOne.getId()));
        assertNotNull(bookingService.findBookingByProductId(productTwo.getId()));
        assertEquals(bookingService.findBookingByProductId(productOne.getId()).size(), countOne);
        assertEquals(bookingService.findBookingByProductId(productTwo.getId()).size(), countTwo);
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
        long length = (bookingService.findBookingByProductId(productOne.getId())).size();
        long lengthDelete = ChronoUnit.DAYS.between(b6.getArrival(), b6.getDeparture()) - 2;
        bookingService.delete(b6.getId());
        assertEquals(length-lengthDelete, (bookingService.findBookingByProductId(productOne.getId())).size());
    }
}