package com.PI.apiBooking.Services.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Interfaces.ICheckId;
import com.PI.apiBooking.Model.Ciudad;
import com.PI.apiBooking.Model.DTO.CiudadDto;
import com.PI.apiBooking.Repository.ICiudadRepository;
import com.PI.apiBooking.Services.Interfaces.ICiudadServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.PI.apiBooking.Interfaces.ICheckId.msjError;

@Service
public class CiudadServices implements ICiudadServices, ICheckId<Ciudad> {
    protected final static Logger logger = Logger.getLogger(CiudadServices.class);

    @Autowired
    ICiudadRepository ciudadRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<CiudadDto> findAll() {
        Set<CiudadDto> ciudadesDtos = new HashSet<>();
        List<Ciudad> ciudades = ciudadRepository.findAll();
        for (Ciudad ciudad:ciudades) {
            ciudadesDtos.add(mapper.convertValue(ciudad,CiudadDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ ciudadesDtos);
        return ciudadesDtos;
    }

    @Override
    public CiudadDto findById(Long id) throws ResourceNotFoundException {
        Ciudad ciudad = checkId(id);
        CiudadDto ciudadDto = mapper.convertValue(ciudad,CiudadDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return ciudadDto;
    }

    @Override
    public CiudadDto save(CiudadDto ciudadDto) {
        Ciudad ciudad = mapper.convertValue(ciudadDto,Ciudad.class);
        ciudadRepository.save(ciudad);
        if (ciudadDto.getId() == null){
            ciudadDto.setId(ciudad.getId());
            logger.info("Ciudad registrada correctamente: "+ ciudadDto);
        }else{
            logger.info("Ciudad actualizada correctamente: "+ ciudadDto);
        }
        return ciudadDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        ciudadRepository.deleteById(id);
        logger.info("Se elimino la Ciudad correctamente: id("+id+")");
    }

    public Ciudad checkId(Long id) throws ResourceNotFoundException{
        Optional<Ciudad> ciudad = ciudadRepository.findById(id);
        if (ciudad.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return ciudad.get();
    }
}
