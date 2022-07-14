package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.CityListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Model.Entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class CityMapper {

    public abstract CityDto toCityDto(City city);

    public abstract City toCity(CityDto cityDto);

    @Mapping(target = "name", expression="java(city.getName() + \", \" + city.getProvince().getName())")
    @Mapping(target = "nameCountry", expression="java(city.getProvince().getCountry().getName())")
    public abstract CityListDto toCityListDto(City city);

    public abstract Set<CityListDto> toCityListDtoSet(List<City> cities);
}
