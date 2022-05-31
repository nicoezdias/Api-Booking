package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IServices;

import java.util.Set;

public interface IFeatureServices extends IServices<FeatureDto>, ICheckId<Feature> {

    Set<ProductDto> findProductsByFeature(String featureName);
}
