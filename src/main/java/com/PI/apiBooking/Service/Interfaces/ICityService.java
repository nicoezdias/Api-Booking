package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Entity.City;
import com.PI.apiBooking.Model.DTO.City_ListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface ICityService extends IService<CityDto>, ICheckId<City> {

    Set<City_ListDto> findAll();
    CityDto findById(Long id) throws ResourceNotFoundException;
}
