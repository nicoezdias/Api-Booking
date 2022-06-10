package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Repository.IFeatureRepository;
import com.PI.apiBooking.Service.Interfaces.IFeatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FeatureService implements IFeatureService {
    protected final static Logger logger = Logger.getLogger(FeatureService.class);

    @Autowired
    IFeatureRepository featureRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<FeatureDto> findAll() {
        Set<FeatureDto> featuresDto = new HashSet<>();
        List<Feature> features = featureRepository.findAll();
        for (Feature feature : features
        ) {
            featuresDto.add(mapper.convertValue(feature, FeatureDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ featuresDto);
        return featuresDto;
    }

    @Override
    public FeatureDto findById(Long id) throws ResourceNotFoundException {
        Feature feature = checkId(id);
        FeatureDto featureDto = mapper.convertValue(feature, FeatureDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return featureDto;
    }

    @Override
    public FeatureDto save(FeatureDto featureDto) {
        Feature feature = mapper.convertValue(featureDto, Feature.class);
        featureRepository.save(feature);
        if (featureDto.getId() == null){
            featureDto.setId(feature.getId());
            logger.info("Caracteristica registrada correctamente: "+ featureDto);
        }else{
            logger.info("Caracteristica actualizada correctamente: "+ featureDto);
        }

        return featureDto;
    }

    /*
    @Override
    public Set<ProductDto> findProductsByFeature(String featureName){
        Set<ProductDto> productsDto = new HashSet<>();
        Set<Product> products = featureRepository.findProductsByFeature(featureName);
        for (Product product : products) {
            productsDto.add(mapper.convertValue(product, ProductDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ productsDto);
        return productsDto;
    } */

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        featureRepository.deleteById(id);
        logger.info("Se elimino la Caracteristica correctamente: id("+id+")");
    }

    @Override
    public Feature checkId(Long id) throws ResourceNotFoundException{
        Optional<Feature> feature = featureRepository.findById(id);
        if (feature.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return feature.get();
    }

}
