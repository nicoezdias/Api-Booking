package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
import com.PI.apiBooking.Model.Province;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IProvinceService extends IService<ProvinceDto>, ICheckId<Province> {
}
