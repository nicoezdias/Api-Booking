package com.PI.apiBooking.Util.Mapper;

import com.PI.apiBooking.Model.DTO.*;
import com.PI.apiBooking.Model.DTO.Post.ProductDto;
import com.PI.apiBooking.Model.Entity.Feature;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Repository.IFavouriteRepository;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Service.Impl.BookingService;
import com.PI.apiBooking.Service.Impl.ImageService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    @Autowired
    protected IProductRepository productRepository;
    @Autowired
    protected ImageService imageService;
    @Autowired
    protected IFavouriteRepository favouriteRepository;
    @Autowired
    private BookingService bookingService;

    public abstract ProductDto toProductDto(Product product);

    public abstract Product toProduct(ProductDto productDto);

    @Mappings({
            @Mapping(target = "categoryName", source="product.category.title"),
            @Mapping(target = "avgRanting", expression="java(productRepository.averageScoreByProduct(product.getId()))"),
            @Mapping(target = "imagesProduct", expression="java(imageService.findImagesByProductId(productCompleteDto.getId()))"),
            @Mapping(target = "cityName", expression="java(product.getCity().getName() + \", \" + product.getCity().getProvince().getName() + \", \" + product.getCity().getProvince().getCountry().getName())"),
            @Mapping(target = "distance", expression="java(this.distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()))"),
            @Mapping(target = "disabled", expression="java(this.findBookings(product.getId()))"),
            @Mapping(target = "like", expression="java(userId != null && favouriteRepository.findByUserIdAndProductId(userId, product.getId()).isPresent())")
    })
    public abstract ProductCompleteDto toProductCompleteDto(Product product, Long userId);

    @Mappings({
            @Mapping(target = "categoryName", expression="java(product.getCategory().getTitle())"),
            @Mapping(target = "productName", source = "product.name"),
            @Mapping(target = "productStars", source = "product.stars"),
            @Mapping(target = "productCityName", expression="java(product.getDirection() + \", \" + product.getCity().getName() + \", \" + product.getCity().getProvince().getName() + \", \" + product.getCity().getProvince().getCountry().getName())"),
            @Mapping(target = "productPolicies", source = "product.policies"),
            @Mapping(target = "productCheckInMin", source = "product.checkInMin"),
            @Mapping(target = "productCheckInMax", source = "product.checkInMax"),
            @Mapping(target = "userName", source = "userBookingDto.name"),
            @Mapping(target = "userSurname", source = "userBookingDto.surname"),
            @Mapping(target = "userEmail", source = "userBookingDto.email"),
            @Mapping(target = "disabled", expression="java(findBookings(product.getId()))"),
            @Mapping(target = "productImage", expression="java(imageService.findProfileImageByProductId(product.getId()))")
    })
    public abstract ProductBookingDto toProductBookingDto(Product product, UserBookingDto userBookingDto, Long userId);

    @Mappings({
            @Mapping(target = "categoryName", source="product.category.title"),
            @Mapping(target = "avgRanting", expression="java(productRepository.averageScoreByProduct(productCardDto.getId()))"),
            @Mapping(target = "cityName", expression="java(product.getCity().getName() + \", \" + product.getCity().getProvince().getName() + \", \" + product.getCity().getProvince().getCountry().getName())"),
            @Mapping(target = "distance", expression="java(this.distance(product.getLatitude(), product.getLongitude(), product.getCity().getLatitude(), product.getCity().getLongitude()))"),
            @Mapping(target = "imageProfile", expression="java(imageService.findProfileImageByProductId(productCardDto.getId()))"),
            @Mapping(target = "featuresIcons", expression="java(this.featuresIcons(product.getFeatures()))"),
            @Mapping(target = "like", expression="java(userId != null && favouriteRepository.findByUserIdAndProductId(userId, productCardDto.getId()).isPresent())")
    })
    public abstract ProductCardDto toProductCardDto(Product product, Long userId);

    public Set<ProductCardDto> toProductCardDtoSet(List<Product> products, Long userId){
        if ( products == null ) {
            return null;
        }

        Set<ProductCardDto> productsCardDto = new HashSet<>();
        for (Product product : products) {
            productsCardDto.add(toProductCardDto(product, userId));
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

    public Set<String> featuresIcons(Set<Feature> features){
        Set<String> featuresIcons = new HashSet<>();
        for(Feature feature : features){
            featuresIcons.add(feature.getIcon());
        }
        return featuresIcons;
    }

    public Set<LocalDate> findBookings(Long id){
        return bookingService.findBookingByProductId(id);
    }
}
