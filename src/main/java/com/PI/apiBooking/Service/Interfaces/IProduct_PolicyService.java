package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.PolicyDto;

import java.util.Set;

public interface IProduct_PolicyService {

    Set<PolicyDto> findPolicyByProductId(Long productId);
}
