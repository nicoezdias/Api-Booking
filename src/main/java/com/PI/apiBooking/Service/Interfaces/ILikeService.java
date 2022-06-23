package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.Post.LikeDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.Entity.Like;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ILikeService extends IService<LikeDto>, ICheckId<Like> {

    Optional<Like> findByUserIdAndProductId(Long userId, Long productId);
    Set<Product_CardDto> findProductsByUserId(Long userId);
}
