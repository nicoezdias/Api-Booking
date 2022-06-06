package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Model.DTO.PolicyDto;
import com.PI.apiBooking.Service.Interfaces.IProduct_PolicyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Product_PolicyService implements IProduct_PolicyService {

    @Override
    public Set<PolicyDto> findPolicyByProductId(Long productId) {
        return null;
    }
}
