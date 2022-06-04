package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.PolicyDto;
import com.PI.apiBooking.Service.Impl.PolicyService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PolicyServiceTest {

    @Autowired
    private PolicyService policyService;

    public void logInfo(){
        policyService.save(new PolicyDto(
                10,
                true,
                false,
                true,
                true,
                false,
                false,
                true,
                true,
                "Política de cancelación"));
    }

    @Test
    public void saveAndFindPolicy() throws ResourceNotFoundException {
        PolicyDto p1 = policyService.save(new PolicyDto(
                10,
                true,
                false,
                true,
                true,
                false,
                false,
                true,
                true,
                "Política de cancelación"));
        assertNotNull(policyService.findById(p1.getId()));
    }

    @Test
    public void findAllPolicies() {
        logInfo();
        Set<PolicyDto> policiesDto = policyService.findAll();
        assertFalse(policiesDto.isEmpty());
        System.out.println(policiesDto);
    }

    @Test
    public void deletePolicy() throws ResourceNotFoundException {
        boolean ex = false;
        PolicyDto p2 = policyService.save(new PolicyDto(
                10,
                true,
                false,
                true,
                true,
                false,
                false,
                true,
                true,
                "Política de cancelación"));

        policyService.delete(p2.getId());
        try{
            policyService.findById(p2.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updatePolicy() throws ResourceNotFoundException {
        PolicyDto p3 = policyService.save(new PolicyDto(
                8,
                true,
                false,
                true,
                true,
                false,
                false,
                true,
                true,
                "Cancelación"));
        PolicyDto p4 = (new PolicyDto(
                11,
                true,
                false,
                true,
                true,
                false,
                false,
                true,
                true,
                "Política de Cancelación"));
        p4.setId(p3.getId());
        policyService.save(p4);
        assertEquals(p4.toString(), policyService.findById(p4.getId()).toString());
    }
}
