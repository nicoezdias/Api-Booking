package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IFeatureService extends IService<FeatureDto>, ICheckId<Feature> {
}
