package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
import com.PI.apiBooking.Model.Entity.Province;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProvinceMapper {

    public abstract Province toProvince(ProvinceDto provinceDto);
}
