package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.DTO.Product_CompleteDto;
import com.PI.apiBooking.Model.Product;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Service.Interfaces.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    protected final static Logger logger = Logger.getLogger(ProductService.class);

    @Autowired
    IProductRepository productRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Set<Product_CardDto> findAll() {
        List<Product> products = productRepository.findAll();
        Set<Product_CardDto> products_cardDto = produtcToProduct_CardDto(products);
        logger.info("La busqueda fue exitosa: "+ products_cardDto);
        return products_cardDto;
    }

    @Override
    public Product_CompleteDto findById(Long id) throws ResourceNotFoundException {
        Product product = checkId(id);
        Product_CompleteDto product_completeDto = mapper.convertValue(product, Product_CompleteDto.class);
        product_completeDto.setCategoryName(product.getCategory().getTitle());
        product_completeDto.setAvgRanting(productRepository.averageScoreByProduct(product_completeDto.getId()).get());
        product_completeDto.setImagesProduct(imageService.findImagesByProductId(product_completeDto.getId()));
        return product_completeDto;
    }

    @Override
    public Set<Product_CardDto> findByCategoryId(Long categoryId){
        List<Product> products = productRepository.findByCategoryId(categoryId);
        Set<Product_CardDto> products_cardDto = produtcToProduct_CardDto(products);
        logger.info("La busqueda fue exitosa: "+ products_cardDto);
        return products_cardDto;
    }

    @Override
    public Set<Product_CardDto> findByCityId(Long cityId){
        List<Product> products = productRepository.findByCityId(cityId);
        Set<Product_CardDto> products_cardDto = produtcToProduct_CardDto(products);
        logger.info("La busqueda fue exitosa: "+ products_cardDto);
        return products_cardDto;
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
    public Product checkId(Long id) throws ResourceNotFoundException{
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return product.get();
    }

    public Set<Product_CardDto> produtcToProduct_CardDto (List<Product> products){
        Set<Product_CardDto> products_cardDto = new HashSet<>();
        for (Product product : products) {
            Product_CardDto product_cardDto = mapper.convertValue(product, Product_CardDto.class);
            product_cardDto.setCategoryName(product.getCategory().getTitle());
            product_cardDto.setAvgRanting(productRepository.averageScoreByProduct(product_cardDto.getId()).get());
            product_cardDto.setImageProfile(imageService.findProfileImageByProductId(product_cardDto.getId()));
            products_cardDto.add(product_cardDto);
        }
        return products_cardDto;
    }
}
