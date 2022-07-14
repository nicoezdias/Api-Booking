package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.CityListDto;
import com.PI.apiBooking.Model.DTO.Post.CityDto;
import com.PI.apiBooking.Model.Entity.City;
import com.PI.apiBooking.Repository.ICityRepository;
import com.PI.apiBooking.Service.Interfaces.ICityService;
import com.PI.apiBooking.Util.Mapper.CityMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CityService implements ICityService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    private ICityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public Set<CityListDto> findAll() {
        List<City> cities = cityRepository.findAll();
        Set<CityListDto> citiesListDto = cityMapper.toCityListDtoSet(cities);
        logger.info("La busqueda fue exitosa: "+ citiesListDto);
        return citiesListDto;
    }

    @Override
    public CityDto findById(Long id) throws ResourceNotFoundException {
        City city = checkId(id);
        CityDto cityDto = cityMapper.toCityDto(city);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return cityDto;
    }

    @Override
    public CityDto save(CityDto cityDto) {
        City city = cityMapper.toCity(cityDto);
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
