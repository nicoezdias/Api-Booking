package com.PI.apiBooking.Service.Interfaces;

<<<<<<< HEAD
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
=======
>>>>>>> back-dami
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IFeatureService extends IService<FeatureDto>, ICheckId<Feature> {

    Set<FeatureDto> findAll();
    FeatureDto findById(Long id) throws ResourceNotFoundException;
}
