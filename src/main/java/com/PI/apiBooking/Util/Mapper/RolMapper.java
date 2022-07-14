package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.RolDto;
import com.PI.apiBooking.Model.User.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RolMapper {

    public abstract Rol toRol(RolDto rolDto);
}
