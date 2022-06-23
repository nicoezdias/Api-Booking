package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.ProvinceDto;
import com.PI.apiBooking.Model.Entity.Province;
import com.PI.apiBooking.Repository.IProvinceRepository;
import com.PI.apiBooking.Service.Interfaces.IProvinceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    IProvinceRepository provinceRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public ProvinceDto save(ProvinceDto provinceDto) {
        Province province = mapper.convertValue(provinceDto, Province.class);
        provinceRepository.save(province);
        if (provinceDto.getId() == null){
            provinceDto.setId(province.getId());
            logger.info("Provincia registrada correctamente: "+ provinceDto);
        }else{
            logger.info("Provincia actualizada correctamente: "+ provinceDto);
        }
        return provinceDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        provinceRepository.deleteById(id);
        logger.info("Se elimino la Provincia correctamente: id("+id+")");
    }

    @Override
    public Province checkId(Long id) throws ResourceNotFoundException{
        Optional<Province> province = provinceRepository.findById(id);
        if (province.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return province.get();
    }
}
