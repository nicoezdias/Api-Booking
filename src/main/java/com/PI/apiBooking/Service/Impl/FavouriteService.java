package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.FavouriteDto;
import com.PI.apiBooking.Model.DTO.ProductCardDto;
import com.PI.apiBooking.Model.Entity.Favourite;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Repository.IFavouriteRepository;
import com.PI.apiBooking.Service.Interfaces.IFavouriteService;
import com.PI.apiBooking.Util.Mapper.FavouriteMapper;
import com.PI.apiBooking.Util.Mapper.ProductMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FavouriteService implements IFavouriteService {

    protected final static Logger logger = Logger.getLogger(FavouriteService.class);

    @Autowired
    private IFavouriteRepository favouriteRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private FavouriteMapper favouriteMapper;

    @Override
    public FavouriteDto save(FavouriteDto favouriteDto) {
        Favourite favourite = favouriteMapper.toFavourite(favouriteDto);
        favouriteRepository.save(favourite);
        favouriteDto.setId(favourite.getId());
            logger.info("Registrado en favourite correctamente: "+ favouriteDto);
        return favouriteDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        favouriteRepository.deleteById(id);
        logger.info("Se elimino de favourite correctamente: id("+id+")");
    }

    @Override
    public Optional<Favourite> findByUserIdAndProductId(Long userId, Long productId){
        return favouriteRepository.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public Set<ProductCardDto> findProductsByUserId(Long userId) {
        List<Product> products = favouriteRepository.findProductsByUserId(userId);
        Set<ProductCardDto> products_cardDto = productMapper.toProductCardDtoSet(products, userId);
        logger.info("La busqueda fue exitosa: "+ products_cardDto);
        return products_cardDto;
    }

    @Override
    public Favourite checkId(Long id) throws ResourceNotFoundException {
        Optional<Favourite> favourite = favouriteRepository.findById(id);
        if (favourite.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return favourite.get();
    }
}
