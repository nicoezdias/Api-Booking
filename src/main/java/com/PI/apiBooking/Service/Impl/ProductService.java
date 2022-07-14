package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.*;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Repository.IFavouriteRepository;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Service.Interfaces.IProductService;
import com.PI.apiBooking.Util.Mapper.ProductMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    protected final static Logger logger = Logger.getLogger(ProductService.class);

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductMapper productMapper;


    @Override
    public Set<ProductCardDto> findAll(Long userId) {
        List<Product> products = productRepository.findAll();
        Set<ProductCardDto> productsCardDto = productMapper.toProductCardDtoSet(products,userId);
        logger.info("La busqueda fue exitosa: " + productsCardDto);
        return productsCardDto;
    }

    @Override
    public ProductCompleteDto findById(Long id, Long userId) throws ResourceNotFoundException {
        Product product = checkId(id);
        return productMapper.toProductCompleteDto(product, userId);
    }

    @Override
    public Set<ProductCardDto> findByCategoryId(Long categoryId, Long userId){

        List<Product> products = productRepository.findByCategoryId(categoryId);
        Set<ProductCardDto> productsCardDto = productMapper.toProductCardDtoSet(products,userId);
        logger.info("La busqueda fue exitosa: " + productsCardDto);
        return productsCardDto;
    }

    @Override
    public Set<ProductCardDto> findByCityId(Long cityId, Long userId){
        List<Product> products = productRepository.findByCityId(cityId);
        Set<ProductCardDto> productsCardDto = productMapper.toProductCardDtoSet(products,userId);
        logger.info("La busqueda fue exitosa: " + productsCardDto);
        return productsCardDto;
    }

    @Override
    public Set<ProductCardDto> findByDateAndCityId(Long cityId, Long userId, String arrival, String departure) {
        if(arrival != null){
            List<Product> products = productRepository.findByDateAndCityId(cityId, arrival, departure);
            Set<ProductCardDto> productsCardDto = productMapper.toProductCardDtoSet(products,userId);
            logger.info("La busqueda fue exitosa: "+ productsCardDto);
            return productsCardDto;
        } else {
            Set<ProductCardDto> productsCardDto = findByCityId(cityId, userId);
            logger.info("La busqueda fue exitosa: "+ productsCardDto);
            return productsCardDto;
        }
    }

    @Override
    public ProductDto findForEdit(Long id) throws ResourceNotFoundException{
        Product product = checkId(id);
        return productMapper.toProductDto(product);
    }

    @Override
    public ProductBookingDto findForBooking(Long productId, Long userId)throws ResourceNotFoundException{
        Product product = checkId(productId);
        UserBookingDto userBookingDto = userService.findById(userId);
        ProductBookingDto productBookingDto = productMapper.toProductBookingDto(product, userBookingDto, userId);
        if(userBookingDto.getCityId() != null){
            productBookingDto.setUserCityId(userBookingDto.getCityId());
        }
        return productBookingDto;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        productRepository.save(product);
        Set<ImageDto> imageDtos = productDto.getImagesDto();
        for (ImageDto imageDto : imageDtos) {
            imageDto.setProduct(product);
            imageService.save(imageDto);
        }
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
}
