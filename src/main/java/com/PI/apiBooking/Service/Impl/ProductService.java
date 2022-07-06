package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.*;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.Entity.Feature;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Repository.IFavouriteRepository;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Service.Interfaces.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
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
    private BookingService bookingService;
    @Autowired
    private IFavouriteRepository favouriteRepository;
    @Autowired
    private ObjectMapper mapper;


    @Override
    public Set<ProductCardDto> findAll(Long userId) {
        List<Product> products = productRepository.findAll();
        Set<ProductCardDto> productsCardDto = productToProductCardDto(products, userId);
        logger.info("La busqueda fue exitosa: " + productsCardDto);

        return productsCardDto;
    }

    @Override
    public ProductCompleteDto findById(Long id, Long userId) throws ResourceNotFoundException {
        Product product = checkId(id);
        ProductCompleteDto productCompleteDto = mapper.convertValue(product, ProductCompleteDto.class);
        productCompleteDto.setCategoryName(product.getCategory().getTitle());
        productCompleteDto.setAvgRanting(productRepository.averageScoreByProduct(productCompleteDto.getId()));
        productCompleteDto.setImagesProduct(imageService.findImagesByProductId(productCompleteDto.getId()));
        productCompleteDto.setCityName(product.getCity().getName() + ", " + product.getCity().getProvince().getName() + ", " + product.getCity().getProvince().getCountry().getName());
        productCompleteDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
        productCompleteDto.setDisabled(findBookings(id));

        if(userId != null && favouriteRepository.findByUserIdAndProductId(userId, id).isPresent()) {
            productCompleteDto.setLike(true);
        }

        return productCompleteDto;
    }

    @Override
    public Set<ProductCardDto> findByCategoryId(Long categoryId, Long userId){

        List<Product> products = productRepository.findByCategoryId(categoryId);
        Set<ProductCardDto> productsCardDto = productToProductCardDto(products, userId);
        logger.info("La busqueda fue exitosa: " + productsCardDto);
        return productsCardDto;
    }

    @Override
    public Set<ProductCardDto> findByCityId(Long cityId, Long userId){
        List<Product> products = productRepository.findByCityId(cityId);
        Set<ProductCardDto> productsCardDto = productToProductCardDto(products, userId);
        logger.info("La busqueda fue exitosa: " + productsCardDto);
        return productsCardDto;
    }

    @Override
    public Set<ProductCardDto> findByDateAndCityId(Long cityId, Long userId, String arrival, String departure) {
        if(arrival != null){
            List<Product> products = productRepository.findByDateAndCityId(cityId, arrival, departure);
            Set<ProductCardDto> productsCardDto = productToProductCardDto(products, userId);
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
        return mapper.convertValue(product, ProductDto.class);
    }

    @Override
    public Set<LocalDate> findBookings(Long id){

        return bookingService.findBookingByProductId(id);
    }

    @Override
    public ProductBookingDto findForBooking(Long productId, Long userId)throws ResourceNotFoundException{
        Product product = checkId(productId);
        ProductBookingDto bookingProductDto = mapper.convertValue(product, ProductBookingDto.class);
        bookingProductDto.setCategoryName(product.getCategory().getTitle());
        bookingProductDto.setProductName(product.getName());
        bookingProductDto.setProductStars(product.getStars());
        bookingProductDto.setProductCityName(product.getDirection() + ", " + product.getCity().getName() + ", " + product.getCity().getProvince().getName() + ", " + product.getCity().getProvince().getCountry().getName());
        bookingProductDto.setProductPolicies(product.getPolicies());
        bookingProductDto.setProductCheckInMin(product.getCheckInMin());
        bookingProductDto.setProductCheckInMax(product.getCheckInMax());

        UserBookingDto userBookingDto = userService.findById(userId);
        bookingProductDto.setUserName(userBookingDto.getName());
        bookingProductDto.setUserSurname(userBookingDto.getSurname());
        if(userBookingDto.getCityId() != null){
            bookingProductDto.setUserCityId(userBookingDto.getCityId());
        }
        bookingProductDto.setUserEmail(userBookingDto.getEmail());
        bookingProductDto.setDisabled(findBookings(productId));
        bookingProductDto.setProductImage(imageService.findProfileImageByProductId(product.getId()));

        return bookingProductDto;
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

    public Set<ProductCardDto> productToProductCardDto (List<Product> products, Long userId){
        Set<ProductCardDto> productsCardDto = new HashSet<>();
        for (Product product : products) {
            ProductCardDto productCardDto = mapper.convertValue(product, ProductCardDto.class);
            productCardDto.setCategoryName(product.getCategory().getTitle());
            productCardDto.setAvgRanting(productRepository.averageScoreByProduct(productCardDto.getId()));
            productCardDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
            Set<String> featuresIcons = new HashSet<>();
            for(Feature feature : product.getFeatures()){
                featuresIcons.add(feature.getIcon());
            }
            productCardDto.setFeaturesIcons(featuresIcons);
            productCardDto.setImageProfile(imageService.findProfileImageByProductId(productCardDto.getId()));
            if(userId != null && favouriteRepository.findByUserIdAndProductId(userId, productCardDto.getId()).isPresent())
                productCardDto.setLike(true);
            productsCardDto.add(productCardDto);
        }
        return productsCardDto;
    }

    public double distance(double lat1, double lng1, double lat2, double lng2) {
        double radioEarth = 6371;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        return radioEarth * va2;
    }
}
