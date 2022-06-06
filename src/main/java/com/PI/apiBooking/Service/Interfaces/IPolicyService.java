package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.PolicyDto;
import com.PI.apiBooking.Model.Policy;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IPolicyService extends IService<PolicyDto>, ICheckId<Policy> {

}
