package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.*;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
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
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Autowired
    IFavouriteRepository favouriteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Set<ProductCardDto> findAll(Long userId) {
        List<Product> products = productRepository.findAll();
        Set<ProductCardDto> products_cardDto = produtcToProduct_CardDto(products, userId);
        logger.info("La busqueda fue exitosa: " + products_cardDto);
        return products_cardDto;
    }

    @Override
    public ProductCompleteDto findById(Long id, Long userId) throws ResourceNotFoundException {
        Product product = checkId(id);
        ProductCompleteDto product_completeDto = mapper.convertValue(product, ProductCompleteDto.class);
        product_completeDto.setCategoryName(product.getCategory().getTitle());
        product_completeDto.setAvgRanting(productRepository.averageScoreByProduct(product_completeDto.getId()));
        product_completeDto.setImagesProduct(imageService.findImagesByProductId(product_completeDto.getId()));
        product_completeDto.setCityName(product.getCity().getName() + ", " + product.getCity().getProvince().getName() + ", " + product.getCity().getProvince().getCountry().getName());
        product_completeDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
        product_completeDto.setDisabled(findBookings(id));

        if(userId != null && favouriteRepository.findByUserIdAndProductId(id, userId).isPresent()) {
                product_completeDto.setLike(true);
            }

        return product_completeDto;
    }

    @Override
    public Set<ProductCardDto> findByCategoryId(Long categoryId, Long userId){

        List<Product> products = productRepository.findByCategoryId(categoryId);
        Set<ProductCardDto> products_cardDto = produtcToProduct_CardDto(products, userId);
        logger.info("La busqueda fue exitosa: " + products_cardDto);
        return products_cardDto;
    }

    @Override
    public Set<ProductCardDto> findByCityId(Long cityId, Long userId){
        List<Product> products = productRepository.findByCityId(cityId);
        Set<ProductCardDto> products_cardDto = produtcToProduct_CardDto(products, userId);
        logger.info("La busqueda fue exitosa: " + products_cardDto);
        return products_cardDto;
    }

    @Override
    public Set<ProductCardDto> findByDateAndCityId(Long cityId, Long userId, String arrival, String departure) {
        if(arrival != null){
            List<Product> products = productRepository.findByDateAndCityId(cityId, arrival, departure);
            Set<ProductCardDto> products_cardDto = produtcToProduct_CardDto(products, userId);
            logger.info("La busqueda fue exitosa: "+ products_cardDto);
            return products_cardDto;
        } else {
            Set<ProductCardDto> products_cardDto = findByCityId(cityId, userId);
            logger.info("La busqueda fue exitosa: "+ products_cardDto);
            return products_cardDto;
        }
    }

    @Override
    public ProductDto findForEdit(Long id) throws ResourceNotFoundException{
        Product product = checkId(id);
        return mapper.convertValue(product, ProductDto.class);
    }

    @Override
    public ProductBookingDto findForBooking(Long productId, Long userId) throws ResourceNotFoundException{
        Product product = checkId(productId);
        ProductBookingDto booking_productDto = mapper.convertValue(product, ProductBookingDto.class);
        booking_productDto.setCategoryName(product.getCategory().getTitle());
        booking_productDto.setProductName(product.getName());
        booking_productDto.setProductStars(product.getStars());
        booking_productDto.setProductCityName(product.getDirection() + ", " + product.getCity().getName() + ", " + product.getCity().getProvince().getName() + ", " + product.getCity().getProvince().getCountry().getName());
        booking_productDto.setProductPolicies(product.getPolicies());
        booking_productDto.setProductCheckInMin(product.getCheckInMin());
        booking_productDto.setProductCheckInMax(product.getCheckInMax());

        UserBookingDto user_bookingDto = userService.findById(userId);
        booking_productDto.setUserName(user_bookingDto.getName());
        booking_productDto.setUserSurname(user_bookingDto.getSurname());
        if(user_bookingDto.getCityName() != null){
            booking_productDto.setUserCity(user_bookingDto.getCityName());
        }
        booking_productDto.setUserEmail(user_bookingDto.getEmail());
        booking_productDto.setDisabled(findBookings(productId));
        booking_productDto.setProductImage(imageService.findProfileImageByProductId(product.getId()));

        return booking_productDto;
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

    @Override
    public Set<DateDisabledDto> findBookings(Long id) throws ResourceNotFoundException {
        Set<BookingDto> bookingsDto = bookingService.findBookingByProductId(id);
        Set<DateDisabledDto> dates_disabledDto = new HashSet<>();
        for(BookingDto bookingDto : bookingsDto){
            DateDisabledDto date_disabledDto = mapper.convertValue(bookingDto, DateDisabledDto.class);
            dates_disabledDto.add(date_disabledDto);
        }
        return dates_disabledDto;
    }

    public Set<ProductCardDto> produtcToProduct_CardDto (List<Product> products, Long userId){
        Set<ProductCardDto> products_cardDto = new HashSet<>();
        for (Product product : products) {
            ProductCardDto product_cardDto = mapper.convertValue(product, ProductCardDto.class);
            product_cardDto.setCategoryName(product.getCategory().getTitle());
            product_cardDto.setAvgRanting(productRepository.averageScoreByProduct(product_cardDto.getId()));
            product_cardDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
            Set<String> featuresIcons = new HashSet<>();
            for(Feature feature : product.getFeatures()){
                featuresIcons.add(feature.getIcon());
            }
            product_cardDto.setFeaturesIcons(featuresIcons);
            product_cardDto.setImageProfile(imageService.findProfileImageByProductId(product_cardDto.getId()));
            if(userId != null && favouriteRepository.findByUserIdAndProductId(product_cardDto.getId(), userId).isPresent())
                product_cardDto.setLike(true);
            products_cardDto.add(product_cardDto);
        }
        return products_cardDto;
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
