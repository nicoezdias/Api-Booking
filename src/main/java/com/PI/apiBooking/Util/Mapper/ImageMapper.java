package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.ImageProductDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Model.Entity.Image;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class ImageMapper {

    public abstract Image toImage(ImageDto provinceDto);

    public abstract ImageProductDto toImageProductDto(Image image);

    public abstract Set<ImageProductDto> toImageProductDtoSet(List<Image> images);
}
