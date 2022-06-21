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

    ImageDto i1, i2, i3, i4, i5;
    Product  product = new Product();

    @BeforeEach
    public void doBefore(){
        Category category = new Category();
        category.setId(categoryService.save(new CategoryDto("Hotel","Descripcion1","Url1", "txt1")).getId());
        Feature feature = new Feature();
        feature.setId(featureService.save(new FeatureDto("Gym","Url1")).getId());
        Set<Feature> features = new HashSet<>();
        features.add(feature);
        Country country = new Country();
        country.setId(countryService.save(new CountryDto("Argentina")).getId());
        Province province = new Province();
        province.setId(provinceService.save(new ProvinceDto("BsAs",country)).getId());
        City city = new City();
        city.setId(cityService.save(new CityDto("Once",province,-34.6061369839531,-34.6061369839531)).getId());
        Policy policy = new Policy();
        policy.setId(policyService.save(new PolicyDto("Normas de la casa","Check-out: 10:00")).getId());
        Set<Policy> policies = new HashSet<>();
        policies.add(policy);
        product.setId(productService.save(new ProductDto("Fonte Arcada","title","Description",4,"direccion",-37.261919678039064,-56.96991330339291,"10:00","23:00",category,features,city,policies)).getId());

        i1 = imageService.save(new ImageDto("Habitación", "url1", "Habitación", true, product));
        i2 = imageService.save(new ImageDto("Baño", "url2", "Baño", false, product));
        i3 = imageService.save(new ImageDto("Pileta", "url3", "Pileta", false, product));
        i4 = imageService.save(new ImageDto("Salón comedor", "url4", "Salón comedor", false, product));
        i5 = imageService.save(new ImageDto("Hal", "url5", "Hal", false, product));
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
    public void deleteImage() throws ResourceNotFoundException {
        boolean ex = false;
        imageService.delete(i4.getId());
        try{
            imageService.findById(i4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateImage() throws ResourceNotFoundException {
        ImageDto c6 = new ImageDto("Hall", "url5", "Hall", false, product);
        c6.setId(i5.getId());
        imageService.save(c6);
        assertEquals(c6.toString(), imageService.findById(c6.getId()).toString());
    }
}
