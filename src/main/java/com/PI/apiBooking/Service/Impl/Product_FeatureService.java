package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.FeatureDto;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Model.DTO.Product_FeatureDto;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Model.Product_Feature;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Repository.IProduct_FeatureRepository;
import com.PI.apiBooking.Service.Interfaces.IProductService;
import com.PI.apiBooking.Service.Interfaces.IProduct_FeatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Product_FeatureService implements IProduct_FeatureService {
    protected final static Logger logger = Logger.getLogger(ProductService.class);

    @Autowired
    IProduct_FeatureRepository product_featureRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<Product_FeatureDto> findAll() {
        Set<Product_FeatureDto> products_featuresDto = new HashSet<>();
        List<Product_Feature> products_features = product_featureRepository.findAll();
        for (Product_Feature product_feature : products_features) {
            products_featuresDto.add(mapper.convertValue(product_feature, Product_FeatureDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ products_featuresDto);
        return products_featuresDto;
    }

    @Override
    public Product_FeatureDto findById(Long id) throws ResourceNotFoundException {
        Product_Feature product_feature = checkId(id);
        Product_FeatureDto product_featureDto = mapper.convertValue(product_feature, Product_FeatureDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return product_featureDto;
    }

    @Override
    public Product_FeatureDto save(Product_FeatureDto product_featureDto) {
        Product_Feature product_feature = mapper.convertValue(product_featureDto, Product_Feature.class);
        product_featureRepository.save(product_feature);
        if (product_featureDto.getId() == null){
            product_featureDto.setId(product_feature.getId());
            logger.info("Producto registrado correctamente: "+ product_featureDto);
        }else{
            logger.info("Producto actualizado correctamente: "+ product_featureDto);
        }
        return product_featureDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        product_featureRepository.deleteById(id);
        logger.info("Se elimino el producto correctamente: id("+id+")");
    }

    @Override
    public Product_Feature checkId(Long id) throws ResourceNotFoundException{
        Optional<Product_Feature> product_feature = product_featureRepository.findById(id);
        if (product_feature.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return product_feature.get();
    }

    @Override
    public Set<FeatureDto> findFeaturesByProductId(Long productId) {
        Set<FeatureDto> featuresDto = new HashSet<>();
        Set<Feature> features = product_featureRepository.findFeaturesByProductId(productId);
        for (Feature feature : features) {
            featuresDto.add(mapper.convertValue(feature, FeatureDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ featuresDto);
        return featuresDto;
    }
}
