package com.PI.apiBooking.Service.Interfaces;

<<<<<<< HEAD

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.CategoryDto;
=======
import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
>>>>>>> back-dami
import com.PI.apiBooking.Model.DTO.Post.RatingDto;
import com.PI.apiBooking.Model.Rating;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IRatingService extends IService<RatingDto>, ICheckId<Rating> {

    Set<RatingDto> findAll();
    RatingDto findById(Long id) throws ResourceNotFoundException;
}
