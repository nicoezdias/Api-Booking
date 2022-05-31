package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.City;
import com.PI.apiBooking.Model.DTO.CityDto;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IServices;

public interface ICityServices extends IServices<CityDto>, ICheckId<City> {

}
