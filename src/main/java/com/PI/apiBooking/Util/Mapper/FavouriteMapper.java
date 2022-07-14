package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.FavouriteDto;
import com.PI.apiBooking.Model.Entity.Favourite;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class FavouriteMapper {

    public abstract Favourite toFavourite(FavouriteDto favouriteDto);
}
