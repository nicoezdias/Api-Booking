package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.*;
import com.PI.apiBooking.Model.DTO.Image_ProductDto;
import com.PI.apiBooking.Model.DTO.Post.*;
import com.PI.apiBooking.Service.Impl.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;



@SpringBootTest
class ImageServiceTest {

    @Autowired
    private ImageService imageService;
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

    ImageDto i1, i2, i3, i4;
    Category category = new Category();
    Feature feature = new Feature();
    Country country = new Country();
    Province province = new Province();
    City city = new City();
    Policy policy = new Policy();
    Product  product = new Product();


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

        i1 = imageService.save(new ImageDto("Habitación", "url1", "Habitación", true, product));
        i2 = imageService.save(new ImageDto("Baño", "url2", "Baño", false, product));
        i3 = imageService.save(new ImageDto("Pileta", "url3", "Pileta", false, product));
        i4 = imageService.save(new ImageDto("Hal", "url5", "Hal", false, product));
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
    public void saveAndFindImages() throws ResourceNotFoundException {
        assertNotNull(imageService.findById(i1.getId()));
        assertNotNull(imageService.findById(i2.getId()));
        assertNotNull(imageService.findById(i3.getId()));
    }

    @Test
    public void findAllImages() {
        Set<Image_ProductDto> imagesDto = imageService.findAll();
        assertFalse(imagesDto.isEmpty());
        System.out.println(imagesDto);
    }

    @Test
    public void updateImage() throws ResourceNotFoundException {
        ImageDto i5 = new ImageDto("Hall", "url5", "Hall", false, product);
        i5.setId(i4.getId());
        imageService.save(i5);
        assertEquals("Image_ProductDto(id="+i5.getId()+", title=Hall, url=url5, text_alt=Hall)", imageService.findById(i5.getId()).toString());
    }

    @Test
    public void deleteImage() throws ResourceNotFoundException {
        boolean ex = false;
        ImageDto i6 =  imageService.save(new ImageDto("Salón comedor", "url4", "Salón comedor", false, product));
        try{
            imageService.delete(i6.getId());
            imageService.findById(i6.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}
