package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.PolicyDto;
import com.PI.apiBooking.Model.Entity.Policy;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class PolicyMapper {

    public abstract Policy toPolicy(PolicyDto policyDto);

    public abstract PolicyDto toPolicyDto(Policy policy);

    public abstract Set<PolicyDto> toPolicyDtoSet(List<Policy> policies);
}
