package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ImageProductDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Model.Entity.Image;
import com.PI.apiBooking.Repository.IImageRepository;
import com.PI.apiBooking.Service.Interfaces.IImageService;
import com.PI.apiBooking.Util.Mapper.ImageMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ImageService implements IImageService {
    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    private IImageRepository imageRepository;
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Set<ImageProductDto> findAll() {
        List<Image> images = imageRepository.findAll();
        Set<ImageProductDto> imagesDtos = imageMapper.toImageProductDtoSet(images);
        logger.info("La búsqueda fue exitosa: "+ imagesDtos);
        return imagesDtos;
    }

    @Override
    public ImageProductDto findById(Long id) throws ResourceNotFoundException {
        Image image = checkId(id);
        ImageProductDto imageDto = imageMapper.toImageProductDto(image);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return imageDto;
    }

    @Override
    public Set<ImageProductDto> findImagesByProductId(Long productId) {
        List<Image> images = imageRepository.findImagesByProductId(productId);
        Set<ImageProductDto> imageProductsDto = imageMapper.toImageProductDtoSet(images);
        logger.info("Búsqueda exitosa: " + imageProductsDto);
        return imageProductsDto;
    }

    @Override
    public ImageProductDto findProfileImageByProductId(Long productId) {
        return imageMapper.toImageProductDto(imageRepository.findProfileImageByProductId(productId));
    }

    @Override
    public ImageDto save(ImageDto imageDto) {
        Image image = imageMapper.toImage(imageDto);
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
