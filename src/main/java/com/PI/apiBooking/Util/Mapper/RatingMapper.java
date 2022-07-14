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

    @Mapping(source = "ratingDto.user", target = "user")
    public abstract Rating toRating(RatingDto ratingDto);

    @Mapping(source = "rating.user", target = "user")
    public abstract RatingDto toRatingDto(Rating rating);

    public abstract Set<RatingDto> toRatingDtoSet(List<Rating> ratings);
}
