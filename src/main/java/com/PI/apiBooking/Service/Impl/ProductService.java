package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.Booking;
import com.PI.apiBooking.Model.DTO.*;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.Feature;
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
    UserService userService;

    @Autowired
    BookingService bookingService;

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
        product_completeDto.setAvgRanting(productRepository.averageScoreByProduct(product_completeDto.getId()));
        product_completeDto.setImagesProduct(imageService.findImagesByProductId(product_completeDto.getId()));
        product_completeDto.setCityName(product.getCity().getName() + ", " + product.getCity().getProvince().getName() + ", " + product.getCity().getProvince().getCountry().getName());
        product_completeDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
        product_completeDto.setDisabled(findBookings(id));
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

        return products_cardDto;
    }

    @Override
    public Set<Product_CardDto> findByDateAndCityId(String arrival, String departure, int id) {
        List<Product> products = productRepository.findByDateAndCityId(arrival, departure, id);
        Set<Product_CardDto> products_cardDto = produtcToProduct_CardDto(products);
        logger.info("La busqueda fue exitosa: "+ products_cardDto);
        return products_cardDto;
    }

    @Override
    public Product_BookingDto findForBooking(Long productId, Long userId)throws ResourceNotFoundException{
        Product product = checkId(productId);
        Product_BookingDto booking_productDto = mapper.convertValue(product, Product_BookingDto.class);
        booking_productDto.setCategoryName(product.getCategory().getTitle());
        booking_productDto.setProductName(product.getName());
        booking_productDto.setProductStars(product.getStars());
        booking_productDto.setProductCityName(product.getDirection() + ", " + product.getCity().getName() + ", " + product.getCity().getProvince().getName() + ", " + product.getCity().getProvince().getCountry().getName());
        booking_productDto.setProductPolicies(product.getPolicies());
        booking_productDto.setProductCheckInMin(product.getCheckInMin());
        booking_productDto.setProductCheckInMax(product.getCheckInMax());

        User_BookingDto user_bookingDto = userService.findById(userId);
        booking_productDto.setUserName(user_bookingDto.getName());
        booking_productDto.setUserSurname(user_bookingDto.getSurname());
        booking_productDto.setUserCity(user_bookingDto.getCityName());
        booking_productDto.setUserEmail(user_bookingDto.getEmail());

        booking_productDto.setDisabled(findBookings(productId));
        return booking_productDto;
    }

    @Override
    public Set<Date_DisabledDto> findBookings(Long id) throws ResourceNotFoundException {
        Set<BookingDto> bookingsDto = bookingService.findBookingByProductId(id);
        Set<Date_DisabledDto> dates_disabledDto = new HashSet<>();
        for(BookingDto bookingDto : bookingsDto){
            Date_DisabledDto date_disabledDto = mapper.convertValue(bookingDto, Date_DisabledDto.class);
            dates_disabledDto.add(date_disabledDto);
        }
        return dates_disabledDto;
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
            product_cardDto.setAvgRanting(productRepository.averageScoreByProduct(product_cardDto.getId()));
            product_cardDto.setAvgRanting(productRepository.averageScoreByProduct(product_cardDto.getId()));
            product_cardDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
            Set<String> featuresIcons = new HashSet<>();
            for(Feature feature : product.getFeatures()){
                featuresIcons.add(feature.getIcon());
            }
            product_cardDto.setFeaturesIcons(featuresIcons);
            product_cardDto.setImageProfile(imageService.findProfileImageByProductId(product_cardDto.getId()));
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
        double distance = radioEarth * va2;
        return distance;
    }
}
