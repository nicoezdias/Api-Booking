package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Model.Entity.Feature;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class FeatureMapper {

    public abstract Feature toFeature(FeatureDto featureDto);

    public abstract FeatureDto toFeatureDto(Feature feature);

    public abstract Set<FeatureDto> toFeatureDtoSet(List<Feature> features);
}
