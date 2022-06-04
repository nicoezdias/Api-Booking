package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.Product_FeatureDto;
import com.PI.apiBooking.Model.Product_Feature;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IProduct_FeatureService extends IService<Product_FeatureDto>, ICheckId<Product_Feature> {

    Set<FeatureDto> findFeaturesByProductId(Long productId);


}
