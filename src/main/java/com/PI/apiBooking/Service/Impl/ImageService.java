package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ImageDto;
import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Repository.IImageRepository;
import com.PI.apiBooking.Service.Interfaces.IImagenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ImageService implements IImagenService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    IImageRepository imageRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<ImageDto> findAll() {
        Set<ImageDto> imagesDtos = new HashSet<>();
        List<Image> images = imageRepository.findAll();
        for (Image image :images) {
            imagesDtos.add(mapper.convertValue(image, ImageDto.class));
        }
        logger.info("La búsqueda fue exitosa: "+ imagesDtos);
        return imagesDtos;
    }

    @Override
    public ImageDto findById(Long id) throws ResourceNotFoundException {
        Image image = checkId(id);
        ImageDto imageDto = mapper.convertValue(image, ImageDto.class);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return imageDto;
    }

    @Override
    public ImageDto save(ImageDto imageDto) {
        Image image = mapper.convertValue(imageDto, Image.class);
        imageRepository.save(image);
        if (imageDto.getId() == null){
            imageDto.setId(image.getId());
            logger.info("Imagen registrada correctamente: "+ imageDto);
        }else{
            logger.info("Imagen actualizada correctamente: "+ imageDto);
        }
        return imageDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        imageRepository.deleteById(id);
        logger.info("Se elimino la Imagen correctamente: id("+id+")");
    }

    @Override
    public Image checkId(Long id) throws ResourceNotFoundException{
        Optional<Image> imagen = imageRepository.findById(id);
        if (imagen.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return imagen.get();
    }
}
