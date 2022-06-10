package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.City;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

import java.util.Set;

public interface ICityService extends IService<CityDto>, ICheckId<City> {

    Set<CityDto> findAll();
    CityDto findById(Long id) throws ResourceNotFoundException;
}
