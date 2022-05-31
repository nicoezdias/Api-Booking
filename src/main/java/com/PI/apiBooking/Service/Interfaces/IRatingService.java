package com.PI.apiBooking.Service.Interfaces;


import com.PI.apiBooking.Model.DTO.RatingDto;
import com.PI.apiBooking.Model.Rating;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Optional;


public interface IRatingService extends IService<RatingDto>, ICheckId<Rating> {

    Optional<Double> findByProduct(Long ratingId);
}
