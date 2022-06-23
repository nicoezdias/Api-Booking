package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Image_ProductDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Model.Entity.Image;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface IImageService extends IService<ImageDto>, ICheckId<Image> {

    Set<Image_ProductDto> findAll();
    Image_ProductDto findById(Long id) throws ResourceNotFoundException;
    Set<Image_ProductDto> findImagesByProductId(Long productId);
    Image_ProductDto findProfileImageByProductId(Long productId);
}
