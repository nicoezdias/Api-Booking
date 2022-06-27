package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.Post.CountryDto;
import com.PI.apiBooking.Model.Entity.Country;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface ICountryService extends IService<CountryDto>, ICheckId<Country> {
}
