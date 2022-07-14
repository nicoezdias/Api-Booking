package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.RatingDto;
import com.PI.apiBooking.Model.Entity.Rating;
import com.PI.apiBooking.Repository.IRatingRepository;
import com.PI.apiBooking.Service.Interfaces.IRatingService;
import com.PI.apiBooking.Util.Mapper.RatingMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RatingService implements IRatingService {

    protected final static Logger logger = Logger.getLogger(CityService.class);

    @Autowired
    private IRatingRepository ratingRepository;
    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public Set<RatingDto> findAll() {
        List<Rating> ratings = ratingRepository.findAll();
        Set<RatingDto> ratingDtos = ratingMapper.toRatingDtoSet(ratings);
        logger.info("La búsqueda fue exitosa: "+ ratingDtos);
        return ratingDtos;
    }

    @Override
    public RatingDto findById(Long id) throws ResourceNotFoundException {
        Rating rating = checkId(id);
        RatingDto ratingDto = ratingMapper.toRatingDto(rating);
        logger.info("La búsqueda fue exitosa: id("+id+")");
        return ratingDto;
    }

    @Override
    public RatingDto save(RatingDto ratingDto) {
        Rating rating = ratingMapper.toRating(ratingDto);
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
    public Rating checkId(Long id) throws ResourceNotFoundException{
        Optional<Rating> rating = ratingRepository.findById(id);
        if (rating.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return rating.get();
    }
}
