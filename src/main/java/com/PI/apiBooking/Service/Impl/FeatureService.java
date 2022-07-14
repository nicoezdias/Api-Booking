package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FeatureDto;
import com.PI.apiBooking.Model.Entity.Feature;
import com.PI.apiBooking.Repository.IFeatureRepository;
import com.PI.apiBooking.Service.Interfaces.IFeatureService;
import com.PI.apiBooking.Util.Mapper.FeatureMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FeatureService implements IFeatureService {
    protected final static Logger logger = Logger.getLogger(FeatureService.class);

    @Autowired
    private IFeatureRepository featureRepository;
    @Autowired
    private FeatureMapper featureMapper;

    @Override
    public Set<FeatureDto> findAll() {
        List<Feature> features = featureRepository.findAll();
        Set<FeatureDto> featuresDto = featureMapper.toFeatureDtoSet(features);
        logger.info("La busqueda fue exitosa: "+ featuresDto);
        return featuresDto;
    }

    @Override
    public FeatureDto findById(Long id) throws ResourceNotFoundException {
        Feature feature = checkId(id);
        FeatureDto featureDto = featureMapper.toFeatureDto(feature);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return featureDto;
    }

    @Override
    public FeatureDto save(FeatureDto featureDto) {
        Feature feature = featureMapper.toFeature(featureDto);
        featureRepository.save(feature);
        if (featureDto.getId() == null){
            featureDto.setId(feature.getId());
            logger.info("Caracteristica registrada correctamente: "+ featureDto);
        }else{
            logger.info("Caracteristica actualizada correctamente: "+ featureDto);
        }

        return featureDto;
    }

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
