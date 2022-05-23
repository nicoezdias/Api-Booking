package com.PI.apiBooking.Services.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.ProductDto;
import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Services.Interfaces.IProductServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServices implements IProductServices {
    protected final static Logger logger = Logger.getLogger(ProductServices.class);

    @Autowired
    IProductRepository productRepository;
//    @Autowired
//    CaracteristicaServices caracteristicaServices;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<ProductDto> findAll() {
        Set<ProductDto> productsDto = new HashSet<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products
        ) {
            productsDto.add(mapper.convertValue(product, ProductDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ productsDto);
        return productsDto;
    }

    @Override
    public ProductDto findById(Long id) throws ResourceNotFoundException {
        Product product = checkId(id);
        ProductDto productDto = mapper.convertValue(product, ProductDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return productDto;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = mapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        if (productDto.getId() == null){
            productDto.setId(product.getId());
            logger.info("Producto registrado correctamente: "+ productDto);
        }else{
            logger.info("Producto actualizado correctamente: "+ productDto);
        }
        return productDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        productRepository.deleteById(id);
        logger.info("Se elimino el producto correctamente: id("+id+")");
    }

    @Override
    public Long countByCategory(String c) {
        return productRepository.countByCategory(c);
    }

    @Override
    public Set<ProductDto> findByCategory(Long categoryId){
        Set<ProductDto> productsDto = new HashSet<>();
        Set<Product> products = productRepository.buscarPorCategoria(categoryId);
        for (Product product : products) {
            productsDto.add(mapper.convertValue(product, ProductDto.class));
        }
        logger.info("La busqueda fue exitosa: "+ productsDto);
        return productsDto;
    }

//    public Set<ProductDto> findByFeature(long caracteristicaId) throws ResourceNotFoundException {
//        Caracteristica caracteristica = caracteristicaServices.checkId(caracteristicaId);
//        Set<ProductDto> productosDto = new HashSet<>();
//        Set<Product> products = caracteristica.getProducts();
//        for (Product product : products
//        ) {
//            productosDto.add(mapper.convertValue(product, ProductDto.class));
//        }
//        logger.info("La busqueda fue exitosa: "+ productosDto);
//        return productosDto;
//    }

    @Override
    public Product checkId(Long id) throws ResourceNotFoundException{
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return product.get();
    }
}
