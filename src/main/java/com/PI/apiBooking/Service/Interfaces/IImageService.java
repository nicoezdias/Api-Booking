package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
<<<<<<< HEAD
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
=======
>>>>>>> back-dami
import com.PI.apiBooking.Model.DTO.ImageProductDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IImageService extends IService<ImageDto>, ICheckId<Image> {

    Set<ImageProductDto> findAll();
    ImageProductDto findById(Long id) throws ResourceNotFoundException;
    Set<ImageProductDto> findImagesByProductId(Long productId);
    ImageProductDto findProfileImageByProductId(Long productId);
}
