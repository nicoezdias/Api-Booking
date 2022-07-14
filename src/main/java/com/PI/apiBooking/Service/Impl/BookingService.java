package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.BookingUserDto;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Repository.IBookingRepository;
import com.PI.apiBooking.Service.Interfaces.IBookingService;
import com.PI.apiBooking.Service.Interfaces.IUserService;
import com.PI.apiBooking.Util.Mapper.BookingMapper;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class BookingService implements IBookingService {
    protected final static Logger logger = Logger.getLogger(BookingService.class);

    @Autowired
    private IBookingRepository bookingRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private BookingMapper bookingMapper;


    @SneakyThrows
    @Override
    public BookingDto save(BookingDto bookingDto) {
        Booking booking = bookingMapper.toBooking(bookingDto);
        userService.updateCity(bookingDto.getUser().getId(),booking.getUser().getCity());
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
    public Set<LocalDate> findBookingByProductId(Long productId) {
        List<Booking> bookings = bookingRepository.findBookingByProductId(productId);
        Set<LocalDate> disables = new HashSet<>();
        for(Booking booking : bookings){
            long days = ChronoUnit.DAYS.between(booking.getArrival(), booking.getDeparture());
            for (int i=0; i < days; i++) {
                LocalDate date = booking.getArrival().plusDays(i);
                disables.add(date);
            }
        }
        return disables;
    }

    @Override
    public List<BookingUserDto> findBookingByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findBookingByUserId(userId);
        return bookingMapper.toBookingUserDtoSet(bookings);
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

