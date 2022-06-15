package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
<<<<<<< HEAD
import com.PI.apiBooking.Model.Booking;
import com.PI.apiBooking.Model.DTO.Booking_ProductDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
=======
>>>>>>> f065a6309e9b0a9fba717def17c1c8bbdb5b7a95
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.DTO.Product_CompleteDto;
import com.PI.apiBooking.Model.Feature;
import com.PI.apiBooking.Model.Policy;
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
        product_completeDto.setCityName(product.getCity().getName() + ", " + product.getCity().getName_province() + ", " + product.getCity().getName_country());
        product_completeDto.setDistance(distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()));
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
    public Set<Product_CardDto> findByDateAndCityId(String arrival, String departure, int id) {
        List<Product> products = productRepository.findByDateAndCityId(arrival, departure, id);
        Set<Product_CardDto> Products_CardDto = new HashSet<>();
        for (Product product : products) {
            Products_CardDto.add(mapper.convertValue(product, Product_CardDto.class));
        }
        return Products_CardDto;
    }

    @Override
    public Booking_ProductDto findForBooking(Long id)throws ResourceNotFoundException{
        Product product = checkId(id);
        Booking_ProductDto booking_productDto = mapper.convertValue(product, Booking_ProductDto.class);
        booking_productDto.setCategoryName(product.getCategory().getTitle());
        booking_productDto.setProductName(product.getName());
        booking_productDto.setProductStars(product.getStars());
        booking_productDto.setProductCityName(product.getCity().getName() + ", " + product.getCity().getName_province() + ", " + product.getCity().getName_country());
        booking_productDto.setProductPolicies(product.getPolicies());
        booking_productDto.setProductCheckInMin(product.getCheckInMin());
        booking_productDto.setProductCheckInMax(product.getCheckInMax());

        //UserDto userDto = user.Service.findById(userId);
        //booking_productDto.setUserName(userDto.getName());
        //booking_productDto.setUserSurname(userDto.getSurname());
        //booking_productDto.setUserEmail(userDto.getEmail());
        //booking_productDto.setUserCityName(userDto.getName());
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

    public Set<Product_CardDto> produtcToProduct_CardDto (List<Product> products){
        Set<Product_CardDto> products_cardDto = new HashSet<>();
        for (Product product : products) {
            Product_CardDto product_cardDto = mapper.convertValue(product, Product_CardDto.class);
            product_cardDto.setCategoryName(product.getCategory().getTitle());
            product_cardDto.setAvgRanting(productRepository.averageScoreByProduct(product_cardDto.getId()).get());
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
