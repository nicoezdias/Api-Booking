package com.PI.apiBooking.Service.Impl;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Post.BookingDto;
import com.PI.apiBooking.Model.Entity.Booking;
import com.PI.apiBooking.Repository.IBookingRepository;
import com.PI.apiBooking.Repository.IProductRepository;
import com.PI.apiBooking.Repository.IUserRepository;
import com.PI.apiBooking.Service.Interfaces.IBookingService;
import com.PI.apiBooking.Mail.EmailSenderService;
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
    ImageService imageService;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    private EmailSenderService emailSenderService;

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
//        User user = userRepository.findById(bookingDto.getUser().getId()).get();
//        Product product = productRepository.findById(bookingDto.getProduct().getId()).get();
//        Image_ProductDto imagen = imageService.findProfileImageByProductId(product.getId());
//        emailSenderService.sendMailBooking(user.getEmail(),
//                user.getName()+" "+user.getSurname(),
//                bookingDto.getArrival(),
//                bookingDto.getDeparture(),
//                product.getCategory().getTitle(),
//                product.getName(),
//                product.getDirection()+", "+product.getCity().getName()+", "+product.getCity().getProvince().getName()+", "+ product.getCity().getProvince().getCountry().getName(),
//                imagen.getUrl());
        return bookingDto;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        checkId(id);
        bookingRepository.deleteById(id);
        logger.info("Se elimino la Reserva correctamente: id("+id+")");
    }

    @Override
    public Set<BookingDto> findBookingByProductId(Long productId) {
        List<Booking> bookings = bookingRepository.findBookingByProductId(productId);
        Set<BookingDto> bookingsDto = new HashSet<>();
        for(Booking booking : bookings){
            bookingsDto.add(mapper.convertValue(booking, BookingDto.class));
        }
        return bookingsDto;
    }

    @Override
    public Set<BookingDto> findBookingByUserId(Long userId) {
        List<Booking> bookings = bookingRepository.findBookingByUserId(userId);
        Set<BookingDto> bookingsDto = new HashSet<>();
        for(Booking booking : bookings){
            bookingsDto.add(mapper.convertValue(booking, BookingDto.class));
        }
        return bookingsDto;
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
