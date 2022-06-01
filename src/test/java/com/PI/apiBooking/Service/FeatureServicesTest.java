package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Service.Impl.FeatureService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FeatureServicesTest {

    @Autowired
    private FeatureService featureService;

    public void logInfo(){
        featureService.save(new FeatureDto("Gym","Url1"));
        featureService.save(new FeatureDto("Wifi","Url2"));
        featureService.save(new FeatureDto("Mercado","Url3"));
    }

    @Test
    public void saveAndFindFeatures() throws ResourceNotFoundException {
        FeatureDto c1 = featureService.save(new FeatureDto("Gym","Url1"));
        FeatureDto c2 = featureService.save(new FeatureDto("Wifi","Url2"));
        FeatureDto c3 = featureService.save(new FeatureDto("Mercado","Url3"));
        assertNotNull(featureService.findById(c1.getId()));
        assertNotNull(featureService.findById(c2.getId()));
        assertNotNull(featureService.findById(c3.getId()));
    }

    @Test
    public void findAllFeatures() {
        logInfo();
        Set<FeatureDto> caracteristicas = featureService.findAll();
        assertFalse(caracteristicas.isEmpty());
        System.out.println(caracteristicas);
    }

    @Test
    public void deleteFeature() throws ResourceNotFoundException {
        boolean ex = false;
        FeatureDto c4 = featureService.save(new FeatureDto("CoWorking","Url4"));
        featureService.delete(c4.getId());
        try{
            featureService.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateFeature() throws ResourceNotFoundException {
        FeatureDto c5 = featureService.save(new FeatureDto("Servicio de limpieza","Url5"));
        FeatureDto c6 = new FeatureDto("Servicio de limpieza","UrlCambiada");
        c6.setId(c5.getId());

        featureService.save(c6);
        assertEquals(c6.toString(), featureService.findById(c6.getId()).toString());
    }
}