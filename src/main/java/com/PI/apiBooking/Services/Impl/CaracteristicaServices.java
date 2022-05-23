package com.PI.apiBooking.Services.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Caracteristica;
import com.PI.apiBooking.Model.DTO.CaracteristicaDto;
import com.PI.apiBooking.Model.DTO.ProductoDto;
import com.PI.apiBooking.Model.Producto;
import com.PI.apiBooking.Repository.ICaractericaRepository;
import com.PI.apiBooking.Services.Interfaces.ICaracteristicaServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CaracteristicaServices implements ICaracteristicaServices {
    protected final static Logger logger = Logger.getLogger(CaracteristicaServices.class);

    @Autowired
    ICaractericaRepository caractericaRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<CaracteristicaDto> findAll() {
        Set<CaracteristicaDto> caracteristicasDto = new HashSet<>();
        List<Caracteristica> caracteristicas = caractericaRepository.findAll();
        for (Caracteristica caracteristica:caracteristicas
        ) {
            caracteristicasDto.add(mapper.convertValue(caracteristica,CaracteristicaDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ caracteristicasDto);
        return caracteristicasDto;
    }

    @Override
    public CaracteristicaDto findById(Long id) throws ResourceNotFoundException {
        Caracteristica caracteristica = checkId(id);
        CaracteristicaDto caracteristicaDto = mapper.convertValue(caracteristica,CaracteristicaDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return caracteristicaDto;
    }

    @Override
    public CaracteristicaDto save(CaracteristicaDto caracteristicaDto) {
        Caracteristica caracteristica = mapper.convertValue(caracteristicaDto,Caracteristica.class);
        caractericaRepository.save(caracteristica);
        if (caracteristicaDto.getId() == null){
            caracteristicaDto.setId(caracteristica.getId());
            logger.info("Caracteristica registrada correctamente: "+ caracteristicaDto);
        }else{
            logger.info("Caracteristica actualizada correctamente: "+ caracteristicaDto);
        }

        return caracteristicaDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        caractericaRepository.deleteById(id);
        logger.info("Se elimino la Caracteristica correctamente: id("+id+")");
    }

    @Override
    public Set<ProductoDto> buscarPorCaracteristica(String c) {
        Set<ProductoDto> productosDto = new HashSet<>();
        Set<Producto> productos = caractericaRepository.buscarPorCaracteristica(c);
        for (Producto producto:productos) {
            productosDto.add(mapper.convertValue(producto,ProductoDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ productosDto);
        return productosDto;
    }

    public Caracteristica checkId(Long id) throws ResourceNotFoundException{
        Optional<Caracteristica> caracteristica = caractericaRepository.findById(id);
        if (caracteristica.isEmpty()) {
            throw new ResourceNotFoundException("No existe Caracteristica con id: " + id);
        }
        return caracteristica.get();
    }


}
