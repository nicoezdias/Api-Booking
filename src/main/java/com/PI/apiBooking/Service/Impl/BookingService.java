package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.BookingUserDto;
import com.PI.apiBooking.Model.DTO.DateDisabledDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Repository.IBookingRepository;
import com.PI.apiBooking.Service.Interfaces.IBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookingService implements IBookingService {
    protected final static Logger logger = Logger.getLogger(BookingService.class);

    @Autowired
    IBookingRepository bookingRepository;
    @Autowired
    ObjectMapper mapper;


    @SneakyThrows
    @Override
    public BookingDto save(BookingDto bookingDto) {
        Booking booking = mapper.convertValue(bookingDto, Booking.class);
        bookingRepository.save(booking);
        if (bookingDto.getId() == null){
            bookingDto.setId(booking.getId());
            logger.info("Reserva registrada correctamente: "+ bookingDto);
        }else{
            logger.info("Reserva actualizada correctamente: "+ bookingDto);
        }
        return bookingDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        bookingRepository.deleteById(id);
        logger.info("Se elimino la Reserva correctamente: id("+id+")");
    }

    @Override
    public Set<DateDisabledDto> findBookingByProductId(Long productId) {
        List<Booking> bookings = bookingRepository.findBookingByProductId(productId);
        Set<DateDisabledDto> datesDisabledDto = new HashSet<>();
        for(Booking booking : bookings){
            datesDisabledDto.add(mapper.convertValue(booking, DateDisabledDto.class));
        }
        return datesDisabledDto;
    }

    @Override
    public Set<BookingUserDto> findBookingByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findBookingByUserId(userId);
        Set<BookingUserDto> bookingsUserDto = new HashSet<>();
        for(Booking booking : bookings){
            BookingUserDto bookingUserDto = mapper.convertValue(booking, BookingUserDto.class);
            bookingUserDto.setCategoryName(booking.getProduct().getCategory().getTitle());
            bookingUserDto.setProductName(booking.getProduct().getName());
            bookingUserDto.setProductStars(booking.getProduct().getStars());
            bookingUserDto.setProductCityName(booking.getProduct().getCity().getName() + ", " + booking.getProduct().getCity().getProvince().getName() + ", " + booking.getProduct().getCity().getProvince().getCountry().getName());
            bookingUserDto.setProductDirection(booking.getProduct().getDirection());

            bookingsUserDto.add(bookingUserDto);
        }
        return bookingsUserDto;
    }

    @Override
    public Booking checkId(Long id) throws ResourceNotFoundException{
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty()) {
            throw new ResourceNotFoundException(msjError + id);
        }
        return booking.get();
    }
}
