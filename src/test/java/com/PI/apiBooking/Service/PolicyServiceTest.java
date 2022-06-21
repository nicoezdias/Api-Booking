package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Service.Impl.PolicyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    PolicyDto p1, p2, p3, p4, p5;

    @BeforeEach
    public void doBefore(){
        p1 = policyService.save(new PolicyDto("Normas de la casa","Check-out: 10:00"));
        p2 = policyService.save(new PolicyDto("Normas de la casa","No se permiten fiestas"));
        p3 = policyService.save(new PolicyDto("Normas de la casa","No fumar"));
        p4 = policyService.save(new PolicyDto("Salud y seguridad","Detector de humo"));
        p5 = policyService.save(new PolicyDto("Salud y seguridad","Deposito de seguridad"));
    }

    @Test
    public void saveAndFindFeatures() throws ResourceNotFoundException {
        assertNotNull(policyService.findById(p1.getId()));
        assertNotNull(policyService.findById(p2.getId()));
        assertNotNull(policyService.findById(p3.getId()));
    }

    @Test
    public void findAllFeatures() {
        Set<PolicyDto> politicas = policyService.findAll();
        assertFalse(politicas.isEmpty());
        System.out.println(politicas);
    }

    @Test
    public void deleteFeature() throws ResourceNotFoundException {
        boolean ex = false;
        policyService.delete(p4.getId());
        try{
            policyService.findById(p4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateFeature() throws ResourceNotFoundException {
        PolicyDto p6 = policyService.findById(p5.getId());
        p6.setDescription("Botiquin completo");
        policyService.save(p6);
        assertEquals(p6.toString(), policyService.findById(p6.getId()).toString());
    }


}