package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.RatingDto;
import com.PI.apiBooking.Model.Entity.Rating;
import com.PI.apiBooking.Util.Mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public abstract class RatingMapper {

    @Mapping(target = "user", source = "ratingDto.user")
    public abstract Rating toRating(RatingDto ratingDto);

    @Mapping(target = "user", source = "rating.user")
    public abstract RatingDto toRatingDto(Rating rating);

    public abstract Set<RatingDto> toRatingDtoSet(List<Rating> ratings);
}
