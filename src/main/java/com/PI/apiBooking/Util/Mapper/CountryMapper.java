package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.Post.CountryDto;
import com.PI.apiBooking.Model.Entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CountryMapper {

    public abstract Country toCountry(CountryDto countryDto);
}
