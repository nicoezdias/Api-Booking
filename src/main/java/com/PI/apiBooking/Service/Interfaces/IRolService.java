package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.Post.RolDto;
import com.PI.apiBooking.Model.User.Rol;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IRolService extends IService<RolDto>, ICheckId<Rol> {
}
