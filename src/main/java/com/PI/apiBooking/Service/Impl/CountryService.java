package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.CountryDto;
import com.PI.apiBooking.Model.Entity.Country;
import com.PI.apiBooking.Repository.ICountryRepository;
import com.PI.apiBooking.Service.Interfaces.ICountryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {

    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    ICountryRepository countryRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public CountryDto save(CountryDto countryDto) {
        Country country = mapper.convertValue(countryDto, Country.class);
        countryRepository.save(country);
        if (countryDto.getId() == null){
            countryDto.setId(country.getId());
            logger.info("País registrado correctamente: "+ countryDto);
        }else{
            logger.info("País actualizado correctamente: "+ countryDto);
        }
        return countryDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        countryRepository.deleteById(id);
        logger.info("Se elimino el País correctamente: id("+id+")");
    }

    @Override
    public Country checkId(Long id) throws ResourceNotFoundException{
        Optional<Country> country = countryRepository.findById(id);
        if (country.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return country.get();
    }
}
