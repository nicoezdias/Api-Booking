package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Entity.City;
import com.PI.apiBooking.Model.DTO.City_ListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Repository.ICityRepository;
import com.PI.apiBooking.Service.Interfaces.ICityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityService implements ICityService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    ICityRepository cityRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<City_ListDto> findAll() {
        Set<City_ListDto> cities_listDto = new HashSet<>();
        List<City> cities = cityRepository.findAll();
        for (City city:cities) {
            City_ListDto city_listDto = mapper.convertValue(city, City_ListDto.class);
            city_listDto.setName(city.getName() + ", " + city.getProvince().getName());
            city_listDto.setNameCountry(city.getProvince().getCountry().getName());
            cities_listDto.add(city_listDto);
        }
        logger.info("La busqueda fue exitosa: "+ cities_listDto);
        return cities_listDto;
    }

    @Override
    public CityDto findById(Long id) throws ResourceNotFoundException {
        City city = checkId(id);
        CityDto cityDto = mapper.convertValue(city, CityDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return cityDto;
    }

    @Override
    public CityDto save(CityDto cityDto) {
        City city = mapper.convertValue(cityDto, City.class);
        cityRepository.save(city);
        if (cityDto.getId() == null){
            cityDto.setId(city.getId());
            logger.info("Ciudad registrada correctamente: "+ cityDto);
        }else{
            logger.info("Ciudad actualizada correctamente: "+ cityDto);
        }
        return cityDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        cityRepository.deleteById(id);
        logger.info("Se elimino la Ciudad correctamente: id("+id+")");
    }

    @Override
    public City checkId(Long id) throws ResourceNotFoundException{
        Optional<City> city = cityRepository.findById(id);
        if (city.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return city.get();
    }
}
