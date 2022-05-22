package com.PI.apiBooking.Services.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Interfaces.ICheckId;
import com.PI.apiBooking.Model.DTO.ImagenDto;
import com.PI.apiBooking.Model.Imagen;
import com.PI.apiBooking.Repository.IImagenRepository;
import com.PI.apiBooking.Services.Interfaces.IImagenServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ImagenServices implements IImagenServices, ICheckId<Imagen> {
    protected final static Logger logger = Logger.getLogger(CiudadServices.class);

    @Autowired
    IImagenRepository imagenRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<ImagenDto> findAll() {
        Set<ImagenDto> imagenesDtos = new HashSet<>();
        List<Imagen> imagenes = imagenRepository.findAll();
        for (Imagen imagen:imagenes) {
            imagenesDtos.add(mapper.convertValue(imagen,ImagenDto.class));
        }
        logger.info("La búsqueda fue exitosa: "+ imagenesDtos);
        return imagenesDtos;
    }

    @Override
    public ImagenDto findById(Long id) throws ResourceNotFoundException {
        Imagen imagen = checkId(id);
        ImagenDto imagenDto = mapper.convertValue(imagen,ImagenDto.class);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return imagenDto;
    }

    @Override
    public ImagenDto save(ImagenDto imagenDto) {
        Imagen imagen = mapper.convertValue(imagenDto,Imagen.class);
        imagenRepository.save(imagen);
        if (imagenDto.getId() == null){
            imagenDto.setId(imagen.getId());
            logger.info("Imagen registrada correctamente: "+ imagenDto);
        }else{
            logger.info("Imagen actualizada correctamente: "+ imagenDto);
        }
        return imagenDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        imagenRepository.deleteById(id);
        logger.info("Se elimino la Imagen correctamente: id("+id+")");
    }

    public Imagen checkId(Long id) throws ResourceNotFoundException{
        Optional<Imagen> imagen = imagenRepository.findById(id);
        if (imagen.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return imagen.get();
    }
}
