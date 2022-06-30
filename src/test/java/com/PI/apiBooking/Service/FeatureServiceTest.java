package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Service.Impl.FeatureService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FeatureServiceTest {

    @Autowired
    private FeatureService featureService;

    FeatureDto f1, f2, f3, f4;

    @BeforeEach
    public void doBefore(){
        f1 = featureService.save(new FeatureDto("Gym","Url1"));
        f2 = featureService.save(new FeatureDto("Wifi","Url2"));
        f3 = featureService.save(new FeatureDto("Mercado","Url3"));
        f4 = featureService.save(new FeatureDto("Servicio de limpieza","Url5"));
    }

    @AfterEach
    public void doAfter() throws ResourceNotFoundException {
        featureService.delete(f1.getId());
        featureService.delete(f2.getId());
        featureService.delete(f3.getId());
        featureService.delete(f4.getId());
    }

    @Test
    public void saveAndFindFeatures() throws ResourceNotFoundException {
        assertNotNull(featureService.findById(f1.getId()));
        assertNotNull(featureService.findById(f2.getId()));
        assertNotNull(featureService.findById(f3.getId()));
    }

    @Test
    public void findAllFeatures() {
        Set<FeatureDto> caracteristicas = featureService.findAll();
        assertFalse(caracteristicas.isEmpty());
        System.out.println(caracteristicas);
    }

    @Test
    public void updateFeature() throws ResourceNotFoundException {
        FeatureDto f5 = new FeatureDto("Servicio de limpieza","UrlCambiada");
        f5.setId(f4.getId());
        featureService.save(f5);
        assertEquals(f5.toString(), featureService.findById(f5.getId()).toString());
    }

    @Test
    public void deleteFeature(){
        boolean ex = false;
        FeatureDto f6 = featureService.save(new FeatureDto("CoWorking","Url4"));
        try{
            featureService.delete(f6.getId());
            featureService.findById(f6.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}