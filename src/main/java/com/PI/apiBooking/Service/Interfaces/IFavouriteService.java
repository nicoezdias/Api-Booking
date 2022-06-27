package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.Post.FavouriteDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.Entity.Favourite;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Optional;
import java.util.Set;

public interface IFavouriteService extends IService<FavouriteDto>, ICheckId<Favourite> {

    Optional<Favourite> findByUserIdAndProductId(Long userId, Long productId);
    Set<Product_CardDto> findProductsByUserId(Long userId);
}
