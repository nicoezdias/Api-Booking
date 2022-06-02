package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.RatingDto;
import com.PI.apiBooking.Model.Rating;
import com.PI.apiBooking.Repository.IRatingRepository;
import com.PI.apiBooking.Service.Interfaces.IRatingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RatingService implements IRatingService {

    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    IRatingRepository ratingRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<RatingDto> findAll() {
        Set<RatingDto> ratingDtos = new HashSet<>();
        List<Rating> ratings = ratingRepository.findAll();
        for (Rating rating : ratings) {
            ratingDtos.add(mapper.convertValue(rating, RatingDto.class));
        }
        logger.info("La búsqueda fue exitosa: "+ ratingDtos);
        return ratingDtos;
    }

    @Override
    public RatingDto findById(Long id) throws ResourceNotFoundException {
        Rating rating = checkId(id);
        RatingDto ratingDto = mapper.convertValue(rating, RatingDto.class);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return ratingDto;
    }

    @Override
    public RatingDto save(RatingDto ratingDto) {
        Rating rating = mapper.convertValue(ratingDto, Rating.class);
        ratingRepository.save(rating);
        if (ratingDto.getId() == null){
            ratingDto.setId(rating.getId());
            logger.info("Rating registrado correctamente: "+ ratingDto);
        }else{
            logger.info("Rating actualizado correctamente: "+ ratingDto);
        }
        return ratingDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        ratingRepository.deleteById(id);
        logger.info("Se elimino el Rating correctamente: id("+id+")");
    }

    @Override
    public Optional<Integer> findByProduct(Long productId){
        Optional<Integer> prom = ratingRepository.buscarPorProducto(productId);

        if (prom == null){
            return null;

        }else{

        }
        return prom;
    }

    @Override
    public Rating checkId(Long id) throws ResourceNotFoundException{
        Optional<Rating> rating = ratingRepository.findById(id);
        if (rating.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return rating.get();
    }


}
