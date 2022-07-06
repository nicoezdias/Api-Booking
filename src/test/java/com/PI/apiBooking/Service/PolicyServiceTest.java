package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Service.Impl.PolicyService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    static PolicyDto p1, p2, p3, p4;

    @BeforeAll
    static void doBefore(@Autowired PolicyService policyService){
        p1 = policyService.save(new PolicyDto("Normas de la casa","Check-out: 10:00"));
        p2 = policyService.save(new PolicyDto("Normas de la casa","No se permiten fiestas"));
        p3 = policyService.save(new PolicyDto("Normas de la casa","No fumar"));
        p4 = policyService.save(new PolicyDto("Salud y seguridad","Deposito de seguridad"));
    }

    @AfterAll
    static void doAfter(@Autowired PolicyService policyService) throws ResourceNotFoundException {
        policyService.delete(p1.getId());
        policyService.delete(p2.getId());
        policyService.delete(p3.getId());
        policyService.delete(p4.getId());
    }

    @Test
    public void saveAndFindPolicy() throws ResourceNotFoundException {
        assertNotNull(policyService.findById(p1.getId()));
        assertNotNull(policyService.findById(p2.getId()));
        assertNotNull(policyService.findById(p3.getId()));
    }

    @Test
    public void findAllPolicies() {
        Set<PolicyDto> politicas = policyService.findAll();
        assertFalse(politicas.isEmpty());
        System.out.println(politicas);
    }

    @Test
    public void updatePolicy() throws ResourceNotFoundException {
        PolicyDto p6 = policyService.findById(p4.getId());
        p6.setDescription("Botiquín completo");
        policyService.save(p6);
        assertEquals(p6.toString(), policyService.findById(p6.getId()).toString());
    }

    @Test
    public void deletePolicy(){
        boolean ex = false;
        PolicyDto p6 = policyService.save(new PolicyDto("Salud y seguridad","Detector de humo"));
        try{
            policyService.delete(p6.getId());
            policyService.findById(p6.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }
}