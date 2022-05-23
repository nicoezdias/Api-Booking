package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.City;
import com.PI.apiBooking.Model.DTO.CityDto;
import com.PI.apiBooking.Services.ICheckId;
import com.PI.apiBooking.Services.IServices;

public interface ICityServices extends IServices<CityDto>, ICheckId<City> {

}
