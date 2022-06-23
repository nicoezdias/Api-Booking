package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.LikeDto;
import com.PI.apiBooking.Model.DTO.Product_CardDto;
import com.PI.apiBooking.Model.Entity.Like;
import com.PI.apiBooking.Model.Entity.Product;
import com.PI.apiBooking.Repository.ILikeRepository;
import com.PI.apiBooking.Service.Interfaces.ILikeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LikeService implements ILikeService {

    protected final static Logger logger = Logger.getLogger(LikeService.class);

    @Autowired
    ILikeRepository likesRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ObjectMapper mapper;

    @Override
    public LikeDto save(LikeDto likesDto) {
        Like like = mapper.convertValue(likesDto, Like.class);
        likesRepository.save(like);
        likesDto.setId(like.getId());
            logger.info("Like registrado correctamente: "+ likesDto);
        return likesDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        likesRepository.deleteById(id);
        logger.info("Se elimino el Like correctamente: id("+id+")");
    }

    @Override
    public Optional<Like> findByUserIdAndProductId(Long userId, Long productId){
        return likesRepository.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public Set<Product_CardDto> findProductsByUserId(Long userId) {
        List<Product> products = likesRepository.findProductsByUserId(userId);
        Set<Product_CardDto> products_cardDto = productService.produtcToProduct_CardDto(products);
        logger.info("La busqueda fue exitosa: "+ products_cardDto);
        return products_cardDto;
    }

    @Override
    public Like checkId(Long id) throws ResourceNotFoundException {
        Optional<Like> like = likesRepository.findById(id);
        if (like.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return like.get();
    }
}
