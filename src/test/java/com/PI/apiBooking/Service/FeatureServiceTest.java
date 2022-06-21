package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Service.Impl.FeatureService;
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

    FeatureDto f1, f2, f3, f4, f5;

    @BeforeEach
    public void doBefore(){
        f1 = featureService.save(new FeatureDto("Gym","Url1"));
        f2 = featureService.save(new FeatureDto("Wifi","Url2"));
        f3 = featureService.save(new FeatureDto("Mercado","Url3"));
        f4 = featureService.save(new FeatureDto("CoWorking","Url4"));
        f5 = featureService.save(new FeatureDto("Servicio de limpieza","Url5"));
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
    public void deleteFeature() throws ResourceNotFoundException {
        boolean ex = false;
        featureService.delete(f4.getId());
        try{
            featureService.findById(f4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateFeature() throws ResourceNotFoundException {
        FeatureDto f6 = new FeatureDto("Servicio de limpieza","UrlCambiada");
        f6.setId(f5.getId());
        featureService.save(f6);
        assertEquals(f6.toString(), featureService.findById(f6.getId()).toString());
    }
}