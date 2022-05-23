package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Services.ICheckId;
import com.PI.apiBooking.Services.IServices;

import java.util.Set;

public interface IFeatureServices extends IServices<FeatureDto>, ICheckId<Feature> {
}
