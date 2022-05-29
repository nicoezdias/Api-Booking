package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.City;
import com.PI.apiBooking.Model.DTO.CityDto;
import com.PI.apiBooking.Repository.ICityRepository;
import com.PI.apiBooking.Service.Interfaces.ICityServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityServices implements ICityServices{
    protected final static Logger logger = Logger.getLogger(CityServices.class);

    @Autowired
    ICityRepository cityRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<CityDto> findAll() {
        Set<CityDto> citiesDtos = new HashSet<>();
        List<City> cities = cityRepository.findAll();
        for (City city:cities) {
            citiesDtos.add(mapper.convertValue(city, CityDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ citiesDtos);
        return citiesDtos;
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
