package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Model.Policy;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IPolicyService extends IService<PolicyDto>, ICheckId<Policy> {

    Set<PolicyDto> findAll();
    PolicyDto findById(Long id) throws ResourceNotFoundException;
}
